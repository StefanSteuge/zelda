package com.example.zelda;

import com.example.zelda.engine.GObject;
import com.example.zelda.engine.Game;
import com.example.zelda.scene.ZeldaScene;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 * This class handles all the drawing.
 *
 * @author maartenhus
 */
public class View {
	private final Game game;

	private final BufferStrategy buffer;

	private final BufferedImage bi;

	private final GraphicsDevice gd;

	private int x;

	private int y;

	public View(Game game, JFrame frame) {
		this.game = game;

		var ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		gd = ge.getDefaultScreenDevice();
		var gc = gd.getDefaultConfiguration();

		if(!game.isDebug()) {
			gd.setFullScreenWindow(frame); //needs to be done before call too isDisplayChangeSupported
		}

		int displayWidth = 640;
		int displayHeight = 480;

		if (gd.isDisplayChangeSupported() && !game.isDebug()) {
			
			gd.setDisplayMode(new DisplayMode(displayWidth, displayHeight, 32, DisplayMode.REFRESH_RATE_UNKNOWN));
		}

		frame.createBufferStrategy(2);
		frame.setBackground(Color.BLACK);
		buffer = frame.getBufferStrategy();
		bi = gc.createCompatibleImage(game.getWidth(), game.getHeight());

		//calculate the x and y for centering in fullscreen mode.
		
		if(!game.isDebug()) {
			x = (displayWidth - game.getWidth()) /2;
			y = (displayHeight - game.getHeight()) /2;
		}
	}	

	public void draw() {
		var graphics = buffer.getDrawGraphics();
		var g2 = bi.createGraphics();

		//for background in fullscreen.
		g2.setColor(Color.black);

		//System.out.println("draw");
		game.getScene().draw(g2);

		g2.setColor(Color.red);

		//animate, and draw every GObject from Scene
		for (GObject obj : game.getScene().getGObjects()) {
			if (game.isDebug())
				g2.draw(obj.getRectangle());

			if (game.isPaused()) {
				obj.animate();
			} else {
				g2.setColor(Color.white);
				g2.drawString("-- Pauzed --", game.getWidth() / 2 - 30, game.getHeight() / 2);
				g2.setColor(Color.red);
			}

			obj.draw(g2);
		}

		if (game.isDebug()) {

			//Draw solids on the map
			for (Shape s : game.getScene().getSolids()) {
				g2.draw(s);
			}

			//draw blue box when link strikes debug
			for (Rectangle r : game.getScene().getHitters()) {
				g2.setColor(Color.blue);
				g2.draw(r);
			}

			//draw green box for eye views
			for (Shape v : game.getScene().getEyeViews()) {
				g2.setColor(Color.green);
				g2.draw(v);
			}

			if(game.getScene() instanceof ZeldaScene zeldaScene) {

				for(Shape v : zeldaScene.getExits())
				{
					g2.setColor(Color.magenta);
					g2.draw(v);
				}
			}
		}

		if (!game.isDebug()) {
			graphics.drawImage(bi, x, y, null);
		} else {
			graphics.drawImage(bi, 0, 0, null);
		}

		if (!buffer.contentsLost())
			buffer.show();

		graphics.dispose();
		g2.dispose();
	}

	public void exitFullScreen() {
		gd.setFullScreenWindow(null);
	}
}
