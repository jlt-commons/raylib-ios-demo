# Resize

Drag a corner handle to resize a rectangle. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

![Resize on an iPhone 17 Pro](../../../docs/images/resize.png)

## What it is

A rectangle you resize by dragging its corner handle. Ported from raylib-jolt-demo's `rectangle-scaling` demo (originally raylib-jlt's `rectangle_scaling`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| a rectangle and a corner handle | 58 | a sticky grab, because a finger has no hover |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb rectangle-scaling      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.resize.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/resize.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/resize/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/resize_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `rectangle-scaling` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
