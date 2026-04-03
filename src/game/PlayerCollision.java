package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.StaticBody;

import javax.swing.*;

public class PlayerCollision implements CollisionListener {
    private boolean canJump = false;
    private boolean canDamage = false;
    private boolean shield = false;
    private boolean canTakeDamage = true;
    private final Character player;

    private Timer destroyTimer;

    public PlayerCollision(Character player) {
        this.player = player;
    }

    public boolean canJump() {
        return canJump;
    }
    public void setCanJump(boolean value) {
        canJump = value;
    }

    public void setCanDamage(boolean value) { canDamage = value; }


    public void setShield(boolean value) {
        shield = value;
    }

    public void setCanTakeDamage(boolean value) {
        this.canTakeDamage = value;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof StaticBody ) {
            canJump = true; // Allows the player to only jump whilst being in contact with a platform.
        } else if (e.getOtherBody() instanceof Dynamic_Platform) {
            canJump = true;
        } else if (e.getOtherBody() instanceof Enemy enemy && canDamage) { // Used to allow the enemy is take damage when collision occurs.
            enemy.lose_Life();
            canDamage = false; // Used to make sure the enemy only takes damage once upon collision.
        } else if (e.getOtherBody() instanceof Enemy && !shield && !canDamage ) { // Used to allow the player is take damage when collision occurs.
            player.loselife();
            canTakeDamage = false; // Used to make sure the player only takes damage once upon collision.

        } else if (e.getOtherBody() instanceof Enemy && !shield && !canDamage) {
            player.loselife();
            canTakeDamage = false;
        } else if (e.getOtherBody() instanceof Enemy && shield) {
            Character.shieldLife();
        } else if (e.getOtherBody() instanceof Enemy_attack enemyAttack && !shield && !canDamage ) {
            player.loselife();
            canTakeDamage = false;
            enemyAttack.destroyed();
        } else if (e.getOtherBody() instanceof Bullets bullet) {
            player.gainShots();
            bullet.destroy();
        }
        if (e.getOtherBody() instanceof DeathShape) {
            player.loselife(); // Called 3 times to clear all the hearts from the screen.
            player.loselife(); // Allows the player image to disappear upon collision.
            player.loselife();
            player.playerDeath();
            destroyTimer = new Timer(1000, f -> player.destroy());
            destroyTimer.start();}

        }

    }
// Author: Jonathan Ross