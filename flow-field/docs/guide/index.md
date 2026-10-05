# Flow Field

Particles steered by a flow field. One of the Generative scenes in the raylib-ios gallery, and an app of its own here.

![Flow Field on an iPhone 17 Pro](../../../docs/images/flowfield.gif)

## What it is

Particles following a Perlin-ish flow field, ported from raylib-jolt-demo's `flow-field` demo (originally raylib-jlt's `flow_field`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 90 particles, 8-point trails | 54 | the first port the budget bit |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb flow-field      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
```

The app is `net.b12n.raylib-ios.scenes.flowfield.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/flowfield.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/flowfield/draw.clj`

## Where it comes from

Ported from raylib-jolt-demo's `flow-field` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
