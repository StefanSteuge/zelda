package com.example.zelda.scene;



import com.example.zelda.enemy.BlueSoldier;
import com.example.zelda.enemy.WhiteSoldier;
import com.example.zelda.engine.Game;
import com.example.zelda.items.Bush;
import com.example.zelda.items.Guard;
import com.example.zelda.karacter.Direction;

import java.awt.*;

import static com.example.zelda.scene.util.CoordinateConstants.*;


/**
 * @author Christiaan
 */

public class HyruleScene extends ZeldaScene {

    private final Rectangle hatch = new Rectangle(HATCH_X, HATCH_Y, 1, 1);
    private final Rectangle exitDown = new Rectangle(EXIT_DOWN_X, EXIT_DOWN_Y, 290, 20);
    private final Rectangle stairs = new Rectangle(STAIRS_X, STAIRS_Y, 14, 14);
    private final Rectangle door = new Rectangle(DOOR_X, DOOR_Y, 30, 30);
    private final Rectangle forrestExit = new Rectangle(FORREST_EXIT_X , FORREST_EXIT_Y, 50, 20);

    public HyruleScene(Game game, String entrance) {
        super(game, "src/main/resources/static/images/hyrule.png", "HyruleScene");

        exits.add(exitDown);
        exits.add(hatch);
        exits.add(stairs);
        exits.add(door);
        exits.add(forrestExit);

        initSceneObjects(game, entrance);

        var tree1 = createPolygon(TREE1_X, TREE1_Y);
        var tree2 = createPolygon(TREE2_X, TREE2_Y);
        var wall1 = createPolygon(WALL1_X, WALL1_Y);
        var wall2 = createPolygon(WALL2_X, WALL2_Y);
        var castleWall2 = createPolygon(CASTLE_WALL2_X, CASTLE_WALL2_Y);
        var castleWall3 = createPolygon(CASTLE_WALL3_X, CASTLE_WALL3_Y);
        var castleWall1 = createPolygon(CASTLE_WALL1_X, CASTLE_WALL1_Y);
        var downWall1 = createPolygon(DOWN_WALL1_X, DOWN_WALL1_Y);
        var downWall2 = createPolygon(DOWN_WALL2_X, DOWN_WALL2_Y);
        var bush1 = createPolygon(BUSH1_X, BUSH1_Y);
        var bush2 =createPolygon(BUSH2_X, BUSH2_Y);
        var bush3 = createPolygon(BUSH3_X, BUSH3_Y);
        var balk = createPolygon(BALK_X, BALK_Y);
        var garden1 = createPolygon(GARDEN1_X,GARDEN1_Y);
        var garden2 = createPolygon(GARDEN2_X, GARDEN2_Y);
        var garden3 = createPolygon(GARDEN3_X, GARDEN3_Y);

        solids.add(tree1);
        solids.add(tree2);
        solids.add(wall1);
        solids.add(wall2);
        solids.add(castleWall2);
        solids.add(castleWall1);
        solids.add(castleWall3);
        solids.add(downWall1);
        solids.add(downWall2);
        solids.add(bush1);
        solids.add(bush2);
        solids.add(bush3);
        solids.add(balk);
        solids.add(garden1);
        solids.add(garden2);
        solids.add(garden3);
    }

    private Polygon createPolygon(int[] xpoints, int[] ypoints) {
        for (int i = 0; i < ypoints.length; i++) {
            ypoints[i] += 20;
        }
        return new Polygon(xpoints, ypoints, ypoints.length);
    }

    private void initSceneObjects(Game game, String entrance) {
        // Initialize game objects here based on entrance

        gameObjects.add(new Bush(game, 657, 540));
        gameObjects.add(new Bush(game, 673, 540));
        gameObjects.add(new Bush(game, 689, 540));
        gameObjects.add(new Bush(game, 721, 304));
        gameObjects.add(new Bush(game, 721, 320));
        gameObjects.add(new Bush(game, 705, 304));
        gameObjects.add(new Bush(game, 705, 320));
        gameObjects.add(new Bush(game, 284, 526));
        gameObjects.add(new Bush(game, 284, 542));
        gameObjects.add(new Bush(game, 289, 223));
        gameObjects.add(new Bush(game, 305, 223));

        gameObjects.add(new Bush(game, 881, 144));
        gameObjects.add(new Bush(game, 897, 144));
        gameObjects.add(new Bush(game, 913, 144));
        gameObjects.add(new Bush(game, 881, 160));
        gameObjects.add(new Bush(game, 881, 176));
        gameObjects.add(new Bush(game, 897, 176));
        gameObjects.add(new Bush(game, 913, 176));
        gameObjects.add(new Bush(game, 913, 160));
        gameObjects.add(new Bush(game, 895, 942));

        gameObjects.add(new Bush(game, 694, 941));
        gameObjects.add(new Bush(game, 710, 941));
        gameObjects.add(new Bush(game, 710, 957));
        gameObjects.add(new Bush(game, 694, 957));

        gameObjects.add(new Bush(game, 843, 503));
        gameObjects.add(new Bush(game, 843, 519));
        gameObjects.add(new Bush(game, 843, 535));

        gameObjects.add(new Bush(game, 652, 676));
        gameObjects.add(new Bush(game, 668, 676));
        gameObjects.add(new Bush(game, 684, 676));
        gameObjects.add(new Bush(game, 700, 676));
        gameObjects.add(new Bush(game, 716, 676));

        gameObjects.add(new Bush(game, 652, 692));
        gameObjects.add(new Bush(game, 668, 692));
        gameObjects.add(new Bush(game, 684, 692));
        gameObjects.add(new Bush(game, 700, 692));
        gameObjects.add(new Bush(game, 716, 692));

        gameObjects.add(game.getLink());
        gameObjects.add(new BlueSoldier(game, 502, 800, Direction.DOWN, 40));
        gameObjects.add(new BlueSoldier(game, 880, 228, Direction.DOWN, 75));
        gameObjects.add(new BlueSoldier(game, 477, 484, Direction.DOWN, 50));
        gameObjects.add(new BlueSoldier(game, 520, 484, Direction.DOWN, 50));
        gameObjects.add(new BlueSoldier(game, 236, 918, Direction.RIGHT, 50));

        gameObjects.add(new WhiteSoldier(game, 833, 710, Direction.LEFT));
        gameObjects.add(new WhiteSoldier(game, 622, 528, Direction.DOWN));
        gameObjects.add(new WhiteSoldier(game, 293, 293, Direction.DOWN));

        gameObjects.add(new Guard(game, 438, 715, Direction.LEFT));
        gameObjects.add(new Guard(game, 995, 636, Direction.RIGHT));
        gameObjects.add(new Guard(game, 995, 666, Direction.RIGHT));

        if (!game.getSong().equals("src/main/resources/static/sounds/overworld.mp3")) {
            game.stopMusic();
            game.playMusic("src/main/resources/static/sounds/overworld.mp3", true);
        }

        handleSwitchScene(entrance);
    }

    @Override
    public void handleSwitchScene(Rectangle exit) {
        // Handle scene switching based on exit
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
