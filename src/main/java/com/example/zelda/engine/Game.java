package com.example.zelda.engine;

import com.example.zelda.Zelda;
import com.example.zelda.link.Link;
import com.example.zelda.menu.MainMenu;
import com.example.zelda.scene.ArmosScene;
import com.example.zelda.scene.BattleScene;
import com.example.zelda.scene.CastleBasementScene;
import com.example.zelda.scene.CastleScene;
import com.example.zelda.scene.DungeonScene;
import com.example.zelda.scene.ForrestScene;
import com.example.zelda.scene.HiddenScene;
import com.example.zelda.scene.HouseScene;
import com.example.zelda.scene.HyruleScene;

import java.io.*;

/**
 * This class represents the Game: Legend of Zelda: A Link to the Past!
 *
 * @author maartenhus
 */
public class Game {
	private boolean running = true;
	private boolean paused = false;
	private int gameSpeed = 10;

	private final Link link;
	private Scene scene;
	private Music music;

	private boolean aPressed = false;
	private boolean sPressed = false;
	private boolean dPressed = false;
	private boolean wPressed = false;
	private boolean jPressed = false;
	private boolean kPressed = false;
	private boolean lPressed = false;
	private boolean enterPressed = false;

	private final long lastHit = System.currentTimeMillis();
	private final long lastHit2 = System.currentTimeMillis();

	public Game() {
		link = new Link(this, 100, 100);
		scene = new MainMenu(this);
	}

	public void quit() {
		if (music != null)
			music.stop();

		save();

		try {
			Thread.sleep(1000); // give it some time to shut down the music nicely.
		} catch (InterruptedException ignored) {}

		System.exit(0);
	}

	public void playMusic(String mp3file, boolean loop) {
		var mp3 = Zelda.class.getResource(mp3file);
		music = new Music(this, mp3, mp3file, loop);
		music.play();
	}

	public void stopMusic() {
		if (music != null)
			music.stop();
	}

	public String getSong() {
		return music == null ? "" : music.getSong();
	}

	public void playFx(String mp3file) {
		var mp3 = Zelda.class.getResource(mp3file);
		var fx = new SoundFx(this, mp3);
		fx.play();
	}

	public void load() {
		FileInputStream fis;
		ObjectInputStream in;

		try {
			fis = new FileInputStream("Zelda.ser");
			in = new ObjectInputStream(fis);
			var data = (SaveData) in.readObject();

			var scn = initScene(data.getSceneName());

			setScene(scn);

			link.setHealth(data.getHealth());
			link.setRupee(data.getRupee());

			in.close();
		} catch (IOException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	public Scene initScene(String sceneName) {
		return switch (sceneName) {
			case "HouseScene" -> new HouseScene(this, "GameStart");
			case "HyruleScene" -> new HyruleScene(this, "HouseScene");
			case "HiddenScene" -> new HiddenScene(this, "HyruleSceneHatch");
			case "ForrestScene" -> new ForrestScene(this, "HouseScene");
			case "DungeonScene" -> new DungeonScene(this, "GameStart");
			case "CastleScene" -> new CastleScene(this, "HyruleScene");
			case "CastleBasementScene" -> new CastleBasementScene(this, "CastleScene");
			case "ArmosScene" -> new ArmosScene(this, "CastleBasementScene");
			case "BattleScene" -> new BattleScene(this, "warp");
			default -> null;
		};
	}

	public void save() {
		FileOutputStream fos;
		ObjectOutputStream out;

		var file = new File("Zelda.ser");
		try {
			file.delete();
		} catch (Exception ignored) {
		}

		file = new File("Zelda.ser");

		try {
			fos = new FileOutputStream(file);
			out = new ObjectOutputStream(fos);

			var data = new SaveData(link, scene);

			out.writeObject(data);
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public Link getLink() {
		return link;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public boolean isPaused() {
		return !paused;
	}

	public boolean isDebug() {
        return false;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}

	public int getGameSpeed() {
		return gameSpeed;
	}

	public void setGameSpeed(int gameSpeed) {
		this.gameSpeed = gameSpeed;
	}

	public synchronized Scene getScene() {
		return scene;
	}

	public synchronized void setScene(Scene scene) {
		this.scene = scene;
	}

	public int getHeight() {
        return 400;
	}

	public int getWidth() {
        return 500;
	}

	public void setaPressed(boolean aPressed) {
		this.aPressed = aPressed;
	}

	public void setdPressed(boolean dPressed) {
		this.dPressed = dPressed;
	}

	public void setjPressed(boolean jPressed) {
		this.jPressed = jPressed;
	}

	public void setkPressed(boolean kPressed) {
		this.kPressed = kPressed;
	}

	public void setlPressed(boolean lPressed) {
		this.lPressed = lPressed;
	}

	public void setsPressed(boolean sPressed) {
		this.sPressed = sPressed;
	}

	public void setwPressed(boolean wPressed) {
		this.wPressed = wPressed;
	}

	public void setEnterPressed(boolean enterPressed) {
		this.enterPressed = enterPressed;
	}

	public boolean isaPressed() {
		return aPressed;
	}

	public boolean isdPressed() {
		return dPressed;
	}

	public boolean isjPressed() {
		return jPressed;
	}

	public boolean iskPressed() {
		return kPressed;
	}

	public boolean islPressed() {
		return lPressed;
	}

	public boolean issPressed() {
		return sPressed;
	}

	public boolean iswPressed() {
		return wPressed;
	}

	public boolean isEnterPressed() {
		return enterPressed;
	}
}
