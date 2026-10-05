(ns ios-tools
  "Building, installing and testing one sub-project, through raylib-ios's tools.

  raylib-ios owns tools/ios (build.sh, deploy.sh, live.sh). This repo never
  copies them and never names a path to them: each sub-project finds the
  raylib-ios its dependencies resolve to, whatever that is. With a :local/root
  that is the checkout it points at, and with a :git/sha it is the gitlibs
  checkout. This is the ONE place that resolution lives, and every sub-project's
  tasks, the root tasks and `bb doctor` all go through it.

  The tools build the jolt project they are run from (PROJECT_DIR) and the
  namespace they are given (NS), so a sub-project's app is built from its own
  deps.edn and carries only its own scene.

  Device builds need the jolt version the README names; nothing here pins it."
  (:refer-clojure :exclude [run!])
  (:require
   [babashka.fs :as fs]
   [babashka.process :as p]
   [clojure.string :as str]))

(defn jolt-cmd [] (if (fs/which "jolt") "jolt" "joltc"))

(defn spath
  "The classpath entries `dir`'s deps.edn resolves to, from `jolt -Spath`, or
  throws with jolt's own complaint."
  [dir]
  (let [{:keys [exit out err]} (p/shell {:dir (str dir)
                                         :out :string
                                         :err :string
                                         :continue true}
                                        (jolt-cmd) "-Spath")]
    (when-not (zero? exit)
      (throw (ex-info (str "`" (jolt-cmd) " -Spath` failed in " dir ":\n" err) {})))
    (remove str/blank? (str/split (str/trim out) (re-pattern java.io.File/pathSeparator)))))

(defn raylib-ios-root
  "The raylib-ios checkout that `dir`'s dependencies resolve to: the parent of
  the classpath entry ending in `src` that sits beside tools/ios/build.sh."
  [dir]
  (let [dir (fs/absolutize dir)]
    (or (first (for [entry (spath dir)
                     :let [src (fs/normalize (fs/absolutize (fs/path dir entry)))
                           candidate (fs/parent src)]
                     :when (and (= "src" (str (fs/file-name src)))
                                (fs/exists? (fs/path candidate "tools" "ios" "build.sh")))]
                 (str candidate)))
        (throw (ex-info (str "No raylib-ios with tools/ios on the classpath of " dir
                             ". Check common/deps.edn: does net.b12n/raylib-ios resolve?")
                        {})))))

(defn- tool [dir script] (str (raylib-ios-root dir) "/tools/ios/" script))

(defn- sh!
  "Run `sh <script>` from raylib-ios's tools/ios against the project in `dir`,
  returning the exit code. The caller's environment (UDID, TARGET, DEV_BUILD,
  ...) passes through; `env` adds to it."
  [dir script env]
  (let [dir (str (fs/absolutize dir))
        {:keys [exit]} (p/shell {:continue true
                                 :dir dir
                                 :extra-env (merge {"PROJECT_DIR" dir} env)}
                                "sh" (tool dir script))]
    exit))

(defn- ok-or
  "0, or the exit of the first step that fails."
  [& steps]
  (reduce (fn [_ step] (let [exit (step)] (if (zero? exit) 0 (reduced exit)))) 0 steps))

(defn build!
  "Cross-compile `ns` into dir/RaylibIOS.app (TARGET defaults to the phone)."
  [dir ns]
  (sh! dir "build.sh" {"NS" ns}))

(defn deploy!
  "Sign, install and launch dir/RaylibIOS.app. UDID names the phone."
  [dir]
  (sh! dir "deploy.sh" {}))

(defn run!
  "Build `ns` and install it on the phone."
  [dir ns]
  (ok-or #(build! dir ns) #(deploy! dir)))

(defn live!
  "Build `ns` as a dev app with an nREPL, install it and say how to reach it.
  A release build inlines, so a var redefined over the nREPL would never reach
  the running loop: live work needs DEV_BUILD=1, which this sets unless you did."
  [dir ns]
  (sh! dir "live.sh" {"NS" ns
                      "DEV_BUILD" (or (System/getenv "DEV_BUILD") "1")}))

(defn test!
  "Run the tests of the sub-project in `dir`, under jolt."
  [dir]
  (:exit (p/shell {:continue true
                   :dir (str dir)} (jolt-cmd) "-M:test")))

(defn exit-with [exit]
  (when-not (zero? exit) (System/exit exit)))
