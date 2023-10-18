package com.example.zelda.scene;


import com.example.zelda.enemy.BlueSoldier;
import com.example.zelda.engine.Game;
import com.example.zelda.items.Bush;
import com.example.zelda.items.Guard;
import com.example.zelda.karacter.Direction;

import java.util.List;
import java.awt.Polygon;
import java.awt.Rectangle;

import static com.example.zelda.scene.util.CoordinateConstantsHouseScene.*;

/**
 * Links house.
 *
 * @author maartenhus
 */
public class HouseScene extends ZeldaScene {

    private final Rectangle exitUp = new Rectangle(EXIT_UP_X,  EXIT_UP_Y, 300, 20);
    private final Rectangle exitLeft = new Rectangle(EXIT_LEFT1_X, EXIT_LEFT1_Y, 20, 50);
    private final Rectangle exitLeft2 = new Rectangle(EXIT_LEFT2_X, EXIT_LEFT2_Y, 20, 90);

    public HouseScene(Game game, String entrance) {
        super(game, "/static/images/link-house.png", "HouseScene");

        exits.addAll(List.of(exitUp, exitLeft, exitLeft2));

        int[] houseX = HOUSE_X;
        int[] houseY = HOUSE_Y;

        var house = new Polygon(houseX, houseY, houseY.length);

        int[] rightX = RIGHT_X;
        int[] rightY = RIGHT_Y;

        var right = new Polygon(rightX, rightY, rightY.length);

        int[] houseCliffX = HOUSECLIFF_X;
        int[] houseCliffY = HOUSECLIFF_Y;

        var houseCliff = new Polygon(houseCliffX, houseCliffY, houseCliffY.length);

        int[] smallCliffX = SMALLCLIFF_X;
        int[] smallCliffY = SMALLCLIFF_Y;

        var smallCliff = new Polygon(smallCliffX, smallCliffY, smallCliffY.length);

        int[] downX = DOWN_X;
        int[] downY = DOWN_Y;

        var down = new Polygon(downX, downY, downY.length);

        var trees = getPolygon();

        solids.addAll(List.of(trees, houseCliff, smallCliff, right, down, house));

        gameObjects.addAll(
                List.of(
                        new Bush(game, 160, 50),
                        new Bush(game, 272, 51),
                        new Bush(game, 305, 71),
                        new Bush(game, 144, 270),
                        new Bush(game, 128, 270),
                        new Bush(game, 112, 270),
                        new Bush(game, 144, 284),
                        new Bush(game, 128, 284),
                        new Bush(game, 112, 284),
                        new Bush(game, 229, 271),
                        new Bush(game, 229, 287),
                        new Bush(game, 245, 271),
                        new Bush(game, 245, 287),
                        new Bush(game, 34, 272),
                        new Bush(game, 50, 288),
                        new Bush(game, 34, 302),
                        new Bush(game, 50, 272),
                        new Bush(game, 34, 288),
                        new Bush(game, 50, 302),
                        game.getLink(),
                        new BlueSoldier(game, 300, 90, Direction.LEFT, 20),
                        new BlueSoldier(game, 325, 300, Direction.DOWN, 30),
                        new Guard(game, 483, 408, Direction.RIGHT),
                        new Guard(game, 483, 376, Direction.RIGHT),
                        new Guard(game, 9, 415, Direction.LEFT),
                        new Guard(game, 9, 385, Direction.LEFT),
                        new Guard(game, 233, 480, Direction.UP),
                        new Guard(game, 206, 480, Direction.UP)
                )
        );

        if (!game.getSong().equals("/static/sounds/overWorld.mp3")) {
            try {
                game.stopMusic();
            } catch (Exception ignored) {}

            game.playMusic("/static/sounds/overWorld.mp3", true);
        }

        handleSwitchScene(entrance);
    }

    private static Polygon getPolygon() {
        int[] treesX = TREES_X;
        int[] treesY = TREES_Y;
        return new Polygon(treesX, treesY, treesY.length);
    }

    @Override
    public void handleSwitchScene(Rectangle exit) {
        if (exit == exitUp) {
            game.setScene(new HyruleScene(game, "HouseScene"));
        }
        if (exit == exitLeft) {
            game.setScene(new ForrestScene(game, "HouseSceneLeft1"));
        }
        if (exit == exitLeft2) {
            game.setScene(new ForrestScene(game, "HouseSceneLeft2"));
        }
    }

    @Override
    public void handleSwitchScene(String entrance) {
        if (entrance.equals("HyruleScene")) {
            moveScene(12, 0);
            game.getLink().setXHardCore(320);
            game.getLink().setYHardCore(34);
        }
        if (entrance.equals("GameStart")) {
            moveScene(0, 100);
            game.getLink().setXHardCore(185);
            game.getLink().setYHardCore(177);
        }
        if (entrance.equals("ForrestScene1")) {
            moveScene(0, 100);
            game.getLink().setXHardCore(29);
            game.getLink().setYHardCore(100);
        }
        if (entrance.equals("ForrestScene2")) {
            moveScene(0, 100);
            game.getLink().setXHardCore(29);
            game.getLink().setYHardCore(165);
        }
    }
}
