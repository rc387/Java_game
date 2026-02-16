package game;
import city.cs.engine.*;
import city.cs.engine.Shape;
import city.cs.engine.DynamicBody;

public class Character extends DynamicBody  {
    private static final Shape CharacterShape = new BoxShape(1,2.5f);
    private static final BodyImage image = new BodyImage("data/Fighter/Idle(1).png", 5.5f);
    private static int lives = 3;
    private boolean canDamage = false;

    public Character(World world) {
        super(world, CharacterShape);
        addImage(image);
        setFixedRotation(true);
        setAngle(0f);
    }

    public int getLives() {
        return lives;
    }

    public void loselife(){
        lives--;
    }

    private void setFixedRotation(boolean b) {}
}

