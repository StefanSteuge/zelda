package com.example.zelda.engine;

import java.net.URL;

/**
 * This class plays Music.
 *
 * @author maartenhus
 */
public class Music extends Sound {
	private String songName = "";
	private final boolean loop;

	public Music(Game game, URL mp3, String songName, boolean loop) {
		super(game, mp3);

		this.loop = loop;
		this.songName = songName;
	}

	public void run() {
		while (!player.isComplete()) {// if song is not over
			try {
				player.play();
				Thread.sleep(1000);
			} catch (Exception ee) {
				ee.printStackTrace();
			}
		}

		if (loop) {//if song is over but its on a loop replay the song.
			game.playMusic(songName, true);
		}

		player.close();
	}

	public void stop() {
		player.close();
	}

	public String getSong() {
		return songName;
	}
}
