# Flappy Bird

Tap to flap through the pipe gaps. One of the Games scenes in the raylib-ios gallery, and an app of its own here.

![Flappy Bird on an iPhone 17 Pro](../../../docs/images/flappy-bird.gif)

## What it is

Pure, deterministic, touch-first Flappy Bird simulation.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| ~30 shapes | 59 | identical to the Android experiment apart from names and whitespace |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb flappy-bird      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.flappy-bird.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/flappy_bird.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/flappy_bird/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/flappy_bird_test.cljc`

## Where it comes from

Carried from [jasalt/jolt-android-experiment](https://github.com/jasalt/jolt-android-experiment) at 6d2b291, identical apart from namespace names and whitespace. `tools/jasalt-identity.edn` and the identity test check it, so do not edit the scene beyond its names. raylib-jolt-demo has a desktop sibling, `flappy-bird`, originally raylib-jlt's.
