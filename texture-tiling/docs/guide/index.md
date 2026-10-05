# Texture Tiling

One tile repeated across the screen. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Texture Tiling, ported from raylib-jolt-demo's `texture-tiling` demo (originally raylib-jlt's `texture_tiling`) (net/b12n/raylib_jlt/texture_tiling.clj, zlib licence), which is raylib-jlt's own example and not a port of a raylib C example. raylib 6.0's nearest is `textures_tiled_drawing`, which tiles with DrawTextureTiled where this lets the GPU's REPEAT wrap do it: one small procedural tile covers the screen as a single textured quad, by asking for texture coordinates well past 1.0.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| one 64 by 64 texture drawn as a single quad over the whole screen, a translucent band with 2 lines of text, 2 buttons and their labels | 58 | the original's tile (a diagonal weave of BLUE and SKYBLUE over a dark ground with a GOLD dot in the middle), REPEAT wrap, and texcoords from the scroll to the scroll plus the density, which starts at 6.0, moves 0.08 a frame and is held to 1.0 to 24.0; the scroll grows 0.004 a frame; **the first scene on a real GPU texture**, uploaded once through rlgl when the scene opens (rlLoadTexture, 64 is a power of two, which GLES2 needs for REPEAT) and freed when you leave it; the screen is the picture, so the v range is the density times the screen's own height over width and the tiles stay square; UP and DOWN are two buttons under the text and a finger held on one repeats as the key does, at the original's 0.08 a frame; the count line is the original's `tiles * tiles * (h / w)` for the screen's own `h / w`; a reopen costs about one frame |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb texture-tiling      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.textiling.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/textiling.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/textiling/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/textiling_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `texture-tiling` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
