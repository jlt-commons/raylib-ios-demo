# Render Texture

A scene drawn off-screen, then reused. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Render Texture, ported from raylib-jolt-demo's `render-texture` demo (originally raylib-jlt's `render_texture`) (net/b12n/raylib_jlt/render_texture.clj, zlib licence), which is raylib's `textures_render_texture`. The raylib C example it follows is zlib licensed too, and this is an altered version of both.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| one 320 by 240 render target drawn into once (6 balls of radius 18, the text "off-screen" and a gray outline), then drawn back as 4 quads at 1, 0.6, 0.35 and 0.5 of its size, with 5 lines of text | 58 | the target, the balls' Lissajous (`160 + 110 sin(t + 0.9 i)`, `120 + 70 cos(1.4 (t + 0.9 i))`), their colours and the table of copies are the original's, and the last copy is tinted (255, 180, 180); the copies are drawn with `:v0 1.0 :v1 0.0` because GL stores a target bottom-up; the original's 800 by 450 window is drawn as one block scaled to the screen and centred below Back, so a "100%" copy is the target at that block scale and not one texel to a pixel, and the text sizes scale with it; `t` is the seconds the scene has run, from `:delta-seconds`, in place of `get-time`; the target is 307 KB with no depth buffer, since the pass is 2D, zeroed on the CPU when the scene opens (0.18 ms under laptop jolt with the upload stubbed; on the phone the largest frame is 103 ms on a first open, which was the first scene opened after launch and so includes part of the launch), and freed when you leave; under laptop jolt a frame (update, draw loops, FFI stubbed) averages 0.014 ms |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb render-texture      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.rendertex.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/rendertex.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/rendertex/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/rendertex_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `render-texture` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
