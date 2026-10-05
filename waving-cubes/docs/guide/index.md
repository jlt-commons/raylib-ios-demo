# Waving Cubes

A grid of columns rippling like water. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

A grid of columns whose heights ripple like water, ported from raylib-jolt-demo's `waving-cubes` demo (originally raylib-jlt's `waving_cubes`) (zlib licence), with a smaller grid.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 9 by 9 columns of width 1 and height 0.6 to 5.4 (the original has 14 by 14, 196), coloured by three sines and shaded face by face, projected in software (468 to 486 triangles, no lines), and 1 line of text | 59 | no input, as the original has none; each height is `0.6 + 2.4 (1 + sin(0.6 ix + 0.6 iz + t))` with `t` 0.06 a frame; the camera orbits 0.012 radians a frame at 1.3 times and 0.9 times the grid's span, looking at (0, 1.5, 0); the first version of this port, with all 196 columns through `net.b12n.raylib-ios.soft3d/cube` and `finish`, ran at 15 fps on an iPhone 17 Pro (67 ms a frame), and this one draws 81 columns, each a `net.b12n.raylib-ios.soft3d/cube`, painted far to near by axis order with no triangle sort; the original's fps counter is dropped; the original's 45 degree fovy is kept in a field as wide as 800x450 and widened in a narrower one so the original's horizontal view still fits; a little painter's residue can remain where a tall column stands before a short one; the 3D view is the field below the caption, which is below Back, and is clipped to it |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb waving-cubes      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.wavecubes.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/wavecubes.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/wavecubes/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/wavecubes_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `waving-cubes` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
