# Particles

Water, smoke and fire from your fingertip. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

![Particles on an iPhone 17 Pro](../../../docs/images/particles.png)

## What it is

Particles that pour out of your fingertip: water falls, smoke rises and fades, fire shrinks from yellow to red. Ported from raylib-jolt-demo's `particles` demo (originally raylib-jlt's `particles`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| about 190 circles for fire, 324 for smoke, and 65 to 290 for water depending on the finger's height, plus an info box | 59 | emits at the finger while it is down, up to a cap of 600; tapping the box cycles water, smoke and fire |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb particles      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.particles.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/particles.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/particles/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/particles_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `particles` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
