# Analog Clock

A live analog clock face. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

![Analog Clock on an iPhone 17 Pro](../../../docs/images/analog.gif)

## What it is

A live clock face. Ported from raylib-jolt-demo's `analog-clock` demo (originally raylib-jlt's `analog_clock`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| a bezel, 60 ticks, 3 hands | 59 | rlgl stands in for the by-value Vector2 calls |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb analog-clock      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.analog.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/analog.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/analog/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/analog_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `analog-clock` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
