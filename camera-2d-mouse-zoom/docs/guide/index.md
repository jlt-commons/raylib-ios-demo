# 2D Camera Zoom

A 2D camera zooming about a pinned point. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

A 2D camera that zooms about the point you pin. Ported from raylib-jolt-demo's `camera-2d-mouse-zoom` demo (originally raylib-jlt's `camera-2d-mouse-zoom`), which is raylib's `core_2d_camera_mouse_zoom` example (zlib licence).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| a 22 by 22 line grid (the original's 21x21 cells), 1 square, 1 circle, 1 box and the text "world origin" through a camera, a screen-space crosshair and 2 lines of text | 58 | a one-finger drag pans by the finger's movement over the zoom in place of the left-drag, so the world point under the finger stays under it; a two-finger pinch zooms between 0.125 and 64 in log space about its midpoint in place of the wheel and the right-drag, and the midpoint drags the world if it drifts; keys 1 and 2 are dropped, so the original's mode and its HUD word are gone, and the pinch's twist is ignored; the crosshair sits at the last touch or the pinch midpoint; a second finger ends the pan, a pinch acts only while exactly two fingers stay down, so a third finger or a lift pauses it and moves nothing, and the finger left after a lift pans nothing until it lands again; the world origin starts at the field's centre, not the top-left, because that is under Back; a touch that begins under Back pans nothing |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb camera-2d-mouse-zoom      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.camerazoom.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/camerazoom.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/camerazoom/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/camerazoom_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `camera-2d-mouse-zoom` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
