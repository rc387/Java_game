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

        DeathShape deathShape = new DeathShape(this);
        deathShape.setPosition(new Vec2(-1f, -100f));

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

        platformShape = new BoxShape(6f, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(78f, -7.5f));
        platform.addImage(new BodyImage("data/platform(1).png", 10f));

        Enemy npcGangsta1 = new Enemy(this, 73, 77);
        npcGangsta1.setPosition(new Vec2(74f, -6f));
        npcGangsta1.setAngularVelocity(0f);
        npcGangsta1.setAngle(0f);

        Enemy npcGangsta2 = new Enemy(this, 78.5f, 82.5f);
        npcGangsta2.setPosition(new Vec2(82f, -6f));
        npcGangsta2.setAngularVelocity(0f);
        npcGangsta2.setAngle(0f);

        platformShape = new BoxShape(5f, 0.5f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(92f, -3f));
        platform.addImage(new BodyImage("data/platform(1).png", 8f));

        Enemy npcGangsta3 = new Enemy(this, 88, 96.5f);
        npcGangsta3.setPosition(new Vec2(92f, -1f));
        npcGangsta3.setAngularVelocity(0f);
        npcGangsta3.setAngle(0f);

        platformShape = new BoxShape(7f, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(110f, -12f));
        platform.addImage(new BodyImage("data/platform(2).png", 11f));

        Enemy npcGangsta4 = new Enemy(this, 102, 106);
        npcGangsta4.setPosition(new Vec2(106f, -10f));
        npcGangsta4.setAngularVelocity(0f);
        npcGangsta4.setAngle(0f);

        Enemy npcGangsta5 =  new Enemy(this, 110.5f, 114.5f);
        npcGangsta5.setPosition(new Vec2(114f, -10f));
        npcGangsta5.setAngularVelocity(0f);
        npcGangsta5.setAngle(0f);

        platformShape = new BoxShape(6f, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(128f, -6f));
        platform.addImage(new BodyImage("data/platform(1).png", 10f));

        platformShape = new BoxShape(8f, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(150f, -14f));
        platform.addImage(new BodyImage("data/platform(2).png", 12f));

        Enemy npcGangsta6 = new Enemy(this, 142, 144.5f);
        npcGangsta6.setPosition(new Vec2(146f, -12f));
        npcGangsta6.setAngularVelocity(0f);
        npcGangsta6.setAngle(0f);

        Enemy npcGangsta7 = new Enemy(this, 147.5f, 150f);
        npcGangsta7.setPosition(new Vec2(150.5f, -12f));
        npcGangsta7.setAngularVelocity(0f);
        npcGangsta7.setAngle(0f);

        Enemy npcGangsta8 = new Enemy(this, 152, 154.5f);
        npcGangsta8.setPosition(new Vec2(155.5f, -12f));
        npcGangsta8.setAngularVelocity(0f);
        npcGangsta8.setAngle(0f);

        platformShape = new BoxShape(5f, 0.5f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(168f, -8f));
        platform.addImage(new BodyImage("data/platform(1).png", 8f));

        platformShape = new BoxShape(5f, 0.5f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(182f, -4f));
        platform.addImage(new BodyImage("data/platform(1).png", 8f));

        Enemy npcGangsta9 = new Enemy(this, 178, 183.5f);
        npcGangsta9.setPosition(new Vec2(182f, -2f));
        npcGangsta9.setAngularVelocity(0f);
        npcGangsta9.setAngle(0f);

        platformShape = new BoxShape(7f, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(200f, -14f));
        platform.addImage(new BodyImage("data/platform(2).png", 11f));

        Enemy npcGangsta10 = new Enemy(this, 192, 198);
        npcGangsta10.setPosition(new Vec2(196f, -12f));
        npcGangsta10.setAngularVelocity(0f);
        npcGangsta10.setAngle(0f);

        Enemy npcGangsta11 = new Enemy(this, 200f, 206f);
        npcGangsta11.setPosition(new Vec2(204f, -12f));
        npcGangsta11.setAngularVelocity(0f);
        npcGangsta11.setAngle(0f);

        platformShape = new BoxShape(6f, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(220f, -9f));
        platform.addImage(new BodyImage("data/platform(1).png", 10f));

        platformShape = new BoxShape(5f, 0.5f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(235f, -4f));
        platform.addImage(new BodyImage("data/platform(1).png", 8f));

        Enemy npcGangsta12 = new Enemy(this, 231, 239);
        npcGangsta12.setPosition(new Vec2(235f, -2f));
        npcGangsta12.setAngularVelocity(0f);
        npcGangsta12.setAngle(0f);

        platformShape = new BoxShape(9f, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(255f, -14f));
        platform.addImage(new BodyImage("data/platform(2).png", 13f));

        Enemy npcGangsta13 = new Enemy(this, 247, 249.5f);
        npcGangsta13.setPosition(new Vec2(251f, -12f));
        npcGangsta13.setAngularVelocity(0f);
        npcGangsta13.setAngle(0f);

        Enemy npcGangsta14 = new Enemy(this, 252, 254.5f);
        npcGangsta14.setPosition(new Vec2(255f, -12f));
        npcGangsta14.setAngularVelocity(0f);
        npcGangsta14.setAngle(0f);

        Enemy npcGangsta15 = new Enemy(this, 257.5f, 260);
        npcGangsta15.setPosition(new Vec2(260f, -12f));
        npcGangsta15.setAngularVelocity(0f);
        npcGangsta15.setAngle(0f);

        platformShape = new BoxShape(12f, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(285f, -14f));
        platform.addImage(new BodyImage("data/platform(2).png", 16f));

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
        final boolean[] canDamage = { false };
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
                player.applyImpulse(new Vec2(0f, 110f));
                player.removeAllImages();
                player.addImage( new BodyImage("data/Fighter/Jump(3.2).png", 5.5f));
               }

            else if (e.getKeyCode() == KeyEvent.VK_S) {
                listener.setShield(true);
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
                    listener.setShield(false);
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
                npcGangsta.update(); npcGangsta.setAngle(0f); npcGangsta.setAngularVelocity(0f);
                npcGangsta1.update(); npcGangsta1.setAngle(0f); npcGangsta1.setAngularVelocity(0f);
                npcGangsta2.update(); npcGangsta2.setAngle(0f); npcGangsta2.setAngularVelocity(0f);
                npcGangsta3.update(); npcGangsta3.setAngle(0f); npcGangsta3.setAngularVelocity(0f);
                npcGangsta4.update(); npcGangsta4.setAngle(0f); npcGangsta4.setAngularVelocity(0f);
                npcGangsta5.update(); npcGangsta5.setAngle(0f); npcGangsta5.setAngularVelocity(0f);
                npcGangsta6.update(); npcGangsta6.setAngle(0f); npcGangsta6.setAngularVelocity(0f);
                npcGangsta7.update(); npcGangsta7.setAngle(0f); npcGangsta7.setAngularVelocity(0f);
                npcGangsta8.update(); npcGangsta8.setAngle(0f); npcGangsta8.setAngularVelocity(0f);
                npcGangsta9.update(); npcGangsta9.setAngle(0f); npcGangsta9.setAngularVelocity(0f);
                npcGangsta10.update(); npcGangsta10.setAngle(0f); npcGangsta10.setAngularVelocity(0f);
                npcGangsta11.update(); npcGangsta11.setAngle(0f); npcGangsta11.setAngularVelocity(0f);
                npcGangsta12.update(); npcGangsta12.setAngle(0f); npcGangsta12.setAngularVelocity(0f);
                npcGangsta13.update(); npcGangsta13.setAngle(0f); npcGangsta13.setAngularVelocity(0f);
                npcGangsta14.update(); npcGangsta14.setAngle(0f); npcGangsta14.setAngularVelocity(0f);
                npcGangsta15.update(); npcGangsta15.setAngle(0f); npcGangsta15.setAngularVelocity(0f);
                view.setCentre(player.getPosition()); player.setAngle(0f); player.setAngularVelocity(0f);
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
