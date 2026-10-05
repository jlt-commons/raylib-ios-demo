# Virtual Controls

An on-screen D-pad and action button. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

An on-screen D-pad and an A button that makes a square move and hop. Ported from raylib-jolt-demo's `input-virtual-controls` demo (originally raylib-jlt's `input_virtual_controls`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| a D-pad of 4 circles and a ring, an A button, a square, 3 lines of text | 58 | every finger down is tested, so a direction and A work together, in place of the arrow keys and SPACE; motion is delta-time based as in the original, and a rotation starts over |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb input-virtual-controls      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.virtualpad.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/virtualpad.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/virtualpad/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/virtualpad_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `input-virtual-controls` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
