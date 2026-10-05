# Starfield Effect

Stars flying at you, dragged faster or slower. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Stars flying at the viewer, dragged faster or slower. Ported from raylib-jolt-demo's `starfield-effect` demo (originally raylib-jlt's `starfield_effect`), which is raylib's `shapes_starfield_effect` example. It is a different scene from `stars`, which is a twinkle: those stars drift and pulse in place, while these fly toward the camera under a perspective projection and respawn at the far plane.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| up to 350 circles or streaks and 3 lines of text | 52 | a vertical drag sets the speed in place of the mouse wheel and a tap toggles streaks in place of SPACE; motion is delta-time based as in the original, and a rotation needs no reset |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb starfield-effect      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.starfield.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/starfield.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/starfield/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/starfield_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `starfield-effect` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
