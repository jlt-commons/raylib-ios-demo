# Lorenz

The Lorenz attractor, re-projected each frame. One of the Generative scenes in the raylib-ios gallery, and an app of its own here.

![Lorenz on an iPhone 17 Pro](../../../docs/images/lorenz.gif)

## What it is

The Lorenz attractor, ported from raylib-jolt-demo's `lorenz-attractor` demo (originally raylib-jlt's `lorenz_attractor`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 450 lines, re-projected each frame | 58 | see the sweep in [performance](../../../docs/guide/performance-on-a-phone.md) |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb lorenz-attractor      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.lorenz.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/lorenz.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/lorenz/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/lorenz_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `lorenz-attractor` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
