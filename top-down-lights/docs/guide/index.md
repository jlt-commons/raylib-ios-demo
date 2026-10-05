# Top Down Lights

Lights and shadow volumes from a top-down view. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Top Down Lights, ported from raylib-jolt-demo's `top-down-lights` demo (originally raylib-jlt's `top_down_lights`) (net/b12n/raylib_jlt/top_down_lights.clj, EPL 2.0), which is raylib's `shapes_top_down_lights` by Jeffery Myers (zlib). This is an altered version of both.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| a ground of 64 pixel checks, 20 boxes (two placed by hand, 18 from the LCG), up to 16 lights, each with a mask the size of the field and one merged mask drawn over the ground in black, a circle on every light, 2 lines of help and a button | 58 | the constants (16 lights, 20 boxes, tile 64), the boxes, the shadow volumes (one quad per edge the light is outside of, plus the footprint, pushed out twice the radius), light 1 (radius 300, the others 200), its idle walk and the blend sequence are the original's: each dirty light is a mask cleared to WHITE, then a gradient drawn with `GL_SRC_ALPHA, GL_SRC_ALPHA, GL_MIN`, then its shadows with `GL_SRC_ALPHA, GL_SRC_ALPHA, GL_MAX`, and the master is cleared to BLACK and every mask merged with GL_MIN; **the touch**: a drag that travels past the tap slop moves light 1 and leaves it there, a quick tap adds a light (the right button), and a button toggles the shadow volumes (F1, which draws light 1's volumes in DARKPURPLE, the boxes it reaches in PURPLE and every box outlined in DARKBLUE); positions are the original's fractions of the field and lengths (boxes, radii, tile, markers) its scale; the help texts are raised to 24 pixels so a phone can read them; the original's FPS counter is dropped; **this seed's box darkens the opening light**: the idle walk starts at the field's centre, and with the seeded box placement a box sits there, so the light goes dark for its first frames until it walks out (the original's boxes are unseeded, so this is this port's placement, not its behaviour); a turn starts the scene again with one light, and the dropped lights' masks shrink to a pixel; **each mask is the size of the field** (about 1206 by 2214 in portrait, 10.7 MB of colour and no depth buffer, since the passes are 2D), so 16 lights hold 17 targets, about 182 MB (arithmetic, 17 times 10.7 MB, not a measurement), and each is zeroed on the CPU when made (about 1 ms under laptop jolt with the upload stubbed); **on the phone** it reads 58 with one light and 58 with 16, idle and while dragging a light, and the first open pauses 75 ms (119 ms when its targets still had depth buffers), with the shadows correct without depth; an earlier build that gave every target a depth buffer (an estimate of 272 to 363 MB) ran 16 lights without the app being ended; a frame redraws the masks of the lights that moved and merges all of them (laptop jolt, FFI stubbed): 0.08 ms with one light walking, 0.11 ms with 16 and one walking, 0.14 ms on the frame a tap adds a 16th |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb top-down-lights      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.toplights.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/toplights.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/toplights/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/toplights_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `top-down-lights` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
