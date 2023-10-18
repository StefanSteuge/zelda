package com.example.zelda.scene;


import com.example.zelda.enemy.WhiteSoldier;
import com.example.zelda.engine.Game;
import com.example.zelda.items.Rupee;
import com.example.zelda.karacter.Direction;

import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.List;

import static com.example.zelda.scene.util.CoordinateConstantsHiddenScene.EXIT_DOWN_X;
import static com.example.zelda.scene.util.CoordinateConstantsHiddenScene.EXIT_DOWN_Y;
import static com.example.zelda.scene.util.CoordinateConstantsHiddenScene.UITGANG_X;
import static com.example.zelda.scene.util.CoordinateConstantsHiddenScene.UITGANG_Y;
import static com.example.zelda.scene.util.CoordinateConstantsHiddenScene.WALL1_X;
import static com.example.zelda.scene.util.CoordinateConstantsHiddenScene.WALL1_Y;
import static com.example.zelda.scene.util.CoordinateConstantsHiddenScene.WALL2_X;
import static com.example.zelda.scene.util.CoordinateConstantsHiddenScene.WALL2_Y;
import static com.example.zelda.scene.util.CoordinateConstantsHiddenScene.WALL3_X;
import static com.example.zelda.scene.util.CoordinateConstantsHiddenScene.WALL3_Y;
import static com.example.zelda.scene.util.CoordinateConstantsHiddenScene.WALL_X;
import static com.example.zelda.scene.util.CoordinateConstantsHiddenScene.WALL_Y;

/**
 * @author Christiaan
 */
public class HiddenScene extends ZeldaScene {

    private final Rectangle exitDown = new Rectangle(EXIT_DOWN_X, EXIT_DOWN_Y, 20, 20);

    public HiddenScene(Game game, String entrance) {
        super(game, "/static/images/hiddenPath.png", "HiddenScene");
        exits.add(exitDown);

        int[] wallX = WALL_X;
        int[] wallY = WALL_Y;

        var wall = new Polygon(wallX, wallY, wallY.length);

        int[] wall1X = WALL1_X;
        int[] wall1Y = WALL1_Y;

        var wall1 = new Polygon(wall1X, wall1Y, wall1Y.length);

        int[] wall2X = WALL2_X;
        int[] wall2Y = WALL2_Y;

        var wall2 = new Polygon(wall2X, wall2Y, wall2Y.length);

        int[] wall3X = WALL3_X;
        int[] wall3Y = WALL3_Y;

        var wall3 = new Polygon(wall3X, wall3Y, wall3Y.length);

        int[] uitgangX = UITGANG_X;
        int[] uitgangY = UITGANG_Y;

        var uitgang = new Polygon(uitgangX, uitgangY, uitgangY.length);

        solids.addAll(List.of(wall, wall1, wall2, wall3, uitgang));

        gameObjects.addAll(List.of(
                game.getLink(),
                new Rupee(game, 365, 322),
                new Rupee(game, 373, 322),
                new Rupee(game, 381, 322),
                new Rupee(game, 389, 322),
                new Rupee(game, 397, 322),
                new Rupee(game, 405, 322),
                new Rupee(game, 413, 322),
                new Rupee(game, 365, 336),
                new Rupee(game, 373, 336),
                new Rupee(game, 381, 336),
                new Rupee(game, 389, 336),
                new Rupee(game, 397, 336),
                new Rupee(game, 405, 336),
                new Rupee(game, 413, 336),
                new WhiteSoldier(game, 123, 117, Direction.UP),
                new WhiteSoldier(game, 121, 337, Direction.LEFT),
                new WhiteSoldier(game, 325, 331, Direction.LEFT)
        ));

        if (!game.getSong().equals("/static/sounds/cave.mp3")) {
            game.stopMusic();
            game.playMusic("/static/sounds/cave.mp3", true);
        }

        handleSwitchScene(entrance);
    }

    @Override
    public void handleSwitchScene(Rectangle exit) {
        if (exit == exitDown) {
            game.setScene(new HyruleScene(game, "HiddenScene"));
        }
    }

    @Override
    public void handleSwitchScene(String entrance) {
        if (entrance.equals("HyruleSceneHatch")) {
            moveScene(13, 0);

            game.getLink().setXHardCore(396);
            game.getLink().setYHardCore(141);
        }

        if (entrance.equals("HyruleSceneStairs")) {
            moveScene(1, 79);

            game.getLink().setXHardCore(116);
            game.getLink().setYHardCore(346);
        }
    }
}
