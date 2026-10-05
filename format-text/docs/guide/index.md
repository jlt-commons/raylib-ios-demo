# Formatted Text

A padded score and an MM:SS timer. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

![Formatted Text on an iPhone 17 Pro](../../../docs/images/formattext.png)

## What it is

A zero-padded score and an MM:SS timer counting up. Ported from raylib-jolt-demo's `format-text` demo (originally raylib-jlt's `format_text`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 2 lines of text | 58 | zero-padded score and MM:SS, padded by a private `zero-pad` built from `str` |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb format-text      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.formattext.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/formattext.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/formattext/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/formattext_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `format-text` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
