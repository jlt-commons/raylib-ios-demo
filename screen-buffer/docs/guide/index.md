# Screen Buffer

The classic DOS fire effect. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Screen Buffer, ported from raylib-jolt-demo's `screen-buffer` demo (originally raylib-jlt's `screen_buffer`) (net/b12n/raylib_jlt/screen_buffer.clj, EPL 2.0), which is raylib's `textures_screen_buffer`: the classic DOS fire as a software screen buffer. A 100 by 56 grid of palette indices is simulated, blitted through a 256-colour flame palette into a texture and drawn scaled up. The raylib C example it follows is zlib licensed, and this is an altered version of that too.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| one 100 by 56 texture of the classic DOS fire, scaled up to the width the free area allows and nothing else on screen | 58 | the original's 256-colour flame palette (hue `250 + 150 t^2`, saturation and value both `t`) and its ember grid, with the roots growing 0 to 2 a step from column 2, the bottom row seeded from them, the top row blanked and every lit cell rising a row with a random drift and decay, clamped and unfiltered; the randomness is the project LCG, seeded in the state, in place of GetRandomValue, so a seed replays the same fire; **the grid is a quarter of the original's**: 100 by 56 against its 200 by 112 (raylib's C example uses 400 by 225), so the same rules give a relatively taller flame and chunkier cells; **the roots start hot**: from column 2 each is a random 192 to 255 (columns 0 and 1 stay dark, as in the original) instead of 0, so the first sweep already has a flame; **the fire steps and uploads a band at a time**: the original simulates the whole grid and rewrites every texel every frame, which would stall the phone, so each frame steps a band of 8 rows and uploads them with the row above (where their cells land), a sweep of 7 frames is exactly one of the original's steps, and so the fire follows the original's rules at about 8.6 steps a second instead of 60 (laptop jolt: a frame averages 0.19 ms, 0.29 ms at the 99th percentile); rows below the band are older than rows above it by up to 7 frames, so a moving seam shows between fresher and older rows; entering the scene fills all 5600 texels once, a one-off cost; the original has no text and neither does this; a reopen costs about one frame |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb screen-buffer      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.screenbuf.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/screenbuf.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/screenbuf/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/screenbuf_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `screen-buffer` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
