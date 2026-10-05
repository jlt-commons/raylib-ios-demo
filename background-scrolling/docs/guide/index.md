# Background Scrolling

Three parallax skyline layers. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Background scrolling, ported from raylib-jolt-demo's `background-scrolling` demo (originally raylib-jlt's `background_scrolling`) (net/b12n/raylib_jlt/background_scrolling.clj, zlib licence): three skyline layers scroll left at different speeds for a parallax, each drawn twice side by side so the seam wraps.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| the original's three skyline layers (back, middle, front) on a clear colour of (5, 44, 70), each a row of building rects (25, 16 and 9 buildings in columns of 32, 52 and 88 units, so the buildings are 28, 46 and 76 wide after the 15 percent gaps, in (20, 52, 78), (12, 34, 50) and (4, 12, 20)) drawn twice, one period apart, standing on the bottom of the screen, and the red caption; 50 rects and 1 line of text a frame | 58 | the layers' seeds, horizons, column widths and colours, the building heights (`hash01` of the seed plus the column), the speeds of 0.1, 0.5 and 1.0 units a frame to the left with no frame time, and the wrap at minus 800 are the original's; the three `texture-from-fn` skylines become one rect per building from the same arithmetic (a test samples every 11th column and every 9th row, at six offsets, against a transcription of the original's `skyline-pixel`), so the transparent sky and the gaps show the layer behind as before; the 800 units of a period are one screen width, so the picture is scaled by the width over 800 and sits on the bottom of the screen, with more sky above it on a portrait phone; a rect wholly off the screen is not drawn; there is no input, as in the original; it builds in about 0.03 ms under jolt on the laptop plus 50 FFI calls, against the 0.30 ms target |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb background-scrolling      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.bgscroll.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/bgscroll.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/bgscroll/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/bgscroll_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `background-scrolling` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
