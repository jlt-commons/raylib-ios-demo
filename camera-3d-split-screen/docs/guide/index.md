# 3D Split Screen

Two players, two cameras, half a screen each. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Two players on a plane of cube trees, each seen by its own camera in half of the screen, ported from raylib-jolt-demo's `camera-3d-split-screen` demo (originally raylib-jlt's `camera_3d_split_screen`) (zlib licence, from raylib's `core_3d_camera_split_screen`). The projection is in software, by `net.b12n.raylib-ios.soft3d`.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| the original's 121 trees (a lime cube of side 1 on a brown post of 0.25 by 1 by 0.25, 4 apart) and two cube players on a beige plane, flat coloured as `DrawCube` colours them, seen by two software-projected cameras in two scissored halves on a sky of SKYBLUE (at the start on the phone's screen a half builds 126 and 197 triangles, no lines, 323 for both halves), each with a translucent bar and 1 line of text, and a divider | 58 | the world, both cameras (player one at (0, 1, z1) looking down +z, player two at (x2, 3, 0) looking down +x, fovy 45), the start of -3 and the speed of `10 * dt` are the original's; the halves stack in portrait and sit side by side in landscape in place of the two render textures, each with its own camera and scissor, and a half narrower than the original's 400 by 450 gets a wider fovy so its horizontal view still fits; a relative thumb-stick in each half replaces W and S and UP and DOWN, one `net.b12n.raylib-ios.stick` per half, so two thumbs work at once, a stick starts only on a fresh press inside its own half and follows only that finger by its touch id, and a resting finger is never adopted; a stick reads only up or down from where the thumb began, past the tap slop, at the original's one speed (the keys move along one axis); the key text in the labels becomes the touch controls; the plane is cut to the part ahead of the eye, from half the depth at which the bottom of the glass meets the ground (out of sight), because a quad with a corner behind the near plane is dropped whole, so the picture is the original's; a cube with a corner behind the near plane is dropped whole, so a tree you walk into vanishes instead of being clipped; the plane is painted first, and the cubes are painted whole, far to near by the distance of their centres from the eye, without `finish`, so where two overlap a face can paint over one a depth buffer would put in front; trees wholly behind the eye or outside the sides of the view are not built, and nor are cube triangles wholly outside the half's rectangle (more than a pixel past one side), which leaves the picture unchanged; each half's 3D view is clipped to it; on the phone it reads 58 idle and while a player walks through the trees, and 31 while a player walks out of the grove looking back at all of it, since every tree is then in view |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb camera-3d-split-screen      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.split3d.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/split3d.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/split3d/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/split3d_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `camera-3d-split-screen` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
