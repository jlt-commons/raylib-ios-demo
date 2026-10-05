# Box Collisions

A cube walked across a grid of boxes. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

A cube walked across a grid, and the boxes it touches turn red. Ported from raylib-jolt-demo's `box-collisions` demo (originally raylib-jlt's `box_collisions`) (zlib licence).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| the original's grid of 20, five static boxes standing on it and the lime player cube of side 2, shaded face by face and projected in software (36 triangles and 42 lines from the start), and 1 line of caption | 58 | A, D, W and S are a relative thumb-stick started in the 3D area: past `gesture/slop` left is A (x - 0.18 a frame), right is D (x + 0.18), up the glass is W (z - 0.18, forward) and down is S (z + 0.18), each axis on its own, but a diagonal scales both by 1/sqrt 2 so it moves 0.18 in all, where the original's two keys move 0.18 on both (about 1.41 times as fast), the one deliberate difference; the speed is per update like the original and the player is not held to the grid, as in the original; a box turns red while the 3D AABB overlap test `\|dx\| < 1 + s/2` and `\|dz\| < 1 + s/2` (strict, x and z only) holds, the player spawns touching the fourth box so one is red from frame 0, and the caption says "COLLISION!" in maroon then, otherwise "drag to move the player" in dark gray where the original says "WASD move the player"; the caption sits below Back instead of at (10, 10); the original's 45 degree fovy is kept in a 3D area as wide as 800x450 and widened in a narrower one; a face with a corner behind the near plane is dropped whole; overlapping boxes are ordered whole, face by face, so while the player overlaps a box one of its faces can paint over a face of that box where a depth buffer would not; the 3D area is the field below the caption, which is below Back, and is clipped to it |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb box-collisions      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.boxcollide.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/boxcollide.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/boxcollide/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/boxcollide_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `box-collisions` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
