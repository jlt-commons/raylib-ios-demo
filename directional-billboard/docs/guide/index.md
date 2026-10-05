# Directional Billboard

A walking billboard figure seen from all sides. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

A walking figure on a camera-facing billboard, whose pose changes as the camera goes round it, ported from raylib-jolt-demo's `directional-billboard` demo (originally raylib-jlt's `directional_billboard`) (zlib licence, after raylib's models_directional_billboard). The projection is in software, by `net.b12n.raylib-ios.soft3d`.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| the original's figure on a billboard of side 1 at (0, 0.5, 0) over a grid of 10 with the camera going round at 0.5 radians a second on a circle of 2.83 and 1 up, projected in software (8 rectangles, 16 triangles, and 22 lines) and 1 line of text; about 0.16 ms a frame on the laptop with the draw side's code run | 58 | the row from the view angle (`floor(atan2(z, x) / pi * 4 + 1/4)`, plus 8 when negative), the walk frame stepping when a timer passes 0.5 s, the orbit and the camera are the original's, and a test compares the row with a copy of the original's at about 2400 angles; the sheet's cell is redrawn as the two legs, body and head in value 0.5, 0.7 and 1 of hue 45 degrees a row, the legs, body and head pixel for pixel (all 32 poses checked against the original's rule) and the head as five rectangles that follow its circle row by row (the whole cell checked against the original's rule); the figure is the sheet mirrored left to right, as the original's quad draws it; the original reads no input, so none is mapped; its two text lines become one ("animation: N  direction frame: N") below Back; there is no `finish`; the 3D view is clipped to the field |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb directional-billboard      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.dirbillboard.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/dirbillboard.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/dirbillboard/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/dirbillboard_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `directional-billboard` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
