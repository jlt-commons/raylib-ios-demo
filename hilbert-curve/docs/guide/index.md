# Hilbert Curve

A Hilbert curve drawn progressively. One of the Fractals scenes in the raylib-ios gallery, and an app of its own here.

![Hilbert Curve on an iPhone 17 Pro](../../../docs/images/hilbert.png)

## What it is

A Hilbert space-filling curve, ported from raylib-jolt-demo's `hilbert-curve` demo (originally raylib-jlt's `hilbert_curve`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 1023 lines | 60 | order 5, drawn progressively |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb hilbert-curve      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
```

The app is `net.b12n.raylib-ios.scenes.hilbert.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/hilbert.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/hilbert/draw.clj`

## Where it comes from

Ported from raylib-jolt-demo's `hilbert-curve` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
