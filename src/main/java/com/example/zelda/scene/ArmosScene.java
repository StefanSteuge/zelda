package com.example.zelda.scene;

import com.example.zelda.enemy.armos.ArmosKnight;
import com.example.zelda.engine.GObject;
import com.example.zelda.engine.Game;
import com.example.zelda.items.Warp;
import com.example.zelda.karacter.Direction;

import java.awt.*;
import java.util.List;

import static com.example.zelda.scene.util.CoordinateConstantsArmosScene.*;

/**
 *
 * @author frankie
 */
public class ArmosScene extends ZeldaScene {

	private final Rectangle warpExit = new Rectangle(WARP_X, WARP_Y, 16, 16);
    private final Warp warp = new Warp(game, WARP_X, WARP_Y);
	private boolean warpVisible = false;

    public ArmosScene(Game game, String entrance) {
        super(game, "/static/images/battle-scene.png", "ArmosScene");

		exits.add(warpExit);

		var leftTreeline = getPolygon();

		int[] rightTreeLineX = RIGHT_TREE_LINE_X;
        int[] rightTreeLineY = RIGHT_TREE_LINE_Y;

		var rightTreeline = new Polygon(rightTreeLineX, rightTreeLineY, rightTreeLineY.length);

        int[] deadTreeX = DEAD_TREE_X;
        int[] deadTreeY = DEAD_TREE_Y;

		var deadTree = new Polygon(deadTreeX, deadTreeY, deadTreeY.length);

        solids.addAll(List.of(leftTreeline, rightTreeline, deadTree));

        warp.setActive();
        
		gameObjects.addAll(List.of(
				warp,
				game.getLink(),
				new ArmosKnight(game, 231, 90, Direction.DOWN),
				new ArmosKnight(game, 83, 236, Direction.LEFT),
				new ArmosKnight(game, 422, 251, Direction.RIGHT)
				));

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
	public void inputHook() {
		boolean dead = true;

		for (GObject obj : gameObjects) {
			if (obj instanceof ArmosKnight) {
				dead = false;
				break;
			}
		}

		if (dead && !warpVisible) {
			game.stopMusic();
            game.playMusic("/static/sounds/fanfare.mp3", false);
            
            warp.setActive();
			warpVisible = true;
		}
	}

	@Override
	public void handleSwitchScene(Rectangle exit) {
		if (exit == warpExit && warpVisible) {
			game.setScene(new DungeonScene(game, "ArmosScene"));
		}
	}

	@Override
	public void handleSwitchScene(String entrance) {
		if(entrance.equals("CastleBasementScene")) {
			//moveScene(1,19);

			game.getLink().setXHardCore(251);
			game.getLink().setYHardCore(298);
		}
	}
}
