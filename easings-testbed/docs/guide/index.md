# Easings Testbed

One easing curve at a time, plotted. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

One easing curve at a time, plotted with a ball running along it. Ported from raylib-jolt-demo's `easings-testbed` demo (originally raylib-jlt's `easings_testbed`), which is raylib's `shapes_easings_testbed` example. A curve alone is hard to judge, because elastic and back leave the [0,1] band, which a plot shows and a number does not, and bounce and elastic feel alike in words and nothing alike in motion.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 69 lines (4 frame, 64 plot segments, 1 rail), a circle and 3 lines of text | 58 | a swipe changes the curve in place of LEFT and RIGHT, a tap replays in place of SPACE and a long press toggles the plot in place of D; frame-locked as in the original |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb easings-testbed      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.easingstestbed.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/easingstestbed.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/easingstestbed/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/easingstestbed_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `easings-testbed` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
