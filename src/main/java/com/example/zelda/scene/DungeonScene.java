package com.example.zelda.scene;


import com.example.zelda.engine.Game;

import java.awt.*;
import java.util.List;

import static com.example.zelda.scene.util.CoordinateConstantsDungeonScene.*;

/**
 *
 * @author Christiaan
 */
public class DungeonScene extends ZeldaScene {
    Polygon wall2;
    Polygon wall1;
    Polygon table;
    Polygon door;

    private final Rectangle zeldaExit = new Rectangle(ZELDAEXIT_X, ZELDAEXIT_Y, 20, 10);


    public DungeonScene(Game game, String entrance) {
        super(game, "/static/images/kerker.png", "DungeonScene");

        exits.add(zeldaExit);

        int[] wall2X = WALL2_X;
        int[] wall2Y = WALL2_Y;

        wall2 = new Polygon(wall2X, wall2Y, wall2Y.length);

        int[] wall1X = WALL1_X;
        int[] wall1Y = WALL1_Y;

        wall1 = new Polygon(wall1X, wall1Y, wall1Y.length);

        int[] tableX = TABLE_X;
        int[] tableY = TABLE_Y;

        table = new Polygon(tableX, tableY, tableY.length);

        int[] doorX = DOOR_X;
        int[] doorY = DOOR_Y;

        door = new Polygon(doorX, doorY, doorY.length);

        solids.addAll(List.of(wall2, wall1, table, door));

        gameObjects.add(game.getLink());

		if (!game.getSong().equals("/static/sounds/castle.mp3")) {
            game.stopMusic();
            game.playMusic("/static/sounds/castle.mp3", true);
		}

        handleSwitchScene(entrance);
    }

    @Override
    public void handleSwitchScene(Rectangle exit) {
        if (exit == zeldaExit) {
			game.setScene(new CreditScene(game));
		}
    }

    @Override
    public void handleSwitchScene(String entrance) {
        if (entrance.equals("ArmosScene")) {
            game.getLink().setXHardCore(81);
            game.getLink().setYHardCore(120);
        }
    }
}
