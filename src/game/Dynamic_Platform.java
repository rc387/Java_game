package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

public class Dynamic_Platform extends DynamicBody {
    private static final Shape PlatformShape = new BoxShape(7,1);
    private static final BodyImage image = new BodyImage("data/platform_level2.png", 11.5f);
    private int direction = 1;
    private final float ceilingBound;
    private final float floorBound;
    public Dynamic_Platform(World w, float ceilingBound, float floorBound) {
        super(w, PlatformShape);
        this.ceilingBound = ceilingBound;
        this.floorBound = floorBound;
        addImage(image);
        setFixedRotation(true);
        setAngle(0f);
    }

    private void setFixedRotation(boolean b) {
    }

    public void update() {
        float y = getPosition().y;
        if (y > ceilingBound) direction = -1;
        if (y < floorBound) direction = 1;

        setLinearVelocity(new Vec2(0, 5 * direction));

        }
}

