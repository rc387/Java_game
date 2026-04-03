package game;

import city.cs.engine.*;

import javax.swing.*;

public class Enemy_attack extends DynamicBody {
    private static final Shape AttackShape = new BoxShape(1f, 1f);
    private static final BodyImage Stave =  new BodyImage("data/3.png", 2.5f);
    public Enemy_attack(World w) {
        super(w, AttackShape);
        addImage(Stave);
    }

    public void destroyed() {
        destroy();
    }


    }
