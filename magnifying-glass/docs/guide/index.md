# Magnifying Glass

A lens that magnifies what it covers. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Magnifying Glass, ported from raylib-jolt-demo's `magnifying-glass` demo (originally raylib-jlt's `magnifying_glass`) (net/b12n/raylib_jlt/magnifying_glass.clj, EPL 2.0), which is raylib's `textures_magnifying_glass` (zlib). This is an altered version of both.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| the original's scene (a Perlin backdrop, seven squares with a circle each, 2 lines of one text) laid over the field below Back, and a 220 pixel lens that follows a finger, a render target of the same scene at 3x drawn back as a 64 wedge disc under a black ring | 58 | the constants (lens 220, zoom 3.0, 64 segments), the squares and circles and their colours, the five markers that show only in the lens (a LIME circle of 11 over a DARKGREEN one of 6), the lens's centring (`ox = half - x * zoom`), the flipped v of a bottom-up target, the ring 4 thick and the two texts are the original's; **the backdrop is raylib's own `GenImagePerlinNoise`**, 800 by 450 with offsets 0 and scale 6.0, made in C and uploaded straight from the buffer it fills (the pure `net.b12n.raylib-ios.perlin` model takes about 17 microseconds a texel under laptop jolt, 6 seconds for the image, and is the tested reference; the C takes about 20 ms on the laptop and 11.7 ms on the phone for 800 by 450), stretched over the field and drawn smooth where the original's is not; **a finger is the pointer**: the lens follows a finger that landed in the field, stays where it was left, and walks the original's slow path until the first touch; the lens centre is held a half lens inside the field, so a marker at the field's edge is reached with the lens at the edge; the scene is the original's 800 by 450 laid over the field as fractions (positions) and by the smaller side ratio (lengths), the lens stays 220 target pixels, so on the phone it is a small disc a finger covers; the lens target is 220 by 220 and the pixels of the image stay on the GPU while you are in the scene, a reopen makes the image again, and on the phone the largest frame is 30 ms on a first open; under laptop jolt a frame (update, the draw plans and loops, FFI stubbed) averages 0.16 ms |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb magnifying-glass      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.magnify.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/magnify.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/magnify/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/magnify_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `magnifying-glass` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
