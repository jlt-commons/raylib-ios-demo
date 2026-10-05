(ns net.b12n.raylib-ios.scenes.flappy-bird.draw
  "The draw-scene! method for the `:flappy-bird` scene, beside the scene it draws.

  It was the standalone Flappy Bird host loop in raylib-ios (`net.b12n.raylib-ios.flappy`,
  milestone 4) before the scenes moved here. That loop is gone, since the
  single-scene runner does what it did, but its drawing is what this scene
  draws, so it lives on as `draw-game!`."
  (:require [net.b12n.raylib-ios.draw :refer [draw-scene!]]
            [net.b12n.raylib-ios.host :as rl]
            [net.b12n.raylib-ios.scenes.flappy-bird :as flappy]))

(def DARKGREEN (rl/rgba 0 117 44 255))
(def GOLD (rl/rgba 255 203 0 255))

(defn draw-game!
  "Draw one game state at scale k for metrics m."
  [k game m]
  (let [{:keys [height bird-x bird-radius pipe-width gap-height]} (flappy/dimensions m)
        px (fn [v] (int (* k v)))]
    (rl/clear-background rl/SKYBLUE)
    (doseq [{:keys [x gap]} (:pipes game)]
      (rl/draw-rectangle (int x) 0 (int pipe-width) (int gap) DARKGREEN)
      (rl/draw-rectangle (int x) (int (+ gap gap-height)) (int pipe-width)
                         (int (- height gap gap-height)) DARKGREEN))
    (rl/draw-circle (int bird-x) (int (:y game)) (double bird-radius) GOLD)
    (rl/draw-text (str "score " (:score game) "   " (rl/get-fps) " fps") (px 24) (px 80) (px 20) rl/DARKGRAY)
    (when (:over? game)
      (rl/draw-text "GAME OVER - TAP TO RESTART" (px 24) (int (/ height 2.0)) (px 22) rl/MAROON))))

(defmethod draw-scene! :flappy-bird [_ game {:keys [k m]}]
  (draw-game! k game m))
