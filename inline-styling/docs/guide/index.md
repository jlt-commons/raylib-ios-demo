# Inline Styling

Colours set inside the string itself. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Colours set inside the string itself. Ported from raylib-jolt-demo's `inline-styling` demo (originally raylib-jlt's `inline_styling`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 5 lines of text in runs, a rectangle behind some runs, a box of 4 lines and 1 legend line | 58 | nothing is read; the colours come from a tiny markup inside each string, `[cRRGGBBAA]` for the text, `[bRRGGBBAA]` for the background and `[r]` to reset, with a tag's alpha multiplied by the base's, and a bad tag prints as text; the CREATIVE word takes a new colour every 20 frames, frame-locked as in the original, from the project's seeded generator; lines are scaled by one factor and each run starts where the last ends by the measured width |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb inline-styling      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.inlinestyle.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/inlinestyle.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/inlinestyle/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/inlinestyle_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `inline-styling` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
