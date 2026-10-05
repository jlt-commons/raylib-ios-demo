# Multitouch

A circle and trail for every finger. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

![Multitouch on an iPhone 17 Pro](../../../docs/images/multitouch.png)

## What it is

Every finger on the glass, drawn where it is. Ported from raylib-jolt-demo's `input-multitouch` demo (originally raylib-jlt's `input_multitouch`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| a circle and trail per finger | 58 | every point, not just point zero |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb input-multitouch      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.multitouch.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/multitouch.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/multitouch/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/multitouch_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `input-multitouch` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
