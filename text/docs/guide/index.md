# Font Sizes

Lines at several sizes and colours. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Lines at several font sizes and colours, two of them centred by measuring them. Ported from raylib-jolt-demo's `text` demo (originally raylib-jlt's `text`), which uses raylib's built-in bitmap font and no external one.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 6 lines of text at 5 sizes and 6 colours | 58 | nothing moves and nothing is read; sizes are the original's 10, 20, 24, 30 and 40 scaled by one factor to fit below Back and rounded to whole numbers, and two lines are centred by the measured width; it is about size where Text Alignment is about placement |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb text      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.fontsizes.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/fontsizes.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/fontsizes/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/fontsizes_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `text` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
