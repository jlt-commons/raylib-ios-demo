# Rounded Bars

Per-side rounded bars with a gradient. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

![Rounded Bars on an iPhone 17 Pro](../../../docs/images/bars.png)

## What it is

Five bars, each rounded by a different amount on its left and right ends, each filled with a horizontal gradient. Ported from raylib-jolt-demo's `rectangle-advanced` demo (originally raylib-jlt's `rectangle_advanced`), itself raylib's `shapes_rectangle_advanced.c`.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 5 fans, 200 triangles | 60 | per-side rounding and a gradient, from one loop |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb rectangle-advanced      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.bars.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/bars.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/bars/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/bars_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `rectangle-advanced` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
