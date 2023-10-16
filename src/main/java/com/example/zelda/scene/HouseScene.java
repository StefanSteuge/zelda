package com.example.zelda.scene;


import com.example.zelda.enemy.BlueSoldier;
import com.example.zelda.engine.Game;
import com.example.zelda.items.Bush;
import com.example.zelda.items.Guard;
import com.example.zelda.karacter.Direction;

import java.util.List;
import java.awt.Polygon;
import java.awt.Rectangle;

/**
 * Links house.
 *
 * @author maartenhus
 */
public class HouseScene extends ZeldaScene {

    private final Rectangle exitUp = new Rectangle(155, 0, 300, 20);
    private final Rectangle exitLeft = new Rectangle(0, 180, 20, 50);
    private final Rectangle exitLeft2 = new Rectangle(0, 250, 20, 90);

    public HouseScene(Game game, String entrance) {
        super(game, "/static/images/link-house.png", "HouseScene");

        exits.addAll(List.of(exitUp, exitLeft, exitLeft2));

        int[] hxpos = {149, 146, 145, 151, 177, 178, 182, 182, 202, 202, 208, 208, 232, 238, 240, 237, 150};
        int[] hypos = {177, 180, 265, 271, 273, 275, 275, 272, 271, 275, 275, 272, 272, 268, 183, 177, 177};

        var house = new Polygon(hxpos, hypos, hypos.length);

        int[] rxpos = {449, 450, 385, 384, 418, 416, 492, 511, 510};
        int[] rypos = {0, 27, 90, 180, 215, 292, 370, 373, 1};

        var right = new Polygon(rxpos, rypos, rypos.length);

        int[] hcxpos = {1, 55, 81, 84, 119, 251, 303, 304, 275, 125, 112, 110, 126, 276, 278, 240, 127, 108, 108, 120, 122, 73, 49, 49, 1, 1};
        int[] hcypos = {232, 232, 206, 157, 122, 122, 173, 352, 383, 382, 359, 328, 340, 340, 175, 139, 139, 158, 176, 177, 219, 271, 271, 251, 249, 233};

        var houseCliff = new Polygon(hcxpos, hcypos, hcypos.length);

        int[] scxpos = {0, 47, 56, 56, 63, 64, 68, 69, 66, 49, 0, 0};
        int[] scypos = {383, 382, 378, 369, 362, 353, 348, 330, 328, 342, 342, 382};

        var smallcliff = new Polygon(scxpos, scypos, scypos.length);

        int[] dxpos = {1, 71, 87, 124, 137, 171, 206, 207, 256, 303, 512, 512, 1, 1};
        int[] dypos = {441, 440, 424, 424, 442, 440, 476, 486, 488, 436, 433, 487, 488, 442};

        var down = new Polygon(dxpos, dypos, dypos.length);

        var trees = getPolygon();

        solids.addAll(List.of(trees, houseCliff, smallcliff, right, down, house));

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
        int[] txpos = {2, 12, 18, 25, 31, 32, 29, 28, 36, 37, 33, 40, 40, 45, 51, 56, 55, 54, 54, 55, 62, 58, 64, 64, 74, 85, 96, 102, 104, 107, 112, 125, 129, 128, 125, 125, 129, 134, 134, 130, 136, 137, 143, 146, 152, 152, 149, 149, 157, 157, 153, 158, 161, 0};
        int[] typos = {190, 190, 180, 183, 183, 178, 176, 171, 168, 166, 160, 150, 132, 132, 136, 136, 131, 128, 124, 121, 118, 113, 100, 86, 87, 86, 83, 94, 96, 96, 84, 88, 88, 83, 79, 75, 73, 72, 68, 65, 54, 36, 38, 41, 40, 33, 30, 25, 25, 22, 16, 11, 0, 0};
        return new Polygon(txpos, typos, typos.length);
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
