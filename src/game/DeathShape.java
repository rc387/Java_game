package game;
import city.cs.engine.*;
public class DeathShape extends StaticBody {
    private static final Shape deathShape = new BoxShape(1000f, 1f);
    public DeathShape(World world) {
        super(world, deathShape);
    }
}
