# Changelog

## 2026-10-04: pinned to GitHub

- `common/deps.edn` pins raylib-ios at 5691933 (`:git/url` and the full `:git/sha`)
  instead of a checkout beside this repo, which `:local/root "../../raylib-ios"` used
  to need. The first `bb doctor` fetches it into jolt's gitlibs.
- CI drops the second `actions/checkout` and the `path` and `working-directory`
  settings, as raylib-jolt-demo's does.

## 2026-10-04: the split

- The scenes moved here from raylib-ios as 136 sub-projects, one per scene, laid
  out as raylib-jolt-demo lays out its demos. Each builds an iOS app that shows
  that scene full screen through raylib-ios's single-scene runner.
- Each sub-project is named after the raylib-jolt-demo demo it ports. All 136 have
  one, including the three carried from jasalt/jolt-android-experiment (`eyes`,
  `mouse-trail` and `flappy-bird`). `demos.edn` records the scene id beside the name.
- Hello, the basic window, stays in raylib-ios. The gallery takes it from there and
  still shows 137 scenes.
- `gallery/` is the 137-scene app. Its registry is generated from `demos.edn`.
  The smoke test that runs every scene's update and draw for 120 frames over
  stubbed raylib moved with it, along with a new check that the registry holds
  raylib-ios's pre-split scenes, in order and by category.
- `bb gen` writes the root `deps.edn` and tasks, each sub-project's files, the
  gallery registry and the scene gallery page. `bb gen --check` is a CI gate.
- Namespaces are `net.b12n.raylib-ios.scenes.<id>`, with the draw method in
  `...<id>.draw` and the apps in `...<id>.app` and `...<id>.live`.
- The three carried scenes are identical to the Android experiment apart from
  namespace names and whitespace. The identity check for them moved with them.
- Device builds need jolt v0.8.15. See the README.
- The gallery app hands its registry to raylib-ios's shell with `gallery/run!`, so the
  menu lists the registry's scenes and categories and nothing else. The smoke test calls
  the shell's `guard-scene` and `next-scroll`, which are public now.
