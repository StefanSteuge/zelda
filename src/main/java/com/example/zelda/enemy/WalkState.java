package com.example.zelda.enemy;


import com.example.zelda.karacter.Direction;
import com.example.zelda.karacter.Karacter;
import com.example.zelda.karacter.KaracterState;

/**
 *
 * @author maartenhus
 */
public class WalkState extends KaracterState {
	private final String[] downAnimation	= {"Stand down", "Walk down 1", "Walk down 2", "Walk down 3"};
	private final String[] upAnimation		= {"Stand up", "Walk up 1", "Walk up 2"};
	private final String[] leftAnimation	= {"Stand left", "Walk left 1", "Walk left 2"};
	private final String[] rightAnimation	= {"Stand right", "Walk right 1", "Walk right 2"};

    private static final int WALK_SPEED = 2;

	public WalkState(Karacter soldier) {
		super(soldier);
		name = "WalkState";

        karacter.setAnimationInterval(90);

		long oldAnimationInterval = karacter.getAnimationInterval();

		int oldX = karacter.getX();
		int oldY = karacter.getY();
    }

	@Override
	public void handleInput() {
        switch (karacter.getDirection()) {
            case UP -> up();
            case DOWN -> down();
            case LEFT -> left();
            case RIGHT -> right();
        }
	}

	public void left() {
		if (karacter.getAnimation() != leftAnimation) {
			karacter.setAnimation(leftAnimation);
		}
		if (karacter.getDirection() != Direction.LEFT) {
			karacter.setDirection(Direction.LEFT);
		}

		karacter.setWidth(29);
		karacter.setX(karacter.getX() - WALK_SPEED);
	}

	public void right() {
		if (karacter.getAnimation() != rightAnimation) {
			karacter.setAnimation(rightAnimation);
		}
		if (karacter.getDirection() != Direction.RIGHT) {
			karacter.setDirection(Direction.RIGHT);
		}

		karacter.setWidth(29);
		karacter.setX(karacter.getX() + WALK_SPEED);
	}

	public void up()
	{
		if (karacter.getAnimation() != upAnimation)
		{
			karacter.setAnimation(upAnimation);
		}

		if (karacter.getDirection() != Direction.UP)
		{
			karacter.setDirection(Direction.UP);
		}

		karacter.setWidth(22);
		karacter.setY(karacter.getY() - WALK_SPEED);
	}

	public void down() {
		if (karacter.getAnimation() != downAnimation) {
			karacter.setAnimation(downAnimation);
		}
		if (karacter.getDirection() != Direction.DOWN) {
			karacter.setDirection(Direction.DOWN);
		}

		karacter.setWidth(22);
		karacter.setY(karacter.getY() + WALK_SPEED);
	}

    @Override
	public void handleAnimation() {
		int animationCounter = karacter.getAnimationCounter();

		var dir = karacter.getDirection();

		if (animationCounter == karacter.getAnimation().length) {

		} else {
			if (dir == Direction.LEFT) {
                switch (animationCounter) {
                    case 0 -> {
                    }
                    //karacter.setX(karacter.getX() - 0);
                    case 1 -> karacter.setX(karacter.getX() - 5);
                    case 2 -> karacter.setX(karacter.getX() + 5);
                }
			}
		}
    }
}
