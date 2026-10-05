# rlgl Hue Wheel

A hue wheel with a colour on every vertex. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

A hue wheel built as an rlgl triangle fan, with a colour on every vertex. Ported from raylib-jolt-demo's `rlgl-color-wheel` demo (originally raylib-jlt's `rlgl_color_wheel`), which is raylib's `shapes_rlgl_color_wheel` example. It is a different example from `colorwheel`, which came from `color_wheel` and draws filled sectors: this one hands the GPU a few dozen triangles that share the centre and lets it interpolate every shade between the rim hues.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| a fan of 3 to 128 triangles with a colour on every vertex, or 2 lines a wedge as a wireframe, and 3 lines of text | 58 | a vertical swipe doubles or halves the triangle count in place of the mouse wheel, a horizontal drag sets the centre brightness in place of the arrow keys and a tap toggles the wireframe in place of SPACE, and the wireframe spokes ignore the brightness because a thick line takes one colour; the wheel fits the safe region, so UP and DOWN resizing is dropped; a different example from Colour Wheel |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb rlgl-color-wheel      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.huewheel.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/huewheel.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/huewheel/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/huewheel_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `rlgl-color-wheel` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
