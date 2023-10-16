package com.example.zelda.enemy;


import com.example.zelda.karacter.Direction;
import com.example.zelda.karacter.Karacter;
import com.example.zelda.karacter.KaracterState;

/**
 *
 * @author maartenhus
 */
public class StandState extends KaracterState {
	private final static String[] downAnimation	= {"Stand down"};
	private final static String[] upAnimation	= {"Stand up"};
	private final static String[] leftAnimation	= {"Stand left"};
	private final static String[] rightAnimation= {"Stand right"};

	private final Direction oldDirection;;

	public StandState(Karacter soldier) {
		super(soldier);
		name = "StandState";

		oldDirection = soldier.getDirection();

        switch (oldDirection) {
            case UP -> soldier.setAnimation(upAnimation);
            case DOWN -> soldier.setAnimation(downAnimation);
            case LEFT -> soldier.setAnimation(leftAnimation);
            case RIGHT -> soldier.setAnimation(rightAnimation);
        }
	}

	@Override
	public void handleInput() {
		//System.out.println("oldDirection " + oldDirection + " new " + karacter.getDirection());
		if (oldDirection != karacter.getDirection()) {
            karacter.setState(new WalkState(karacter));
        }
	}
}
