# Delta Time

Per-frame against delta-time movement. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

![Delta Time on an iPhone 17 Pro](../../../docs/images/deltatime.png)

## What it is

Two boxes cross the screen, one by a fixed step per frame and one by a distance scaled by the time since the last frame. Ported from raylib-jolt-demo's `delta-time` demo (originally raylib-jlt's `delta_time`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 2 rectangles, 2 labels and an fps line | 58 | per-frame against delta time; at 58 fps the delta box already gains about 9 px a second |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb delta-time      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.deltatime.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/deltatime.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/deltatime/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/deltatime_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `delta-time` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
