# 2048

2048, played by swipe. One of the Games scenes in the raylib-ios gallery, and an app of its own here.

## What it is

2048, played by swipe. Ported from raylib-jolt-demo's `game-2048` demo (originally raylib-jlt's `game_2048`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 16 tiles on a board, a score line | 58 | a swipe slides and a tap restarts once stuck or won, in place of the arrow keys and SPACE; reaching 2048 wins and stops play, which the original does not, and a rotation only re-lays out the board |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb game-2048      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.game2048.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/game2048.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/game2048/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/game2048_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `game-2048` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
