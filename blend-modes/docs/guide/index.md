# Blend Modes

Blend modes over a night skyline. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Blend Modes, ported from raylib-jolt-demo's `blend-modes` demo (originally raylib-jlt's `blend_modes`) (net/b12n/raylib_jlt/blend_modes.clj, zlib licence): a cluster of three coloured glows drawn over a night skyline through each of four blend modes in turn.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| the original's night skyline (a gradient from (18, 12, 42) to (58, 24, 74), 19 buildings in (14, 10, 22) and 81 lit windows) under three coloured glows (cyan, magenta and yellow, radius 70, 60 and 55 texture pixels) drawn through BLEND_ALPHA, BLEND_ADDITIVE, BLEND_MULTIPLIED and BLEND_ADD_COLORS in turn, with 2 lines of text; 1 gradient quad, 100 rects, 1 clear quad and 48 gradient triangles a frame, about 350 FFI calls | 58 | the four modes and their order, the 800 by 450 picture over 400 by 225 textures, `hash01`, the skyline's columns of 22, their tops and the window rule, the three blobs and the linear falloff are the original's; the two procedural textures are redrawn as shapes (the sky is one gradient quad and so is smooth where the original steps its channels by row, the buildings and windows are rects checked pixel for pixel against the original's rule, each glow is a fan of 16 triangles with a centre of (r, g, b, 255) and a clear rim, so the colour interpolates as `k * colour`); the glows are blended one at a time where the original sums them into the texture and blends once, so where two glows overlap the picture differs (under ADDITIVE about half as bright, ALPHA and MULTIPLIED too, ADD_COLORS the same), and a 16-sided fan is not a disc; under MULTIPLIED a source of (0, 0, 0, 0) leaves the pixel alone in `glBlendFunc(GL_DST_COLOR, GL_ONE_MINUS_SRC_ALPHA)`, so the original's note that it blackens the rest of the picture does not hold, and the clear quad it stands for changes nothing; SPACE becomes a tap anywhere outside Back, on its release; the two texts sit above the picture at a readable size rather than on it at size 10; the picture is the largest 16:9 that fits below them; `BeginBlendMode` and `EndBlendMode` are the first blend bindings and the draw ends the mode in a `finally`; the GLES2 blend on the phone is unmeasured; builds in about 0.044 ms under jolt on the laptop with the draw side's own code run and the FFI stubbed, against the 0.30 ms target |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb blend-modes      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.blendmodes.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/blendmodes.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/blendmodes/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/blendmodes_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `blend-modes` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
