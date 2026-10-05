# Basic Voxel

A voxel block you walk round and hollow out. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

A block of voxels you walk round and hollow out, on two thumbs. Ported from raylib-jolt-demo's `basic-voxel` demo (originally raylib-jlt's `basic_voxel`), which is raylib's `models_basic_voxel` (zlib licence). The projection is in software, by `net.b12n.raylib-ios.soft3d`.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| the original's 8 by 8 by 8 block of 512 unit voxels at the integer positions 0 to 7, BEIGE with BLACK wires, over a grid of 10, from a 45 degree camera that orbits the block's centre (radius 22, height 14, 0.006 radians an update) until you steer it, projected in software: only the exposed faces draw (384 on the full block), merged plane by plane into rectangles of one flat colour (the view from two sides is 4 triangles and 35 wire lines, from three sides 6 triangles and 51 lines; a block eaten full of holes is hundreds), a RED crosshair dot of radius 4 in the middle of the field, a voxel count as the caption below Back and a button for what a tap does | 59 | the world, the walk and look maths (forward (cos yaw, sin yaw), right (-sin yaw, cos yaw), SPEED 0.15, SENS 0.004, pitch held to +-1.4, the height never changing), the idle orbit with its hand-over, the crosshair as the ray and the nearest-voxel pick are the original's, with `soft3d/screen->ray` and `ray-box` standing in for its brute-force slab test; a relative thumb-stick started in the lower third of the field replaces WASD at one speed in every direction, a drag that starts in the upper two thirds replaces the mouse (0.004 radians a pixel scaled by 800 over the field's width), both at once, each by its own finger (`net.b12n.raylib-ios.stick`), a resting finger never adopted; a tap in the field is the left click and removes the voxel under the crosshair, wherever the tap lands, and it hands the camera over; a tap that moved, that ended a touch of two fingers or that began under Back does nothing; **the original has no placing**, so the button in the row under Back ("tap: remove" / "tap: place") is an addition: in place mode a tap puts a voxel on the face of the nearest voxel the ray entered, and does nothing on a miss, on an occupied cell or on the eye's cell; the frame counter and the original's two text lines are dropped (the caption is the voxel count); the 45 degree fovy is kept in a field as wide as 800x450 and widened in a narrower one; there is no depth buffer, so the wires draw over every fill (nothing is sorted, every fill being one opaque colour), which in a hollowed pit can show an edge of the far wall over the rim in front of it, and a face with a corner behind the near plane is dropped whole; wires that carry on in a straight line are joined into one line (same pixels, 35 instead of 280 from two sides); **the cost follows the exposed faces and mostly the wires**: under jolt on the laptop, with the draw side's code stubbed, a frame is 0.20 ms from two sides, 0.28 ms from three (the orbit's 45 degree corner) and 0.94 ms with a third of the block eaten in a scattered pattern (about three times the 0.30 ms target, and not timed on the phone), because each pit adds its walls (0.38, 0.56 and 1.3 before the merge and with a sort, which measured 32 to 57 fps on the phone); caching the exposed faces until the world changes, merging them, dropping the sort and joining wires were taken, no voxels were cut; a tap is ignored while another finger is down, so you stop walking to remove, where the original clicks while holding W; picking from inside the block takes the voxel the eye is in, as the original does |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb basic-voxel      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.voxel.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/voxel.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/voxel/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/voxel_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `basic-voxel` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
