# First-Person Camera

A first-person walk round a yard of columns. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

A first-person camera walked round a yard of columns on two thumbs, ported from raylib-jolt-demo's `camera-3d-first-person` demo (originally raylib-jlt's `camera_3d_first_person`) (zlib licence).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| the original's 40 random columns (x and z in -20 to 20, height 2 to 12, each colour 60 to 255) shaded face by face over a grid of 40, seen from an eye 2 up on a sky of (140, 190, 230), projected in software (about 70 triangles and 60 lines from the start), and 1 line of caption | 58 | the columns come from the project's LCG seeded with 20261002 in the original's order (x, z, h, r, g, b), so the yard is the same every run; the camera is the original's own yaw and pitch maths (it does not call `UpdateCamera`): forward on the ground is (cos yaw, sin yaw) and the target is the eye plus (cos pitch * cos yaw, sin pitch, cos pitch * sin yaw), with the Free Camera's stick direction reused; a relative thumb-stick started in the lower third of the field replaces WASD and walks 0.25 an update along the ground heading, one speed in every direction where the original's keys add up on a diagonal; a drag that starts in the upper two thirds replaces the mouse, 0.004 radians a pixel scaled by 800 over the field's width, the pitch held to +-1.4 radians as the original does; both work at once, each by its own finger (`net.b12n.raylib-ios.stick`), and a resting finger is never adopted; the frame counter (`fps!`) is dropped and the key text becomes a touch caption below Back; the original's 60 degree fovy is kept in a field as wide as 800x450 and widened in a narrower one; a face with a corner behind the near plane is dropped whole; the grid is drawn under every face, so a column hides the grid under its foot, and overlapping columns are ordered whole, face by face; the 3D view is the field below the caption, which is below Back, and is clipped to it |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb camera-3d-first-person      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.fpcamera.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/fpcamera.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/fpcamera/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/fpcamera_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `camera-3d-first-person` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
