/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.zelda.scene;


import com.example.zelda.engine.Game;

import java.awt.*;

/**
 *
 * @author Christiaan
 */
public class CreditScene extends ZeldaScene {
    public CreditScene(Game game) {
        super(game, "/static/images/aftitel.png", "CreditScene");

         if (!game.getSong().equals("/static/sounds/credits.mp3")) {
            game.stopMusic();
            game.playMusic("/static/sounds/credits.mp3", true);
            }

    }

    @Override
    public void handleSwitchScene(Rectangle exit) {}

    @Override
    public void handleSwitchScene(String entrance) {}

}
