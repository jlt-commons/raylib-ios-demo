# Bezier

A cubic Bezier that follows your finger. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

![Bezier on an iPhone 17 Pro](../../../docs/images/bezier.png)

## What it is

A cubic Bezier whose far end follows your finger. Ported from raylib-jolt-demo's `lines-bezier` demo (originally raylib-jlt's `lines_bezier`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 48 segments and a control polygon | 58 | follows a finger; handles are derived, not dragged |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb lines-bezier      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.bezier.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/bezier.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/bezier/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/bezier_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `lines-bezier` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
