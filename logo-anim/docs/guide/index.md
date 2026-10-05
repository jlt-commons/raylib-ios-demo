# raylib Logo

The raylib logo assembling itself. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

![raylib Logo on an iPhone 17 Pro](../../../docs/images/logoanim.gif)

## What it is

raylib's logo assembling itself, ported from raylib-jolt-demo's `logo-anim` demo (originally raylib-jlt's `logo_anim`), which ports raylib's own shapes_logo_raylib_anim.c.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 4 rectangles and a word | 58 | nothing eased, on purpose |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb logo-anim      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.logoanim.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/logoanim.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/logoanim/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/logoanim_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `logo-anim` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
