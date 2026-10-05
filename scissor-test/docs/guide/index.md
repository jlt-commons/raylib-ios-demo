# Scissor

A moving scissor box clips a grid. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

![Scissor on an iPhone 17 Pro](../../../docs/images/clipbox.png)

## What it is

A grid drawn across the whole screen, with only the part inside a moving box visible. Ported from raylib-jolt-demo's `scissor-test` demo (originally raylib-jlt's `scissor_test`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 435 rectangles, most clipped | 58 | a scene's own clip, intersected with the safe region |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb scissor-test      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.clipbox.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/clipbox.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/clipbox/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/clipbox_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `scissor-test` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
