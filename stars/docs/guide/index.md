# Starfield

A twinkling starfield. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

![Starfield on an iPhone 17 Pro](../../../docs/images/stars.gif)

## What it is

A starfield flying toward the viewer, ported from raylib-jolt-demo's `stars` demo (originally raylib-jlt's `stars`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| ~300 points | 58 | seeded |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb stars      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
```

The app is `net.b12n.raylib-ios.scenes.stars.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/stars.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/stars/draw.clj`

## Where it comes from

Ported from raylib-jolt-demo's `stars` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
