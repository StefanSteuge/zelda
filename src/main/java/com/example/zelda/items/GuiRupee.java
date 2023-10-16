package com.example.zelda.items;


import com.example.zelda.engine.GObject;
import com.example.zelda.engine.Game;

import java.awt.*;

/**
 *
 * @author Bas Harteveld
 */

public class GuiRupee extends GObject {
    private final static String[] rupeeAnimation = {"rupee"};

    public GuiRupee(Game game, int x, int y) {
        super(game, x, y, 11, 10, "/static/images/rupeegui2.png");
        spriteLoc.put("rupee",new Rectangle(0, 0, 11, 10));

        setAnimation(rupeeAnimation);

		z = 2;

        screenAdjust = false;
        checkCollision = false;
        liquid = true;
    }
}
