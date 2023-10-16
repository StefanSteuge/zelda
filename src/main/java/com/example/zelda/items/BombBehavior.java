package com.example.zelda.items;


import com.example.zelda.enemy.Behavior;

/**
 *
 * @author vincentklarholz
 */
public class BombBehavior extends Behavior {
    private final Bomb bomb;

    private long lastAnimation = System.currentTimeMillis();

    private int ticks = 0;

    public BombBehavior(Bomb bomb ) {
        this.bomb = bomb;
    }
	
    public void behave() {
        long animationInterval = 50;
        if (System.currentTimeMillis() > lastAnimation + animationInterval) {// if it time to reanimate
            if(ticks == 49) {
                bomb.setAlive(false);
            }
            lastAnimation = System.currentTimeMillis();
            ticks++;
        }
    }

}
