# Tetris

The block-stacking puzzle by drag and tap. One of the Games scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Tetris, dragged and tapped. Ported from raylib-jolt-demo's `tetris` demo (originally raylib-jlt's `tetris`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| a 10 by 20 well, up to 4 falling cells, a next-piece preview, 3 counters | 59 | a horizontal drag moves the piece a column per cell of travel, a tap rotates, a swipe down hard drops and a tap restarts after game over, in place of the arrow keys, SPACE and ENTER; the release swipe of a drag is ignored so the piece does not move twice, and the soft drop is dropped; the seven pieces, the score table, the level speed (a frame count) and the uniform piece choice (from the project's LCG) are the original's, and a rotation starts a new game |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb tetris      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.tetris.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/tetris.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/tetris/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/tetris_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `tetris` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
