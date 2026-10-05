# Kaleidoscope

A stroke mirrored with six-fold symmetry. One of the Generative scenes in the raylib-ios gallery, and an app of its own here.

![Kaleidoscope on an iPhone 17 Pro](../../../docs/images/kaleidoscope.gif)

## What it is

Six-fold symmetry over a moving stroke, ported from raylib-jolt-demo's `kaleidoscope` demo (originally raylib-jlt's `kaleidoscope`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 708 lines | 58 | 60-point trail, twelve-fold symmetry |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb kaleidoscope      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.kaleidoscope.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/kaleidoscope.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/kaleidoscope/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/kaleidoscope_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `kaleidoscope` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
