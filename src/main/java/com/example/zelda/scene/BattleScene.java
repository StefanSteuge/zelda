package com.example.zelda.scene;


import com.example.zelda.enemy.BlueSoldier;
import com.example.zelda.enemy.GhostSoldier;
import com.example.zelda.engine.Game;
import com.example.zelda.items.Warp;
import com.example.zelda.karacter.Direction;

import java.util.List;

import java.awt.Polygon;
import java.awt.Rectangle;

import static com.example.zelda.scene.util.CoordinateConstantsBattleScene.*;

/**
 *
 * @author frankie
 */
public class BattleScene extends ZeldaScene {

    private final Rectangle warpExit = new Rectangle(WARP_EXIT_X, WARP_EXIT_Y, 16, 16);

    public BattleScene(Game game, String entrance) {
        super(game, "/static/images/battle-dark.png", "BattleScene");

        exits.add(warpExit);

        var leftTreeline = getPolygon();

        int[] rightTreeLineX = RIGHT_TREE_LINE_X;
        int[] rightTreeLineY = RIGHT_TREE_LINE_Y;

        var rightTreeline = new Polygon(rightTreeLineX, rightTreeLineY, rightTreeLineY.length);

        int[] deadTreeX = DEAD_TREE_X;
        int[] deadTreeY = DEAD_TREE_Y;

        var deadTree = new Polygon(deadTreeX, deadTreeY, deadTreeY.length);

        solids.addAll(List.of(leftTreeline, rightTreeline, deadTree));

        gameObjects.addAll(List.of(
                        new Warp(game, 232, 458),
                        game.getLink(),
                        new BlueSoldier(game, 330, 145, Direction.LEFT, 10),
                        new BlueSoldier(game, 150, 340, Direction.DOWN, 10),
                        new BlueSoldier(game, 135, 135, Direction.RIGHT, 10),
                        new BlueSoldier(game, 280, 400, Direction.LEFT, 20),
                        new GhostSoldier(game, 240, 98, Direction.DOWN)
                )
        );

        if (!game.getSong().equals("/static/sounds/boss-bgm.mp3")) {
            game.stopMusic();
            game.playMusic("/static/sounds/boss-bgm.mp3", true);
        }

        handleSwitchScene(entrance);
    }

    private static Polygon getPolygon() {
        int[] leftTreeLineX = LEFT_TREE_LINE_X;
        int[] leftTreeLineY = LEFT_TREE_LINE_Y;

        return new Polygon(leftTreeLineX, leftTreeLineY, leftTreeLineY.length);
    }

    @Override
    public void handleSwitchScene(Rectangle exit) {
        if (exit == warpExit) {
            game.setScene(new ForrestScene(game, "BattleScene"));
        }
    }

    @Override
    public void handleSwitchScene(String entrance) {
        if (entrance.equals("warp")) {
            moveScene(1, 19);

            game.getLink().setXHardCore(233);
            game.getLink().setYHardCore(200);
        }
    }
}
