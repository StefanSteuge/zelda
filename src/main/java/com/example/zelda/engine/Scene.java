package com.example.zelda.engine;

import java.awt.Graphics2D;
import java.util.List;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This represents a level in the game.
 *
 * @author maartenhus
 */
public abstract class Scene implements DrawAble {

	protected Sprite sprite;
	protected Game game;
	protected final List<GObject> gameObjects = new ArrayList<>();
	protected final List<GObject> newGameObjects = new ArrayList<>();
	protected final List<Polygon> solids = new ArrayList<>();
	protected final List<Rectangle> hitters = new ArrayList<>();
	protected final List<Polygon> eyeViews = new ArrayList<>();
	protected String sceneName;
	protected static final int MOD = 1;

	public Scene(Game game, String img, String sceneName) {
		this.game = game;
		sprite = new Sprite(img);
		this.sceneName = sceneName;
	}

	@Override
	public void draw(Graphics2D g2) {
		g2.drawImage(sprite.getImage(), 0, 0, game.getWidth(), game.getHeight(), null);
	}

	public Sprite getSprite() {
		return sprite;
	}

	public synchronized void handleInput() {
		gameObjects.addAll(newGameObjects);
		gameObjects.sort(new GObjectComparator());

		// Remove dead objects
		gameObjects.removeIf(obj -> !obj.isAlive());
		newGameObjects.clear();
	}

	public void moveScene(int toX, int toY) {
		boolean moved;

		do {
			moved = isMoved(toX, toY);
		} while (moved);
	}

	private boolean isMoved(int toX, int toY) {
		boolean moved = false;

		if (sprite.getX() < toX) {
			int newX = sprite.getX() + MOD;

			if ((newX + sprite.getWidth()) <= sprite.getImageWidth()) {
				game.getLink().setX(game.getLink().getX() - MOD);
				modShapes(-MOD, 0);
				sprite.setX(newX);
				moved = true;
			}
		}
		if (sprite.getX() > toX) {
			int newX = sprite.getX() - MOD;

			if (newX > 0) {
				game.getLink().setX(game.getLink().getX() + MOD);
				modShapes(MOD, 0);
				sprite.setX(newX);
				moved = true;
			}
		}
		if (sprite.getY() < toY) {
			int newY = sprite.getY() + MOD;
			if ((newY + sprite.getHeight()) <= sprite.getImageHeight()) {
				game.getLink().setY(game.getLink().getY() - MOD);
				modShapes(0, -MOD);
				sprite.setY(newY);
				moved = true;
			}
		}
		if (sprite.getY() > toY) {
			int newY = sprite.getY() - MOD;

			if (newY > 0) {
				game.getLink().setY(game.getLink().getY() + MOD);
				modShapes(0, MOD);
				sprite.setY(newY);
				moved = true;
			}
		}
		return moved;
	}

	public void modShapes(int modX, int modY) {
		for (Polygon poly : solids) {
			poly.translate(modX, modY);
		}

		for (GObject obj : gameObjects) {
			if (obj.isScreenAdjust()) {
				obj.setXHardCore(obj.getX() + modX);
				obj.setYHardCore(obj.getY() + modY);
			}
		}
	}

	public void addGObject(GObject gObject) {
		gameObjects.add(gObject);
	}

	public void addNewGObject(GObject gObject) {
		newGameObjects.add(gObject);
	}

	public List<Polygon> getSolids() {
		return solids;
	}

	public List<GObject> getGObjects() {
		return gameObjects;
	}

	public void addHitter(Rectangle rect) {
		hitters.add(rect);
	}

	public void removeHitter(Rectangle rect) {
		hitters.remove(rect);
	}

	public List<Rectangle> getHitters() {
		return hitters;
	}

	public void addEyeView(Polygon poly) {
		eyeViews.add(poly);
	}

	public void removeEyeView(Polygon poly) {
		eyeViews.remove(poly);
	}

	public List<Polygon> getEyeViews() {
		return eyeViews;
	}

	public String getName() {
		return sceneName;
	}
}
