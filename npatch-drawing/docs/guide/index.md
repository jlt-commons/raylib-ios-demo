# Npatch Drawing

Nine-patch stretching with fixed corners. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Npatch Drawing, ported from raylib-jolt-demo's `npatch-drawing` demo (originally raylib-jlt's `npatch_drawing`) (net/b12n/raylib_jlt/npatch_drawing.clj, EPL 2.0), which is raylib's `textures_npatch_drawing`: three panels stretched by the pointer, a nine-patch that grows in both axes and two three-patches that grow in one. The corners stay the size they were drawn at while the edges and the middle take up the slack. The raylib C example it follows is zlib licensed, and this is an altered version of that too.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| one 64 by 64 texture drawn as fifteen quads, a nine-patch and two three-patches, with a line of text, a hint, 3 panel labels and the source at its own size | 58 | the original's source (a bevelled border with gold corner studs round a quiet middle, BORDER 16), clamped, and its `npatch!` arithmetic written out as nine quads whose source rectangles carve the image 16 texels from each edge, so the corners keep their size while the edges and the middle stretch; a three-patch is the same routine with no top and bottom, or no left and right; **the mouse is touch**: a drag over the screen is the pointer, and the nine-patch grows to `px - 380` by `py - 150` (held to 40..360 by 40..250), the horizontal one to `px - 60` and the vertical one to `py - 150`, all in the original's 800 by 450 units, which are scaled to the screen; until a finger lands the panels breathe on their own as the original's do, and a finger that lifts leaves them where it was; a reopen costs about one frame |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb npatch-drawing      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.npatch.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/npatch.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/npatch/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/npatch_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `npatch-drawing` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
