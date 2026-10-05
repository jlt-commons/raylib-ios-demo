# Roadmap

What's next for the scenes in raylib-ios-demo, roughly in order. The platform's
own items (the host, textures, soft3d, the build tooling, the nREPL port and the
app lifecycle) are in raylib-ios's ROADMAP. Shipped work moves to Done at the
bottom, and the dated detail lives in `CHANGELOG.md`.

## Port backlog

[raylib-jolt-demo](https://github.com/jlt-commons/raylib-jolt-demo) (the home of raylib-jlt's examples) has 187 examples. 139 of
them are in the gallery as of 2026-10-04, which leaves 48. That counts
examples and not scenes: the gallery has 134 scenes ported from raylib-jlt, one
of which (`easings`) covers three examples, and the three Android scenes are
versions of `flappy_bird`, `eyes` and `mouse_trail`, so 134 + 2 + 3 = 139. They sort into
three groups by what a port would need. The grouping comes from reading each
example's docstring and the raylib calls it makes, so a closer read may move a
few of them.

**Ready to port, no new bindings (0).** The list is empty after batch 7.

**A few new scalar bindings (0).** The group is empty after batch 8.

**Blocked for now (48).** The 2026-10-02 triage sorted the then 95 unported
examples by what a port would need. About 32 could be rebuilt with what is
already bound, and batches 9 to 13 ported 30 of them, so 2 remain. Two more
needed only a pair of scalar blend-mode bindings, and batch 13 added them. The
other 46 need something the project doesn't bind or the phone doesn't have:
shaders, texture and image pipelines, 3D models and meshes, desktop windowing,
the keyboard, gamepad or clipboard, files, or audio. 2 + 0 + 46 = 48. Five of
the old 51 (`render_texture`, `framebuffer_rendering`, `mouse_painting`,
`magnifying_glass` and `top_down_lights`) left the group on 2026-10-04, once
`net.b12n.raylib-ios.texture/target!` could make a framebuffer. These remain rewrite-ready:

- 3D, projected in software: `dna_helix`. A faithful one built in 12.7 ms on
  the laptop, about 42 times the 0.30 ms a scene is sized to there, so it waits
  for a rewrite that draws far less.
- `reasings` is already ported: it is the easing header, and `net.b12n.raylib-ios.easings`
  carries it, so no scene is left to add for it.

Still blocked, and what each waits on:

- **Shaders.** The examples that pair a render texture with a shader
  (`postprocessing` and the rest) wait on shader bindings.
- **The Image API.** `perlin-texture!` shows jolt can take raylib's `Image` by
  value as a return, but the `Image*` calls that take one as an argument still
  can't be called.

## Scenes

- **A `memo-last` helper for the draw caches.** The `draw-scene!` methods now sit
  beside their scenes, each in its own `...scenes.<name>.draw` namespace. They
  carry 53 `*-cache` atoms with the same eight-line body, so a `memo-last` helper
  is still due.
  The field-below-Back layout and the text `fit` lambdas also repeat across the
  render-target scenes.
  The two newest caches hold a whole draw list (`geoshapes-cache` and
  `split3d-list-cache`), so under `DEV_BUILD=1` a redefined `scene-list` or
  soft3d builder does not show until the screen or a player changes. Clearing
  both when a scene opens would fix that.
- **Lift the virtual window into `net.b12n.raylib-ios.vwindow`.** Viewport Scaling and
  Window Letterbox carry the same `window`, `handle`, `clamp`, start geometry
  and drag step, about 55 lines each. A pure `.cljc` next to `net.b12n.raylib-ios.stick`
  would hold `window`, `handle`, `clamp`, the start geometry and `drag-step`,
  with Viewport Scaling passing its button claim in. It takes about an hour and
  is worth doing when a third scene would use it.
- **Rebalance the categories.** Toys holds 113 of the 137 scenes, and Games has 11, so a scroll
  through Toys is long. raylib-jlt's own groups (core, shapes, text) would be a
  starting point.
- **Extract `call-blended!` into `net.b12n.raylib-ios.blend`** when a third blend scene
  arrives. Blend Modes and Particles Blending each carry the same six lines and a
  test for them, and none is planned yet.
- **Pick the Basic Voxel axis at an edge.** A place at an edge or corner hit
  chooses an arbitrary axis from `max-key` over a tied normal.
- **Tighten some tests, each optional.** The capsule sphere case checks only
  counts, Directional Billboard's grid-behind claim is untested, 3D Split Screen's
  `tol` and near-plane `>=` mutants survive, and the text-fit tests use a
  synthetic measure across the project.
- **Share the touch helpers.** `net.b12n.raylib-ios.gesture` now holds `down?`, `in-rect?`,
  `back-region`, `in-back-region?` and the tap, swipe and long-press `track`,
  and the batch 3 scenes use it. The batch 1 and 2 scenes (`touchball`,
  `rlgltriangle`, `particles` and `breakout`) still carry their own copies of
  some of it. `breakout` still carries its own Back region. `breakout`,
  `particles` and `rlgltriangle` each carry a closed `in-rect?`. All four still
  carry their own press-or-down predicate. Migrating them
  is worth doing as its own task, with one catch: those `in-rect?` copies are
  closed on the right and bottom edge, while `gesture/in-rect?` is half-open, so
  a touch exactly on that edge changes sides by one pixel.
- **Lift the relative thumb-stick into `net.b12n.raylib-ios.gesture`.** `stick-dir`,
  `next-stick` and `knob` are the same text in `survivors` and `nudge`. One home
  means a fix to the stick lands once. `net.b12n.raylib-ios.stick` now exists and `freecam`,
  `yawpitchroll` and `boxcollide` use it, so this is a matter of moving
  `survivors` and `nudge` onto it, or onto the part of it that fits.
- **Close freecam's two-finger gap.** When two fingers land on the same frame,
  the look path can still adopt a finger that was already down.
- **Move `nudge` and `splitscreen` onto `net.b12n.raylib-ios.stick`.** Each keeps its own
  tracker, and the shared one could replace both.
- **Give the older games the idle `:press` exception.** Tetris, Asteroids,
  Snake, Space Invaders and Pong store `gesture/idle` on the frame the game ends
  even when that frame is a fresh press, so a tap landing on that one frame is
  lost. A held touch can't restart them, which is right. Pac-Man and Vampire
  Survivors keep a press that lands on the ending frame.
- **Try batch 7 with a real finger.** The device pass drove it with synthetic
  touches, which never reach iOS, so whether swipes and thumb-sticks near the
  bottom edge fight the home gesture is still open. The small hint lines in
  Vampire Survivors, Keyboard Ball and Mouse Wheel, about 8 to 10 pt, are worth
  a look too.
- **Decide Minesweeper's rules.** The port keeps the original's: a tap on a
  flagged cell reveals it, and the first tap can hit a mine. A flag guard would
  stop the first, and first-tap safety the second.
- **Decide Breakout's pace.** The ball takes about 5 s from the paddle to the
  bricks on a portrait phone, since its speed scales with the width.
- **3D Split Screen from outside the grove.** It reads 58 fps idle and while a
  player walks through the trees, but 31 while a player walks out of the grove
  and looks back, with all 121 trees in view. The original doesn't clamp the
  players. A lossless cut or a disclosed one is still to choose.
- **Basic Voxel freezes the phone on a tap.** Measured on the phone on
  2026-10-03: a tap holds a single frame for about 285 ms, because the mesh
  rebuild takes 309 ms, and 574 ms for a hollowed block. A hollowed block's
  frame build is also 23 ms, against 11.6 ms for the full block. The fix is an
  incremental mesh update on a tap, so a tap changes the faces around one voxel
  instead of rebuilding them all. The four blend modes were checked by eye on
  2026-10-03 and look as each mode should.
- **Try the cameras with a real finger.** The camera pinch and twist in 2D
  Camera and 2D Camera Zoom, and the two thumbs in 2D Split Screen, have not
  been driven by a hand on the phone.
- **See DRAG and DOUBLETAP in Input Gestures.** A real finger logged TAP, HOLD,
  SWIPE RIGHT and SWIPE DOWN, so raylib's recogniser does fire under the SDL
  host. DRAG and DOUBLETAP have not shown up yet, and pinch can't, because SDL
  feeds raylib one finger at a time.
- **Texture first opens pause.** The first open after launch holds the largest
  single frame at about 1.0 s for Sprite Animation, 0.8 s for Polygon Drawing,
  0.5 s for Procedural Textures, 0.2 s for Srcrec Dstrec and Sprite Button, and
  0.17 s for Raw Data (phone measurements, 2026-10-04). The cost is the pixel fn
  and the per-texel write, so the cure is a faster fill or a cached upload.
  Texture Tiling, Srcrec Dstrec, Sprite Button, Npatch Drawing and the noise
  panel of Procedural Textures also still pack a vector per texel (`texel/pack`
  where `texel/pack4` would do), which is part of that fill cost. The
  catalog discloses the pauses for now.
- **Audit the licence wording on the older scenes.** The scenes that
  predate the texture arc, and NOTICE's "Ported, and altered" section, call
  their raylib-jlt originals zlib. raylib-jlt relicensed to EPL 2.0 on
  2026-09-05, so an original added to it after that date is EPL 2.0. The ten
  texture scenes already say which.
- **Retexture four older scenes through `target!`.** Fog of War, Smooth
  Pixel-Perfect, Viewport Scaling and Window Letterbox were ported before render
  targets existed, and each original draws through a render texture.
- **Top Down Lights' first open.** 75 ms on the phone (119 ms before its
  targets dropped their depth buffers). The ground packs a vector per texel,
  and `texel/pack4` should take part of it (estimate 30 to 80 ms). If a
  target-heavy open passes 100 ms, upload
  NULL and clear in the first pass instead of zeroing on the CPU.

- **Device builds need jolt v0.8.15.** `jolt live` fails to build under v0.8.16
  and the builds after it (`variable error is not bound` in the
  `jolt.socket.native` unit). The scripts here pin nothing, so the README names
  the version. Move on when jolt fixes it.
- **Move the CI jolt pin forward** from 0.8.6. The suite is green on newer
  releases.
- **Pin raylib-ios by sha.** `common/deps.edn` points at a checkout beside this
  one until raylib-ios is pushed. Then it takes a `:git/url` and a `:git/sha`,
  and CI stops checking out a second repository.
- **The gallery takes its scenes from the registry.** raylib-ios's shell still
  builds its own list, and the registry test holds the two equal. When the shell
  takes a registry, `gallery/src/.../gallery/app.clj` hands it
  `registry/scenes` and `registry/categories`.

## Done

- 2026-10-04: the scenes moved here from raylib-ios, one sub-project each, with
  a generated registry for the gallery. See `CHANGELOG.md`.
