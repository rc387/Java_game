package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.StaticBody;

public class PlayerCollision implements CollisionListener {
    private boolean[] canJump;

public PlayerCollision(boolean[] player) {
    this.canJump = player;
}

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof StaticBody){
            canJump[0] = true;
        }
    }
}
