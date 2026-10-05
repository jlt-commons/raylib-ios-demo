# Pong

Pong against a CPU, paddle on a finger. One of the Games scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Pong against a CPU, your paddle on a finger. Ported from raylib-jolt-demo's `pong` demo (originally raylib-jlt's `pong`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 2 paddles, a ball, a dashed line, 2 scores | 58 | your paddle follows the finger and a tap restarts after a win, in place of W, S and ENTER; the court turns 90 degrees on a tall phone, with you at the bottom and the CPU at the top, and a rotation starts a new game; the CPU, the english off the paddle and first to 7 are the original's, and the ball does not speed up |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb pong      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.pong.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/pong.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/pong/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/pong_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `pong` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
