# Sprite Stacking

Forty slices faking a 3D car. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Sprite stacking, ported from raylib-jolt-demo's `sprite-stacking` demo (originally raylib-jlt's `sprite_stacking`) (net/b12n/raylib_jlt/sprite_stacking.clj, zlib licence): forty top-down slices of a small car, each drawn at the same rotation and a little higher on the screen than the one below, which the eye reads as a solid body turning in place.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| the original's 40 slices of a small car, drawn last row first so the roof lands on top, each a stack of rects and circles (two wheels, then the body, the shoulders, the cabin and its glass, with rounded corners of radius 3 or 2) turned about its own centre by one rotation and set `spacing` higher than the slice below, on RAYWHITE, with 3 readouts under Back and a note at the bottom; 92 rects, 164 circles and 160 matrix calls a frame | 58 | the slices (every `image-draw-rectangle!` and `image-draw-circle!` of `draw-layer!` and `slab!`, by the same thresholds on `i / 39`), the 3x scale, the 40 layers, the spacing of 3.2 held to 0 to 5, the spin of 30 degrees a second that the keys change by 0.35 a frame, the order of drawing and the rotation about each slice's centre are the original's; each slice is drawn as rects and circles under an rlgl rotation (push, translate, rotate, pop), so the 56 by 784 image and its textured quads are dropped and a corner is a true circle where the original's is a raster one; a horizontal drag replaces the arrow keys and A and D, as a relative stick from the press point that adds or takes off 0.35 of speed a frame past the tap slop, with no cap as in the original; a two-finger pinch replaces the mouse wheel, adding 2.5 times the change of distance minus one to the spacing (the original adds 0.1 a notch; this is a guess at the feel, and additive so that 0 can open again), held to 0 and 5, and only while exactly two fingers stay down; the stack is scaled by the smaller of the width over 800 and the field's height over 450 and centred on the field; the key hint becomes "drag: spin - pinch: spread the layers" and the note says the slices are rects and circles; it builds in about 0.08 ms under jolt on the laptop plus about 420 FFI calls, against the 0.30 ms target |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb sprite-stacking      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.spritestack.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/spritestack.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/spritestack/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/spritestack_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `sprite-stacking` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
