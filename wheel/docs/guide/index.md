# Mouse Wheel

A box dragged up and down. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

![Mouse Wheel on an iPhone 17 Pro](../../../docs/images/wheelbox.png)

## What it is

A box dragged up and down. Ported from raylib-jolt-demo's `wheel` demo (originally raylib-jlt's `wheel`), which is raylib's `core_input_mouse_wheel` example.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 1 square and 1 line of text | 58 | a vertical drag moves the box, in place of the mouse wheel: it follows the finger one for one from where the press anchored it, so the 20 pixel notch is whatever the finger travels, and the release swipe is ignored so the box does not move twice; the box is the original's 80 scaled by one factor, centred across the width and held inside the field below Back as the original holds it inside the window, and a rotation pulls it back in |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb wheel      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.wheelbox.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/wheelbox.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/wheelbox/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/wheelbox_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `wheel` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
