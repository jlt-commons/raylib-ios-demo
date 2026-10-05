(ns net.b12n.raylib-ios.demo.test-runner
  "Entry point for `jolt -M:test` and `clojure -M:test`, from the repo root and
  from a sub-project.

      -m net.b12n.raylib-ios.demo.test-runner test            this directory's tests
      -m net.b12n.raylib-ios.demo.test-runner --subprojects   every <dir>/test here

  Every `*_test.cljc` and `*_test.clj` under the named directories is a test
  namespace, found on disk and not from a list, because a list silently skips any
  file not on it and \"Ran 23 tests\" reads exactly like success when the new
  namespace never loaded.

  A `.cljc` test is pure and runs under both runtimes. A `.clj` test loads
  jolt.ffi, directly or through the gallery, so only jolt can require it: the
  JVM run skips those and says so.

  Nothing here touches raylib, SDL, UIKit or a device: the scene contract keeps
  the simulation pure, so its tests run on the build host."
  (:require
   [clojure.string :as str]
   [clojure.test :as t]))

(defmethod t/report :error [m]
  (t/with-test-out
    (t/inc-report-counter :error)
    (println "\nERROR in" (t/testing-vars-str m))
    (when (seq t/*testing-contexts*) (println (t/testing-contexts-str)))
    (when-let [message (:message m)] (println message))
    (when-let [e (:actual m)]
      (if (instance? Throwable e)
        (do (println "  ->" (.getName (class e)) ":" (ex-message e))
            (when-let [d (ex-data e)] (prn d)))
        (prn e)))))

(def ^:private jolt?
  "True under jolt, which sets the jolt.version system property. It is nil on
  JVM Clojure."
  (some? (System/getProperty "jolt.version")))

(defn- test-file? [^java.io.File f]
  (and (.isFile f) (boolean (re-find #"_test\.cljc?$" (.getName f)))))

(defn- ->ns
  "The namespace a test file under `dir` declares: its path with the directory
  and extension gone, `_` turned to `-` and `/` to `.`."
  [^java.io.File dir ^java.io.File f]
  (let [base (str (.getPath dir) java.io.File/separator)]
    (-> (.getPath f)
        (subs (count base))
        (str/replace #"\.cljc?$" "")
        (str/replace "_" "-")
        (str/replace java.io.File/separator ".")
        symbol)))

(defn- find-tests
  "[ns file] for every test file under `dirs`, sorted by namespace."
  [dirs]
  (->> dirs
       (map #(java.io.File. ^String %))
       (mapcat (fn [dir] (->> (file-seq dir) (filter test-file?) (map (fn [f] [(->ns dir f) f])))))
       (sort-by (comp str first))))

(defn- subproject-test-dirs
  "<dir>/test for every directory here that has one."
  []
  (->> (.listFiles (java.io.File. "."))
       (filter (fn [^java.io.File d] (.isDirectory d)))
       (map (fn [^java.io.File d] (java.io.File. d "test")))
       (filter (fn [^java.io.File d] (.isDirectory d)))
       (map (fn [^java.io.File d] (subs (.getPath d) 2)))
       sort))

(defn- exit
  "End the run with `code`. Called directly: System/exit exists under both
  runtimes, so nothing needs detecting."
  [code]
  (System/exit code))

(defn -main [& args]
  (let [dirs (if (= ["--subprojects"] args) (subproject-test-dirs) args)
        _ (when (empty? dirs)
            (println "usage: test-runner <test-dir>... | --subprojects")
            (exit 2))
        found (find-tests dirs)
        pure (vec (for [[n ^java.io.File f] found :when (str/ends-with? (.getName f) ".cljc")] n))
        jolt-only (vec (for [[n ^java.io.File f] found :when (str/ends-with? (.getName f) ".clj")] n))
        load-failures (atom 0)
        load! (fn [nss]
                (doseq [n nss]
                  (try (require n :reload)
                       (catch Exception e
                         (swap! load-failures inc)
                         (println "ERROR requiring" n ":" (ex-message e))))))]
    (when (empty? found)
      (println "ERROR: no *_test.clj or *_test.cljc files under" (str/join " " dirs))
      (exit 1))
    (if jolt?
      (println "running jolt-only:" (str/join " " jolt-only))
      (println "skipped (jolt.version not set, so not running under jolt; needs jolt.ffi):"
               (str/join " " jolt-only)))
    (load! pure)
    (when jolt? (load! jolt-only))
    (let [counters [:test :pass :fail :error]
          pure-results (apply t/run-tests pure)
          ;; its own run, so that "it ran" can be checked: were the jolt-only
          ;; set dropped or emptied, the combined count would still look fine
          only-results (if (and jolt? (seq jolt-only)) (apply t/run-tests jolt-only) {})
          missing? (and jolt? (seq jolt-only) (zero? (:test only-results 0)))
          _ (when missing?
              (println "ERROR: jolt-only namespaces ran zero tests:" (str/join " " jolt-only)))
          results (merge-with + (select-keys pure-results counters) (select-keys only-results counters))
          failed (+ (:fail results 0) (:error results 0) @load-failures (if missing? 1 0))]
      (println "----")
      (println "tests:" (:test results 0)
               "assertions:" (:pass results 0) "passed /"
               failed "failed")
      (when (pos? failed) (exit 1)))))
