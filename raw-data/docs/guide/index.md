# Raw Data

Textures built from a hand-filled byte buffer. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Raw Data, ported from raylib-jolt-demo's `raw-data` demo (originally raylib-jlt's `raw_data`) (net/b12n/raylib_jlt/raw_data.clj, EPL 2.0), which is raylib's `textures_raw_data`: a texture is a flat block of bytes this program fills in itself. Two panels, a 256 by 256 checkerboard, uploaded once, and a 128 by 128 panel whose colour is arithmetic on x, y and time. The raylib C example it follows is zlib licensed, and this is an altered version of that too.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| a checkerboard drawn 256 by 256 from one 64 by 64 repeating texture, and a 128 by 128 live panel, each drawn as one quad with an outline and a name, and 3 lines of text | 58 | the original's checkerboard (ORANGE and GOLD in squares of 32 texels, uploaded once as its one 64 by 64 period with `:repeat` and texcoords 0 to 4, which samples the same colour at every texel of the original's 256 by 256 panel) and its live panel (red, green and blue each an absolute sine or cosine of x, y and time, `t = frame * 0.03`), both unfiltered, the checkerboard repeating and the live panel clamped; **the live panel is refreshed a band at a time**: the original rewrites all 16384 texels every frame, which would stall the phone, so each frame refills a band of 3 rows (`rlUpdateTexture` with an offset and a size) walking down the panel, every row is refreshed once every 43 frames (the last band is 2 rows), about 1.4 times a second at 60 frames a second, and the animation drifts at that rate rather than the original's; the rows of one band share one `t`, so a moving seam shows between fresher rows above and older rows below, and the live panel's name says "a band at a time" in place of "every frame"; the fps readout is left out; entering the scene fills the 4096-texel checkerboard and the live panel once, a one-off cost; the panels stack on a portrait screen and sit side by side on a landscape one, square, with each name above its panel; the first open after launch pauses about 0.17 s, and a reopen about 0.15 s, since the live panel is banded and not kept (the checkerboard reopens in about one frame) |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb raw-data      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.rawdata.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/rawdata.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/rawdata/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/rawdata_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `raw-data` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
