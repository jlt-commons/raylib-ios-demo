# Framebuffer Rendering

Two cameras into two framebuffers. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Framebuffer Rendering, ported from raylib-jolt-demo's `framebuffer-rendering` demo (originally raylib-jlt's `framebuffer_rendering`) (net/b12n/raylib_jlt/framebuffer_rendering.clj, EPL 2.0), which is raylib's `textures_framebuffer_rendering`. The raylib C example it follows is zlib licensed, and this is an altered version of that too.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| two render targets, each the size of its half of the field below Back (about 1206 by 1100 each in portrait), the observer's with a gold cube of side 2, pink wires, a grid of 10 and the other camera's green view frustum, the subject's with the same cube and a green 128 by 128 outline in the middle, then drawn back with a 128 by 128 inset of the subject's middle (the same texture sampled through a narrower rectangle), a green outline round it and a divider | 58 | the world, the two orbits (radius 5, height 2, 0.012 radians a frame, and radius 14, height 10, 0.004), fovy 45, the frustum built from the subject camera's own numbers at depth 3, the crop of 128, the inset 20 in from the subject view's corner and the texts are the original's; the views stack in portrait and sit side by side in landscape (as 3D Split Screen does) and each target is the size of its viewport in place of 400 by 450, so the crop and the inset, which stay 128 and 20 pixels, are small on a large half; the 3D is projected in software and drawn into each target as a 2D draw list, with no depth buffer, so the frustum is not depth tested: each of its 8 segments is painted under the cube when its midpoint is farther from the observer than the cube's centre and over it otherwise, an approximation where a long edge crossing the cube is wholly hidden or wholly drawn; the text sizes are the original's times the half's scale, cut back to fit; the original's FPS counter is dropped; the two targets are zeroed on the CPU when the scene opens (about 5.3 MB each in portrait, 2.1 ms for both under laptop jolt with the upload stubbed; on the phone the largest frame is 33 ms on a first open) and freed when you leave; under laptop jolt a frame (update, the draw-list builds and the draw loops, FFI stubbed) averages 0.15 ms |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb framebuffer-rendering      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.fbrender.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/fbrender.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/fbrender/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/fbrender_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `framebuffer-rendering` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
