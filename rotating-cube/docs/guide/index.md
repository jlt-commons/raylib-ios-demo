# Rotating Cube

A cube turning in place. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

A cube turning in place, ported from raylib-jolt-demo's `rotating-cube` demo (originally raylib-jlt's `rotating_cube`), which is raylib's rlgl matrix-stack demonstration (zlib licence).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| the original's grid of 10 and a red cube of side 2 shaded face by face, projected in software (about 6 triangles and 22 lines), and 1 line of text | 59 | no input, as the original has none; the cube turns one degree a frame about x and 0.7 of that about y, composed in the order of the original's two rlRotatef calls; the original's 45 degree fovy is kept in a field as wide as 800x450 and widened in a narrower one so the original's horizontal view still fits; the grid is drawn under every face, so where the original's grid crosses the lower half of its cube (centred on y = 0, half below the grid) the lines a depth buffer would show in front of it are hidden here; the 3D view is the field below the caption, which is below Back, and is clipped to it |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb rotating-cube      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.rotcube.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/rotcube.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/rotcube/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/rotcube_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `rotating-cube` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
