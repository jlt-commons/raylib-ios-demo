# Gradients

Colour interpolated across a rectangle. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

![Gradients on an iPhone 17 Pro](../../../docs/images/gradient.png)

## What it is

Colour interpolated across a rectangle. Ported from raylib-jolt-demo's `gradient` demo (originally raylib-jlt's `gradient`), itself raylib's `shapes_rectangle_gradient.c`.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 4 quads, 8 vertices | 58 | one rlgl quad covers raylib's three calls |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb gradient      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.gradient.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/gradient.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/gradient/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/gradient_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `gradient` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
