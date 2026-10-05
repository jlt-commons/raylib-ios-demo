# Sprite Animation

Six poses cycled from one source rectangle. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Sprite Animation, ported from raylib-jolt-demo's `sprite-animation` demo (originally raylib-jlt's `sprite_animation`) (net/b12n/raylib_jlt/sprite_animation.clj, EPL 2.0), which is raylib's `textures_sprite_animation`: one strip of six frames goes to the GPU once, and a source rectangle walks along it. Only the texcoords change. The raylib C example it follows is zlib licensed, and this is an altered version of that too.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| one 576 by 120 texture drawn twice, as the whole strip with the frame in use boxed RED and as that frame larger, plus 3 lines of text, 15 speed boxes and 2 buttons | 58 | the original's strip of six 96 by 120 frames, a stick walker painted by 15-circle limbs, a head and an eye through `ImageDrawCircle` (replayed through `net.b12n.raylib-ios.texel`, so it keeps raylib 6.0's circle one texel short on the right and bottom; the original's poses repeat, so six frames show three distinct poses), CLAMP wrap; the frame steps every `60 / speed` updates, the speed runs 1 to 15 from 8, and the source rectangle is the only thing that changes after the one upload; LEFT and RIGHT are two buttons, SLOWER and FASTER, a press each; the first open after launch pauses about 1.0 s while the strip is drawn texel by texel, the longest in the gallery, and a reopen costs about one frame because the filled buffer is kept |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb sprite-animation      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.spriteanim.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/spriteanim.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/spriteanim/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/spriteanim_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `sprite-animation` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
