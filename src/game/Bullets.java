package game;

import city.cs.engine.*;

public class Bullets extends DynamicBody {
    private static final Shape BulletShape = new BoxShape(2f, 2f);
    private static final BodyImage Bullet =  new BodyImage("data/4.png", 0.5f);
    public Bullets(World w) {
        super(w, BulletShape);
        addImage(Bullet);
    }
    public void destroy(){
        super.destroy();
    }
}
