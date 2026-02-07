package game;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import city.cs.engine.DynamicBody;
import city.cs.engine.AttachedImage;
import city.cs.engine.BodyImage;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.Timer;
public class GameWorld extends World {
    public GameWorld() {


        UserView view = new UserView(this, 640, 565);

        Character player = new Character(this);
        player.setPosition(new Vec2(-15, -9.5f));
        player.setLinearVelocity(new Vec2(0, 0));
        player.setAlwaysActive(false);


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


        platformShape = new BoxShape(1, 0.5f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(0, -1.5f));
        platform.addImage(new BodyImage("data/background.jpg", 35));


        setGravity(0f);


        final JFrame frame = new JFrame("Game world");
        frame.add(view);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        final int[] frameCount = {0};
        final Timer[] runTimer = {null};
        BodyImage[] runFrames = new BodyImage[]{
                new BodyImage("data/Fighter/Run(1).png", 5.5f),
                new BodyImage("data/Fighter/Run(2).png", 5.5f),
                new BodyImage("data/Fighter/Run(3).png", 5.5f),
                new BodyImage("data/Fighter/Run(4).png", 5.5f),
                new BodyImage("data/Fighter/Run(5).png", 5.5f),
                new BodyImage("data/Fighter/Run(6).png", 5.5f),
                new BodyImage("data/Fighter/Run(7).png", 5.5f),
                new BodyImage("data/Fighter/Run(8).png", 5.5f),
        };
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_D:
                        player.setLinearVelocity(new Vec2(20    , player.getLinearVelocity().y));

                        if (runTimer[0] == null) { // only start timer if not already running
                            frameCount[0] = 0;
                            runTimer[0] = new Timer(100, ev -> {
                            player.removeAllImages();
                            player.addImage(runFrames[frameCount[0] % runFrames.length]);
                            frameCount[0] = (frameCount[0] + 1) % runFrames.length;
                            });
                            runTimer[0].start();
                            }



                            break;


                    case KeyEvent.VK_W:
                        player.setLinearVelocity(new Vec2(player.getLinearVelocity().x, 2));
                        BodyImage[] jumpFrames = new BodyImage[] {
                                new BodyImage("data/Fighter/Jump(1).png", 5.5f),
                                new BodyImage("data/Fighter/Jump(2).png", 5.5f),
                                new BodyImage("data/Fighter/Jump(3).png", 5.5f),
                                new BodyImage("data/Fighter/Jump(4).png", 5.5f),
                                new BodyImage("data/Fighter/Jump(5).png", 5.5f),
                                new BodyImage("data/Fighter/Jump(6).png", 5.5f),
                                new BodyImage("data/Fighter/Jump(7).png", 5.5f)
                        };
                        break;
                    case KeyEvent.VK_S:
                        player.setLinearVelocity(new Vec2(player.getLinearVelocity().x, player.getLinearVelocity().y));
                        BodyImage[] shieldFrame = new BodyImage[]{
                                new BodyImage("data/Fighter/Shield(1).png", 5.5f)
                        };
                        break;

                    case KeyEvent.VK_E:
                        player.setLinearVelocity(new Vec2(player.getLinearVelocity().x, player.getLinearVelocity().y));
                        BodyImage[] attackFrame = new BodyImage[]{ new BodyImage("data/Fighter/Attack_3(2).png", 5.5f)};
                        break;
                }
            }

            public void keyReleased(KeyEvent e) {
                if  (e.getKeyCode() == KeyEvent.VK_D) {
                runTimer[0].stop();
                runTimer[0] = null;
                player.removeAllImages();
                player.addImage(new BodyImage("data/Fighter/Idle(1).png", 5.5f));
                player.setLinearVelocity(new Vec2(0, player.getLinearVelocity().y));}
            }

        });

        this.start();

    }
    public static void main(String[] args) {

        new GameWorld();

    }



}
