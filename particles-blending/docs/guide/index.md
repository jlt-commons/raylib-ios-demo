# Particles Blending

200 sparks, alpha against additive. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Particles Blending, ported from raylib-jolt-demo's `particles-blending` demo (originally raylib-jlt's `particles_blending`) (net/b12n/raylib_jlt/particles_blending.clj, zlib licence): a pool of 200 coloured sparks that fall and fade, drawn with alpha blending or additive blending.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| the original's pool of 200 sparks (r, g, b from the LCG, a size of 1 to 30 over 20, falling 1.5 units a frame and fading 0.005 a frame) as flat circles of the sprite's size (32 times the size) tinted by their alpha, on DARKGRAY, with alpha or additive blending and 2 text lines; up to 200 circles, 1 button and 3 texts a frame, about 205 FFI calls | 59 | the pool, the draws in the order r g b size, the first-inactive activation, the fade, the fall, the order (spawn, then age, so a new particle ages that frame), the sprite's size, the tint `(r, g, b, int(255 * alpha))`, the texts and the clear are the original's, checked against the original's own loop over 400 frames; the mouse becomes a held finger, one particle a frame at the finger (the original spawns at the mouse wherever it is, so nothing is emitted here with no finger down); SPACE becomes a tap on a button that carries the original's label ("ALPHA BLENDING" in BLACK or "ADDITIVE BLENDING" in RAYWHITE) and flips on its release; the soft radial sprite is a flat circle, so the per-pixel falloff is gone and additive saturates sooner; the window is 800 units wide and as tall as the field, so a portrait field is taller than 450; the top text is centred and cut back to fit; the draw ends the blend mode in a `finally`; the GLES2 blend on the phone is unmeasured; builds in about 0.087 ms under jolt on the laptop with a full pool, a finger held and the draw side's own code run, against the 0.30 ms target |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb particles-blending      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.blendparticles.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/blendparticles.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/blendparticles/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/blendparticles_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `particles-blending` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
