# rlgl Triangle

A Gouraud triangle with draggable corners. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

![rlgl Triangle on an iPhone 17 Pro](../../../docs/images/rlgltriangle.png)

## What it is

One Gouraud-shaded triangle whose three corners you drag. Ported from raylib-jolt-demo's `rlgl-triangle` demo (originally raylib-jlt's `rlgl_triangle`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 3 vertices, 3 handles, 2 buttons | 58 | a colour per vertex; sticky corner grab, and the keys became buttons |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb rlgl-triangle      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.rlgltriangle.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/rlgltriangle.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/rlgltriangle/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/rlgltriangle_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `rlgl-triangle` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
