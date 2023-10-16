package com.example.zelda.enemy;


import com.example.zelda.karacter.Direction;
import com.example.zelda.karacter.Karacter;
import com.example.zelda.link.Link;

/**
 *
 * @author vincentklarholz
 */
public class AttackBehavior extends Behavior {

    private final Karacter soldier;

    private final Link link;

    public AttackBehavior(Karacter soldier) {
        //System.out.println("here");
		this.soldier = soldier;
        link = soldier.getGame().getLink();
	}

	public void behave() {
        int valueX = Math.abs(link.getX() - soldier.getX());
        int valueY = Math.abs(link.getY() - soldier.getY());

        //check which direct between link and soldier is longer, X or Y
        if(valueX < valueY) {
            //Set new direction for soldier
            //Soldier up
            if(link.getY() < soldier.getY()) {
                soldier.setY(soldier.getY() - 1);
                if(soldier.getDirection() != Direction.UP) {
                    soldier.setDirection(Direction.UP);
                }

            } else if(link.getY() > soldier.getY()) {//Soldier downw
                soldier.setY(soldier.getY() + 1);
                if(soldier.getDirection() != Direction.DOWN) {
                    soldier.setDirection(Direction.DOWN);
                }
            }
        } else {
            //Set new direction for soldier
            //Soldier left
            if(link.getX() < soldier.getX()) {
                soldier.setX(soldier.getX() - 1);
                if(soldier.getDirection() != Direction.LEFT) {
                  soldier.setDirection(Direction.LEFT);
                }
            } else if(link.getX() > soldier.getX()) { //Soldier right
                soldier.setX(soldier.getX() + 1);
                if(soldier.getDirection() != Direction.RIGHT) {
                    soldier.setDirection(Direction.RIGHT);
                }
            }
        }

        //Set new X for soldier
        //Soldier left
        if(link.getX() < soldier.getX()) {
            soldier.setX(soldier.getX() - 1);
        } else if(link.getX() > soldier.getX()) { //Soldier right
            soldier.setX(soldier.getX() + 1);
        }

        //Set new Y for soldier
        //Soldier up
        if(link.getY() < soldier.getY()) {
            soldier.setY(soldier.getY() - 1);
        } else if(link.getY() > soldier.getY()) { //Soldier downw
            soldier.setY(soldier.getY() + 1);
        }
    }
}
