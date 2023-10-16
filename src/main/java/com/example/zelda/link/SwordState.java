package com.example.zelda.link;

import com.example.zelda.collision.Hittable;
import com.example.zelda.collision.Weapon;
import com.example.zelda.engine.GObject;
import com.example.zelda.karacter.Direction;

import java.awt.*;
import java.awt.geom.Area;

/**
 * State for when link is swinging his sword.
 *
 * @author maartenhus
 */
public class SwordState extends LinkState {
	private final static String[] downAnimation	= {"Link sword down 1", "Link sword down 2", "Link sword down 3",
			"Link sword down 4", "Link sword down 5", "Link sword down 6"};
	private final static String[] upAnimation	= {"Link sword up 1", "Link sword up 2", "Link sword up 3",
			"Link sword up 4", "Link sword up 5", "Link sword up 6", "Link sword up 7", "Link sword up 8",
			"Link sword up 9"};
	private final static String[] leftAnimation	= {"Link sword left 1", "Link sword left 2", "Link sword left 3",
			"Link sword left 4", "Link sword left 5", "Link sword left 6", "Link sword left 7", "Link sword left 8",
			"Link sword left 9"};
	private final static String[] rightAnimation= {"Link sword right 1", "Link sword right 2", "Link sword right 3",
			"Link sword right 4", "Link sword right 5", "Link sword right 6", "Link sword right 7", "Link sword right 8"};

	private Rectangle sword;

	private final int oldX;
    private final int oldY;
	private final long oldAnimationInterval;

	public SwordState(Link link) {
		super(link);
		name = "SwordState";

		oldX = link.getX();
		oldY = link.getY();
		oldAnimationInterval = link.getAnimationInterval();
		link.setCheckCollision(false);

        switch (link.getDirection()) {
            case UP -> {
                link.setAnimation(upAnimation);
                link.setAnimationInterval(20);
                sword = new Rectangle(oldX - 10, oldY - 10, 30, 10);
                game.playFx("/static/sounds/swordSlash1.mp3");
            }
            case DOWN -> {
                link.setAnimation(downAnimation);
                link.setAnimationInterval(30);
                sword = new Rectangle(oldX, oldY + link.getHeight(), 25, 10);
                game.playFx("/static/sounds/swordSlash2.mp3");
            }
            case LEFT -> {
                link.setAnimation(leftAnimation);
                link.setAnimationInterval(20);
                sword = new Rectangle(oldX - 10, oldY, 20, 30);
                game.playFx("/static/sounds/swordSlash3.mp3");
            }
            case RIGHT -> {
                link.setAnimation(rightAnimation);
                link.setAnimationInterval(20);
                sword = new Rectangle(oldX + link.getWidth(), oldY, 13, 28);
                game.playFx("/static/sounds/swordSlash4.mp3");
            }
        }

		game.getScene().addHitter(sword);
	}

	@Override
	public void handleInput() {
		for (GObject obj : link.getGame().getScene().getGObjects()) {
			final Area area = new Area();
			area.add(new Area(sword));
			area.intersect(new Area(obj.getRectangle()));

			if((obj instanceof Hittable hittable) && !area.isEmpty() && link != obj) {
                hittable.hitBy(Weapon.SWORD);
			}
		}
	}

	@Override
	public void handleAnimation() {
		int animationCounter = link.getAnimationCounter();

		//System.out.println("Animation Counter is " + animationCounter);

		//sword is done swinging revert back to former state
		if (animationCounter == link.getAnimation().length) {
			link.setY(oldY);
			link.setX(oldX);
			link.setAnimationInterval(oldAnimationInterval);
			link.setCheckCollision(true);
			link.setState(new StandState(link));
			game.getScene().removeHitter(sword);
		} else {
			// This section of the code corrects the position of link when he's striking.
			// If you don't do this link appears to be moving when he swings his sword.
			// Go ahead and remove the entire body of this else statement. You'll see what i mean.

			var dir = link.getDirection();

			if (dir == Direction.UP) {
                switch (animationCounter) {
                    case 0 -> link.setY(link.getY() + 1);
                    case 2 -> link.setY(link.getY() - 2);
                    case 3 -> link.setY(link.getY() - 6);
                    case 4 -> link.setY(link.getY() - 1);
                    case 6 -> {
                        link.setY(link.getY() + 2);
                        link.setX(link.getX() - 4);
                    }
                    case 7 -> {
                        link.setY(link.getY() + 2);
                        link.setX(link.getX() - 6);
                    }
                    case 8 -> {
                        link.setY(link.getY() + 3);
                        link.setX(link.getX() - 2);
                    }
                }
			} else if (dir == Direction.LEFT) {
                switch (animationCounter) {
                    case 0 -> {
                        link.setY(link.getY() - 1);
                        link.setX(link.getX() + 3);
                    }
                    case 1 -> link.setX(link.getX() - 2);
                    case 2 -> {
                        link.setY(link.getY() - 1);
                        link.setX(link.getX() - 5);
                    }
                    case 3 -> link.setX(link.getX() - 2);
                    case 4 -> {
                        link.setY(link.getY() + 2);
                        link.setX(link.getX() - 4);
                    }
                    case 6 -> link.setX(link.getX() + 1);
                    case 8 -> link.setX(link.getX() + 6);
                }
			} else if(dir == Direction.DOWN) {
                switch (animationCounter) {
                    case 0 -> link.setX(link.getX() - 4);
                    case 1 -> link.setX(link.getX() - 1);
                    case 2 -> link.setX(link.getX() + 1);
                }
			}
		}
	}
}
