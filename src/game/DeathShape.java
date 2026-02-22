package game;
import city.cs.engine.*;
public class DeathShape extends StaticBody {
    private static final Shape deathShape = new BoxShape(1000, 1); // Used to make image always catch the player.
    public DeathShape(World world) {
        super(world, deathShape);
    }
}
