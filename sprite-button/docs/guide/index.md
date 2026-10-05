# Sprite Button

One sheet, three button states. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Sprite Button, ported from raylib-jolt-demo's `sprite-button` demo (originally raylib-jlt's `sprite_button`) (net/b12n/raylib_jlt/sprite_button.clj, EPL 2.0), which is raylib's `textures_sprite_button`: one texture holds three stacked frames of a button, normal, hover and pressed, and the button picks its frame by sliding a window down the sheet, a third of the texture's height at a time. Click it and the counter goes up. The raylib C example it follows is zlib licensed, and this is an altered version of that too.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| one 160 by 144 texture drawn twice, as a button showing one third of it and as a preview of the whole sheet with a RED outline round the frame in use, plus 3 lines of text | 58 | the original's sheet of three 160 by 48 frames (normal, hover, pressed), clamped, and its slice by `v0 = frame / 3` to `v1 = (frame + 1) / 3`; **the mouse is touch**: a finger down on the button shows the pressed frame and a release over it adds one to the click count, judged by where the finger was last down because the release's own position is not trusted; the hover frame shows while a finger that pressed the button has slid off it and is still down; the original's idle cycle through the frames is kept, since on a phone its `live?` is just a finger being down: with none down the three frames cycle, 60 frames each, and a finger landing stops it; the button is half the shorter side wide and the preview a quarter; the first open after launch pauses about 0.2 s, and a reopen costs about one frame because the filled buffer is kept |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb sprite-button      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.spritebutton.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/spritebutton.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/spritebutton/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/spritebutton_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `sprite-button` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
