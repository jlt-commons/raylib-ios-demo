# raylib-ios-demo

The raylib examples as iPhone apps. A hundred and thirty-seven scenes, drawn by
raylib 6.0 over SDL2 and driven from Clojure by Jolt. Each is a sub-project that
builds an app of its own, and a gallery app holds all of them behind a two-level
menu.

The platform they run on is [raylib-ios](https://github.com/jlt-commons/raylib-ios).
Most scenes are ports of demos from
[raylib-jolt-demo](https://github.com/jlt-commons/raylib-jolt-demo), originally
raylib-jlt's. Three are carried from
[jasalt/jolt-android-experiment](https://github.com/jasalt/jolt-android-experiment),
identical apart from namespace names and whitespace.

- [The scene gallery](demos.html) lists every scene by category, with its sub-project.
- [The scene catalog](scene-catalog.html) gives what each scene draws per frame and
  the frame rate measured on an iPhone 17 Pro.
- [Porting an example](porting-an-example.html) is what a port from raylib-jolt-demo needs.
- [Performance on a phone](performance-on-a-phone.html) is where the frame budget goes.

Build the gallery with `UDID=<hardware udid> bb gallery`, or one scene with
`UDID=<hardware udid> bb <name>`. The README has the rest.
