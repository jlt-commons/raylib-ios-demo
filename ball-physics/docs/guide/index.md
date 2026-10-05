# Ball Physics

Balls under gravity. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

![Ball Physics on an iPhone 17 Pro](../../../docs/images/balls.gif)

## What it is

Balls under gravity, ported from raylib-jolt-demo's `ball-physics` demo (originally raylib-jlt's `ball_physics`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 9 circles | 58 | restarts when everything settles |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb ball-physics      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.balls.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/balls.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/balls/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/balls_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `ball-physics` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
