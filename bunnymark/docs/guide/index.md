# Bunnymark

The sprite-count benchmark. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Bunnymark, ported from raylib-jolt-demo's `bunnymark` demo (originally raylib-jlt's `bunnymark`) (net/b12n/raylib_jlt/bunnymark.clj, zlib licence), the traditional sprite-count benchmark: hold to spawn bunnies that bounce off the edges, and watch the frame rate fall as they pile up.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| the original's 200 opening bunnies, as tinted squares of the sprite's size (32 units, scaled by the width over 800), added 60 a frame while a finger is held up to a cap of 40000 (a hold from 200 ends at 40040, as the original's does), each bouncing off the four edges at its own velocity and tint, with a header bar showing the count, the host's live fps and 1 line of hint, and a clear button; one `draw-rectangle` per bunny and nothing else, so it is a stress test by design: it builds in about 0.24 microseconds a bunny under jolt on the laptop (0.025 ms at 100, 0.24 ms at 1000, 9.7 ms at 40040) plus one FFI call each, and the 0.30 ms target is passed at about 1,250 bunnies, fewer with the draw calls | 58 | the bunny physics (`step`: move, then flip the velocity of an axis whose sprite is outside the window, with no clamp), the spawn (x and y at the touch, vx and vy `GetRandomValue(-250, 250) / 60`, each channel 90 to 255, drawn in that order from the LCG seeded 20261002 in place of `GetRandomValue`), the opening scatter, the batch of 60, the cap and the order of a frame (clear, else spawn, then step all) are the original's; holding a finger inside the field and outside Back and the clear button replaces the left mouse button, so nothing spawns above the field or off its edge, a finger that began on the clear button or in Back never spawns, and one that began in the field stops spawning while it is over the button; a tap that begins on the clear button replaces SPACE; when the phone turns, every bunny is clamped into the new field and the gesture is reset, where the original's window never changes; the sprite's rabbit silhouette and its alpha are dropped, so a bunny is a flat square and one over another hides it instead of showing the tint of the one beneath through a transparent ear; the field is 800 units wide and as tall as the phone needs below Back (about 1469 at 1206 by 2334) where the original's is 450, so the velocities, which are per frame, take longer to cross it, and the bunnies are square rather than stretched; the fps is the host's `GetFPS`, read every frame as Starfield and Delta Time do; the bunnies are held in arrays that `advance` updates in place, which keeps the per-bunny path free of allocation; the original's mouse hint text becomes "hold to add - tap clear" |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb bunnymark      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.bunnymark.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/bunnymark.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/bunnymark/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/bunnymark_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `bunnymark` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
