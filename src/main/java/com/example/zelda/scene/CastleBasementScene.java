package com.example.zelda.scene;


import com.example.zelda.enemy.BlueSoldier;
import com.example.zelda.enemy.WhiteSoldier;
import com.example.zelda.engine.Game;
import com.example.zelda.items.Rupee;
import com.example.zelda.items.Warp;
import com.example.zelda.karacter.Direction;

import java.awt.*;
import java.util.List;

import static com.example.zelda.scene.util.CoordinateConstantsCastleBasementScene.*;

/**
 * @author Bas Harteveld
 */
public class CastleBasementScene extends ZeldaScene {

    private final Rectangle warpExit = new Rectangle(WARP_EXIT_X, WARP_EXIT_Y, 16, 16);
    private final Rectangle exitUp = new Rectangle(EXIT_UP_X, EXIT_UP_Y, 27, 20);

    public CastleBasementScene(Game game, String entrance) {
        super(game, "/static/images/castleBasement.png", "CastleBasementScene");

        exits.addAll(List.of(warpExit, exitUp));

        int[] wall1X = WALL1_X;
        int[] wall1Y = WALL1_Y;

        var wall1 = new Polygon(wall1X, wall1Y, wall1Y.length);

        int[] wxpos2 = WALL2_X;
        int[] wypos2 = WALL2_Y;

        var wall2 = new Polygon(wxpos2, wypos2, wypos2.length);

        int[] wxpos3 = WALL3_X;
        int[] wypos3 = WALL3_Y;

        var wall3 = new Polygon(wxpos3, wypos3, wypos3.length);

        int[] wxpos4 = WALL4_X;
        int[] wypos4 = WALL4_Y;

        var wall4 = new Polygon(wxpos4, wypos4, wypos4.length);

        int[] wxpos5 = WALL5_X;
        int[] wypos5 = WALL5_Y;

        var wall5 = new Polygon(wxpos5, wypos5, wypos5.length);

        int[] bxpos = BLOCK1_X;
        int[] bypos = BLOCK1_Y;

        var block1 = new Polygon(bxpos, bypos, bypos.length);

        int[] wxpos6 = WALL6_X;
        int[] wypos6 = WALL6_Y;

        var wall6 = new Polygon(wxpos6, wypos6, wypos6.length);

        int[] bxpos2 = BLOCK2_X;
        int[] bypos2 = BLOCK2_Y;

        var block2 = new Polygon(bxpos2, bypos2, bypos2.length);

        int[] bxpos3 = BLOCK3_X;
        int[] bypos3 = BLOCK3_Y;

        var block3 = new Polygon(bxpos3, bypos3, bypos3.length);

        int[] wxpos7 = WALL7_X;
        int[] wypos7 = WALL7_Y;

        var wall7 = new Polygon(wxpos7, wypos7, wypos7.length);

        solids.addAll(List.of(wall1, wall2, wall3, wall4, wall5, wall6, wall7, block1, block2, block3));

        gameObjects.addAll(
                List.of(game.getLink(),
                new BlueSoldier(game, 755, 195, Direction.UP, 60),
                new BlueSoldier(game, 675, 399, Direction.UP, 110),
                new BlueSoldier(game, 740, 794, Direction.DOWN, 80),
                new BlueSoldier(game, 126, 703, Direction.DOWN, 120),
                new BlueSoldier(game, 331, 385, Direction.RIGHT, 70),
                new WhiteSoldier(game, 637, 905, Direction.LEFT),
                new Rupee(game, 355, 368),
                new Rupee(game, 363, 368),
                new Rupee(game, 371, 368),
                new Rupee(game, 379, 368),
                new Rupee(game, 387, 368),
                new Rupee(game, 395, 368),
                new Rupee(game, 403, 368),
                new Rupee(game, 355, 382),
                new Rupee(game, 363, 382),
                new Rupee(game, 371, 382),
                new Rupee(game, 379, 382),
                new Rupee(game, 387, 382),
                new Rupee(game, 395, 382),
                new Rupee(game, 403, 382),
                new Rupee(game, 355, 396),
                new Rupee(game, 363, 396),
                new Rupee(game, 371, 396),
                new Rupee(game, 379, 396),
                new Rupee(game, 387, 396),
                new Rupee(game, 395, 396),
                new Rupee(game, 403, 396),
                new Warp(game, 160, 91)
        ));

        if (!game.getSong().equals("/static/sounds/castle.mp3")) {
            game.stopMusic();
            game.playMusic("/static/sounds/castle.mp3", true);
        }

        handleSwitchScene(entrance);
    }

    @Override
    public void handleSwitchScene(Rectangle exit) {
        if (exit == warpExit) {
            game.setScene(new ArmosScene(game, "CastleBasementScene"));
        }
        if (exit == exitUp) {
            game.setScene(new CastleScene(game, "CastleBasementScene"));
        }
    }

    @Override
    public void handleSwitchScene(String entrance) {
        if (entrance.equals("CastleScene")) {
            moveScene(482, 1);

            game.getLink().setXHardCore(275);
            game.getLink().setYHardCore(86);
        }
    }
}
