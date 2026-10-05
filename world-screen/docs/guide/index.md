# World to Screen

A 2D label pinned above a 3D cube. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

A 2D label pinned above a 3D cube, ported from raylib-jolt-demo's `world-screen` demo (originally raylib-jlt's `world_screen`), which is raylib's `core_world_screen` (zlib licence).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| the original's grid of 10 and a red cube of side 2 shaded face by face, projected in software (about 6 triangles and 22 lines), a label "Enemy: 100/100" pinned above the cube, a position readout and 1 line of caption | 58 | no input, as the original has none; the camera orbits at 0.3 radians a second from `:delta-seconds`, where the original uses `get-frame-time`, and the label sits at the world point (0, 2.5, 0) projected through the same camera the cube is drawn with, truncated to whole pixels and centred by the measured text width; the readout is drawn over the top left of the 3D view as in the original and the caption sits below Back, and all text uses the field's text size where the original uses 20; the original's fovy 45 is kept in a field as wide as 800x450 and widened in a narrower one so the original's horizontal view still fits; the grid is drawn under every face, so where the original's grid crosses the lower half of its cube (centred on y = 0, half below the grid) the lines a depth buffer would show in front of it are hidden here; the 3D view is the field below the caption, which is below Back, and is clipped to it |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb world-screen      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.worldscreen.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/worldscreen.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/worldscreen/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/worldscreen_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `world-screen` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
