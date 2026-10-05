# Contributing

## Adding a scene

A scene is a sub-project, and `demos.edn` lists it. Everything else is generated.

1. **Make the directory.** Name it after the raylib-jolt-demo demo you are porting,
   or after the scene id if it ports none. Put three files in it:
   - `src/net/b12n/raylib_ios/scenes/<id>.cljc`, the pure scene. It returns the map
     `(scene)` that raylib-ios's gallery contract defines (`:id :title :init :update
     :draw :dispose`), takes its geometry from `(:screen metrics)`, which is the safe
     region and not the display, and uses a seeded LCG instead of `GetRandomValue`. Its
     docstring names the raylib-jolt-demo demo it ports, with "originally raylib-jlt",
     because the zlib licence asks that an altered source be marked.
   - `src/net/b12n/raylib_ios/scenes/<id>/draw.clj`, which `defmethod`s `draw-scene!`
     from `net.b12n.raylib-ios.gallery.draw-util`.
   - `test/net/b12n/raylib_ios/scenes/<id>_test.cljc`.
   Three habits from the ports so far:
   - **Frame-locked speeds.** The originals move by a fixed step per frame, so a
     port scales that step to the screen. Scale each axis by its own dimension when
     the motion is bound to an axis, as `breakout`, `pong` and `invaders` do, and
     use one factor when direction matters, such as thrust along a heading:
     `asteroids` uses the geometric mean of the two axes. Cap the per-frame step
     below what a hit test needs, so nothing tunnels.
   - **Prefer properties over golden values** in the test: that a rotation preserves
     length, that slices tile a circle exactly, that a trail stays bounded.
   - **Test the first frame.** A scene once crashed asking for element 0 of an empty
     buffer, past 1400 assertions, because every test called `advance` before
     looking at anything.
   The platform helpers a scene can use (text measuring, textures, render targets,
   software 3D, the camera, the thumb-stick) are described in raylib-ios's
   CONTRIBUTING.
2. **Add a line to `demos.edn`.** The name (the directory), the id, the category
   (`generative`, `fractals`, `toys` or `games`), the title, a description of 49
   characters at most, and where it comes from. The order of the file is the
   gallery's registration order.
3. **Run `bb gen`.** It writes the sub-project's `deps.edn` and `bb.edn`, its `app.clj`
   and `live.clj`, the gallery registry, the root `deps.edn` aliases and tasks, and
   `docs/guide/demos.md`. A scene that requires another scene (Outlines uses Rounded
   Rect) gets that dependency from its `ns` form, so there is nothing to declare.
4. **Write the page.** `<name>/docs/guide/index.md`, in the shape of its neighbours.
   Add the scene's catalog row to `docs/guide/scene-catalog.md` and its fps once you have
   a reading from the phone, and its entry to `NOTICE` if it carries a licence that
   the existing entries do not cover.
5. **Run the gates.** `jolt -M:test`, `clojure -M:test`, `bb gen --check`, `bb lint:strict`
   and `bb check`.

The porting guide, `docs/guide/porting-an-example.md`, covers what a port needs, and
`docs/guide/performance-on-a-phone.md` covers the frame budget. Read both first.

## Hand-edited and generated

`bb gen` owns the root `deps.edn`, the root `bb.edn` between its markers, each
sub-project's `deps.edn`, `bb.edn`, `app.clj` and `live.clj`, the gallery's registry,
`app.clj`, `live.clj`, `deps.edn` and `bb.edn`, `src/.../demo/check.clj` and
`docs/guide/demos.md`. Each carries a header that says so. Everything else is
yours: scene sources, draws, tests and docs pages are copied once and edited by hand.

## The three carried scenes

`eyes/`, `mouse-trail/` and `flappy-bird/` are identical to
jasalt/jolt-android-experiment apart from namespace names and whitespace. The
identity test in `gallery/test` checks it against `tools/jasalt-identity.edn`, so a
change beyond a name fails the JVM suite. Leave them alone.

## Phone checks

The suites prove nothing about the phone. After a change to a scene or its draw,
build it with `bb <name>`, open it, and compare the fps with its catalog row.
The simulator has not shown OpenGL ES since iOS 17.5, so test on hardware.
