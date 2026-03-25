package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Level2 extends World {
    private int timeRemaining = 95;
    private Timer levelTimer;
    private Timer destroyTimer;
    public Level2()
    {
        GameWorldBackground_Level2 views = new GameWorldBackground_Level2(this,640,565);

        final JFrame frames = new JFrame("Level 2");
        frames.add(views); frames.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); frames.setLocationByPlatform(true);
        frames.setResizable(false); frames.pack(); frames.repaint(); frames.revalidate(); frames.setVisible(true);
        frames.setBackground(Color.BLACK);

        Character player = new Character(this);
        player.setPosition(new Vec2(-7.25f, 2));
        player.setLinearVelocity(new Vec2(0, 0)); player.setAngularVelocity(0); player.setAngle(0);

        Shape platformShape = new BoxShape(7, 1);
        StaticBody platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(-2.75f, -4.5f));
        platform.addImage(new BodyImage("data/platform_level2.png", 11.5f));

        Enemy_Level2 npcGangsta1 = new Enemy_Level2(this, 15, 19);
        npcGangsta1.setPosition(new Vec2(16, -4));
        npcGangsta1.setAngularVelocity(0); npcGangsta1.setAngle(0);

        Enemy_Level2 npcGangsta = new Enemy_Level2(this, 20,28.5f);
        npcGangsta.setPosition(new Vec2(24, -4));
        npcGangsta.setLinearVelocity(new Vec2(0, 0)); npcGangsta.setAngularVelocity(0); npcGangsta.setAngle(0);

        platformShape = new BoxShape(7, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(20, -4.5f));
        platform.addImage(new BodyImage("data/platform_level2.png", 11.5f));

        Dynamic_Platform dynamicPlatform = new Dynamic_Platform(this,40 ,-20);
        dynamicPlatform.setPosition(new Vec2(35, -5f));
        dynamicPlatform.setLinearVelocity(new Vec2(0, 0));
        dynamicPlatform.setAngularVelocity(0); dynamicPlatform.setAngle(0);

        platformShape = new BoxShape(7, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(55, -10f));
        platform.addImage(new BodyImage("data/platform_level2.png", 12f));

        Enemy_Level2 npcGangsta2 = new Enemy_Level2(this, 50, 54);
        npcGangsta2.setPosition(new Vec2(51, -8f));
        npcGangsta2.setAngularVelocity(0); npcGangsta2.setAngle(0);

        Enemy_Level2 npcGangsta3 = new Enemy_Level2(this, 58.5f, 62.5f);
        npcGangsta3.setPosition(new Vec2(59, -8f));
        npcGangsta3.setAngularVelocity(0); npcGangsta3.setAngle(0);

        platformShape = new BoxShape(4, 0.5f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(69, -5f));
        platform.addImage(new BodyImage("data/platform_level2.png", 7f));

        platformShape = new BoxShape(6, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(80, -2f));
        platform.addImage(new BodyImage("data/platform_level2.png", 10f));

        Enemy npcGangsta4 = new Enemy(this, 75, 84);
        npcGangsta4.setPosition(new Vec2(79, 0f));
        npcGangsta4.setAngularVelocity(0); npcGangsta4.setAngle(0);

        Dynamic_Platform dynamicPlatform2 = new Dynamic_Platform(this, 40 ,-20);
        dynamicPlatform2.setPosition(new Vec2(95, -2f));
        dynamicPlatform2.setLinearVelocity(new Vec2(0, 20));
        dynamicPlatform2.setAngularVelocity(0); dynamicPlatform2.setAngle(0);

        platformShape = new BoxShape(9, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(115, 30f));
        platform.addImage(new BodyImage("data/platform_level2.png", 13f));

        Enemy_Level2 npcGangsta5 = new Enemy_Level2(this, 107, 110);
        npcGangsta5.setPosition(new Vec2(108, 32f)); npcGangsta5.setAngularVelocity(0); npcGangsta5.setAngle(0);

        Enemy_Level2 npcGangsta6 = new Enemy_Level2(this, 112, 116);
        npcGangsta6.setPosition(new Vec2(114, 32f)); npcGangsta6.setAngularVelocity(0); npcGangsta6.setAngle(0);

        Enemy_Level2 npcGangsta7 = new Enemy_Level2(this, 118, 122);
        npcGangsta7.setPosition(new Vec2(120, 32f)); npcGangsta7.setAngularVelocity(0); npcGangsta7.setAngle(0);

        platformShape = new BoxShape(5, 0.5f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(132, -10f));
        platform.addImage(new BodyImage("data/platform_level2.png", 8f));

        platformShape = new BoxShape(5, 0.5f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(145, -4f));
        platform.addImage(new BodyImage("data/platform_level2.png", 8f));

        Enemy_Level2 npcGangsta8 = new Enemy_Level2(this, 141, 149);
        npcGangsta8.setPosition(new Vec2(144, -2f)); npcGangsta8.setAngularVelocity(0); npcGangsta8.setAngle(0);

        platformShape = new BoxShape(8, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(165, -13f));
        platform.addImage(new BodyImage("data/platform_level2.png", 12f));

        Enemy_Level2 npcGangsta9 = new Enemy_Level2(this, 158, 162);
        npcGangsta9.setPosition(new Vec2(160, -10f)); npcGangsta9.setAngularVelocity(0); npcGangsta9.setAngle(0);

        Enemy_Level2 npcGangsta10 = new Enemy_Level2(this, 165, 170);
        npcGangsta10.setPosition(new Vec2(168, -10f)); npcGangsta10.setAngularVelocity(0); npcGangsta10.setAngle(0);

        Dynamic_Platform dynamicPlatform3 = new Dynamic_Platform(this,40,-20);
        dynamicPlatform3.setPosition(new Vec2(182, -12f));
        dynamicPlatform3.setLinearVelocity(new Vec2(0, 20));
        dynamicPlatform3.setAngularVelocity(0);dynamicPlatform3.setAngle(0);

        platformShape = new BoxShape(7, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(200, -6f));
        platform.addImage(new BodyImage("data/platform_level2.png", 11f));

        Enemy_Level2 npcGangsta11 = new Enemy_Level2(this, 194, 198);
        npcGangsta11.setPosition(new Vec2(196, -4f));
        npcGangsta11.setAngularVelocity(0); npcGangsta11.setAngle(0);

        Enemy_Level2 npcGangsta12 = new Enemy_Level2(this, 200, 205);
        npcGangsta12.setPosition(new Vec2(203, -4f));
        npcGangsta12.setAngularVelocity(0); npcGangsta12.setAngle(0);

        platformShape = new BoxShape(4, 0.5f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(218, -3f));
        platform.addImage(new BodyImage("data/platform_level2.png", 7f));

        platformShape = new BoxShape(10, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(240, -14f));
        platform.addImage(new BodyImage("data/platform_level2.png", 14f));

        Enemy_Level2 npcGangsta13 = new Enemy_Level2(this, 232, 233.75f);
        npcGangsta13.setPosition(new Vec2(236, -12f));
        npcGangsta13.setAngularVelocity(0); npcGangsta13.setAngle(0);

        Enemy_Level2 npcGangsta14 = new Enemy_Level2(this, 236, 237.75f);
        npcGangsta14.setPosition(new Vec2(239.3f, -12f));
        npcGangsta14.setAngularVelocity(0); npcGangsta14.setAngle(0);

        Enemy_Level2 npcGangsta15 = new Enemy_Level2(this, 240.85f, 242.5f);
        npcGangsta15.setPosition(new Vec2(242.6f, -12f));
        npcGangsta15.setAngularVelocity(0); npcGangsta15.setAngle(0);

        Enemy_Level2 npcGangsta16 = new Enemy_Level2(this, 245.1f, 246.85f);
        npcGangsta16.setPosition(new Vec2(246, -12f));
        npcGangsta16.setAngularVelocity(0); npcGangsta16.setAngle(0);

        platformShape = new BoxShape(6, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(262, -8f));
        platform.addImage(new BodyImage("data/platform_level2.png", 10f));

        platformShape = new BoxShape(6, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(278, -3f));
        platform.addImage(new BodyImage("data/platform_level2.png", 10f));

        platformShape = new BoxShape(12, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(295, -14f));
        platform.addImage(new BodyImage("data/platform_level2.png", 14f));

        Flag flagimage = new Flag(this);
        flagimage.setPosition(new Vec2(290, -10));
        flagimage.addImage(new BodyImage("data/Flag(1).png", 5.5f));

        Shape GoldCoin = new BoxShape(2,10);
        StaticBody GoldCoinBody = new StaticBody(this, GoldCoin);
        GoldCoinBody.setPosition(new Vec2(300, 2.5f));
        GoldCoinBody.addImage(new BodyImage("data/PNG/Gold/Gold_21.png", 5));

        DeathShape deathShape = new DeathShape(this); deathShape.setPosition(new Vec2(-1, -100));

        Shape stopper = new BoxShape(0.2f,1.2f);
        StaticBody stopperBody = new StaticBody(this, stopper);
        stopperBody.setPosition(new Vec2(288, -13f));

        setGravity(9.8f);

        final int[] frameCounter = {0};
        final Timer[] runTimer = {null};

        BodyImage[] runFrames = new BodyImage[]{ // Use of AI:idea of using array to store images.
                new BodyImage("data/Samurai/Run(1).png", 5.5f),
                new BodyImage("data/Samurai/Run(2).png", 5.5f),
                new BodyImage("data/Samurai/Run(3).png", 5.5f),
                new BodyImage("data/Samurai/Run(4).png", 5.5f),
                new BodyImage("data/Samurai/Run(5).png", 5.5f),
                new BodyImage("data/Samurai/Run(6).png", 5.5f),
                new BodyImage("data/Samurai/Run(7).png", 5.5f),
                new BodyImage("data/Samurai/Run(8).png", 5.5f),
        };

        BodyImage[] leftFrames = new BodyImage[]{
                new BodyImage("data/Samurai/RunLeft(1).png", 5.5f),
                new BodyImage("data/Samurai/RunLeft(2).png", 5.5f),
                new BodyImage("data/Samurai/RunLeft(3).png", 5.5f),
                new BodyImage("data/Samurai/RunLeft(4).png", 5.5f),
                new BodyImage("data/Samurai/RunLeft(5).png", 5.5f),
                new BodyImage("data/Samurai/RunLeft(6).png", 5.5f),
                new BodyImage("data/Samurai/RunLeft(7).png", 5.5f),
                new BodyImage("data/Samurai/RunLeft(8).png", 5.5f),
        };
        player.gainLife();
        player.setSoundClip_Level2();
        final boolean[] moveRight = {false};
        final boolean[] moveLeft = {false};
        final boolean[] canDamage = { false };
        PlayerCollision listener = new PlayerCollision(player);
        player.addCollisionListener(listener);
        frames.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    moveRight[0] = !(player.getPosition().x > 285);
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
                    if(player.getPosition().x > 285){
                        player.setLinearVelocity(new Vec2(0f, 0f));
                        player.applyImpulse(new Vec2(0f, 0f));
                    }
                    listener.setCanJump(false);
                    player.applyImpulse(new Vec2(0f, 110f));
                    player.removeAllImages();
                    player.addImage( new BodyImage("data/Samurai/Jump(1).png", 5.5f));
                }

                else if (e.getKeyCode() == KeyEvent.VK_S) {
                    if(player.getPosition().x > 285){
                        player.setLinearVelocity(new Vec2(0f, 0f));
                    }
                    listener.setShield(true);
                    player.setLinearVelocity(new Vec2(player.getLinearVelocity().x, player.getLinearVelocity().y));
                    player.removeAllImages();
                    player.addImage(new BodyImage("data/Samurai/Shield(1).png", 5.5f));
                }

                else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if(player.getPosition().x > 285){
                        player.setLinearVelocity(new Vec2(0f, 0f));
                    }
                    listener.setCanDamage(true);
                    player.setLinearVelocity(new Vec2(player.getLinearVelocity().x, player.getLinearVelocity().y));
                    player.removeAllImages();
                    player.addImage(new BodyImage("data/Samurai/Attack_1(5).png", 5.5f));
                }

                else if (e.getKeyCode() == KeyEvent.VK_A) {
                    moveLeft[0] = true;
                    if(player.getPosition().x > 285){
                        player.setLinearVelocity(new Vec2(0f, 0f));
                    }
                    if (runTimer[0] == null) {
                        frameCounter[0] = 0;
                        runTimer[0] = new Timer(75, ev -> {
                            player.removeAllImages();
                            player.addImage(leftFrames[frameCounter[0] % leftFrames.length]);
                            frameCounter[0] = (frameCounter[0] + 1) % leftFrames.length;
                        });
                        runTimer[0].start();
                    }
                } if(player.getPosition().x > 285){
                    player.finish_Level2();
                } else if (e.getKeyCode() == KeyEvent.VK_M) {
                    player.finish_Level2();
                } else if (e.getKeyCode() == KeyEvent.VK_U) {
                    player.setSoundClip_Level2();
                }
                if(player.getPosition().x > 285){
                    new Level3();
                    frames.getContentPane().removeAll();
                    frames.setVisible(false);
                    player.finish_Level2();}

            }

            public void keyReleased(KeyEvent e) {
                if  (e.getKeyCode() == KeyEvent.VK_D) {
                    moveRight[0]= false;
                    if (runTimer[0] != null) {
                        runTimer[0].stop();
                        runTimer[0] = null;
                    }
                    player.removeAllImages();
                    player.addImage(new BodyImage("data/Samurai/Idle(1).png", 5.5f));
                    player.setLinearVelocity(new Vec2(0, player.getLinearVelocity().y));}

                else if (e.getKeyCode() == KeyEvent.VK_W) {
                    player.removeAllImages();
                    player.addImage(new BodyImage("data/Samurai/Idle(1).png", 5.5f));
                }

                else if (e.getKeyCode() == KeyEvent.VK_S) {
                    listener.setShield(false);
                    player.removeAllImages();
                    player.addImage( new BodyImage("data/Samurai/Idle(1).png", 5.5f));
                }

                else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    canDamage[0] = false;
                    player.removeAllImages();
                    player.addImage( new BodyImage("data/Samurai/Idle(1).png", 5.5f));
                }

                else if (e.getKeyCode() == KeyEvent.VK_A) {
                    moveLeft[0] = false;
                    if (runTimer[0] != null) {
                        runTimer[0].stop();
                        runTimer[0] = null;
                    }
                    player.removeAllImages();
                    player.addImage(new BodyImage("data/Samurai/LeftIdle(1).png", 5.5f));
                    player.setLinearVelocity(new Vec2(0, player.getLinearVelocity().y));
                }
            }
        });
        levelTimer = new Timer(1000, e -> {
            if (timeRemaining >= 0 && (player.getPosition().x < 285)) {
                timeRemaining--;
            } else if (player.getPosition().x > 285) {
                levelTimer.stop();((Timer)e.getSource()).stop();
                moveRight[0] = false; moveLeft[0] = false; canDamage[0] = false;
                player.setLinearVelocity(new Vec2(0f,0f));
            } else {
                levelTimer.stop();
                ((Timer)e.getSource()).stop();
                player.loselife(); player.loselife(); player.loselife();
                player.playerDeath();
                player.setLinearVelocity(new Vec2(0f,0f));
                destroyTimer = new Timer(1000, f -> {
                    player.destroy();
                });destroyTimer.start();
            }
        });
        levelTimer.start();


        this.addStepListener(new StepListener() {
            public void preStep(StepEvent e) {
                if (moveRight[0] && !(player.getPosition().x >285)) {
                    player.setLinearVelocity(new Vec2(10, player.getLinearVelocity().y));
                }
                else if (moveLeft[0] && !(player.getPosition().x >285)) {
                    player.setLinearVelocity(new Vec2(-10, player.getLinearVelocity().y));
                }
                npcGangsta.update_Level2(); npcGangsta.setAngle(0f); npcGangsta.setAngularVelocity(0f);
                npcGangsta1.update_Level2(); npcGangsta1.setAngle(0f); npcGangsta1.setAngularVelocity(0f);
                npcGangsta2.update_Level2(); npcGangsta2.setAngle(0f); npcGangsta2.setAngularVelocity(0f);
                npcGangsta3.update_Level2(); npcGangsta3.setAngle(0f); npcGangsta3.setAngularVelocity(0f);
                npcGangsta4.update_Level2(); npcGangsta4.setAngle(0f); npcGangsta4.setAngularVelocity(0f);
                npcGangsta4.update_Level2(); npcGangsta4.setAngle(0f); npcGangsta4.setAngularVelocity(0f);
                npcGangsta5.update_Level2(); npcGangsta5.setAngle(0f); npcGangsta5.setAngularVelocity(0f);
                npcGangsta6.update_Level2(); npcGangsta6.setAngle(0f); npcGangsta6.setAngularVelocity(0f);
                npcGangsta7.update_Level2(); npcGangsta7.setAngle(0f); npcGangsta7.setAngularVelocity(0f);
                npcGangsta8.update_Level2(); npcGangsta8.setAngle(0f); npcGangsta8.setAngularVelocity(0f);
                npcGangsta9.update_Level2(); npcGangsta9.setAngle(0f); npcGangsta9.setAngularVelocity(0f);
                npcGangsta10.update_Level2(); npcGangsta10.setAngle(0f); npcGangsta10.setAngularVelocity(0f);
                npcGangsta11.update_Level2(); npcGangsta11.setAngle(0f); npcGangsta11.setAngularVelocity(0f);
                npcGangsta12.update_Level2(); npcGangsta12.setAngle(0f); npcGangsta12.setAngularVelocity(0f);
                npcGangsta13.update_Level2(); npcGangsta13.setAngle(0f); npcGangsta13.setAngularVelocity(0f);
                npcGangsta14.update_Level2(); npcGangsta14.setAngle(0f); npcGangsta14.setAngularVelocity(0f);
                npcGangsta15.update_Level2(); npcGangsta15.setAngle(0f); npcGangsta15.setAngularVelocity(0f);
                npcGangsta16.update_Level2(); npcGangsta16.setAngle(0f); npcGangsta16.setAngularVelocity(0f);
                views.setCentre(player.getPosition()); player.setAngle(0f); player.setAngularVelocity(0f);
                dynamicPlatform.update(); dynamicPlatform.setAngle(0f); dynamicPlatform.setAngularVelocity(0f);
                dynamicPlatform2.update(); dynamicPlatform2.setAngle(0f); dynamicPlatform2.setAngularVelocity(0f);
                dynamicPlatform3.update(); dynamicPlatform3.setAngle(0f); dynamicPlatform3.setAngularVelocity(0f);
            }

            @Override
            public void postStep(StepEvent e) {}
        });
        this.start();
    }
    static void main() {
    }
}
