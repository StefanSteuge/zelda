package com.example.zelda.scene;


import com.example.zelda.enemy.BlueSoldier;
import com.example.zelda.engine.Game;
import com.example.zelda.items.Rupee;
import com.example.zelda.items.Warp;
import com.example.zelda.karacter.Direction;

import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.List;

import static com.example.zelda.scene.util.CoordinateConstantsForrestScene.*;

/**
 * @author frankie
 */
public class ForrestScene extends ZeldaScene {

    private final Rectangle exitRight1 = new Rectangle(RIGHT_EXIT, RIGHT_EXIT1_Y, 20, 50);
    private final Rectangle exitRight2 = new Rectangle(RIGHT_EXIT, RIGHT_EXIT2_Y, 20, 90);
    private final Rectangle exitUp = new Rectangle(EXIT_UP_X, EXIT_UP_Y, 90, 20);
    private final Rectangle warpExit = new Rectangle(WARP_EXIT_X, WARP_EXIT_Y, 16, 16);

    public ForrestScene(Game game, String entrance) {
        super(game, "/static/images/forrest-scene.png", "ForrestScene");

        exits.addAll(List.of(exitRight1, exitRight2, exitUp, warpExit));

        int[] upperTreeLine1X = UPPER_TREE_LINE1_X;
        int[] upperTreeLine1Y = UPPER_TREE_LINE1_Y;

        var upperTreeline1 = new Polygon(upperTreeLine1X, upperTreeLine1Y, upperTreeLine1Y.length);

        int[] upperTreeLine2X = UPPER_TREE_LINE2_X;
        int[] upperTreeLine2Y = UPPER_TREE_LINE2_Y;

        var upperTreeline2 = new Polygon(upperTreeLine2X, upperTreeLine2Y, upperTreeLine2Y.length);

        int[] leftTreeLine1X = LEFT_TREE_LINE1_X;
        int[] leftTreeLine1Y = LEFT_TREE_LINE1_Y;

        var leftTreeline1 = new Polygon(leftTreeLine1X, leftTreeLine1Y, leftTreeLine1Y.length);

        int[] leftTreeLine2X = LEFT_TREE_LINE2_X;
        int[] leftTreeLine2Y = LEFT_TREE_LINE2_Y;

        var leftTreeline2 = new Polygon(leftTreeLine2X, leftTreeLine2Y, leftTreeLine2Y.length);


        int[] middleTreeLineX = MIDDLE_TREE_LINE_X;
        int[] middleTreeLineY = MIDDLE_TREE_LINE_Y;

        var middleTreeline = new Polygon(middleTreeLineX, middleTreeLineY, middleTreeLineY.length);


        int[] entryWall1X = ENTRY_WALL1_X;
        int[] entryWall1Y = ENTRY_WALL1_Y;

        var entreeWall1 = new Polygon(entryWall1X, entryWall1Y, entryWall1Y.length);

        int[] entryWall2X = ENTRY_WALL2_X;
        int[] entryWall2Y = ENTRY_WALL2_Y;

        var entreeWall2 = new Polygon(entryWall2X, entryWall2Y, entryWall2Y.length);

        int[] lowerWallX = LOWER_WALL_X;
        int[] lowerWallY = LOWER_WALL_Y;

        var lowerWall = new Polygon(lowerWallX, lowerWallY, lowerWallY.length);

        int[] deadTree1X = DEAD_TREE1_X;
        int[] deadTree1Y = DEAD_TREE1_Y;

        var deadTree1 = new Polygon(deadTree1X, deadTree1Y, deadTree1Y.length);

        int[] deadTree2X = DEAD_TREE2_X;
        int[] deadTree2Y = DEAD_TREE2_Y;

        var deadTree2 = new Polygon(deadTree2X, deadTree2Y, deadTree2Y.length);

        int[] deadTree3X = DEAD_TREE3_X;
        int[] deadTree3Y = DEAD_TREE3_Y;

        var deadTree3 = new Polygon(deadTree3X, deadTree3Y, deadTree3Y.length);

        solids.addAll(List.of(upperTreeline1, leftTreeline1, upperTreeline2, leftTreeline2, middleTreeline,
                entreeWall1, entreeWall2, lowerWall, deadTree1, deadTree2, deadTree3));

        gameObjects.addAll(List.of(
                game.getLink(),
                new BlueSoldier(game, 440, 375, Direction.UP, 20),
                new BlueSoldier(game, 259, 403, Direction.RIGHT, 50),
                new BlueSoldier(game, 137, 411, Direction.DOWN, 15),
                new BlueSoldier(game, 128, 110, Direction.UP, 55),
                new Rupee(game, 380, 110),
                new Rupee(game, 390, 110),
                new Rupee(game, 400, 110),
                new Rupee(game, 410, 110),
                new Rupee(game, 380, 128),
                new Rupee(game, 390, 128),
                new Rupee(game, 400, 128),
                new Rupee(game, 410, 128),
                new Warp(game, 393, 108)
        ));

        if (!game.getSong().equals("/static/sounds/overworld.mp3")) {
            game.stopMusic();
            game.playMusic("/static/sounds/overworld.mp3", true);
        }

        handleSwitchScene(entrance);
    }

    @Override
    public void handleSwitchScene(Rectangle exit) {
        if (exit == exitRight1) {
            game.setScene(new HouseScene(game, "ForrestScene1"));
        }

        if (exit == exitRight2) {
            game.setScene(new HouseScene(game, "ForrestScene2"));
        }

        if (exit == exitUp) {
            game.setScene(new HyruleScene(game, "ForrestScene3"));
        }

        if (exit == warpExit) {
            game.setScene(new BattleScene(game, "warp"));
        }
    }

    @Override
    public void handleSwitchScene(String entrance) {
        if (entrance.equals("HouseSceneLeft1")) {
            moveScene(10, 1);

            game.getLink().setXHardCore(462);
            game.getLink().setYHardCore(195);
        }

        if (entrance.equals("HouseSceneLeft2")) {
            moveScene(10, 80);

            game.getLink().setXHardCore(459);
            game.getLink().setYHardCore(200);
        }

        if (entrance.equals("HyruleScene")) {
            moveScene(1, 1);
            game.getLink().setXHardCore(135);
            game.getLink().setYHardCore(31);
        }

        if (entrance.equals("BattleScene")) {
            moveScene(10, 1);
            game.getLink().setXHardCore(382);
            game.getLink().setYHardCore(131);
        }
    }
}
