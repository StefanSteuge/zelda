package com.example.zelda.scene;

import com.example.zelda.engine.GObject;
import com.example.zelda.engine.Game;
import com.example.zelda.engine.Scene;
import com.example.zelda.items.GuiHeart;
import com.example.zelda.items.GuiRupee;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * A specialised Scene object for the Zelda game.
 *
 * @author maartenhus
 */
public abstract class ZeldaScene extends Scene {

	protected final ArrayList<Rectangle> exits = new ArrayList<>();
	private boolean adjust = false;
	private final int xSensitivity;
	private final int ySensitivity;

	public ZeldaScene(Game game, String img, String sceneName) {
		super(game, img, sceneName);

		xSensitivity = game.getWidth() / 2;
		ySensitivity = game.getHeight() / 2;

		sprite.setSprite(new Rectangle(0, 0, game.getWidth(), game.getHeight()));

		GuiHeart.clear();

		for (int i = 0; i < 5; i++) {
			var heart = new GuiHeart(game, (game.getWidth() - 130) + i * 12, 50);
			gameObjects.add(heart);
		}

		var rupee = new GuiRupee(game, 100, game.getHeight() / 11);
		gameObjects.add(rupee);
	}

	@Override
	public void handleInput() {
		super.handleInput();
		checkLinkIsInExit();

		if (game.getLink().moveInput()) {
			adjust = true;
		}

		if (adjust) {
			var stateString = game.getLink().getStateString();
			if (!stateString.equals("SwordState") && !stateString.equals("BowState")) {
				adjustScene(game.getLink().getX(), game.getLink().getY());
			}
		}

		inputHook();
	}

	public void inputHook() {
	}

	private void checkLinkIsInExit() {
		for (Rectangle exit : exits) {
			if (exit.intersects(game.getLink().getRectangle())) {
				handleSwitchScene(exit);
			}
		}
	}

	public void adjustScene(int moveToX, int moveToY) {
		int mod = MOD;

		if (moveToX > (sprite.getWidth() - xSensitivity)) {
			int newX = sprite.getX() + mod;
			if ((newX + sprite.getWidth()) <= sprite.getImageWidth()) {
				game.getLink().setX(game.getLink().getX() - mod);
				modShapes(-mod, 0);
				sprite.setX(newX);
			}
		}

		if (moveToX < xSensitivity) {
			int newX = sprite.getX() - mod;
			if (newX > 0) {
				game.getLink().setX(game.getLink().getX() + mod);
				modShapes(mod, 0);
				sprite.setX(newX);
			}
		}

		if (moveToY > (sprite.getHeight() - ySensitivity)) {
			int newY = sprite.getY() + mod;
			if ((newY + sprite.getHeight()) <= sprite.getImageHeight()) {
				game.getLink().setY(game.getLink().getY() - mod);
				modShapes(0, -mod);
				sprite.setY(newY);
			}
		}

		if (moveToY < ySensitivity) {
			int newY = sprite.getY() - mod;
			if (newY > 0) {
				game.getLink().setY(game.getLink().getY() + mod);
				modShapes(0, mod);
				sprite.setY(newY);
			}
		}
	}

	@Override
	public void modShapes(int modX, int modY) {
		for (Polygon poly : solids) {
			poly.translate(modX, modY);
		}

		for (Rectangle rect : exits) {
			rect.translate(modX, modY);
		}

		for (GObject obj : gameObjects) {
			if (obj.isScreenAdjust()) {
				obj.setXHardCore(obj.getX() + modX);
				obj.setYHardCore(obj.getY() + modY);
			}
		}
	}

	@Override
	public void draw(Graphics2D g2) {
		super.draw(g2);

		g2.setColor(Color.white);
		var f = new Font("Serif", Font.BOLD, 12);
		g2.setFont(f);

		g2.drawString("-- LIFE --", game.getWidth() - 122, game.getHeight() / 9);
		g2.drawString(String.valueOf(game.getLink().getRupee()), 102, game.getHeight() / 7);
	}

	public ArrayList<Rectangle> getExits() {
		return exits;
	}

	public abstract void handleSwitchScene(Rectangle exit);

	public abstract void handleSwitchScene(String entrance);
}

    

