# Textured Cube

Two textured cubes under an orbiting camera. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Two textured cubes under an orbiting camera, ported from raylib-jolt-demo's `textured-cube` demo (originally raylib-jlt's `textured_cube`) (zlib licence, after raylib's rlgl immediate-mode textured quads). The projection is in software, by `net.b12n.raylib-ios.soft3d`.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| the original's two cubes (2 by 4 by 2 at (-2, 2, 0), and 2 by 2 by 2 at (2, 1, 0)) over a grid of 10 with the camera going round at 0.01 radians a frame, 14 out and 8 up, projected in software (up to 30 triangles and 22 lines) and 1 line of text; about 0.15 ms a frame on the laptop with the draw side's code run (0.20 at worst), against the 0.30 ms target | 59 | the camera, its angle, the cubes, their sizes, the grid and the six faces' vertex lines with their texture coordinates are the original's, and a test compares every sub-quad's colour with the original's texture at that spot of that face, and its winding with the face's outward normal; there is no texture, so each face is drawn as the quads of its texels: the whole cube's face as the atlas's four quadrants (red, green, blue, yellow, cut at 0.5 as the 64 by 64 atlas has them, so nothing is lost to the cut) and the slice cube's face as one blue quad, since its slice u 0 to 0.5, v 0.5 to 1 lies in one quadrant; the slice cube's v runs the other way up, as the original's `draw-cube-texture-rec` has it; the original reads no input, so none is mapped; its text line sits below Back; there is no `finish`: the grid goes first, a convex cube needs only its back faces left out, and the cube on the camera's side of the plane x = 0 is painted last, which a test checks with rays; the 3D view is clipped to the field |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb textured-cube      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.texcube.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/texcube.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/texcube/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/texcube_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `textured-cube` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
