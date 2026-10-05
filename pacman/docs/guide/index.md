# Pac-Man

Pac-Man, steered by swipes. One of the Games scenes in the raylib-ios gallery, and an app of its own here.

![Pac-Man on an iPhone 17 Pro](../../../docs/images/pacman.png)

## What it is

Pac-Man, steered by swipes. Ported from raylib-jolt-demo's `pacman` demo (originally raylib-jlt's `pacman`), which came from Michiel Borkent's example in babashka/ffi (MIT).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 194 walls as two rectangles each, up to 197 dots, a 28-triangle Pac-Man, four ghosts of 9 shapes, a HUD row | 58 | a swipe sets the desired direction, in place of the arrow keys and WASD, and Pac-Man takes it at the next tile centre where that way is open, so a swipe into a wall is remembered and not dropped; a tap restarts after game over, outside Back, in place of ENTER; the maze, the four ghost personalities (Blinky, Pinky, Inky and Clyde), scatter for 7 s and chase for 20 s, 7 s of fright with the 200/400/800/1600 combo, scoring, three lives and the levels are the original's, in seconds from `:delta-seconds` like it (it calls `get-frame-time`); the level clear is fixed, because the original re-arms its two second timer every frame and never starts the next level, and the board freezes while LEVEL CLEARED shows; the ghosts' feet are spaced inside the body, where the original's third foot sticks out past it; the mouth is a 28-triangle fan, since `sector!` is not bound, the frightened ghosts' random turns come from the project's LCG, the maze is drawn with square tiles in the safe region below Back, and a rotation re-lays it out and keeps the game |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb pacman      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.pacman.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/pacman.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/pacman/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/pacman_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `pacman` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
