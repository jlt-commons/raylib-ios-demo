# Asteroids

The vector shooter on four buttons. One of the Games scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Asteroids with four on-screen buttons. Ported from raylib-jolt-demo's `asteroids` demo (originally raylib-jlt's `asteroids`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| outlined rocks, a ship, bullets, 4 buttons, 2 counters | 58 | four buttons along the bottom (rotate left, rotate right, thrust, fire), held together by two thumbs, and a tap on the field, not on a button, restarts after game over, in place of the arrow keys, SPACE and ENTER; the physics (ROT, THRUST, FRICTION, wrap), the three asteroid sizes and splits, the 55-frame bullet life, the waves, 3 lives and the invulnerability blink are the original's; a press fires at once as the original's does, and a held fire button keeps firing every 10 frames, where the original fires once per press; the speeds and radii are scaled by one factor so thrust still goes where the ship points, the field wraps above the buttons and below Back, and a rotation starts a new game |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb asteroids      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.asteroids.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/asteroids.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/asteroids/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/asteroids_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `asteroids` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
