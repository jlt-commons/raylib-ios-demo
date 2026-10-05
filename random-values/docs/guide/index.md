# Random Values

A new random number every two seconds. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

![Random Values on an iPhone 17 Pro](../../../docs/images/randomvalues.png)

## What it is

A new random number from 0 to 99 every two seconds, with a short history of recent rolls. Ported from raylib-jolt-demo's `random-values` demo (originally raylib-jlt's `random_values`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| a number and a label | 58 | seeded, so it replays |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb random-values      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.randomvalues.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/randomvalues.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/randomvalues/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/randomvalues_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `random-values` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
