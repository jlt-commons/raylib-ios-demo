# Touch Trail

A fading trail follows your finger. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

![Touch Trail on an iPhone 17 Pro](../../../docs/images/touch-trail.png)

## What it is

Pure bounded primary-pointer trail; adapted from raylib-jlt mouse-trail.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| ~40 circles | 59 | identical to the Android original apart from names and whitespace; the first scene here that wanted a finger |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb mouse-trail      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.touch-trail.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/touch_trail.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/touch_trail/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/touch_trail_test.cljc`

## Where it comes from

Carried from [jasalt/jolt-android-experiment](https://github.com/jasalt/jolt-android-experiment) at 6d2b291, identical apart from namespace names and whitespace. `tools/jasalt-identity.edn` and the identity test check it, so do not edit the scene beyond its names. raylib-jolt-demo has a desktop sibling, `mouse-trail`, originally raylib-jlt's.
