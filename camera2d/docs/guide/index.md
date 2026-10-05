# 2D Camera

A 2D camera following a player on a skyline. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

A 2D camera that follows a player along a skyline. Ported from raylib-jolt-demo's `camera2d` demo (originally raylib-jlt's `camera2d`), which is raylib's `core_2d_camera` example (zlib licence).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| the original's 30-building skyline, the ground and the player box through a camera, a screen-space centre line, 1 line of text and 1 labelled button | 58 | a one-finger drag is a relative thumb-stick on x only (the press point is the centre, a dead zone of the tap slop) that moves the player at the original's 4 units a frame in place of the arrow keys; a two-finger pinch zooms between 0.25 and 3.0 in place of the wheel and a twist rotates in place of A and D, both about the field's centre; the reset button below Back replaces R and leaves the player where it is; a second finger ends the stick, and the finger left after a lift starts none until it lands again; the original's 800x450 view is fitted into the field below the button by a base zoom and the world is clipped to that field; a touch under Back is ignored |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb camera2d      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.camera2d.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/camera2d.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/camera2d/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/camera2d_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `camera2d` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
