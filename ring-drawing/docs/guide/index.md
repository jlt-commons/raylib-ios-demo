# Ring Drawing

A breathing annulus with a stroked outline. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

![Ring Drawing on an iPhone 17 Pro](../../../docs/images/ring.png)

## What it is

A filled annulus whose sweep and inner radius breathe, with a stroked outline. Ported from raylib-jolt-demo's `ring-drawing` demo (originally raylib-jlt's `ring_drawing`), itself raylib's `shapes_ring_drawing` minus its raygui sliders.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| a breathing annulus, stroked | 59 | the scene that would have caught the winding bug |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb ring-drawing      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.ring.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/ring.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/ring/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/ring_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `ring-drawing` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
