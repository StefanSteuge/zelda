package com.example.zelda.items;


import com.example.zelda.collision.Hittable;
import com.example.zelda.collision.Weapon;
import com.example.zelda.engine.GObject;
import com.example.zelda.engine.Game;

import java.awt.*;

/**
 *
 * @author Christiaan
 */
public class Bush extends GObject implements Hittable {

    public Bush(Game game, int x, int y) {
        super(game, x, y, 16, 14, "src/main/resources/static/images/items.png");
        spriteLoc.put("bush", new Rectangle(0, 0, 16, 15));
        spriteLoc.put("stump", new Rectangle(17, 0, 16, 15));
        
        String[] bushani = {"bush"};
        setAnimation(bushani);
        sprite.setSprite(spriteLoc.get("bush"));
    }

    public void hitBy(Weapon weapon) {
        if(weapon == Weapon.SWORD) {
            String[] bushani = {"stump"};
            setAnimation(bushani);
            if (liquid == false) {
                game.playFx("src/main/resources/static/sounds/bushCut.mp3");

                randomGoodie();
            }

            liquid = true;
        }
        if(weapon == Weapon.BOMB) {
            String[] bushani = {"stump"};
            setAnimation(bushani);
            if (!liquid) {
                game.playFx("src/main/resources/static/sounds/bushCut.mp3");

                randomGoodie();
            }
            liquid = true;
        }
    }
}
