package com.example.zelda.menu;


import com.example.zelda.engine.GObject;
import com.example.zelda.engine.Game;

import java.awt.*;

/**
 *
 * @author maartenhus
 */
public class Fairy extends GObject {
	private static final String[] flyani = {"Fly1", "Fly2"};

	public Fairy(Game game, int x, int y) {
		super(game, x, y, 14, 16, "/static/images/fairy.png");

		spriteLoc.put("Fly1",	new Rectangle(0, 0, 14, 16));
		spriteLoc.put("Fly2",	new Rectangle(20, 0, 14, 16));

		sprite.setSprite(spriteLoc.get("Fly1"));

		setAnimationInterval(250);
		setAnimation(flyani);
	}
}
