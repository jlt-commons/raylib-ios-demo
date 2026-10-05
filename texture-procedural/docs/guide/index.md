# Procedural Textures

Four procedural textures. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Procedural Textures, ported from raylib-jolt-demo's `texture-procedural` demo (originally raylib-jlt's `texture_procedural`) (net/b12n/raylib_jlt/texture_procedural.clj, zlib licence), which is raylib-jlt's own example rather than a port of a raylib C example. raylib 6.0's nearest is `textures_image_generation`, which builds gradients, a checkerboard and noise with GenImage* on the CPU. Here: four textures generated pixel by pixel and uploaded to the GPU, each drawn as one quad.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| four 128 by 128 textures, a checkerboard, a gradient, noise and rings, each drawn as one quad with an outline and a name, and three lines of text | 58 | the original's four pixel functions, clamped and unfiltered as its textures are; the noise is a grey from the project LCG (high bits of one step a texel, in row order) in place of GetRandomValue, so a seed always replays the same picture; **a tap is SPACE**: a finger landing (not the frames it stays down, and not on Back) reseeds the noise and bumps its `:version`, which rewrites that one texture in place; the panels are a 2 by 2 grid on a portrait screen and a row of four on a landscape one, square, whichever is bigger; entering the scene fills all four textures once; the first open after launch pauses about 0.5 s, and a reopen about 0.14 s, since the noise is versioned and not kept (the other three textures reopen in about one frame) |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb texture-procedural      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.texproc.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/texproc.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/texproc/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/texproc_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `texture-procedural` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
