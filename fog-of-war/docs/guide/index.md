# Fog of War

A tile map under a fog that lifts as you walk. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

A tile map under a fog that lifts where you walk. Ported from raylib-jolt-demo's `fog-of-war` demo (originally raylib-jlt's `fog-of-war`) (`src/net/b12n/raylib_jlt/fog_of_war.clj`), itself a port of raylib's `textures_fog_of_war` (zlib licence).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| the original's 25 by 15 map of 32 unit tiles in two blues (BLUE and (0, 121, 241, 230), picked at random per tile) with outlines of (0, 82, 172, 128), the 16 unit RED player and a fog that is black where unexplored, black at alpha 163 where remembered and clear where lit, with 2 lines of text; 375 tiles, 80 outline strips, 1 player rect, one batch of up to 375 quads (2250 vertices) and 2 text lines a frame, about 3600 FFI calls at worst | 60 | the map, the tile size, the visibility of 2 (the loops run t-2 to t+1, four tiles a side, as there), `tile-of`, the age-then-light order, the fog alphas (unexplored 255, lit 0 and remembered 204 drawn into a texture cleared to clear black, which stores 204 * 204 / 255 = 163, so 163 here), SPEED 5, the clamp to 0 to 784 and 0 to 464, the patrol loop until the first move and the text are the original's; the 25 by 15 render texture stretched with a bilinear filter becomes one quad a tile in a single rlgl triangle batch (the vertex order of `draw-gradient-quad`, the colour set only when it changes, on the tile fills' own whole-pixel edges), each corner's alpha the mean of the four tiles that meet there (an edge tile repeats off the map, as the texture's clamp does), which is the same bilinear blend sampled half a tile over, so a clear patch looks about half a tile smaller at its edge; the arrow keys become a relative thumb-stick on `net.b12n.raylib-ios.stick` (an axis is on past the tap slop, a diagonal is scaled to the one speed where the original's adds 5 on both axes, a resting finger never steers); `GetRandomValue` is the LCG; the whole 800 by 480 map is drawn at the largest scale that fits below Back, so the bottom row the original's 450 high window cuts off is shown; the 375 outlines are 80 strips across the map; a tile whose four corners are clear is not drawn; the hint says "DRAG" where the original says "ARROW KEYS"; builds in about 0.30 ms under jolt on the laptop (update, corner alphas and the batch with the FFI stubbed out), at the 0.30 ms target, which held 59 to 60 fps on the phone |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb fog-of-war      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.fogofwar.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/fogofwar.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/fogofwar/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/fogofwar_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `fog-of-war` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
