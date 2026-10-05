# Touch Ball

A ball that follows your finger. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

![Touch Ball on an iPhone 17 Pro](../../../docs/images/touchball.png)

## What it is

A ball that follows your finger and turns green while you hold it. Ported from raylib-jolt-demo's `mouse` demo (originally raylib-jlt's `mouse`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 1 circle and a caption | 58 | follows a finger; green while held, and it stays put when the finger lifts |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb mouse      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.touchball.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/touchball.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/touchball/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/touchball_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `mouse` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
