# Doom-like Raycaster

A Doom-style ray caster on two thumbs. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

A Doom-style ray caster you walk and shoot in on two thumbs, ported from raylib-jolt-demo's `doom` demo (originally raylib-jlt's `doom`) (`doom.clj`, 613 lines), which is Michiel Borkent's (@borkdude) `examples/doom.clj` in babashka/ffi (MIT licence, see NOTICE), itself the technique Wolfenstein made famous: one ray per screen column, a DDA walk over a grid of characters, and the distance of the hit decides how tall that column's strip is. The projection and the rects are `net.b12n.raylib-ios.scenes.doom.ray`, the level and the colours `net.b12n.raylib-ios.scenes.doom.map`, the HUD, minimap and crosshair `net.b12n.raylib-ios.scenes.doom.hud`. This namespace is the game: the state, the rules, the fingers and the layout.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| the original's sixteen-row level with its six imps, cast by a DDA with one ray per column (180 columns, the original's 450) and drawn as flat vertical strips shaded by distance and side (a wall square on to the eye is one rect, 48 rects from the start and at most 221 in the poses measured), the imps as strips of rects tested against the wall behind them, the minimap (a panel, 96 wall cells, a dot for each living imp, the player and a heading line), the HUD bar with HEALTH, KILLS, IMPS, SHOTS and the fps and column count, the crosshair, YOU DIED and the muzzle flash, at the original's 900 by 560 proportions scaled to the field's width and placed at its top; a FIRE button in the field's lower right, the caption below Back and, while held, the stick's ring and knob; about 350 draw calls | 58 | the level, the DDA with its perpendicular distance, the wall height `H / dist`, the distance and side shade, the z-buffer with the sprite pass's 12 strips tested against it, `rotate`, `move` at 3.4 cells a second sliding along walls by testing each axis alone, `shoot` (the nearest living imp inside a 0.985 cone, walls ignored), the imps walking at 0.9 and biting within 0.9, the 0.06 second flash, the fps averaged over 0.4 seconds, `dt` held to 0.05 and the HUD and minimap are the original's, in its order of a frame; a relative thumb-stick begun on a fresh press in the lower half of the left half of the field replaces WASD (a unit vector, so one speed everywhere where the original's keys add, and the strafe is the original's along the camera plane so it is 0.66 of the forward speed), a drag in the right half replaces the mouse (0.0022 radians a pixel times 900 over the picture's width) and the arrow keys, both at once, each by its own finger (`net.b12n.raylib-ios.stick`), a resting finger never adopted; a finger that lands on FIRE fires once, as `mouse-pressed?` does, also while the other thumb walks, and never starts a stick or a turn; **the cursor calls are dropped** (`hide-cursor`, `set-mouse-position`, `show-cursor`: a phone has no pointer to hold at the window's middle), as is the quit key; **180 columns, not 450**: the phone runs scene code about 33 times slower than the laptop and on the laptop a frame has to build in about 0.30 ms under jolt to hold 60 fps (that 0.30 is empirical, from the device pass, and not 16.7 ms divided by 33, which is 0.50), and 180 is the largest of the counts measured (100, 160, 180 and 200) whose worst pose fits: update, build and the draw side's loops with the FFI stubbed take 0.20 ms from the start, 0.29 ms at the worst of 2576 poses (every open cell centre by 16 headings) with and without six imps in view, and 0.28 ms at the worst of 1500 random poses with both thumbs held and the flash on (a column is 6.7 pixels wide on the phone, where the original's 450 are 2.7; at 100 columns the worst was 0.20 ms, at 160 0.27 and at 200 0.31); **textured walls are flat**: a wall is its style's colour from the original's own minimap, 150 70 55, 120 120 130, 90 110 150 and 70 180 110, times the original's shade as the vertex colour multiplies a texel, and the brick, stone, panel and circuit patterns are dropped; **sprites are rects**: each of the original's 12 strips draws the body (an ellipse), head (a circle) and eyes of the imp texel's column at its middle, depth-tested at its middle column as the original does, so a strip is the texel's colour in a flat bar and its edges are the strips' not the texture's; lossless cuts taken: no allocation per column, runs of columns that are the same rect in pixels merged into one, the strip extents worked out once, `int` for `long` on the hot path (a `long` of a float cost 100 ns under jolt, an `int` 25), and the original's bounds test and 64 step limit left out because the map's border is all wall and the player cannot cross a wall; the 900 by 560 picture is kept, so pixels are not square as in the original; the 'died' state freezes the imps but not the player, as in the original; on the phone it reads 58 idle and 58 to 59 while walking and turning |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb doom      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.doom.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/doom.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/doom/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/doom_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `doom` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
