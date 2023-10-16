package com.example.zelda.link;


import com.example.zelda.karacter.Direction;
import com.example.zelda.scene.HouseScene;

/**
 * @author Bas Harteveld
 */
public class DeathState extends LinkState {
    private long oldAnimationInterval;

    public DeathState(Link link, Direction direction) {
        super(link);
        name = "DeathState";

        link.setAnimationInterval(700);

        String[] deathRightAnimation = {"Link hit right", "Link death right", "Link death right 2"};
        String[] deathLeftAnimation = {"Link hit left", "Link death left", "Link death left 2"};
        switch (direction) {
            case UP -> link.setAnimation(deathLeftAnimation);
            case DOWN -> link.setAnimation(deathRightAnimation);
            case LEFT -> link.setAnimation(deathLeftAnimation);
            case RIGHT -> link.setAnimation(deathRightAnimation);
        }
    }

    @Override
	public void handleAnimation() {
		int animationCounter = link.getAnimationCounter();
		
		if (animationCounter == link.getAnimation().length) {
			link.setAnimationInterval(oldAnimationInterval);			
			link.setState(new StandState(link));
			link.setHealth(2);
			game.setScene(new HouseScene(game, "GameStart"));
		}
    }
}
