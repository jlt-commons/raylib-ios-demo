# Vampire Survivors

Auto-fire survival with a thumb-stick. One of the Games scenes in the raylib-ios gallery, and an app of its own here.

![Vampire Survivors on an iPhone 17 Pro](../../../docs/images/survivors.png)

## What it is

Vampire Survivors, steered with a thumb-stick. Ported from raylib-jolt-demo's `vampire-survivors` demo (originally raylib-jlt's `vampire_survivors`).

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| up to ~50 enemies and gems (through the first 12 s) and 18 bullets, a hero, two bars, 3 counters, a thumb-stick ring while held | 58 | a relative thumb-stick moves the hero, in place of WASD and the arrows: the press point is its centre, a finger within the tap slop of it does nothing, and beyond it the hero goes that way at one fixed speed, so a diagonal is no faster; a tap on the field restarts after game over, in place of ENTER; the spawn rate and wave growth, speeds, radii, two-hit enemies, the auto-fire at the nearest enemy and its level-based cooldown, gem pickup, levelling, contact damage with its grace period and 100 HP are the original's, frame-locked like it; the speeds and radii are scaled by one factor, enemies appear on the field's edge one radius inside it and never touching the hero where the original starts them 20 px outside, gems drawn centred (the original draws from the top-left corner), the field is below Back, and a rotation starts a new game |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb vampire-survivors      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.survivors.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/survivors.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/survivors/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/survivors_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `vampire-survivors` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
