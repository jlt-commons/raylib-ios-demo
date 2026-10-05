# Easings Box

Drop, flatten, spin, grow and fade a square. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

A square that drops, flattens into a bar, spins, grows to fill the screen and fades out, each stage on its own easing curve. Ported from raylib-jolt-demo's `easings-box` demo (originally raylib-jlt's `easings_box`), which is raylib's `shapes_easings_box_anim` example. A `:tap` from `net.b12n.raylib-ios.gesture` restarts it, in place of SPACE, unless it lands in the Back region, which belongs to the host.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 2 triangles and 1 line of text | 58 | a tap restarts, in place of SPACE; frame-locked as in the original, and the box grows to fill the region below Back |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb easings-box      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.easingsbox.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/easingsbox.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/easingsbox/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/easingsbox_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `easings-box` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
