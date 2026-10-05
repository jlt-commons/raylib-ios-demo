# 3D Camera

An orbiting 3D camera. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

An orbiting 3D camera, ported from raylib-jolt-demo's `camera-3d` demo (originally raylib-jlt's `camera_3d`), which is raylib's `core_3d_camera_mode` family (zlib licence).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| the original's grid of 20 and a red cube shaded face by face, projected in software (about 4 triangles and 42 lines), and 1 line of text | 58 | no input, as the original has none; the camera orbits at radius 12 and height 8 by 0.02 radians a frame, looking at (0, 1, 0), with the original's fovy 45, widened in a field narrower than 800x450 so the original's horizontal view still fits; the 3D view is the field below the caption, which is below Back, and is clipped to it |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb camera-3d      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.camera3d.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/camera3d.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/camera3d/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/camera3d_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `camera-3d` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
