# Rectangle Bounds

Word-wrapped text in a resizable box. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Text wrapped inside a box you resize by dragging its corner handle. Ported from raylib-jolt-demo's `rectangle-bounds` demo (originally raylib-jlt's `rectangle_bounds`), which is raylib's `text_rectangle_bounds` example.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 4 lines, 2 rectangles and 3 or more lines of text, depending on the box | 58 | dragging the corner handle resizes the box and a tap on the wrap button toggles word or character wrap, in place of the mouse and SPACE; the layout is cached, so an idle frame measures nothing |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb rectangle-bounds      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.rectbounds.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/rectbounds.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/rectbounds/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/rectbounds_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `rectangle-bounds` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
