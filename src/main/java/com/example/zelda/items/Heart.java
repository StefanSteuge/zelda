package com.example.zelda.items;


import com.example.zelda.engine.GObject;
import com.example.zelda.engine.Game;
import com.example.zelda.link.Link;

import java.awt.*;

/**
 *
 * @author Tom
 */

public class Heart extends GObject {
    private final static String[] heartAnimation = {"heart"};

    public Heart (Game game, int x, int y) {
        super(game, x, y, 11, 10, "src/main/resources/static/images/heart1.png");
        spriteLoc.put("heart",new Rectangle(0, 0, 11, 10));
    
        sprite.setSprite(spriteLoc.get("heart"));
        setAnimation(heartAnimation);

		liquid = true;
    }

    @Override
    public void collision(GObject obj) {
        //System.out.println("Collision");
        if (obj instanceof Link) {
            alive = false;
        }        
    }
}