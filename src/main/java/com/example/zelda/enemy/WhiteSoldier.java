package com.example.zelda.enemy;


import com.example.zelda.collision.Hittable;
import com.example.zelda.collision.Weapon;
import com.example.zelda.engine.Game;
import com.example.zelda.karacter.Direction;

/**
 * A White soldier.
 *
 * @author maartenhus
 */
public class WhiteSoldier extends Soldier implements Hittable {

    public WhiteSoldier(Game game, int x, int y, Direction direction) {
        super(game, x, y, direction, "/static/images/white-soldier.png");
        behavior = new RandomBehavior(this);
    }

    public void hitBy(Weapon weapon) {
        if (health >= 1) {
            game.playFx("/static/sounds/enemyHit.mp3");
        }

        switch (weapon) {
            case SWORD -> {
                if (health > 0 && System.currentTimeMillis() > lastHit + 800) {
                    lastHit = System.currentTimeMillis();
                    health -= 3;
                    setState(new TransState(this, game.getLink().getDirection()));
                    setBehavior(new AttackBehavior(this));
                }
            }
            case BOMB -> health = 0;
            case ARROW -> {
                if (health > 0 && System.currentTimeMillis() > lastHit + 800) {
                    lastHit = System.currentTimeMillis();
                    health -= 2;
                    setBehavior(new AttackBehavior(this));
                }
            }
        }

        if (health <= 0) {
            alive = false;
            game.playFx("/static/sounds/enemyDie.mp3");
            randomGoodie();
        }
    }
}
