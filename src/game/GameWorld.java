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
import city.cs.engine.DynamicBody;
import city.cs.engine.AttachedImage;
import city.cs.engine.BodyImage;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import java.util.Scanner;
import javax.swing.Timer;
import city.cs.engine.Fixture;

public class GameWorld extends World {
    public GameWorld() {
        GameWorldBackground view = new GameWorldBackground(this,640,565);

        Character player = new Character(this);
        player.setPosition(new Vec2(-7.25f, 2f));
        player.setLinearVelocity(new Vec2(0, 0));
        player.setAngularVelocity(0f);
        player.setAngle(0f);


        Enemy npcGangsta = new Enemy(this, 44,69);
        npcGangsta.setPosition(new Vec2(68f, -14f));
        npcGangsta.setLinearVelocity(new Vec2(0, 0));
        npcGangsta.setAngularVelocity(0f);
        npcGangsta.setAngle(0f);

        Shape platformShape = new BoxShape(7f, 1);
        StaticBody platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(-2.75f, -4.5f));

        platform.addImage(new BodyImage("data/platform(1).png", 11.5f));

        platformShape = new BoxShape(7f, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(20, -4f));
        platform.addImage(new BodyImage("data/platform(1).png", 11.5f));

        platformShape = new BoxShape(7f, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(20, -14f));
        platform.addImage(new BodyImage("data/platform(1).png", 11.5f));

        platformShape = new BoxShape(5.5f, 0.5f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(32.5f, -10.5f));
        platform.addImage(new BodyImage("data/platform(1).png", 9));

        platformShape = new BoxShape(7.5f, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(50, -14f));
        platform.addImage(new BodyImage("data/platform(1).png", 11.5f));

        platformShape = new BoxShape(7.5f, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(63.25f, -14f));
        platform.addImage(new BodyImage("data/platform(2).png", 11.5f));

        setGravity(9.8f);

        final JFrame frame = new JFrame("Game world");
        frame.add(view);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        frame.setBackground(Color.BLACK);
        final int[] frameCounter = {0};
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

        BodyImage[] leftFrames = new BodyImage[]{
                new BodyImage("data/Fighter/RunLeft(1).png", 5.5f),
                new BodyImage("data/Fighter/RunLeft(2).png", 5.5f),
                new BodyImage("data/Fighter/RunLeft(3).png", 5.5f),
                new BodyImage("data/Fighter/RunLeft(4).png", 5.5f),
                new BodyImage("data/Fighter/RunLeft(5).png", 5.5f),
                new BodyImage("data/Fighter/RunLeft(6).png", 5.5f),
                new BodyImage("data/Fighter/RunLeft(7).png", 5.5f),
                new BodyImage("data/Fighter/RunLeft(8).png", 5.5f),
        };


        final boolean[] moveRight = {false};
        final boolean[] moveLeft = {false};
        final boolean[] canJump = { true };
        final boolean[] canDamage = { false };
        final int[] enemy_lives = {1};
        int character_lives = 3;
        PlayerCollision listener = new PlayerCollision();
        player.addCollisionListener(listener);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_D) {
                moveRight[0] = true;
                if (runTimer[0] == null) {
                    frameCounter[0] = 0;
                    runTimer[0] = new Timer(75, _ -> {
                        player.removeAllImages();
                        player.addImage(runFrames[frameCounter[0] % runFrames.length]);
                        frameCounter[0] = (frameCounter[0] + 1) % runFrames.length;
                    });
                    runTimer[0].start();
                } }

            else if (e.getKeyCode() == KeyEvent.VK_W && listener.canJump()) {
                listener.setCanJump(false);
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
                listener.setCanDamage(true);
                player.setLinearVelocity(new Vec2(player.getLinearVelocity().x, player.getLinearVelocity().y));
                player.removeAllImages();
                player.addImage(new BodyImage("data/Fighter/Attack_3(2).png", 5.5f));
            }

            else if (e.getKeyCode() == KeyEvent.VK_A) {
                moveLeft[0] = true;
                if (runTimer[0] == null) {
                    frameCounter[0] = 0;
                    runTimer[0] = new Timer(75, ev -> {
                        player.removeAllImages();
                        player.addImage(leftFrames[frameCounter[0] % leftFrames.length]);
                        frameCounter[0] = (frameCounter[0] + 1) % leftFrames.length;
                    });
                    runTimer[0].start();
                }
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
                    canDamage[0] = false;
                    player.removeAllImages();
                    player.addImage( new BodyImage("data/Fighter/Idle(1).png", 5.5f));
                }

                else if (e.getKeyCode() == KeyEvent.VK_A) {
                    moveLeft[0] = false;
                    if (runTimer[0] != null) {
                        runTimer[0].stop();
                        runTimer[0] = null;
                    }
                    player.removeAllImages();
                    player.addImage(new BodyImage("data/Fighter/LeftIdle(1).png", 5.5f));
                    player.setLinearVelocity(new Vec2(0, player.getLinearVelocity().y));
                }
            }
        });


        this.addStepListener(new StepListener() {
            @Override
            public void preStep(StepEvent e) {
                if (moveRight[0]) {
                    player.setLinearVelocity(new Vec2(10, player.getLinearVelocity().y));
                }
                else if (moveLeft[0]) {
                    player.setLinearVelocity(new Vec2(-10, player.getLinearVelocity().y));
                }
                npcGangsta.update();
                view.setCentre(player.getPosition());
                player.setAngle(0f);
                player.setAngularVelocity(0f);
                npcGangsta.setAngle(0f);
                npcGangsta.setAngularVelocity(0f);
            }

            @Override
            public void postStep(StepEvent e) {}
        });

        this.start();
    }

    static void main(String[] args) {
        new GameWorld();
    }
}
