# Solar System

A sun, Earth and Moon through nested transforms. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

A sun, an Earth and a Moon through nested transforms, ported from raylib-jolt-demo's `rlgl-solar-system` demo (originally raylib-jlt's `rlgl_solar_system`) (zlib licence).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| the original's gold Sun of side 3, blue Earth of side 1.4 and light gray Moon of side 0.7 shaded face by face, projected in software (14 to 18 triangles, no lines), and 1 line of text | 58 | no input, as the original has none; the Earth orbits half a degree a frame at 9 from the Sun and spins 1 degree a frame, the Moon orbits the Earth 2 degrees a frame at 2.6, composed in the order of the original's rlRotatef and rlTranslatef calls; the original's 45 degree fovy is kept in a field as wide as 800x450 and widened in a narrower one so the original's horizontal view still fits; the 3D view is the field below the caption, which is below Back, and is clipped to it |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb rlgl-solar-system      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.solarsystem.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/solarsystem.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/solarsystem/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/solarsystem_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `rlgl-solar-system` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
