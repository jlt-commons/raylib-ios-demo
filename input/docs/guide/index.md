# Keyboard Ball

A ball moved with a thumb-stick. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

![Keyboard Ball on an iPhone 17 Pro](../../../docs/images/nudge.png)

## What it is

A ball moved with a thumb-stick. Ported from raylib-jolt-demo's `input` demo (originally raylib-jlt's `input`), which is raylib's `core_input_keys` example.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 1 circle, 1 line of text, and a thumb-stick ring and knob while held | 58 | a relative thumb-stick moves the ball, in place of the arrow keys: the press point is its centre, a finger within the tap slop of it does nothing, and beyond it the ball goes that way at the original's 2 pixels a frame, frame-locked like it; the vector is normalised, so a diagonal is no faster where the original's keys make it 2.83, and the ball is held wholly inside the field, which starts below the caption so the ball never covers it, and below Back where the original lets it leave the window; the speed and radius are scaled by one factor, and a rotation pulls the ball back in |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb input      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.nudge.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/nudge.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/nudge/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/nudge_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `input` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
