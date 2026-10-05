# Circle Sector

A pie slice that degrades to a triangle. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

![Circle Sector on an iPhone 17 Pro](../../../docs/images/sector.png)

## What it is

A pie slice degrading into a triangle as its segment count falls. Ported from raylib-jolt-demo's `circle-sector-drawing` demo (originally raylib-jlt's `circle_sector_drawing`), itself raylib's `shapes_circle_sector_drawing.c`.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| one sector, 1-36 segments | 58 | raylib's own segment floor, demonstrated |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb circle-sector-drawing      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.sector.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/sector.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/sector/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/sector_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `circle-sector-drawing` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
