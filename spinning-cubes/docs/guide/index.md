# Spinning Cubes

A row of cubes spinning with a phase offset. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

A row of cubes each spinning in place with a phase offset, ported from raylib-jolt-demo's `spinning-cubes` demo (originally raylib-jlt's `spinning_cubes`) (zlib licence).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| the original's grid of 12 and five cubes of side 1 (red, orange, green, blue, violet) shaded face by face, projected in software (30 triangles and 26 lines), and 1 line of text | 58 | no input, as the original has none; each cube turns 2 degrees a frame about the axis (0.3, 1, 0), 30 degrees ahead of the one before, after a translate to its place, composed in the order of the original's rlTranslatef and rlRotatef calls; the original's 45 degree fovy is kept in a field as wide as 800x450 and widened in a narrower one so the original's horizontal view still fits; the 3D view is the field below the caption, which is below Back, and is clipped to it |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb spinning-cubes      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.spincubes.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/spincubes.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/spincubes/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/spincubes_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `spinning-cubes` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
