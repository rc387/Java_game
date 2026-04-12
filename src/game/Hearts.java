package game;

import city.cs.engine.*;
import city.cs.engine.Shape;

public class Hearts extends DynamicBody {
    private static final Shape HeartShape = new BoxShape(1f, 1f);
    private static final BodyImage heart = new BodyImage("data/PNG/Bronze/Bronze_11.png");
    public Hearts(World w) {
        super(w, HeartShape);
        addImage(heart);
    }

    public void destroy(){
        super.destroy();
    }

}
