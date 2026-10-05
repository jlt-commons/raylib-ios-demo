# Point Cloud

A cloud of points turning slowly. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

A cloud of points turning slowly, ported from raylib-jolt-demo's `point-cloud` demo (originally raylib-jlt's `point_cloud`) (zlib licence), with fewer points.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 400 points (the original has 1500), each a screen-space square of 2 triangles (800 triangles, no lines) in place of its small cube, coloured by position on black, and 1 line of text | 60 | no input, as the original has none; the points are the first 400 of the cloud the project's seeded LCG makes in place of `GetRandomValue`, and the cloud turns 0.3 degrees a frame about the y axis; the first version of this port, with all 1500 points as squares sorted by `finish`, ran at 9 fps on an iPhone 17 Pro (110 ms a frame), and this one draws 400; the squares are unshaded, painted far to near by 64 depth buckets, and the caption says "square" where the original says "cube"; the original's 45 degree fovy is kept in a field as wide as 800x450 and widened in a narrower one so the original's horizontal view still fits; the 3D view is the field below the caption, which is below Back, and is clipped to it |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb point-cloud      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.pointcloud.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/pointcloud.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/pointcloud/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/pointcloud_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `point-cloud` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
