package com.example.zelda.scene;

import com.example.zelda.enemy.BlueSoldier;
import com.example.zelda.enemy.WhiteSoldier;
import com.example.zelda.engine.Game;
import com.example.zelda.items.Bush;
import com.example.zelda.items.Guard;
import com.example.zelda.karacter.Direction;

import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.List;

import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.BALK_X;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.BALK_Y;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.BUSH1_X;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.BUSH1_Y;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.BUSH2_X;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.BUSH2_Y;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.BUSH3_X;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.BUSH3_Y;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.CASTLE_WALL1_X;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.CASTLE_WALL1_Y;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.CASTLE_WALL2_X;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.CASTLE_WALL2_Y;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.CASTLE_WALL3_X;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.CASTLE_WALL3_Y;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.DOOR_X;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.DOOR_Y;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.DOWN_WALL1_X;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.DOWN_WALL1_Y;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.DOWN_WALL2_X;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.DOWN_WALL2_Y;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.EXIT_DOWN_X;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.EXIT_DOWN_Y;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.FORREST_EXIT_X;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.FORREST_EXIT_Y;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.GARDEN1_X;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.GARDEN1_Y;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.GARDEN2_X;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.GARDEN2_Y;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.GARDEN3_X;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.GARDEN3_Y;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.HATCH_X;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.HATCH_Y;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.STAIRS_X;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.STAIRS_Y;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.TREE1_X;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.TREE1_Y;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.TREE2_X;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.TREE2_Y;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.WALL1_X;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.WALL1_Y;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.WALL2_X;
import static com.example.zelda.scene.util.CoordinateConstantsHyruleScene.WALL2_Y;

/**
 * @author Christiaan
 */

public class HyruleScene extends ZeldaScene {
    private final Rectangle hatch = new Rectangle(HATCH_X, HATCH_Y, 1, 1);
    private final Rectangle exitDown = new Rectangle(EXIT_DOWN_X, EXIT_DOWN_Y, 290, 20);
    private final Rectangle stairs = new Rectangle(STAIRS_X, STAIRS_Y, 14, 14);
    private final Rectangle door = new Rectangle(DOOR_X, DOOR_Y, 30, 30);
    private final Rectangle forrestExit = new Rectangle(FORREST_EXIT_X, FORREST_EXIT_Y, 50, 20);

    public HyruleScene(Game game, String entrance) {
        super(game, "/static/images/hyrule.png", "HyruleScene");

        exits.addAll(List.of(exitDown, hatch, stairs, door, forrestExit));

        int[] tree1X = TREE1_X;
        int[] tree1Y = TREE1_Y;

        for (int i = 0; i < tree1Y.length; i++) {
            tree1Y[i] += 20;
        }
        var tree1 = new Polygon(tree1X, tree1Y, tree1Y.length);

        int[] tree2X = TREE2_X;
        int[] tree2Y = TREE2_Y;

        for (int i = 0; i < tree2Y.length; i++) {
            tree2Y[i] += 20;
        }

        var tree2 = new Polygon(tree2X, tree2Y, tree2Y.length);

        int[] castleWall2X = CASTLE_WALL2_X;
        int[] castleWall2Y = CASTLE_WALL2_Y;

        for (int i = 0; i < castleWall2Y.length; i++) {
            castleWall2Y[i] += 20;
        }

        var castleWall2 = new Polygon(castleWall2X, castleWall2Y, castleWall2Y.length);

        int[] castleWall3X = CASTLE_WALL3_X;
        int[] castleWall3Y = CASTLE_WALL3_Y;

        for (int i = 0; i < castleWall3Y.length; i++) {
            castleWall3Y[i] += 20;
        }

        var castleWall3 = new Polygon(castleWall3X, castleWall3Y, castleWall3Y.length);

        int[] castleWall1X = CASTLE_WALL1_X;
        int[] castleWall1Y = CASTLE_WALL1_Y;

        for (int i = 0; i < castleWall1Y.length; i++) {
            castleWall1Y[i] += 20;
        }

        var castleWall1 = new Polygon(castleWall1X, castleWall1Y, castleWall1Y.length);

        int[] wall1X = WALL1_X;
        int[] wall1Y = WALL1_Y;

        for (int i = 0; i < wall1Y.length; i++) {
            wall1Y[i] += 20;
        }

        var wall1 = new Polygon(wall1X, wall1Y, wall1Y.length);


        int[] downWall1X = DOWN_WALL1_X;
        int[] downWall1Y = DOWN_WALL1_Y;

        var downWall1 = new Polygon(downWall1X, downWall1Y, downWall1Y.length);

        int[] downWall2X = DOWN_WALL2_X;
        int[] downWall2Y = DOWN_WALL2_Y;

        var downWall2 = new Polygon(downWall2X, downWall2Y, downWall2Y.length);

        int[] bush1X = BUSH1_X;
        int[] bush1Y = BUSH1_Y;

        for (int i = 0; i < bush1Y.length; i++) {
            bush1Y[i] += 20;
        }
        var bush1 = new Polygon(bush1X, bush1Y, bush1Y.length);

        int[] bush2X = BUSH2_X;
        int[] bush2Y = BUSH2_Y;

        for (int i = 0; i < bush2Y.length; i++) {
            bush2Y[i] += 20;
        }
        var bush2 = new Polygon(bush2X, bush2Y, bush2Y.length);

        int[] bush3X = BUSH3_X;
        int[] bush3Y = BUSH3_Y;

        for (int i = 0; i < bush3Y.length; i++) {
            bush3Y[i] += 20;
        }
        var bush3 = new Polygon(bush3X, bush3Y, bush3Y.length);

        int[] balkX = BALK_X;
        int[] balkY = BALK_Y;

        for (int i = 0; i < balkY.length; i++) {
            balkY[i] += 20;
        }

        var balk = new Polygon(balkX, balkY, balkY.length);

        int[] garden1X = GARDEN1_X;
        int[] garden1Y = GARDEN1_Y;

        for (int i = 0; i < garden1Y.length; i++) {
            garden1Y[i] += 20;
        }

        var garden1 = new Polygon(garden1X, garden1Y, garden1Y.length);

        int[] garden2X = GARDEN2_X;
        int[] garden2Y = GARDEN2_Y;

        for (int i = 0; i < garden2Y.length; i++) {
            garden2Y[i] += 20;
        }

        var garden2 = new Polygon(garden2X, garden2Y, garden2Y.length);

        int[] garden3X = GARDEN3_X;
        int[] garden3Y = GARDEN3_Y;

        for (int i = 0; i < garden3Y.length; i++) {
            garden3Y[i] += 20;
        }

        var garden3 = new Polygon(garden3X, garden3Y, garden3Y.length);

        int[] wall2X = WALL2_X;
        int[] wall2Y = WALL2_Y;

        for (int i = 0; i < wall2Y.length; i++) {
            wall2Y[i] += 20;
        }

        var wall2 = new Polygon(wall2X, wall2Y, wall2Y.length);

        solids.addAll(List.of(balk, garden1, garden2, garden3, bush1, bush2, bush3, tree1, tree2, castleWall2,
                castleWall1, castleWall3, wall1, wall2, downWall1, downWall2));

        gameObjects.addAll(List.of(
                new Bush(game, 657, 540),
                new Bush(game, 673, 540),
                new Bush(game, 689, 540),
                new Bush(game, 721, 304),
                new Bush(game, 721, 320),
                new Bush(game, 705, 304),
                new Bush(game, 705, 320),
                new Bush(game, 284, 526),
                new Bush(game, 284, 542),
                new Bush(game, 289, 223),
                new Bush(game, 305, 223),
                new Bush(game, 881, 144),
                new Bush(game, 897, 144),
                new Bush(game, 913, 144),
                new Bush(game, 881, 160),
                new Bush(game, 881, 176),
                new Bush(game, 897, 176),
                new Bush(game, 913, 176),
                new Bush(game, 913, 160),
                new Bush(game, 895, 942),
                new Bush(game, 694, 941),
                new Bush(game, 710, 941),
                new Bush(game, 710, 957),
                new Bush(game, 694, 957),
                new Bush(game, 843, 503),
                new Bush(game, 843, 519),
                new Bush(game, 843, 535),
                new Bush(game, 652, 676),
                new Bush(game, 668, 676),
                new Bush(game, 684, 676),
                new Bush(game, 700, 676),
                new Bush(game, 716, 676),
                new Bush(game, 652, 692),
                new Bush(game, 668, 692),
                new Bush(game, 684, 692),
                new Bush(game, 700, 692),
                new Bush(game, 716, 692),
                game.getLink(),
                new BlueSoldier(game, 502, 800, Direction.DOWN, 40),
                new BlueSoldier(game, 880, 228, Direction.DOWN, 75),
                new BlueSoldier(game, 477, 484, Direction.DOWN, 50),
                new BlueSoldier(game, 520, 484, Direction.DOWN, 50),
                new BlueSoldier(game, 236, 918, Direction.RIGHT, 50),
                new WhiteSoldier(game, 833, 710, Direction.LEFT),
                new WhiteSoldier(game, 622, 528, Direction.DOWN),
                new WhiteSoldier(game, 293, 293, Direction.DOWN),
                new Guard(game, 438, 715, Direction.LEFT),
                new Guard(game, 995, 636, Direction.RIGHT),
                new Guard(game, 995, 666, Direction.RIGHT)
        ));

        if (!game.getSong().equals("/static/sounds/overWorld.mp3")) {
            game.stopMusic();
            game.playMusic("/static/sounds/overWorld.mp3", true);
        }

        handleSwitchScene(entrance);
    }

    @Override
    public void handleSwitchScene(Rectangle exit) {
        if (exit == hatch) {
            game.setScene(new HiddenScene(game, "HyruleSceneHatch"));
        }
        if (exit == exitDown) {
            game.setScene(new HouseScene(game, "HyruleScene"));
        }
        if (exit == stairs) {
            game.setScene(new HiddenScene(game, "HyruleSceneStairs"));
        }
        if (exit == door) {
            game.setScene(new CastleScene(game, "HyruleScene"));
        }
        if (exit == forrestExit) {
            game.setScene(new ForrestScene(game, "HyruleScene"));
        }
    }

    @Override
    public void handleSwitchScene(String entrance) {
        if (entrance.equals("HouseScene")) {
            moveScene(524, 623);

            game.getLink().setXHardCore(309);
            game.getLink().setYHardCore(349);
        }

        if (entrance.equals("HiddenScene")) {
            moveScene(463, 44);

            game.getLink().setXHardCore(250);
            game.getLink().setYHardCore(200);
        }

        if (entrance.equals("ForrestScene3")) {
            moveScene(1, 623);

            game.getLink().setXHardCore(139);
            game.getLink().setYHardCore(341);
        }

        if (entrance.equals("CastleScene")) {
            moveScene(251, 88);

            game.getLink().setXHardCore(250);
            game.getLink().setYHardCore(200);
        }
    }
}
