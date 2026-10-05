# Yaw Pitch Roll

A plane flown with three aircraft rotations. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

A plane built from boxes, flown with the three aircraft rotations. Ported from raylib-jolt-demo's `yaw-pitch-roll` demo (originally raylib-jlt's `yaw_pitch_roll`) (zlib licence).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| the original's plane of five boxes shaded face by face over a grid of 12 sunk to y = -3, projected in software (44 triangles and 26 lines, because the wing and the tailplane are cut into outer panels, with a strip for the tailplane's overhang, so that the painter's sort orders them against the fuselage), its title, its three gauges (label, centre-out bar, tick and angle in degrees) over a dark panel with the line "let go and each axis eases back to level", and two buttons | 58 | A, D, W and S are a relative thumb-stick started in the 3D area: past `gesture/slop` left is A (yaw +1.1 degrees a frame), right is D (-1.1), up is W (pitch +0.9) and down is S (-0.9), each axis on its own so a diagonal turns both as two keys do; Q and E are two buttons read from `:touch-points`, so a thumb on the stick and a thumb on a button act together: "roll right" is Q (-1.3 a frame, tested first as in the original) and "roll left" is E (+1.3), named by what the plane does; each angle is held to 90 and an undriven one eases by 0.94 a frame, to 0 under 0.15 degrees, per update like the original; the rotations are composed in the order of the original's rlRotatef calls (yaw, pitch, roll, so a vertex rolls first); the readout is `%6.1f deg` without the padding, the three gauges stand side by side instead of stacked and are labelled `yaw`, `pitch` and `roll` without the key names; a face with a corner behind the near plane is dropped whole; the original's 45 degree fovy is kept in a 3D area as wide as 800x450 and widened in a narrower one; the 3D area is the field below the title, which is below Back, down to the panel |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb yaw-pitch-roll      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.yawpitchroll.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/yawpitchroll.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/yawpitchroll/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/yawpitchroll_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `yaw-pitch-roll` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
