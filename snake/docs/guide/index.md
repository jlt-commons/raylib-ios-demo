# Snake

The classic snake, steered by swipes. One of the Games scenes in the raylib-ios gallery, and an app of its own here.

## What it is

The classic snake, steered by swipes. Ported from raylib-jolt-demo's `snake` demo (originally raylib-jlt's `snake`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| up to 576 cells, a board and a score line | 58 | a swipe steers and a tap restarts, in place of the arrow keys and SPACE; the 32 by 18 grid turns to 18 by 32 on a tall phone, and a rotation starts a new game |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb snake      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.snake.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/snake.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/snake/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/snake_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `snake` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
