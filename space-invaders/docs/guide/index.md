# Space Invaders

Marching aliens and a one-finger ship. One of the Games scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Space Invaders on one finger. Ported from raylib-jolt-demo's `space-invaders` demo (originally raylib-jlt's `space_invaders`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| up to 32 aliens, a ship, bullets, a score line | 58 | the ship follows the finger and fires while one is down, and a tap restarts after a loss or a win, in place of the arrow keys and SPACE; the 8 by 4 formation, its 1.2 px march, 18 px drops, the 15-frame fire cooldown and the loss rule (the lowest alien reaches the ship's row) are the original's, scaled to the safe region per axis, and a rotation starts a new game |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb space-invaders      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.invaders.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/invaders.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/invaders/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/invaders_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `space-invaders` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
