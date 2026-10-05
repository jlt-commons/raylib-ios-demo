# Still Logo

The raylib logo, still. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

The raylib logo, still. Ported from raylib-jolt-demo's `logo` demo (originally raylib-jlt's `logo`): a thick black square border built from two rectangles, a black one with a background-coloured one inside it, and 'raylib' tucked into the bottom-right corner of the inside.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 2 rectangles and 1 line of text | 58 | nothing moves and nothing is read, so the logo is the finished picture where raylib Logo is the assembly; the label is placed by the measured text width, and the logo is sized to fit below Back |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb logo      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.logo.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/logo.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/logo/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/logo_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `logo` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
