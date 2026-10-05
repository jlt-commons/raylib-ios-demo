# Minesweeper

Tap to reveal, long press to flag. One of the Games scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Minesweeper, played by tap and long press. Ported from raylib-jolt-demo's `minesweeper` demo (originally raylib-jlt's `minesweeper`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| up to 192 cells, a status line | 58 | a tap reveals and a long press flags, in place of left and right click; a tap restarts after a mine or a win, in place of SPACE; the 16 by 12 grid turns to 12 by 16 on a tall phone with the same 30 mines, a rotation starts a new game, and as in the original a tap on a flagged cell opens it and the first tap can hit a mine |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb minesweeper      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.minesweeper.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/minesweeper.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/minesweeper/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/minesweeper_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `minesweeper` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
