# 3D Free Camera

A free 3D camera on two thumbs. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

A free 3D camera on two thumbs, ported from raylib-jolt-demo's `camera-3d-free` demo (originally raylib-jlt's `camera_3d_free`), which is raylib's `core_3d_camera_free` example (zlib licence).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| the original's red cube of side 2 drawn flat as `DrawCube` does it, its maroon wires, a grid of 10 and the translucent help box with four lines of text, projected in software (6 triangles and about 31 lines from the start), and a "reset" button | 58 | raylib's own `UpdateCamera(CAMERA_FREE)` is rebuilt in pure Clojure from rcamera.h (forward, up, right, move forward, move right, move to target, yaw, pitch with the view locked 0.001 radians short of vertical); a drag that starts in the upper two thirds of the field looks, at 0.003 radians a pixel scaled by 800 over the field's width; a relative thumb-stick started in the lower third replaces WASD and moves along the view at 5.4 units a second times the frame time, one speed in every direction, where the original's keys add up on a diagonal; two fingers both in the upper two thirds pinch to dolly in place of the wheel, and two fingers in different regions are look plus stick; "reset" replaces Z and sets only the target to the origin; the cursor lock, the arrow keys, Q and E, Space and Control, the middle-mouse pan, the gamepad and the keypad keys are dropped; the help text names the touch controls; a face with a corner behind the near plane is dropped whole, so flying into the cube makes its faces vanish; the original's 45 degree fovy is kept in a field as wide as 800x450 and widened in a narrower one so the original's horizontal view still fits; the grid is drawn under every face, so where the original's grid crosses the lower half of its cube (centred on y = 0, half below the grid) the lines a depth buffer would show in front of it are hidden here; the 3D view is the field below the caption row, which is below Back, and is clipped to it |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb camera-3d-free      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.freecam.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/freecam.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/freecam/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/freecam_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `camera-3d-free` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
