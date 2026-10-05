# Fourier Epicycles

Circles on circles that draw a square wave. One of the Generative scenes in the raylib-ios gallery, and an app of its own here.

![Fourier Epicycles on an iPhone 17 Pro](../../../docs/images/epicycles.gif)

## What it is

Fourier epicycles drawing a square wave, ported from raylib-jolt-demo's `fourier-epicycles` demo (originally raylib-jlt's `fourier_epicycles`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| ~200 lines | 59 | a square wave, drawn by circles |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb fourier-epicycles      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
```

The app is `net.b12n.raylib-ios.scenes.epicycles.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/epicycles.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/epicycles/draw.clj`

## Where it comes from

Ported from raylib-jolt-demo's `fourier-epicycles` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
