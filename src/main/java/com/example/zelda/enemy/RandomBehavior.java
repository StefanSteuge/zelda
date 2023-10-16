package com.example.zelda.enemy;


import com.example.zelda.karacter.Direction;

import java.util.Random;

/**
 *
 * @author Christiaan
 */
public class RandomBehavior extends Behavior {
    private final WhiteSoldier soldier;

    private long lastInput = System.currentTimeMillis();

    public RandomBehavior(WhiteSoldier soldier) {
        this.soldier = soldier;
    }
    
    public void behave() {
        long inputInterval = 5000;
        if (System.currentTimeMillis() > lastInput + inputInterval) {
            var random = new Random();
            int r = random.nextInt(3);

            switch (r) {
                case 0 -> soldier.setDirection(Direction.UP);
                case 1 -> soldier.setDirection(Direction.LEFT);
                case 2 -> soldier.setDirection(Direction.RIGHT);
                case 3 -> soldier.setDirection(Direction.DOWN);
            }

            lastInput = System.currentTimeMillis();
        }
    }
}
