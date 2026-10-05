# Basic Shapes

A static tour of the basic shapes. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

A static tour of the basic shapes: a filled and an outlined rectangle, a filled and an outlined circle, an ellipse, a line and a triangle. Ported from raylib-jolt-demo's `shapes` demo (originally raylib-jlt's `shapes`), itself raylib's `shapes_basic_shapes`. It is the side-by-side of the plain primitives, where `rounded`, `ring`, `sector` and `rlgltriangle` each animate one of them in depth and `outlines` studies a stroke's thickness. Nothing moves and nothing is read, so there is no input handling to get wrong.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 1 line of text, 2 rectangles, 2 circles, an ellipse of up to 180 triangles, 1 line, 1 triangle and 4 outline lines | 58 | nothing moves and nothing is read; the ellipse is a triangle fan whose segment count follows its radius, the circle outline is a ring and the lines are thicker than the original's hairlines so they show on a phone; laid out for portrait, where the original is 800 by 450 |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb shapes      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.shapes.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/shapes.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/shapes/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/shapes_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `shapes` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
