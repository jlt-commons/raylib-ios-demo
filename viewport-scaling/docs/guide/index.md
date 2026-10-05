# Viewport Scaling

Six viewport scaling policies. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

A game drawn at a fixed resolution and scaled into a window under six viewport policies. Ported from raylib-jolt-demo's `viewport-scaling` demo (originally raylib-jlt's `viewport-scaling`), which is raylib's `core_viewport_scaling` example (zlib licence).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| the original's game (a white clear with a LIME circle of radius 20, at 64x64, 256x240, 320x180 or 3840x2160), its six policies (KEEP_ASPECT_INTEGER, KEEP_HEIGHT_INTEGER, KEEP_WIDTH_INTEGER, KEEP_ASPECT, KEEP_HEIGHT, KEEP_WIDTH) and its six readouts (window, game, type, scale ratio, source size, destination size), in a virtual window on the field, with two pairs of < > buttons; 1 scissor, 1 push and scale, about 28 FFI calls a frame | 59 | the maths of `compute-rects` is the original's line for line (the quirks included: the two height policies are one function and so are the two width policies, so only KEEP_ASPECT_INTEGER snaps), and the blit rectangle, the scale ratio, the source and destination sizes and the mouse mapping `(mx - dx) * sw / dw` on both axes are the original's, with the scale readout INVALID under 0.001 as it is there; the resizable 800x450 window becomes a virtual window that starts in the original's 800x450 shape at 80 percent of what the field allows (so it can grow) and is resized by dragging a square handle in its bottom-right corner, clamped to the field; the mouse becomes the finger, which moves the circle while it is down and leaves it where it was after, starting in the middle; the < > pairs become taps that began on a button, wrapping; the render texture is dropped, so the destination is a scissor and the game is drawn under a push, translate and scale; the panel's box is dropped and the readouts sit above the field, with the game and type lines between their buttons, so the order is not the original's; a destination that is empty (an integer policy for a game bigger than the window, where `quot` gives 0) draws nothing and gives no mouse position; builds in about 0.010 ms under jolt on the laptop, against the 0.30 ms target |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb viewport-scaling      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.vpscaling.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/vpscaling.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/vpscaling/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/vpscaling_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `viewport-scaling` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
