# Srcrec Dstrec

A source rectangle picks the frame, a dest scales. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Source and Destination Rects, ported from raylib-jolt-demo's `srcrec-dstrec` demo (originally raylib-jlt's `srcrec_dstrec`) (net/b12n/raylib_jlt/srcrec_dstrec.clj, EPL 2.0), which is raylib's `textures_srcrec_dstrec`: one frame of a sprite sheet drawn the way DrawTexturePro draws it. A source rectangle picks the frame, a destination rectangle scales it, and an origin offset makes it spin in place. The raylib C example it follows is zlib licensed, and this is an altered version of that too.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| one 384 by 64 texture drawn as a single rotated quad, two gray lines through the middle and a line of text | 58 | the original's sheet of six 64 by 64 frames (RED, ORANGE, GOLD, GREEN, SKYBLUE, VIOLET grounds with a RAYWHITE disc of radius 20.48), clamped because 384 is not a power of two; the fourth frame is the source rectangle (u from 192/384 to 256/384), the destination is a square at the middle of the screen turning about its own middle by 1 degree a frame, clockwise and unwrapped, like DrawTexturePro; the destination is 0.32 of the shorter side, not a whole 2x of the frame, and the vertical line starts below Back; uploaded once through rlgl when the scene opens and freed when you leave it; the first open after launch pauses about 0.2 s, and a reopen costs about one frame because the filled buffer is kept |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb srcrec-dstrec      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.srcrec.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/srcrec.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/srcrec/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/srcrec_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `srcrec-dstrec` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
