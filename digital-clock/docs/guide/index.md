# Clock

A seven-segment clock from libc time. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

![Clock on an iPhone 17 Pro](../../../docs/images/clock.gif)

## What it is

A seven-segment clock, ported from raylib-jolt-demo's `digital-clock` demo (originally raylib-jlt's `digital_clock`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 42 rectangles | 59 | libc `time()` through the FFI |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb digital-clock      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.clock.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/clock.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/clock/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/clock_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `digital-clock` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
