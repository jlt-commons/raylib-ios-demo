# Billboard Rendering

Camera-facing billboards over a grid. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Two camera-facing billboards over a grid, one of them spinning, with the camera going round them, ported from raylib-jolt-demo's `billboard-rendering` demo (originally raylib-jlt's `billboard_rendering`) (zlib licence, after raylib's models_billboard_rendering). The projection is in software, by `net.b12n.raylib-ios.soft3d`, whose `billboard` builds each quad from the same corner maths as rmodels.c's DrawBillboardPro.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| the original's two billboards of side 2 at (0, 2, 0) and (1, 2, 1), one of them turning 0.4 degrees a frame, over a grid of 10 with the camera going round at 0.5 radians a second from 7.07 out and 4 up, projected in software (6 triangles each, up to 12 and 22 lines) and 1 line of text; about 0.13 ms a frame on the laptop with the draw side's code run, against the 0.30 ms target | 59 | the camera, the spin, the positions, the sizes and the grid are the original's, and a test compares every corner with a copy of the original's `draw-billboard`; the texture is redrawn as three flat squares (blue the whole billboard, red 0.7 of it, yellow 0.35) where the original's ring is circles, so the squares' corners are the difference and the squares visibly turn with the spin where the original's circles do not (discs of strips measured 0.62 ms, over the 0.30 ms target); the original's quad is the camera's mirror image where raylib's DrawBillboardPro is not, which this atlas hides; the original reads no input, so none is mapped; there is no `finish`, because the squares are coplanar and painted in order and the two billboards are on parallel planes, painted farther first by depth along the view axis where the original sorts by the distance of the centre from the camera (that is wrong for about 5.7 degrees of each lap, which its depth buffer hides); the caption sits below Back; the 3D view is clipped to the field |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb billboard-rendering      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.billboard.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/billboard.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/billboard/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/billboard_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `billboard-rendering` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
