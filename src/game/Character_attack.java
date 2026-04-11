package game;

import city.cs.engine.*;

public class Character_attack extends DynamicBody {
    private static final Shape AttackShape = new BoxShape(1f, 1f);
    private static final BodyImage Bullet =  new BodyImage("data/1.png", 0.5f);
    public Character_attack(World w) {
        super(w,AttackShape);
        addImage(Bullet);
    }

    public void destroyed() {destroy();}
}
