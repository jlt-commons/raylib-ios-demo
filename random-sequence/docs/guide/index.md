# Random Sequence

A shuffled sequence of bars. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

![Random Sequence on an iPhone 17 Pro](../../../docs/images/sequence.gif)

## What it is

A shuffled sequence of bars, ported from raylib-jolt-demo's `random-sequence` demo (originally raylib-jlt's `random_sequence`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 24 rectangles | 57 | a permutation, not independent draws |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb random-sequence      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.sequence.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/sequence.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/sequence/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/sequence_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `random-sequence` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
