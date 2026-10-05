# Breakout

Paddle, ball and bricks. One of the Games scenes in the raylib-ios gallery, and an app of its own here.

![Breakout on an iPhone 17 Pro](../../../docs/images/breakout.png)

## What it is

Breakout: slide the paddle under the ball and clear every brick. Ported from raylib-jolt-demo's `breakout` demo (originally raylib-jlt's `breakout`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| up to 60 bricks, a paddle, a ball | 58 | the paddle follows the finger, and a tap restarts after game over or a win; frame-locked like the original, and a rotation starts a new game |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb breakout      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.breakout.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/breakout.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/breakout/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/breakout_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `breakout` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
