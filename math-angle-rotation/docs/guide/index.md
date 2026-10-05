# Angles

Fixed spokes and one that turns. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

![Angles on an iPhone 17 Pro](../../../docs/images/angles.gif)

## What it is

A ring of fixed spokes and one that turns, ported from raylib-jolt-demo's `math-angle-rotation` demo (originally raylib-jlt's `math_angle_rotation`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 13 lines and a circle | 59 | the two lines every circular scene here uses |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb math-angle-rotation      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.angles.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/angles.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/angles/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/angles_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `math-angle-rotation` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
