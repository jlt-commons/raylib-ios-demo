# L-system Plant

An L-system plant that grows and regrows. One of the Fractals scenes in the raylib-ios gallery, and an app of its own here.

![L-system Plant on an iPhone 17 Pro](../../../docs/images/lsystem.gif)

## What it is

An L-system plant, ported from raylib-jolt-demo's `l-system` demo (originally raylib-jlt's `l_system`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 1488 segments | 59 | static once grown, which is why it is cheap |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb l-system      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
```

The app is `net.b12n.raylib-ios.scenes.lsystem.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/lsystem.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/lsystem/draw.clj`

## Where it comes from

Ported from raylib-jolt-demo's `l-system` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
