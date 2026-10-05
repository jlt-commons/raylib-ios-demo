# Strings Management

Text particles you throw, cut and glue. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

![Strings Management on an iPhone 17 Pro](../../../docs/images/strings.png)

## What it is

Bouncing text particles you can throw, cut, shatter and glue. Ported from raylib-jolt-demo's `strings-management` demo (originally raylib-jlt's `strings-management`), which is raylib's `text_strings_management` example. A sentence is one particle, and every particle bounces round the arena losing a tenth of its speed at a wall and a hundredth to friction on every frame.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| up to 100 bordered text particles, each a border, a fill and 1 line of text, plus 2 lines of text and 3 labelled buttons | 58 | dragging a particle and lifting throws it in place of the left button, with the velocity of the last four `:down` frames; a long press cuts it in half in place of right-click; the shatter button arms the next tap to shatter it into characters in place of SHIFT and right-click; the shake button replaces middle-click; releasing a dragged particle over another glues them in place of CTRL while dragging, and only a drag past the tap slop that is set down slowly glues, so a throw across another flies on; the case button steps the six case transforms in place of keys 1 to 6, starting at UPPER because the opening sentence is already plain; typing a character to split the lone sentence is dropped, since there is no keyboard; physics use `:delta-seconds` with the original's per-frame friction, and the opening sentence is centred, with the text size fitted to the widest of the six case versions; a touch under Back is ignored |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb strings-management      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.strings.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/strings.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/strings/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/strings_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `strings-management` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
