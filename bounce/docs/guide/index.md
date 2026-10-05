# Bouncing Ball

A bouncing ball; tap to pause. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

A ball bouncing around the screen; tap to pause. Ported from raylib-jolt-demo's `bounce` demo (originally raylib-jlt's `bounce`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 1 circle and 1 or 2 lines of text | 58 | a tap pauses, in place of SPACE; speed and radius scale with the shorter side, and a rotation clamps the ball back inside |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb bounce      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.bounce.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/bounce.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/bounce/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/bounce_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `bounce` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
