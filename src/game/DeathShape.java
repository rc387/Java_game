package game;
import city.cs.engine.*;
public class DeathShape extends StaticBody {
    private static final Shape deathShape = new BoxShape(261, 1); // Used to make a shape that always catches the player.
    public DeathShape(World world) {
        super(world, deathShape);
    }
}
// Author: Jonathan Ross