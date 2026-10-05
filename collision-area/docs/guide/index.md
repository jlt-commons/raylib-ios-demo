# Collision Area

Two boxes and their overlap. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

![Collision Area on an iPhone 17 Pro](../../../docs/images/collision.gif)

## What it is

Two boxes and their overlap, ported from raylib-jolt-demo's `collision-area` demo (originally raylib-jlt's `collision_area`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 3 rectangles | 59 | follows a finger, and drifts without one |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb collision-area      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.collision.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/collision.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/collision/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/collision_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `collision-area` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
