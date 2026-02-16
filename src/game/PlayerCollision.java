package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.StaticBody;

public class PlayerCollision implements CollisionListener {
    private boolean canJump = false;
    private boolean canDamage = false;

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

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof StaticBody) {
            canJump = true;
        }
        if (e.getOtherBody() instanceof Enemy enemy && canDamage) {
            enemy.loseLife();
            canDamage = false;
            enemy.destroy();
        }
    }
}