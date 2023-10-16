/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.zelda.enemy.armos;


import com.example.zelda.karacter.Karacter;
import com.example.zelda.karacter.KaracterState;

/**
 *
 * @author Christiaan
 */
public class AttackState extends KaracterState {

    private final String[] animation = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private static final int WALK_SPEED = 5;

    public AttackState(Karacter armosKnight) {
        super(armosKnight);
        name = "AttackState";

        armosKnight.setAnimationInterval(90);

        long oldAnimationInterval = armosKnight.getAnimationInterval();

        int oldX = armosKnight.getX();
        int oldY = armosKnight.getY();
    }

    public void handleInput() {
        switch (karacter.getDirection()) {
            case UP, DOWN, LEFT, RIGHT -> animation();
        }
    }

    public void animation() {
        karacter.setAnimation(animation);
    }
}
