# Textured Curve

A road texture laid along a Bezier curve. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Textured Curve, ported from raylib-jolt-demo's `textured-curve` demo (originally raylib-jlt's `textured_curve`) (net/b12n/raylib_jlt/textured_curve.clj, EPL 2.0), which is raylib's `textures_textured_curve`: a road texture laid along a cubic Bezier as a strip of quads, each square across the curve at its point. The raylib C example it follows is zlib licensed, and this is an altered version of that too.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| a 64 by 128 road texture laid along a cubic Bezier as 3 to 48 quads (2 triangles each), 2 lines of text and 4 buttons | 58 | the original's road, asphalt with two white edge lines and four yellow dashes, REPEAT wrap and LINEAR filter (both sides are powers of two); each quad is square across the curve with the previous segment's normal on its near edge, and v accumulates by arc length, `len / 256`, so the dashes keep an even spacing; the middle two control points swing on their own at 0.015 `t` a frame, and nothing a finger does moves them; WIDTH - and WIDTH + repeat while held at 0.8 a frame between 6 and 80, SEG - and SEG + step the count once a press between 3 and 48; at the widest settings the ribbon can fold on a tight bend, and a folded triangle draws as a mirrored sliver where the original's RL_QUADS would be culled by rlgl; a reopen costs about one frame |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb textured-curve      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.texcurve.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/texcurve.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/texcurve/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/texcurve_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `textured-curve` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
