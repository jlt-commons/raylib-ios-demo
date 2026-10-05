# Colour Wheel

An HSV colour wheel as an rlgl triangle fan. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

![Colour Wheel on an iPhone 17 Pro](../../../docs/images/colorwheel.gif)

## What it is

An HSV colour wheel drawn as an rlgl triangle fan, ported from raylib-jolt-demo's `color-wheel` demo (originally raylib-jlt's `color_wheel`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 540 vertices | 59 | [rlgl immediate mode](https://jlt-commons.github.io/raylib-ios/guide/rlgl-immediate-mode.html) |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb color-wheel      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.colorwheel.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/colorwheel.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/colorwheel/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/colorwheel_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `color-wheel` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
