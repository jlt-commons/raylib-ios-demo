# Helitorus

A helix wound around a torus. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

A helix wound around a torus, swept into a tube. Ported from raylib-jolt-demo's `helitorus` demo (originally raylib-jlt's `helitorus`), which is Michiel Borkent's `examples/helitorus.clj` in babashka/ffi (MIT licence); raylib-jlt's port is zlib-licensed work on top of it. This is an altered version of both.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| a helix wound round a torus and swept into a lit tube of 64 rings of 12 points (up to 900), hidden faces removed by hand, 3 lines of text (fps, compute and draw milliseconds; windings and detail; a hint) and 4 labelled buttons | 58 | a one-finger drag turns it by the original's 0.008 radians a pixel, with its velocity memory and coast to the idle turn, in place of the mouse drag; a two-finger pinch zooms between 110 and 520 in place of the wheel, and its midpoint and twist are ignored; four buttons below the field replace the arrow keys, read from every touch point so a button and the field work at once: windings - and windings + change the windings from 3 to 24 by one on a press (LEFT and RIGHT), detail - and detail + change the rings from 60 to 900 by 4 a frame while held (DOWN and UP); the original's key-help line is dropped for a hint line and its thousand-vertices-a-second figure is dropped from the HUD; the centre and zoom scale come from the field, not the original's 1000 by 560 window; a finger on a button or under Back turns and zooms nothing; the original starts at 260 rings and this starts at 64, chosen from the phone measuring 19 fps at 260, where 64 holds 60 fps (detail + still reaches 260); each visible quad is sent in the winding rlgl keeps, because the batch is drawn at a later flush with culling on |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb helitorus      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.helitorus.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/helitorus.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/helitorus/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/helitorus_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `helitorus` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
