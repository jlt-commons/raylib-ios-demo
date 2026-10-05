# Life

Conway's Game of Life, reseeded when it stalls. One of the Generative scenes in the raylib-ios gallery, and an app of its own here.

![Life on an iPhone 17 Pro](../../../docs/images/life.gif)

## What it is

Conway's Game of Life, ported from raylib-jolt-demo's `game-of-life` demo (originally raylib-jlt's `game_of_life`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 1470 rectangles falling to ~670 | 59 | reseeds itself when the board stalls |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb game-of-life      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.life.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/life.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/life/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/life_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `game-of-life` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
