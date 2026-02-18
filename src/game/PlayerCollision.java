package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.StaticBody;

public class PlayerCollision implements CollisionListener {
    private boolean canJump = false;
    private boolean canDamage = false;
    private boolean shield = false;
    private boolean canDie =  false;
    private boolean canTakeDamage = true;
    private Character player;

    public boolean canJump() {
        return canJump;
    }
    public void setCanJump(boolean value) {
        canJump = value;
    }

    public boolean canDamage() {
        return canDamage;
    }
    public void setCanDamage(boolean value) { canDamage = value; }

    public boolean isShield() {
        return shield;
    }

    public void setShield(boolean value) {
        shield = value;
    }

    public boolean isCanDie() {
        return canDie;
    }

    public void setCanDie(boolean value) {
        this.canDie = value;
    }

    public boolean isCanTakeDamage() {
        return canTakeDamage;
    }

    public void setCanTakeDamage(boolean value) {
        this.canTakeDamage = value;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof StaticBody) {
            canJump = true;
        } else if (e.getOtherBody() instanceof Enemy enemy && canDamage) {
            enemy.loseLife();
            enemy.destroy();
            canDamage = false;
        } else if (e.getOtherBody() instanceof Enemy && !shield && !canDamage ) {
            Character.loselife(player);
            canTakeDamage = false;

            new java.util.Timer().schedule(
                    new java.util.TimerTask(){
                        @Override
                        public void run() {
                            canTakeDamage = true;
                        }
                    }, 800);
        } else if (e.getOtherBody() instanceof Enemy && shield) {
            Character.shieldLife();
        } if (e.getOtherBody() instanceof DeathShape) {
            Character.loselife(player);
            Character.loselife(player);
            Character.loselife(player);
        }

    }

}