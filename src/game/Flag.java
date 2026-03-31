package game;
import city.cs.engine.*;
public class Flag extends StaticBody {
    private static final Shape flagShape = new BoxShape(1f, 1f);

    static {
        new BodyImage("data/Flag(1).png", 5.5f);
    }

    public Flag(World world) {
        super(world, flagShape);
    }
}
// Author: Jonathan Ross