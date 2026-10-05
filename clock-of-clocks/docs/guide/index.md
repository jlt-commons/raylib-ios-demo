# Clock of Clocks

The time spelled by a grid of tiny clocks. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

![Clock of Clocks on an iPhone 17 Pro](../../../docs/images/clockgrid.png)

## What it is

The time spelled out by a grid of little clock faces. Ported from raylib-jolt-demo's `clock-of-clocks` demo (originally raylib-jlt's `clock_of_clocks`), itself a port of raylib's `shapes_clock_of_clocks.c`.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 144 bezels, 288 hands | 59 | the time spelled by little clock faces |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb clock-of-clocks      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.clockgrid.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/clockgrid.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/clockgrid/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/clockgrid_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `clock-of-clocks` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
