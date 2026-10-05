# Window Letterbox

A fixed picture letterboxed to any shape. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

A fixed 480 by 360 picture scaled into a window of any shape, with black bars where it does not fill. Ported from raylib-jolt-demo's `window-letterbox` demo (originally raylib-jlt's `window-letterbox`), a raylib example of its own (zlib licence).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| the original's 480 by 360 picture (a clear of (24, 28, 38), two rows of 12 alternating blue blocks, a GOLD circle swinging on 240 + 90 sin t, two lines of text and a RED crosshair) at the largest scale that fits a virtual window, centred, with black bars where it does not fill, and a readout of the window, the scale and the bars; 1 scissor, 1 push and scale, about 60 FFI calls a frame | 58 | `fit`, the blit rectangle `(int ox) (int oy) (int (* 480 s)) (int (* 360 s))`, the bars the readout reports (the offsets cut to whole pixels), the two-decimal scale and the mouse mapping `(int (/ (- mouse offset) s))`, truncating toward zero, with the crosshair drawn only over the picture, are the original's; the resizable window becomes a virtual window that starts in the original's 800x450 shape at 80 percent of what the field allows (so the bars are there from the first frame) and is resized by dragging a square handle in its bottom-right corner, clamped to the field; the mouse becomes the finger, which moves the crosshair while it is down and leaves it where it was after, starting in the middle; `get-time` becomes the sum of `:delta-seconds`; **R, the window-state calls and the resizable flag are dropped** (the window is always resizable, so the second text is the original's resizable branch, in GREEN); the render texture is dropped, so the blit is a scissor and the picture is drawn under a push, translate and scale; the strip along the window's bottom edge is dropped and its words sit in two lines above the field; builds in about 0.010 ms under jolt on the laptop, against the 0.30 ms target |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb window-letterbox      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.letterbox.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/letterbox.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/letterbox/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/letterbox_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `window-letterbox` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
