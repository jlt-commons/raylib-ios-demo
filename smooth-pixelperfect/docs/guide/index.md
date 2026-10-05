# Smooth Pixel-Perfect

A smooth pixel-perfect camera. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Smooth pixel-perfect camera, ported from raylib-jolt-demo's `smooth-pixelperfect` demo (originally raylib-jlt's `smooth_pixelperfect`) (net/b12n/raylib_jlt/smooth_pixelperfect.clj, itself raylib's `core_smooth_pixelperfect`, zlib licence), without its render texture.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| the original's three spinning rects (20 by 20 black, 30 by 10 red and 15 by 25 blue, turning about their top-left corners by the spin, minus the spin and the spin plus 45) in a 160 by 90 world on RAYWHITE, swaying on the original's sine and cosine path, drawn at the largest whole number of screen pixels for a world pixel that fits the field (7 on a 1206 wide phone, so the window is 1120 by 630), with the camera on the integer part of the path and, with smoothing on, the remainder times that zoom slid off the offset, and the original's four readouts; each rect rasterised to the 160 by 90 grid as row runs of cells (at most 86 runs a frame, one `draw-rectangle` each), 1 fill and 1 camera, about 130 FFI calls a frame | 58 | the world, the sway (`cx` is sin t * 50 - 10 and `cy` is cos t * 30, truncated toward zero for the integer part), the three rects and their spins, the 60 degrees a second, the remainder times the ratio, the two blit rects (overscan: -R, -R, W + 2R, H + 2R of the window; off: centred) and the readouts are the original's; the S key becomes a "smooth" button and O an "overscan" button, side by side below Back, each flipped by a tap that began on it, and the key hint is dropped from the status line since the buttons say it; `get-time` and `get-frame-time` become the sum of `:delta-seconds`; the fps is the host's `GetFPS`, read every frame as Starfield shows it; the 160 by 90 render texture is dropped, so the picture is drawn under `with-camera-2d` and clipped by a scissor, and each rotated rect is rasterised on the CPU to the 160 by 90 grid (a cell is filled when its centre is inside the rect, a row of cells is one rect), which is what the nearest-filtered texture showed, so the slanted edges are chunky staircases (an edge tie goes by a half-open interval, not the GPU's rule); the overscan stretch is one zoom, the larger of the two the original uses across and down (5.0625 and 5.111 at 5), so the world always covers the window and no strip of the clear colour shows, and with overscan off the picture is at the zoom less one (4 at 5, the original's) instead of 4/5 of it; the original's window size is the window drawn here, 160 times the zoom by 90 times the zoom; builds in about 0.052 ms under jolt on the laptop plus about 130 FFI calls (about 0.11 ms in all), against the 0.30 ms target |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb smooth-pixelperfect      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.pixelperfect.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/pixelperfect.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/pixelperfect/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/pixelperfect_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `smooth-pixelperfect` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
