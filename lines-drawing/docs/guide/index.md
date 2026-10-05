# Line Widths

A turning fan of thick lines. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

![Line Widths on an iPhone 17 Pro](../../../docs/images/fan.png)

## What it is

A turning fan of thick lines, each a different width and colour. Ported from raylib-jolt-demo's `lines-drawing` demo (originally raylib-jlt's `lines_drawing`), itself raylib's `shapes_lines_drawing` without its texture cursor.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 16 spokes, 16 widths | 58 | a direct test of thick-line winding |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb lines-drawing      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.fan.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/fan.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/fan/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/fan_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `lines-drawing` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
