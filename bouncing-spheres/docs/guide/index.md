# Bouncing Spheres

Six balls bouncing in a box. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Six balls bouncing inside a box under gravity, ported from raylib-jolt-demo's `bouncing-spheres` demo (originally raylib-jlt's `bouncing_spheres`) (zlib licence). The projection is in software, by `net.b12n.raylib-ios.soft3d`.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| the original's 6 balls (radius 0.3 to 0.6, the palette RED, ORANGE, GREEN, SKYBLUE, VIOLET, GOLD) under gravity 0.01 with wall restitution 0.9 in a box of plus or minus 4, over a grid of 10, projected in software (about 240 triangles and 22 lines a frame), tessellated 6 rings by 8 slices where the original's `sphere!` is 10 by 14, because 10 by 14 built in 0.89 ms a frame on the laptop and a scene is sized to about 0.30 ms on the laptop (see "Sizing a scene on the laptop" in the performance guide), and 6 by 8 builds in about 0.39, inside the edge of that rule (60 fps on the phone); 1 line of text | 60 | the balls, their physics (one step a frame, with no frame time, as the original), colours (from the LCG, for `GetRandomValue`, seeded 20261002), the camera at (10, 8, 10) and the grid are the original's; a tap outside Back replaces SPACE and respawns all six, from where the LCG stopped; balls that touch no other are painted whole, far to near by the distance of their centres from the eye, without `finish`; balls whose spheres intersect (the original has no collision, so about 4 frames in 9 once they settle) are grouped transitively and their triangles sorted together by `finish`, placed among the rest by the group's mean centre, so a little residue by mean depth can remain where they cross; a lone ball whose depth falls between the members of a group can also paint over the nearer member (5 of 12,000 simulated poses); and the grid is drawn first so a line under a ball is lost; the caption's "SPACE respawns" becomes "tap respawns"; the 3D view is clipped to the field |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb bouncing-spheres      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.spheres.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/spheres.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/spheres/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/spheres_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `bouncing-spheres` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
