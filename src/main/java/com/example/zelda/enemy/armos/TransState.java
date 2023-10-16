package com.example.zelda.enemy.armos;


import com.example.zelda.karacter.Direction;
import com.example.zelda.karacter.Karacter;
import com.example.zelda.karacter.KaracterState;

/**
 *
 * @author vincentklarholz
 */
public class TransState extends KaracterState {
    private final String[] animationHit = {"hit 1", "hit 2", "hit 3", "hit 4", "hit 5",
                                           "hit 6", "hit 7", "hit 8", "hit 9", "hit 10"};

    private final Direction direction;

    public TransState(Karacter armosKnight, Direction direction) {
        super(armosKnight);
		name = "TransState";
        karacter.setAnimationInterval(10);

        this.direction = direction;
    }

    public void left() {
        karacter.setAnimation(animationHit);
		karacter.setX(karacter.getX() + 8);
	}

	public void right() {
        karacter.setAnimation(animationHit);
		karacter.setX(karacter.getX() - 8);
	}

	public void up() {
        karacter.setAnimation(animationHit);
        karacter.setY(karacter.getY() + 8);
	}

	public void down() {
        karacter.setAnimation(animationHit);
		karacter.setY(karacter.getY() - 8);
	}

    @Override
	public void handleAnimation() {
		int animationCounter = karacter.getAnimationCounter();

        if (animationCounter == karacter.getAnimation().length) {
            karacter.setAnimationInterval(90);
            karacter.setState(new AttackState(karacter));
        }

        switch (direction) {
            case UP -> down();
            case DOWN -> up();
            case LEFT -> right();
            case RIGHT -> left();
        }
    }
}
