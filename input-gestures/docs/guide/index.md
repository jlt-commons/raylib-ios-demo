# Input Gestures

Raylib's gesture recogniser, named and logged. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

What raylib's own gesture recogniser reports, named and logged. Ported from raylib-jolt-demo's `input-gestures` demo (originally raylib-jlt's `input_gestures`), which is raylib's `core_input_gestures` example (zlib licence).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| a log of up to 20 gesture names in alternating rows, the newest in maroon, a test box with a title and a hint line, and a finger circle while a gesture is set | 58 | raylib's own gesture recogniser, read through `GetGestureDetected` as `:raylib-gesture`, names tap, double-tap, hold, drag and the four swipes, logged when the code changes and the finger is in the box; the finger comes from `:pointer`, the last position seen on a press or a drag when the gesture is reported on release, never the release position; **pinch in and pinch out never appear**, because raylib's SDL platform feeds its gesture system one touch point at a time, and the hint line says so; the log stacks above the box in portrait and runs down its left in landscape, with text sizes shrunk until 20 rows fit |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb input-gestures      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.gestures.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/gestures.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/gestures/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/gestures_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `input-gestures` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
