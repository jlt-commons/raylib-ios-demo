# Geometric Shapes

Cubes, a sphere, cylinders, a cone, a capsule. One of the Toys scenes in the raylib-ios gallery, and an app of its own here.

## What it is

Cubes, a sphere, cylinders, a cone and a capsule, solid and in wire, over a grid, ported from raylib-jolt-demo's `geometric-shapes` demo (originally raylib-jlt's `geometric_shapes`) (zlib licence, after raylib's examples/models/models_geometric_shapes.c). The projection is in software, by `net.b12n.raylib-ios.soft3d`.

## Measured

| per frame | fps | notes |
| --- | ---: | --- |
| the original's shapes at its positions, sizes and colours: a red cube 2 by 5 by 2 with gold wires, maroon cube wires 3 by 6 by 2, a green sphere of radius 1, lime sphere wires of radius 2, a sky blue cylinder (top radius 1, bottom 2, 4 sides) with dark blue wires, brown cylinder wires (6 sides), a gold cone (8 sides) with pink wires and a violet capsule with purple wires, over a grid of 10, from the fixed camera at (0, 10, 10), projected in software (362 triangles and 1643 lines, 2005 items) and 1 line of text; 2.5 ms to build under jolt on the laptop and 0.36 ms a frame with the draw side's code run once built, above the 0.30 ms target but inside the edge where the phone held 59 to 60 fps (the bench stubs the draw loop, so the figure is rough) | 59 | the shapes, positions, sizes, colours, the camera and the grid are the original's, and the tessellation is too, with nothing cut: 16 by 16 for the sphere and its wires, 8 by 8 for the capsule; `soft3d/cylinder`, `cylinder-wires`, `capsule` and `capsule-wires` mirror DrawCylinder, DrawCylinderWires, DrawCapsule and DrawCapsuleWires vertex for vertex, and tests compare them with the C by hand for 4 sides and for the tilted capsule, and every triangle's winding with the outward normal; the 2.5 ms build is over the 0.30 ms target, and a cut of tessellation alone could not fit because drawing 2005 items is 0.36 ms by itself, so the list is built once per screen, the scene being static (a test checks that nothing but the screen changes it), and drawn every frame, with 2.5 ms on the laptop (about 80 ms on the phone at a rough 33x) spent once on the first frame and on each rotation, a single-frame hitch; the solid sphere is `soft3d/sphere` with `{:shade :flat}`, one colour as DrawSphere draws it, on that builder's latitude and longitude tessellation, and its wires are the C's `DrawSphereWires` as segments; there is no depth buffer, so `finish` sorts the triangles by mean depth and every wire draws over every face, which shows the far edges of the sky blue, gold and violet shapes, the maroon box's wires behind the red cube and the lime sphere's wires behind the shapes in front of it (the red cube's own gold wires leave out their hidden edges); the original's FPS counter is dropped and its "geometric shapes" text is the caption below Back; the original reads no input; the 3D view is clipped to the field |

Frame rates are from an iPhone 17 Pro; the [scene catalog](../../../docs/guide/scene-catalog.md) says how they were measured.

## Build it

```sh
UDID=<hardware udid> bb geometric-shapes      # from the repo root: build, sign, install, launch
UDID=<hardware udid> bb run         # the same, from this directory
UDID=<hardware udid> bb live        # with an nREPL on the phone (dev build)
bb test                           # this scene's tests, no device needed
```

The app is `net.b12n.raylib-ios.scenes.geoshapes.app`, which hands `(scene)` to raylib-ios's single-scene runner. It carries this scene and nothing else.

## Source

- the scene, pure: `src/net/b12n/raylib_ios/scenes/geoshapes.cljc`
- its `draw-scene!` method: `src/net/b12n/raylib_ios/scenes/geoshapes/draw.clj`
- its tests: `test/net/b12n/raylib_ios/scenes/geoshapes_test.cljc`

## Where it comes from

Ported from raylib-jolt-demo's `geometric-shapes` demo (originally raylib-jlt). The licence rule: raylib-jlt was zlib before 2026-09-05 and EPL 2.0 after, and every raylib C example is zlib. `NOTICE` has this scene's entry.
