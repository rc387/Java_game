package game;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;
import java.awt.*;
import javax.swing.JFrame;
import java.io.IOException;
public class GameWorld {
    public GameWorld() {
        World world = new World();

        UserView view = new UserView(world, 800, 625);

        Shape platformShape = new BoxShape(3, 5);
        StaticBody platform = new StaticBody(world, platformShape);
        platform.setPosition(new Vec2(-10.5f, -13.25f));
        platform.addImage(new BodyImage("data/platform.png", 20));


        platformShape = new BoxShape(6, 5);
        platform = new StaticBody(world, platformShape);
        platform.setPosition(new Vec2(20, -13.25f));
        platform.addImage(new BodyImage("data/platform.png", 20));

        platformShape = new BoxShape(6, 0.5f);
        platform = new StaticBody(world, platformShape);
        platform.setPosition(new Vec2(38, -1.5f));
        platform.addImage(new BodyImage("data/platform.png", 9));

        platformShape = new BoxShape(6, 0.5f);
        platform = new StaticBody(world, platformShape);
        platform.setPosition(new Vec2(38, -1.5f));
        platform.addImage(new BodyImage("data/background.jpg", 90));


        final JFrame frame = new JFrame("Game world");
        frame.add(view);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);

        world.start();

    }
    public static void main(String[] args) {

        new GameWorld();
    }


}
