# Polygon Drawing

A hue-wheel texture on a polygon. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Polygon Drawing, ported from raylib-jolt-demo's `polygon-drawing` demo (originally raylib-jlt's `polygon_drawing`) (net/b12n/raylib_jlt/polygon_drawing.clj, EPL 2.0), which is raylib's `textures_polygon_drawing`: a hue wheel mapped onto a spinning ten-sided polygon, drawn as a triangle fan, the same reimplementation of DrawTexturePoly the C example uses. The original has no polygon helper in its library; the fan is written out in the example (lines 85-101), and `fan` here is that loop. The raylib C example it follows is zlib licensed, and this is an altered version of that too.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| one 256 by 256 hue wheel mapped onto a ten-sided polygon as thirty vertices in ten triangles, and a line of text | 58 | the original's wheel (the angle round the middle as a hue at full saturation and value), clamped because every uv lies in 0..1, and its fan of ten triangles from the middle at uv (0.5, 0.5) through the original's eleven texcoords, `(uv - 0.5) * 256` as the points, turned by 1.0 degree a frame about the middle; the polygon is scaled so its farthest point sits at 45 percent of the shorter free side; the scene draws through `triangles!`, which winds each triangle itself, and there is nothing to touch; the first open after launch pauses about 0.8 s while the wheel is computed, and a reopen costs about one frame because the filled buffer is kept |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb polygon-drawing      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.texpoly.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/texpoly.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/texpoly/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/texpoly_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `polygon-drawing` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
