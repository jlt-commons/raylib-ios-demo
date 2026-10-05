# Boids

A flock: separation, alignment, cohesion. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

![Boids on an iPhone 17 Pro](../../../docs/images/boids.gif)

## What it is

Flocking, ported from raylib-jolt-demo's `boids` demo (originally raylib-jlt's `boids`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 2025 distance tests, 90 draws | 52 | the cheapest drawing and the dearest thinking |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb boids      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
```

The app is `net.b12n.raylib-ios.scenes.boids.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/boids.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/boids/draw.clj`

## Where it comes from

Ported from raylib-jolt-demo's `boids` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
