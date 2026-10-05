# Vector Angle

The signed angle between two vectors. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

![Vector Angle on an iPhone 17 Pro](../../../docs/images/vecangle.png)

## What it is

Two vectors from one origin, with the signed angle between them filled as an arc and read out in degrees. Ported from raylib-jolt-demo's `vector-angle` demo (originally raylib-jlt's `vector_angle`), itself raylib's `shapes_vector_angle`.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 2 arms and a filled arc | 58 | the angle is signed, and you can see the sign |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb vector-angle      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.vecangle.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/vecangle.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/vecangle/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/vecangle_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `vector-angle` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
