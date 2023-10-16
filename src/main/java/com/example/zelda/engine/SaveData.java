package com.example.zelda.engine;


import com.example.zelda.link.Link;

import java.io.Serializable;

/**
 *
 * @author maartenhus
 */
public class SaveData implements Serializable {
	private final int health;
	private final int rupee;

	private final String sceneName;

	public SaveData(Link link, Scene scene) {
		health = link.getHealth();
		rupee = link.getRupee();

		sceneName = scene.getName();
	}
	
	public int getHealth() {
		return health;
	}

	public int getRupee() {
		return rupee;
	}

	public String getSceneName() {
		return sceneName;
	}
}
