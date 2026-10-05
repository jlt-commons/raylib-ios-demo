# Wireframe Shapes

Four wireframe solids tumbling. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Four wireframe solids tumbling side by side, ported from raylib-jolt-demo's `wireframe-shapes` demo (originally raylib-jlt's `wireframe_shapes`) (zlib licence).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| the original's four wireframe solids, a pyramid (8 edges), an octahedron (12), a torus (196) and a helix (64), drawn as 280 lines projected in software, on the original's dark background, and 1 line of text | 59 | no input, as the original has none; each shape stands at x = -6, -2, 2 or 6 and tumbles 0.9 degrees a frame about the axis (0.4, 1, 0.3), after a translate to its place, composed in the order of the original's rlTranslatef and rlRotatef calls; edges are built once and only transformed and projected per frame; the original's 45 degree fovy is kept in a field as wide as 800x450 and widened in a narrower one so the original's horizontal view still fits; a line crossing the near plane is clipped to it; the 3D view is the field below the caption, which is below Back, and is clipped to it |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb wireframe-shapes      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.wireframes.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/wireframes.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/wireframes/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/wireframes_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `wireframe-shapes` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
