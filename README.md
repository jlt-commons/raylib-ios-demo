# raylib-ios-demo

The raylib examples as iPhone apps. A hundred and thirty-seven scenes, drawn by
raylib 6.0 over SDL2 and driven from Clojure by [Jolt](https://github.com/jolt-lang/jolt),
each one a sub-project that builds an app of its own, plus a gallery app that holds
them all behind a two-level menu.

The platform underneath, the host loop, the single-scene runner, the build tools
and the bindings, is [raylib-ios](https://github.com/jlt-commons/raylib-ios).
This repo is what runs on it. It is laid out the way
[raylib-jolt-demo](https://github.com/jlt-commons/raylib-jolt-demo) lays out the
desktop examples, and every scene stands for one of that repo's demos, which were
originally raylib-jlt's.

## What is here

```
demos.edn            every scene: directory, id, category, title, description, origin
<name>/              one sub-project per scene (136 of them)
  deps.edn bb.edn
  src/.../scenes/<id>.cljc        the scene, pure: no raylib, no platform
  src/.../scenes/<id>/draw.clj    its draw-scene! method
  src/.../scenes/<id>/app.clj     generated: the scene full screen, no menu
  src/.../scenes/<id>/live.clj    generated: the same with an nREPL (dev)
  test/.../scenes/<id>_test.cljc
  docs/guide/index.md
gallery/             the 137-scene app: a generated registry, the smoke test, the checks
common/              pins raylib-ios, and the shared test runner
scripts/gen.clj      rebuilds everything generated from demos.edn
scripts/ios_tools.clj  finds raylib-ios and calls its build, deploy and live scripts
tools/               the jasalt identity check for the three carried scenes
docs/                the site, the scene catalog and the porting guides
```

Hello, the basic window, is the one scene that is not a sub-project. It lives in
raylib-ios as the platform's own proof, and the gallery takes it from there, which
is how the gallery still shows 137.

## Running one

You need the phone's hardware udid (`jolt devices` lists it), Xcode, a paired
iPhone. raylib-ios arrives as a git dependency pinned by sha in `common/deps.edn`,
and the first `bb doctor` fetches it into jolt's gitlibs, so that run needs the
network. raylib-ios's README covers the one-time setup of the SDL2 and raylib
archives.

```sh
bb doctor                       # is jolt there, does raylib-ios resolve, is Xcode there?
UDID=<hardware udid> bb gallery           # all scenes in one app
UDID=<hardware udid> bb asteroids         # one scene as an app of its own
UDID=<hardware udid> bb live asteroids    # the same, with an nREPL (dev builds only)
UDID=<hardware udid> bb proxy          # another terminal, after bb live: the nREPL over USB
bb list                         # every scene, with its category and description
bb test                         # every scene's tests, no device needed (11 scenes have none yet, and bb test <scene> says so)
```

Device builds need **jolt v0.8.15**. From v0.8.16 on, `jolt live` fails to build
(`variable error is not bound` in the `jolt.socket.native` unit), and the builds
after that release do too. Nothing in this repo pins the version, so install 0.8.15
before building for the phone, and move on once jolt fixes it. Every other task runs on
any jolt from 0.8.0.

A scene app installs under the same bundle id as the gallery, so building one
replaces the other on the phone.

## How the pieces fit

Each sub-project's `bb.edn` finds raylib-ios through its own dependencies. It asks
`jolt -Spath` for the classpath and takes the `src` entry that sits beside
`tools/ios/build.sh`. With a `:local/root` that is the checkout, and with a
`:git/sha` it is the gitlibs copy. `scripts/ios_tools.clj` is the one place that does
this, and the root tasks, the sub-project tasks and `bb doctor` all go through it.
It then runs raylib-ios's `build.sh`, `deploy.sh` or `live.sh` with `PROJECT_DIR` set
to the sub-project, so the app is compiled from that sub-project's `deps.edn` and
holds its own scene and nothing else.

The gallery's registry, `gallery/src/.../gallery/registry.clj`, is written by `bb gen`
from `demos.edn`. It requires every scene and every draw namespace, so each
`draw-scene!` method is registered, and lists the scenes and categories in order.
The gallery app hands them to raylib-ios's shell as data, `(gallery/run! registry/gallery)`,
and the dev variant does the same through `live/live-run!`. The shell holds no scene of its
own beyond Hello.

## Tests and gates

```sh
jolt -M:test        # a little over a thousand tests under jolt, plus the smoke test and the checks
clojure -M:test     # the same pure tests on the JVM, plus the jasalt identity check
bb gen --check      # generated files match demos.edn
bb lint:strict      # clj-kondo, warnings fail
bb check            # every app namespace loads, no window
```

The gallery smoke test runs every scene's update and `draw-scene!` for 120 frames over
stubbed raylib. The checks test confirms that `bb gen` has nothing to change, that the
registry holds the same 137 scenes in the same order and categories as raylib-ios
did before the split, and that every sub-project's app loads in a fresh jolt that sees
only that sub-project's classpath. CI runs the jolt suite under jolt 0.8.6.

## Moving to a newer raylib-ios

raylib-ios is pinned in exactly one place, the `:git/sha` in `common/deps.edn`.
Every sub-project depends on `common/`, so they all follow it. Before you move,
check that raylib-ios's CI is green at the commit you want.

Change the sha, then run:

```sh
bb doctor           # its "raylib-ios at" line should end in the new sha
bb gen --check
bb check
bb lint:strict
jolt -M:test
clojure -M:test
```

Then build `bb gallery` and open a few scenes on the phone, since the tests run over
stubbed raylib. The gallery smoke test redefines some raylib-ios internals and keeps
a copy of its rlgl model in `gallery/test/.../rlgl_model.clj`, so a refactor inside
raylib-ios can fail it even when no public name changed. Fix the copy, not the pin.

To try a raylib-ios change that isn't pushed yet, point `common/deps.edn` at the
checkout with `{:local/root "../../raylib-ios"}` and run the same gates. Don't commit
that: CI can't see your checkout.

## Adding a scene

See [CONTRIBUTING.md](CONTRIBUTING.md). Short version: make the sub-project, add a line
to `demos.edn`, run `bb gen`.

## Licence

EPL 2.0, in [LICENSE](LICENSE). Each scene keeps the licence it came with, and
[NOTICE](NOTICE) records them: raylib-jlt was zlib before 2026-09-05 and EPL 2.0
after, every raylib C example is zlib, three scenes are MIT from
jasalt/jolt-android-experiment and three more are MIT from babashka/ffi by way of
raylib-jlt. Every scene's docstring names the demo it was ported from.
