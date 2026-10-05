(ns net.b12n.raylib-ios.demo.checks-test
  "The three checks that say the split is whole, run from the repo root.

  - gen-is-current: `bb gen --check` finds nothing out of date.
  - the-gallery-has-137-scenes: the generated registry holds the scenes
    raylib-ios's gallery held before the split, in the same order and the same
    categories (expected_registry.edn, measured from raylib-ios at 12bab71).
  - every-app-ns-loads-alone: for every sub-project, a fresh jolt started in its
    own directory, so with the classpath of that sub-project and nothing else,
    loads its app namespace. All 137 loads, one after another: a load takes
    about a fifth of a second, so the whole check runs in well under a minute.

  A .clj test, so jolt only: the registry loads jolt.ffi."
  (:require
   [clojure.edn :as edn]
   [clojure.java.shell :as sh]
   [clojure.string :as str]
   [clojure.test :refer [deftest is testing]]
   [net.b12n.raylib-ios.demo.gallery.registry :as reg]))

(def ^:private expected
  (edn/read-string (slurp "gallery/test/net/b12n/raylib_ios/demo/expected_registry.edn")))

(def ^:private demos (edn/read-string (slurp "demos.edn")))

(def ^:private sub-projects (remove :home demos))

(deftest gen-is-current
  (let [{:keys [exit out err]} (sh/sh "bb" "gen" "--check")]
    (is (zero? exit) (str "bb gen --check:\n" out err))))

(deftest the-gallery-has-137-scenes
  (is (= 137 (count reg/scenes)))
  (testing "the ids are raylib-ios's pre-split registry, in order"
    (is (= (:ids expected) (mapv :id reg/scenes))))
  (testing "the categories are too, with the same scenes in the same order"
    (is (= (:categories expected) reg/categories)))
  (testing "demos.edn lists the same scenes, 136 of them as sub-projects"
    (is (= (:ids expected) (mapv :id demos)))
    (is (= 136 (count sub-projects)))
    (is (= [:hello] (mapv :id (filter :home demos))))))

(defn- loads-alone
  "nil when a fresh jolt in `dir` loads `ns`, else what it said."
  [dir ns]
  (let [{:keys [exit out err]} (sh/sh "jolt" "-e" (str "(require '" ns ")") :dir dir)]
    (when-not (zero? exit)
      (str dir ": " ns " did not load (exit " exit ")\n" (str/join "\n" (take-last 8 (str/split-lines (str out err))))))))

(deftest every-app-ns-loads-alone
  (let [targets (concat (for [d sub-projects]
                          [(:name d) (str "net.b12n.raylib-ios.scenes." (name (:id d)) ".app")])
                        [["gallery" "net.b12n.raylib-ios.demo.gallery.app"]])
        failures (keep (fn [[dir ns]] (loads-alone dir ns)) targets)]
    (is (= 137 (count targets)))
    (is (empty? failures) (str (count failures) " of " (count targets) " failed:\n" (str/join "\n" failures)))))

(deftest an-untested-scene-says-so-instead-of-opening-a-repl
  ;; stdin is closed, so a jolt that fell through to a REPL would read EOF and
  ;; still exit 0: the message is what proves it did not start.
  (let [{:keys [exit out]} (sh/sh "bb" "test" "spirograph" :in "")]
    (is (zero? exit))
    (is (str/includes? out "spirograph: no tests"))))
