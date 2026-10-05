# 3D Picking

Tap a cube to pick it with a ray. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Tap a cube to pick it with a ray. Ported from raylib-jolt-demo's `picking-3d` demo (originally raylib-jlt's `picking_3d`), which is raylib's `core_3d_picking` example (zlib licence).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| the original's gray cube of side 2 with its DARKGRAY wires, a grid of 10 and the pick ray, projected in software (4 triangles and 29 lines from the start), and the readout "BOX SELECTED" with the hit's distance, point and normal | 58 | a tap replaces the click: it casts `GetScreenToWorldRay` through the tap's press position and tests the cube with `GetRayCollisionBox`, through the same camera and viewport the frame is drawn with; a hit turns the cube RED with MAROON wires and adds the 0.2 larger GREEN wires, and a tap while selected lets go without casting, as the original's latch does; the ray stays drawn, 10000 units from the camera as `DrawRay` does, with the stretch inside the cube cut out (there is no depth buffer, so a line through the opaque cube would show across it), though a part of the ray behind the cube can still show through it from some angles; it is seen end-on (a point) from the camera that cast it until the camera moves; a tap that misses says "missed" in the readout; the original's fps counter is dropped; a drag never picks; the camera circles by itself, 0.005 radians an update, at height 10 and radius 14 round (0, 1, 0), and stands still while a finger is down; a one-finger drag replaces the mouse-look and orbits it, 0.004 radians a pixel times 800 over the field's width, the height following the vertical drag between 2 and 25; the cursor lock, its right-click toggle and its hint, and W, A, S and D are dropped; a face with a corner behind the near plane is dropped whole; the original's 45 degree fovy is kept in a field as wide as 800x450 and widened in a narrower one; the 3D view is the field below the caption, which is below Back, and is clipped to it |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb picking-3d      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.picking.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/picking.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/picking/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/picking_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `picking-3d` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
