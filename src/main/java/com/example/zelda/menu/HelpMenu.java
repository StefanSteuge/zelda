package com.example.zelda.menu;


import com.example.zelda.engine.Game;
import com.example.zelda.engine.Scene;

import java.awt.*;

/**
 * 
 * @author maartenhus
 */
public class HelpMenu extends Scene {
	private long lastInput = System.currentTimeMillis();

	public HelpMenu(Game game) {
		super(game, "src/main/resources/static/images/help-menu.png", "HelpMenu");

		sprite.setSprite(new Rectangle(0, 0, game.getWidth(), game.getHeight()));

		try {
			game.stopMusic();
		}catch(Exception ignored){}

		game.playMusic("src/main/resources/static/sounds/help-menu.mp3", false);
	}

	@Override
	public void handleInput() {
		long inputInterval = 100;
		if (System.currentTimeMillis() > lastInput + inputInterval) {
			if (game.isEnterPressed()) {
				game.setScene(new MainMenu(game));
			}
			
			lastInput = System.currentTimeMillis();
		}
	}
}
