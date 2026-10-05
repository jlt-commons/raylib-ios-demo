# 2D Split Screen

Two players on one grid in split screen. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Two players on one shared grid, each in a half of the screen. Ported from raylib-jolt-demo's `camera-2d-split-screen` demo (originally raylib-jlt's `camera-2d-split-screen`), which is raylib's `core_2d_camera_split_screen` example (zlib licence).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| the original's 20 by 11 grid of 40-unit cells with 220 `[i,j]` labels, a red and a blue player and a banner with 1 line of text in each of 2 scissored halves, and a divider | 58 | a relative thumb-stick in each half, read from `:touch-points` and assigned by the half a point lies in, steers that half's player at the original's 3 units a frame, normalised, in place of W, A, S, D and the arrows; a stick starts on the frame a point first appears in its half, with its centre there, so a tap never moves a player; two thumbs work at once; with two points in one half the stick follows the one nearer its finger; a thumb sliding across the divider ends the stick it left and starts a fresh one in the other half; the render textures become a scissor and a camera per half, stacked in portrait and side by side in landscape, with the camera's offset at the half's centre and a base zoom fitting the original's 400 by 440 half; the banners read "drag to move" in place of the key names and the labels keep the original's size 10, scaled with the world; a touch under Back is ignored |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb camera-2d-split-screen      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.splitscreen.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/splitscreen.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/splitscreen/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/splitscreen_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `camera-2d-split-screen` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
