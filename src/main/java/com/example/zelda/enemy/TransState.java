package com.example.zelda.enemy;


import com.example.zelda.karacter.Direction;
import com.example.zelda.karacter.Karacter;
import com.example.zelda.karacter.KaracterState;

/**
 *
 * @author vincentklarholz
 */
public class TransState extends KaracterState {
    private final static String[] downAnimation	= {"Stand down", "Stand down", "Stand down", "Stand down",
            "Stand down", "Stand down", "Stand down", "Stand down", "Stand down", "Stand down"};
	private final static String[] upAnimation	= {"Stand up", "Stand up", "Stand up", "Stand up", "Stand up",
            "Stand up", "Stand up", "Stand up", "Stand up", "Stand up"};
	private final static String[] leftAnimation	= {"Stand left", "Stand left", "Stand left", "Stand left",
            "Stand left", "Stand left", "Stand left", "Stand left", "Stand left", "Stand left"};
	private final static String[] rightAnimation= {"Stand right", "Stand right", "Stand right", "Stand right",
            "Stand right", "Stand right", "Stand right", "Stand right", "Stand right", "Stand right"};

    private final Direction direction;

    public TransState(Karacter soldier, Direction direction) {
        super(soldier);
		name = "TransState";
        karacter.setAnimationInterval(40);

        this.direction = direction;
    }

    public void left() {
        karacter.setAnimation(leftAnimation);
		karacter.setX(karacter.getX() + 4);
	}

	public void right() {
        karacter.setAnimation(rightAnimation);
		karacter.setX(karacter.getX() - 4);
	}

	public void up() {
        karacter.setAnimation(upAnimation);
        karacter.setY(karacter.getY() + 4);
	}

	public void down() {
        karacter.setAnimation(downAnimation);
		karacter.setY(karacter.getY() - 4);
	}

    @Override
	public void handleAnimation() {
        var animationCounter = karacter.getAnimationCounter();

        if (animationCounter == karacter.getAnimation().length) {
            karacter.setAnimationInterval(90);
            karacter.setState(new WalkState(karacter));
        }

        switch (direction) {
            case UP -> down();
            case DOWN -> up();
            case LEFT -> right();
            case RIGHT -> left();
        }
    }
}
