package com.example.zelda.items;


import com.example.zelda.engine.GObject;
import com.example.zelda.engine.Game;
import com.example.zelda.link.Link;

import java.awt.*;

/**
 *
 * @author Tom
 */
public class Rupee extends GObject {
    private final static String[] rupeeAnimation = {"rupee1", "rupee2", "rupee3", "rupee1", "rupee1", "rupee1",
            "rupee1","rupee1", "rupee1", "rupee1", "rupee1", "rupee1", "rupee1", "rupee1", "rupee1", "rupee1",
            "rupee1", "rupee1", "rupee1", "rupee1", "rupee1", "rupee1"};

    public Rupee (Game game, int x, int y) {
       super(game, x, y, 8, 14, "/static/images/rupee.png");
       spriteLoc.put("rupee1", new Rectangle(0, 0, 8, 14));
       spriteLoc.put("rupee2", new Rectangle(25, 0, 8, 14));
       spriteLoc.put("rupee3", new Rectangle(50, 0, 8, 14));

       sprite.setSprite(spriteLoc.get("rupee1"));
       
       setAnimationInterval(100);
       setAnimation(rupeeAnimation);

	   z = 1;

	   liquid = true;
    }

    @Override
    public void collision(GObject obj) {
        if (obj instanceof Link) {
            alive = false;
        }
    }
}
