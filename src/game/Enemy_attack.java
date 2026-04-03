package game;

import city.cs.engine.*;

public class Enemy_attack extends DynamicBody implements CollisionListener {
    private static final Shape AttackShape = new BoxShape(1f, 1f);
    private static final BodyImage Stave =  new BodyImage("data/3.png", 2.5f);
    public Enemy_attack(World w) {
        super(w, AttackShape);
        addImage(Stave);
    }

    public void destroyed() {
        destroy();
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof StaticBody) {
            destroyed();
        }

    }}
