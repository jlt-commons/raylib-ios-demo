# Ellipse Collision

Two ellipses that redden when they overlap. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Two ellipses, one of which follows your finger. Both turn red while they overlap. A tap on the other ellipse hands the steering to it. Ported from raylib-jolt-demo's `ellipse-collision` demo (originally raylib-jlt's `ellipse_collision`), itself raylib's `shapes_ellipse_collision`, where the mouse steers one ellipse and A and B choose which. It differs from `collision`, which is two boxes and an exact intersection rectangle, and from `shapes`, whose ellipse is one static fan: here the same fan is reused for two moving ones.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 2 ellipses of up to 180 triangles each, 2 outlines of as many lines, 2 centre dots and 3 lines of text | 59 | one ellipse follows your finger while it is down and stays where it was on lift; both turn red when they overlap, by the original's test, which samples 64 points round each rim and so can miss a very thin lens; a tap that starts inside the other ellipse hands the steering to it, and that touch does not drag the steered one, so a swap never moves it; a touch under Back is ignored; both sizes share one scale and the centres are clamped to stay on screen below the text |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb ellipse-collision      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.ellipses.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/ellipses.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/ellipses/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/ellipses_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `ellipse-collision` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
