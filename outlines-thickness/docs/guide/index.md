# Outline Thickness

Three outlines driven by one thickness. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Three outlines driven by one thickness: a rectangle, a rounded rectangle and a ring, so the same setting can be compared across them. Ported from raylib-jolt-demo's `outlines-thickness` demo (originally raylib-jlt's `outlines_thickness`), itself raylib's `shapes_outlines_thickness` minus its raygui slider. It differs from `rounded`, which animates a filled shape's corner radius, and from `ring`, which animates an annulus's sweep: here the radius is fixed and the subject is the stroke width, including below zero.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 7 lines of text, 3 filled shapes, 8 lines (4 rectangle sides and 4 rounded sides), 4 corner arcs and 1 ring | 58 | the value sweeps on its own as the original does, until a touch takes over, and a vertical drag then sets it in place of UP and DOWN, the anchor taken on press and the release swipe ignored; below zero the plain rectangle draws nothing, the rounded one is a one pixel hairline and only the ring grows outward, as raylib does; the range is the original's -30 to 30 and the shapes are scaled to fit below Back |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb outlines-thickness      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.outlines.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/outlines.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/outlines/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/outlines_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `outlines-thickness` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
