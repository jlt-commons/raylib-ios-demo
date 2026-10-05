# Rounded Rect

A rectangle breathing from square to round. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

![Rounded Rect on an iPhone 17 Pro](../../../docs/images/rounded.png)

## What it is

A rectangle with quarter-circle corners, its radius breathing from square to fully round. Ported from raylib-jolt-demo's `rounded-rectangle` demo (originally raylib-jlt's `rounded_rectangle`), itself raylib's `shapes_rounded_rectangle_drawing`.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 2 rects, 4 quarter disks | 58 | DrawRectangleRounded, decomposed |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb rounded-rectangle      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.rounded.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/rounded.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/rounded/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/rounded_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `rounded-rectangle` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
