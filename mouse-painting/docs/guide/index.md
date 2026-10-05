# Mouse Painting

A paint program on a render-target canvas. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Mouse Painting, ported from raylib-jolt-demo's `mouse-painting` demo (originally raylib-jlt's `mouse_painting`) (net/b12n/raylib_jlt/mouse_painting.clj, EPL 2.0), which is raylib's `textures_mouse_painting` (zlib). This is an altered version of both.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| one render target the size of the field below the controls (about 1206 by 1924 in portrait), kept between frames and drawn back as one quad, a palette of 23 swatches, 4 buttons and a brush preview under the finger | 58 | the 23-colour palette, the brush (20, in steps of 5 between 2 and 50) and the paint, the erase to the first swatch and the clear to it are the original's; **a finger is the mouse**: it paints while it stays down, but only if it landed in the field, so a finger that slides in from the panel, or was already down when the scene opened, leaves no mark, and a finger that leaves the field ends its stroke and does not resume it on coming back (the original paints again on re-entry); the brush is the original's 20 pixels and is not scaled with the screen, so on a 1206 pixel wide screen it looks about two thirds the size it has in the original's 800 pixel window; the wheel is SIZE - and SIZE +, the right button is ERASER (a toggle, and picking a swatch turns it off) and C is CLEAR, each a press; **the original draws one circle a frame and a finger moves far further than a mouse**, so a stroke is circles spaced half a radius apart along the segment from the last point (at most 256 a segment), and the first point of a touch is one circle; the swatches wrap to two rows on a narrow screen so a thumb can hit them; the original's SAVE button and S key (a screenshot) and the hover highlight are dropped; **turning the phone clears the picture**: the canvas is the size of the field, so a rotation makes it again and it starts empty in the first swatch's colour (the original's window never turns); only the frame's marks are drawn into the canvas, none on a frame where nothing is touched; the canvas is about 9.3 MB with no depth buffer, since the passes are 2D, zeroed on the CPU when the scene opens (1.1 to 2.1 ms under laptop jolt with the upload stubbed; on the phone the largest frame is 29 ms on a first open) and freed when you leave; under laptop jolt a frame (update, the draw loops, FFI stubbed) averages 0.016 ms idle, 0.024 ms mid-stroke and 0.037 ms replaying 10 strokes |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb mouse-painting      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.mousepaint.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/mousepaint.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/mousepaint/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/mousepaint_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `mouse-painting` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
