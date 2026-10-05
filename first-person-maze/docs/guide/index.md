# First-Person Maze

A first-person maze with a minimap. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

A first-person walk through a grid maze, with a minimap, on two thumbs, ported from raylib-jolt-demo's `first-person-maze` demo (originally raylib-jlt's `first_person_maze`) (zlib licence).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| the original's 16 by 16 maze as 137 wall cubes (CELL 4 by 3 by 4, a checker of (120, 130, 160) and (95, 105, 135) shaded face by face) over a grid of 40 slices of 4, on a clear colour of (16, 18, 26), from an eye 1.6 up at fovy 68, projected in software, with the original's minimap (a translucent black panel, a rect for every wall, a red circle for the player and a gold line along the heading) in the top right of the 3D field, and 1 line of caption | 59 | the maze, wall cubes, per-axis collision with a box of radius 0.9 (x first, so a diagonal into a wall slides), `5 * dt` speed and the heading maths (`target = pos + (sin h, cos h)`, no `UpdateCamera`) are the original's, and the player starts at (6, 6) facing +z; a relative thumb-stick started in the lower third of the field replaces W, S, A and D at one speed in every direction where the original's keys add up on a diagonal, and a drag that starts in the upper two thirds replaces LEFT and RIGHT, turning 0.004 radians a pixel scaled by 800 over the field's width (a rate borrowed from First-Person Camera, as a key has none; vertical motion turns nothing as the original has no pitch); both work at once, each by its own finger (`net.b12n.raylib-ios.stick`), and a resting finger is never adopted; the original's D adds +x at heading 0, which is the left of the glass, so the stick maps by what shows on the glass and pushed right it strafes right; walls behind the eye or outside the sides of the view are not built, nor are walls that rays across the maze grid cannot reach because other walls stand in front (checked over 35,712 poses to hide only what is hidden), which leaves the picture unchanged; the minimap's cell is sized to the field (at most 0.3 of its width and 0.4 of its height) and its 4, 12 and 1 scale with it; the title and key text are dropped and the key text becomes a touch caption below Back; a face with a corner behind the near plane is dropped whole, the grid is drawn under every face, and adjacent walls are ordered whole, face by face |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb first-person-maze      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.fpmaze.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/fpmaze.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/fpmaze/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/fpmaze_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `first-person-maze` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
