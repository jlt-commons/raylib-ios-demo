# 2D Platformer

Five ways for a camera to follow a player. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

A 2D platformer with five ways for the camera to follow the player. Ported from raylib-jolt-demo's `camera-2d-platformer` demo (originally raylib-jlt's `camera-2d-platformer`), which is raylib's `core_2d_camera_platformer` example (zlib licence).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| the 3 platforms, the floor and the sky of the original's 1000 by 600 map, the 40 by 40 player, 1 line of text for the camera mode and 5 labelled buttons | 59 | five buttons along the bottom, read from every touch point so two can be held at once, replace the keys: < and > walk in place of the arrows (the default font has no triangles), jump replaces SPACE and is held as the original holds it, camera steps the five modes on a press in place of C, and reset replaces R on a press and keeps the mode; the original's key-help line is dropped for a line naming the mode; physics, platforms and the five modes (centre, clamped, smooth, even-out, push) are the original's, with `:delta-seconds` for `get-frame-time` and no clamp (a 0.1 s stall still lands); the 800x450 view is fitted into the field by a base zoom and every mode's width and height become the field's, so the clamp and the push margins act on the phone's pixels; a touch under Back is ignored |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb camera-2d-platformer      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.platformer.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/platformer.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/platformer/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/platformer_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `camera-2d-platformer` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
