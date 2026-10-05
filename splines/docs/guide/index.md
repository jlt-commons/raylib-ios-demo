# Splines

Three spline bases over five points. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

![Splines on an iPhone 17 Pro](../../../docs/images/splines.png)

## What it is

Three spline bases over the same five control points. Ported from raylib-jolt-demo's `splines` demo (originally raylib-jlt's `splines`), itself raylib's `shapes_splines_drawing` minus its raygui controls.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 3 bases, 480 segments | 59 | Catmull-Rom passes through, the others do not |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb splines      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.splines.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/splines.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/splines/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/splines_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `splines` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
