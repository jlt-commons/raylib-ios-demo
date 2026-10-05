# Fireworks

Rockets and fading particle bursts. One of the Generative scenes in the raylib-ios gallery, and an app of its own here.

![Fireworks on an iPhone 17 Pro](../../../docs/images/fireworks.gif)

## What it is

Rockets and particles under gravity, ported from raylib-jolt-demo's `fireworks` demo (originally raylib-jlt's `fireworks`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| ~120 circles | 58 | seeded, so it replays identically |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb fireworks      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
```

The app is `net.b12n.raylib-ios.scenes.fireworks.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/fireworks.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/fireworks/draw.clj`

## Where it comes from

Ported from raylib-jolt-demo's `fireworks` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
