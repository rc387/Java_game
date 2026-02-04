package game;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;
import java.awt.*;
import javax.swing.JFrame;
import java.io.IOException;

import city.cs.engine.AttachedImage;
import city.cs.engine.BodyImage;
import org.jbox2d.common.Vec2;
import city.cs.engine.Body;
public class GameWorld extends World {
    public GameWorld() {


        UserView view = new UserView(this, 640, 565);

        Shape platformShape = new BoxShape(3, 5);
        StaticBody platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(-10.5f, -13.25f));
        platform.addImage(new BodyImage("data/platform.png", 20));


        platformShape = new BoxShape(6, 5);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(20, -13.25f));
        platform.addImage(new BodyImage("data/platform.png", 20));

        platformShape = new BoxShape(6, 0.5f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(38, -1.5f));
        platform.addImage(new BodyImage("data/platform.png", 9));

        Character player = new Character(this);
        player.setPosition(new Vec2(0, 5));

        platformShape = new BoxShape(1, 0.5f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(0, -1.5f));
        platform.addImage(new BodyImage("data/background.jpg", 35));




        final JFrame frame = new JFrame("Game world");
        frame.add(view);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);

        this.start();

    }
    public static void main(String[] args) {

        new GameWorld();
    }



}
