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
        player.setPosition(new Vec2(-15, -7f));
        player.setLinearVelocity(new Vec2(0, 0));




        Shape platformShape = new BoxShape(7.5f, 1);
        StaticBody platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(-10.5f, -13.5f));
        platform.addImage(new BodyImage("data/platform(1).png", 11.5f));

        platformShape = new BoxShape(7.5f, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(20, -13.25f));
        platform.addImage(new BodyImage("data/platform(1).png", 11.5f));

        platformShape = new BoxShape(6, 0.5f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(38, -1.5f));
        platform.addImage(new BodyImage("data/platform(1).png", 9));


        platformShape = new BoxShape(1, 0.5f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(0, -3f));
        platform.addImage(new BodyImage("data/background.jpg", 35));

        setGravity(9.8f);



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

        final boolean[] moveRight = {false};

        final boolean[] canJump = { true };
        player.addCollisionListener(new PlayerCollision(canJump));

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                player.setAngularVelocity(0f);
            if (e.getKeyCode() == KeyEvent.VK_D) {
                moveRight[0] = true;
                if (runTimer[0] == null) { // only start timer if not already running
                    frameCount[0] = 0;
                    runTimer[0] = new Timer(100, ev -> {
                        player.removeAllImages();
                        player.addImage(runFrames[frameCount[0] % runFrames.length]);
                        frameCount[0] = (frameCount[0] + 1) % runFrames.length;
                    });
                    runTimer[0].start();
                } }
            else if (e.getKeyCode() == KeyEvent.VK_W && canJump[0]) {
                canJump[0] = false;
                player.applyImpulse(new Vec2(0f, 90f));
                player.removeAllImages();
                player.addImage( new BodyImage("data/Fighter/Jump(3.2).png", 5.5f));
               }


            else if (e.getKeyCode() == KeyEvent.VK_S) {
                player.setLinearVelocity(new Vec2(player.getLinearVelocity().x, player.getLinearVelocity().y));
                player.removeAllImages();
                player.addImage(new BodyImage("data/Fighter/Shield(1).png", 5.5f));
                }

            else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                player.setLinearVelocity(new Vec2(player.getLinearVelocity().x, player.getLinearVelocity().y));
                player.removeAllImages();
                player.addImage(new BodyImage("data/Fighter/Attack_3(2).png", 5.5f));
            }
            }


            public void keyReleased(KeyEvent e) {
                if  (e.getKeyCode() == KeyEvent.VK_D) {
                    moveRight[0]= false;
                    if (runTimer[0] != null) {
                        runTimer[0].stop();
                        runTimer[0] = null;
                    }
                    player.removeAllImages();
                    player.addImage(new BodyImage("data/Fighter/Idle(1).png", 5.5f));
                    player.setLinearVelocity(new Vec2(0, player.getLinearVelocity().y));}
                else if (e.getKeyCode() == KeyEvent.VK_W) {

                    player.removeAllImages();
                    player.addImage(new BodyImage("data/Fighter/Idle(1).png", 5.5f));
                }
                else if (e.getKeyCode() == KeyEvent.VK_S) {
                    player.removeAllImages();
                    player.addImage( new BodyImage("data/Fighter/Idle(1).png", 5.5f));
                }
                else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    player.removeAllImages();
                    player.addImage( new BodyImage("data/Fighter/Idle(1).png", 5.5f));
                }
            }

        });

        this.addStepListener(new StepListener() {

            @Override
            public void preStep(StepEvent e) {
                if (moveRight[0]) {
                    player.setLinearVelocity(
                            new Vec2(10, player.getLinearVelocity().y)
                    );
                }
            }

            @Override
            public void postStep(StepEvent e) {}
        });

        this.start();

    }
    public static void main(String[] args) {

        new GameWorld();

    }



}
