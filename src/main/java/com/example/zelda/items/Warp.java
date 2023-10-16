package com.example.zelda.items;


import com.example.zelda.engine.GObject;
import com.example.zelda.engine.Game;

import java.awt.*;

/**
 *
 * @author maartenhus
 */
public class Warp extends GObject {
	private final static String[] warpani = {"Warp1", "Warp2", "Warp3"};
    private final static String[] emptyani = {"Warp4"};

	public Warp(Game game, int x, int y) {
		super(game, x, y, 1, 1, "/static/images/items.png");
		
		spriteLoc.put("Warp1", new Rectangle(40, 0, 16, 16));
		spriteLoc.put("Warp2", new Rectangle(60, 0, 16, 16));
		spriteLoc.put("Warp3", new Rectangle(80, 0, 16, 16));
        spriteLoc.put("Warp4", new Rectangle(0, 58, 16, 16));


		sprite.setSprite(spriteLoc.get("Warp1"));
        setAnimation(warpani);

		liquid = true;
	}

    public void setActive() {
        if(animation == warpani) {
            setAnimation(emptyani);
        } else {
            setAnimation(warpani);
        }
    }
}
