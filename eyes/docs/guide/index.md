# Following Eyes

Two eyes that track your finger. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

![Following Eyes on an iPhone 17 Pro](../../../docs/images/following-eyes.png)

## What it is

Pure touch-first adaptation of pinned raylib-jlt Following Eyes.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 6 circles | 59 | identical to the Android experiment apart from names and whitespace |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb eyes      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.following-eyes.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/following_eyes.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/following_eyes/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/following_eyes_test.cljc`

## Where it comes from

Carried from [jasalt/jolt-android-experiment](https://github.com/jasalt/jolt-android-experiment) at 6d2b291, identical apart from namespace names and whitespace. `tools/jasalt-identity.edn` and the identity test check it, so do not edit the scene beyond its names. raylib-jolt-demo has a desktop sibling, `eyes`, originally raylib-jlt's.
