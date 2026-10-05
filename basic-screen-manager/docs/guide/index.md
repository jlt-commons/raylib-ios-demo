# Screen Manager

A LOGO, TITLE, GAMEPLAY, ENDING flow. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

A screen manager: LOGO, TITLE, GAMEPLAY, ENDING, each a flat colour and a label. Ported from raylib-jolt-demo's `basic-screen-manager` demo (originally raylib-jlt's `basic_screen_manager`), where ENTER steps to the next screen and a timer steps on its own. It differs from the other scenes in having nothing to draw but a state machine, so what it shows is the transition rule.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| 1 line of text for the screen and 1 for the hint, on a flat colour | 58 | a tap steps LOGO, TITLE, GAMEPLAY, ENDING in place of ENTER, and the timer steps every 90th frame as the original does, frame-locked and counted from the start so a tap does not postpone it; ENDING goes back to LOGO; a tap and the timer on one frame step once, and a finger down when the timer fires is dropped; a touch under Back is ignored |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb basic-screen-manager      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.screens.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/screens.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/screens/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/screens_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `basic-screen-manager` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
