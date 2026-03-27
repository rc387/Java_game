package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Level3 extends World {
    private int timeRemaining = 180;
    private Timer levelTimer;
    private Timer destroyTimer;
    public Level3(){
        GameWorldBackground views = new GameWorldBackground(this,640,595,new ImageIcon("data/background(1)_level3.jpg").getImage());

        final JFrame frames = new JFrame("Level3"); frames.add(views); frames.pack(); frames.repaint();
        frames.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); frames.setLocationByPlatform(true);
        frames.setResizable(false); frames.revalidate(); frames.setVisible(true); frames.setBackground(Color.BLACK);

        Character player = new Character(this);
        player.setPosition(new Vec2(-7.25f, 2));
        player.setLinearVelocity(new Vec2(0, 0));
        player.setAngularVelocity(0);
        player.setAngle(0);

        DeathShape deathShape = new DeathShape(this);
        deathShape.setPosition(new Vec2(-1, -100));

        Shape platformShape = new BoxShape(7, 1);
        StaticBody platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(-2.75f, -4.5f));
        platform.addImage(new BodyImage("data/platform_level3.png", 11.5f));

        platformShape = new BoxShape(7, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(20, -4f));
        platform.addImage(new BodyImage("data/platform_level3.png", 11.5f));

        Enemy npcGangsta = new Enemy(this, 14, 17,3);
        npcGangsta.setPosition(new Vec2(15, -2f));
        npcGangsta.setLinearVelocity(new Vec2(0, 0));
        npcGangsta.setAngularVelocity(0); npcGangsta.setAngle(0);

        Enemy npcGangsta1 = new Enemy(this, 21, 24.5f,3);
        npcGangsta1.setPosition(new Vec2(22, -2f));
        npcGangsta1.setAngularVelocity(0); npcGangsta1.setAngle(0);

        Dynamic_Platform dynamicPlatform = new Dynamic_Platform(this, 40, -20,new BodyImage("data/platform_level3.png",10));
        dynamicPlatform.setPosition(new Vec2(35, -4f));
        dynamicPlatform.setLinearVelocity(new Vec2(0, 0));
        dynamicPlatform.setAngularVelocity(0); dynamicPlatform.setAngle(0);

        platformShape = new BoxShape(8, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(55, -12f));
        platform.addImage(new BodyImage("data/platform_level3.png", 12f));

        Enemy npcGangsta2 = new Enemy(this, 48, 50.5f,3);
        npcGangsta2.setPosition(new Vec2(49, -10f));
        npcGangsta2.setAngularVelocity(0); npcGangsta2.setAngle(0);

        Enemy npcGangsta3 = new Enemy(this, 52.5f, 55f,3);
        npcGangsta3.setPosition(new Vec2(53.5f, -10f));
        npcGangsta3.setAngularVelocity(0); npcGangsta3.setAngle(0);

        Enemy npcGangsta4 = new Enemy(this, 57f, 60f,3);
        npcGangsta4.setPosition(new Vec2(58.5f, -10f));
        npcGangsta4.setAngularVelocity(0); npcGangsta4.setAngle(0);

        platformShape = new BoxShape(3.5f, 0.5f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(70, -7f));
        platform.addImage(new BodyImage("data/platform_level3.png", 6f));

        platformShape = new BoxShape(6, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(83, -3f));
        platform.addImage(new BodyImage("data/platform_level3.png", 10f));

        Enemy npcGangsta5 = new Enemy(this, 78, 81f,3);
        npcGangsta5.setPosition(new Vec2(79.5f, -1f));
        npcGangsta5.setAngularVelocity(0); npcGangsta5.setAngle(0);

        Enemy npcGangsta6 = new Enemy(this, 83.5f, 87f,3);
        npcGangsta6.setPosition(new Vec2(85f, -1f));
        npcGangsta6.setAngularVelocity(0); npcGangsta6.setAngle(0);

        Dynamic_Platform dynamicPlatform2 = new Dynamic_Platform(this, 40, -20,new BodyImage("data/platform_level3.png",10));
        dynamicPlatform2.setPosition(new Vec2(97, -3f));
        dynamicPlatform2.setLinearVelocity(new Vec2(0, 20));
        dynamicPlatform2.setAngularVelocity(0); dynamicPlatform2.setAngle(0);

        platformShape = new BoxShape(9, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(113, -14f));
        platform.addImage(new BodyImage("data/platform_level3.png", 13f));

        Enemy npcGangsta7 = new Enemy(this, 105, 107,3);
        npcGangsta7.setPosition(new Vec2(106f, -12f));
        npcGangsta7.setAngularVelocity(0); npcGangsta7.setAngle(0);

        Enemy npcGangsta8 = new Enemy(this, 108.5f, 110.5f,3);
        npcGangsta8.setPosition(new Vec2(109.5f, -12f));
        npcGangsta8.setAngularVelocity(0); npcGangsta8.setAngle(0);

        Enemy npcGangsta9 = new Enemy(this, 112.5f, 114.5f,3);
        npcGangsta9.setPosition(new Vec2(113.5f, -12f));
        npcGangsta9.setAngularVelocity(0); npcGangsta9.setAngle(0);

        Enemy npcGangsta10 = new Enemy(this, 116f, 118f,3);
        npcGangsta10.setPosition(new Vec2(117f, -12f));
        npcGangsta10.setAngularVelocity(0); npcGangsta10.setAngle(0);

        platformShape = new BoxShape(4.5f, 0.5f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(125, -9f));
        platform.addImage(new BodyImage("data/platform_level3.png", 7.5f));

        Enemy npcGangsta11 = new Enemy(this, 125.5f, 132f,3);
        npcGangsta11.setPosition(new Vec2(128f, -7f));
        npcGangsta11.setAngularVelocity(0); npcGangsta11.setAngle(0);

        platformShape = new BoxShape(4.5f, 0.5f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(135, -4f));
        platform.addImage(new BodyImage("data/platform_level3.png", 7.5f));

        Enemy npcGangsta12 = new Enemy(this, 134.5f, 141f,3);
        npcGangsta12.setPosition(new Vec2(134f, -2f));
        npcGangsta12.setAngularVelocity(0); npcGangsta12.setAngle(0);

        platformShape = new BoxShape(8, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(145, -13f));
        platform.addImage(new BodyImage("data/platform_level3.png", 12f));

        Enemy npcGangsta13 = new Enemy(this, 138, 140.5f,3);
        npcGangsta13.setPosition(new Vec2(139f, -11f));
        npcGangsta13.setAngularVelocity(0); npcGangsta13.setAngle(0);

        Enemy npcGangsta14 = new Enemy(this, 142.5f, 145f,3);
        npcGangsta14.setPosition(new Vec2(145f, -11f));
        npcGangsta14.setAngularVelocity(0); npcGangsta14.setAngle(0);

        Enemy npcGangsta15 = new Enemy(this, 147.5f, 150f,3);
        npcGangsta15.setPosition(new Vec2(149f, -11f));
        npcGangsta15.setAngularVelocity(0); npcGangsta15.setAngle(0);

        Dynamic_Platform dynamicPlatform3 = new Dynamic_Platform(this, 40, -20,new BodyImage("data/platform_level3.png",10));
        dynamicPlatform3.setPosition(new Vec2(160, -13f));
        dynamicPlatform3.setLinearVelocity(new Vec2(0, 20));
        dynamicPlatform3.setAngularVelocity(0); dynamicPlatform3.setAngle(0);

        platformShape = new BoxShape(7, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(173, -6f));
        platform.addImage(new BodyImage("data/platform_level3.png", 11f));

        Enemy npcGangsta16 = new Enemy(this, 167, 170,3);
        npcGangsta16.setPosition(new Vec2(168.5f, -4f));
        npcGangsta16.setAngularVelocity(0); npcGangsta16.setAngle(0);

        Enemy npcGangsta17 = new Enemy(this, 172f, 175.5f,3);
        npcGangsta17.setPosition(new Vec2(174f, -4f));
        npcGangsta17.setAngularVelocity(0); npcGangsta17.setAngle(0);

        platformShape = new BoxShape(3.5f, 0.5f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(189, -3f));
        platform.addImage(new BodyImage("data/platform_level3.png", 6f));

        Dynamic_Platform dynamicPlatform4 = new Dynamic_Platform(this, 40, -20,new BodyImage("data/platform_level3.png",10));
        dynamicPlatform4.setPosition(new Vec2(200, -3f));
        dynamicPlatform4.setLinearVelocity(new Vec2(0, 20));
        dynamicPlatform4.setAngularVelocity(0); dynamicPlatform4.setAngle(0);

        platformShape = new BoxShape(10, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(210, -14f));
        platform.addImage(new BodyImage("data/platform_level3.png", 14f));

        Enemy npcGangsta18 = new Enemy(this, 201.5f, 203.2f,3);
        npcGangsta18.setPosition(new Vec2(202.5f, -12f));
        npcGangsta18.setAngularVelocity(0); npcGangsta18.setAngle(0);

        Enemy npcGangsta19 = new Enemy(this, 204.5f, 206.2f,3);
        npcGangsta19.setPosition(new Vec2(205.5f, -12f));
        npcGangsta19.setAngularVelocity(0); npcGangsta19.setAngle(0);

        Enemy npcGangsta20 = new Enemy(this, 207.5f, 209.2f,3);
        npcGangsta20.setPosition(new Vec2(208.5f, -12f));
        npcGangsta20.setAngularVelocity(0); npcGangsta20.setAngle(0);

        Enemy npcGangsta21 = new Enemy(this, 210.5f, 212.2f,3);
        npcGangsta21.setPosition(new Vec2(211.5f, -12f));
        npcGangsta21.setAngularVelocity(0); npcGangsta21.setAngle(0);

        Enemy npcGangsta22 = new Enemy(this, 213.5f, 215.5f,3);
        npcGangsta22.setPosition(new Vec2(214.5f, -12f));
        npcGangsta22.setAngularVelocity(0); npcGangsta22.setAngle(0);

        platformShape = new BoxShape(6, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(227, -8f));
        platform.addImage(new BodyImage("data/platform_level3.png", 10f));

        platformShape = new BoxShape(6, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(241, -3f));
        platform.addImage(new BodyImage("data/platform_level3.png", 10f));

        platformShape = new BoxShape(12, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(255, -14f));
        platform.addImage(new BodyImage("data/platform_level3.png", 14f));

        Shape stopper = new BoxShape(0.2f, 0.2f);
        StaticBody stopperBody = new StaticBody(this, stopper);
        stopperBody.setPosition(new Vec2(249, -13f));

        Flag flagimage = new Flag(this);
        flagimage.setPosition(new Vec2(250, -10));
        flagimage.addImage(new BodyImage("data/Flag(1).png", 5.5f));

        Shape GoldCoin = new BoxShape(2, 10);
        StaticBody GoldCoinBody = new StaticBody(this, GoldCoin);
        GoldCoinBody.setPosition(new Vec2(255, 2.5f));
        GoldCoinBody.addImage(new BodyImage("data/PNG/Gold/Gold_21.png", 5));

        setGravity(9.8f);

        final int[] frameCounter = {0};
        final Timer[] runTimer = {null};

        BodyImage[] runFrames = new BodyImage[]{ // Use of AI:idea of using array to store images.
                new BodyImage("data/Shinobi/Run(1).png", 5.5f),
                new BodyImage("data/Shinobi/Run(2).png", 5.5f),
                new BodyImage("data/Shinobi/Run(3).png", 5.5f),
                new BodyImage("data/Shinobi/Run(4).png", 5.5f),
                new BodyImage("data/Shinobi/Run(5).png", 5.5f),
                new BodyImage("data/Shinobi/Run(6).png", 5.5f),
                new BodyImage("data/Shinobi/Run(7).png", 5.5f),
                new BodyImage("data/Shinobi/Run(8).png", 5.5f),
        };

        BodyImage[] leftFrames = new BodyImage[]{
                new BodyImage("data/Shinobi/LeftRun(1).png", 5.5f),
                new BodyImage("data/Shinobi/LeftRun(2).png", 5.5f),
                new BodyImage("data/Shinobi/LeftRun(3).png", 5.5f),
                new BodyImage("data/Shinobi/LeftRun(4).png", 5.5f),
                new BodyImage("data/Shinobi/LeftRun(5).png", 5.5f),
                new BodyImage("data/Shinobi/LeftRun(6).png", 5.5f),
                new BodyImage("data/Shinobi/LeftRun(7).png", 5.5f),
                new BodyImage("data/Shinobi/LeftRun(8).png", 5.5f),
        };
        player.gainLife();
        player.setSoundClip_Level3();
        final boolean[] moveRight = {false};
        final boolean[] moveLeft = {false};
        final boolean[] canDamage = { false };
        PlayerCollision listener = new PlayerCollision(player);
        player.addCollisionListener(listener);
        frames.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    moveRight[0] = !(player.getPosition().x > 275);
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
                    if(player.getPosition().x > 275){
                        player.setLinearVelocity(new Vec2(0f, 0f));
                        player.applyImpulse(new Vec2(0f, 0f));
                    }
                    listener.setCanJump(false);
                    player.applyImpulse(new Vec2(0f, 110f));
                    player.removeAllImages();
                    player.addImage( new BodyImage("data/Shinobi/Jump(1).png", 5.5f));
                }

                else if (e.getKeyCode() == KeyEvent.VK_S) {
                    if(player.getPosition().x > 275){
                        player.setLinearVelocity(new Vec2(0f, 0f));
                    }
                    listener.setShield(true);
                    player.setLinearVelocity(new Vec2(player.getLinearVelocity().x, player.getLinearVelocity().y));
                    player.removeAllImages();
                    player.addImage(new BodyImage("data/Shinobi/Shield(1).png", 5.5f));
                }

                else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if(player.getPosition().x > 275){
                        player.setLinearVelocity(new Vec2(0f, 0f));
                    }
                    listener.setCanDamage(true);
                    player.setLinearVelocity(new Vec2(player.getLinearVelocity().x, player.getLinearVelocity().y));
                    player.removeAllImages();
                    if (moveRight[0]){
                        player.addImage(new BodyImage("data/Shinobi/Attack_1(4).png", 5.5f));}
                    else if (moveLeft[0]){
                        player.addImage((new BodyImage("data/Shinobi/LeftAttack_1(4).png", 5.5f)));
                    }else {
                        player.addImage(new BodyImage("data/Shinobi/Attack_1(4).png", 5.5f));
                    }
                }

                else if (e.getKeyCode() == KeyEvent.VK_A) {
                    moveLeft[0] = true;
                    if(player.getPosition().x > 275){
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
                } if(player.getPosition().x > 275){
                    player.finish_Level3();
                } else if (e.getKeyCode() == KeyEvent.VK_M) {
                    player.finish_Level3();
                } else if (e.getKeyCode() == KeyEvent.VK_U) {
                    player.setSoundClip_Level3();
                }
                if(player.getPosition().x > 275){
                    new Level4();
                    frames.getContentPane().removeAll();
                    frames.setVisible(false);
                    player.finish_Level3();}

            }

            public void keyReleased(KeyEvent e) {
                if  (e.getKeyCode() == KeyEvent.VK_D) {
                    moveRight[0]= false;
                    if (runTimer[0] != null) {
                        runTimer[0].stop();
                        runTimer[0] = null;
                    }
                    player.removeAllImages();
                    player.addImage(new BodyImage("data/Shinobi/Idle(1).png", 5.5f));
                    player.setLinearVelocity(new Vec2(0, player.getLinearVelocity().y));}

                else if (e.getKeyCode() == KeyEvent.VK_W) {
                    player.removeAllImages();
                    player.addImage(new BodyImage("data/Shinobi/Idle(1).png", 5.5f));
                }

                else if (e.getKeyCode() == KeyEvent.VK_S) {
                    listener.setShield(false);
                    player.removeAllImages();
                    player.addImage( new BodyImage("data/Shinobi/Idle(1).png", 5.5f));
                }

                else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    canDamage[0] = false;
                    player.removeAllImages();
                    player.addImage( new BodyImage("data/Shinobi/Idle(1).png", 5.5f));
                }

                else if (e.getKeyCode() == KeyEvent.VK_A) {
                    moveLeft[0] = false;
                    if (runTimer[0] != null) {
                        runTimer[0].stop();
                        runTimer[0] = null;
                    }
                    player.removeAllImages();
                    player.addImage(new BodyImage("data/Shinobi/Idle(1).png", 5.5f));
                    player.setLinearVelocity(new Vec2(0, player.getLinearVelocity().y));
                }
            }
        });
        levelTimer = new Timer(1000, e -> {
            if (timeRemaining >= 0) {
                timeRemaining--;
            } else {
                levelTimer.stop();
                ((Timer)e.getSource()).stop();
                player.loselife();
                player.loselife();
                player.loselife();
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
                if (moveRight[0] && !(player.getPosition().x > 275)) {
                    player.setLinearVelocity(new Vec2(10, player.getLinearVelocity().y));
                }
                else if (moveLeft[0] && !(player.getPosition().x > 275)) {
                    player.setLinearVelocity(new Vec2(-10, player.getLinearVelocity().y));
                }
                npcGangsta.update_Level3(); npcGangsta.setAngle(0f); npcGangsta.setAngularVelocity(0f);
                npcGangsta1.update_Level3(); npcGangsta1.setAngle(0f); npcGangsta1.setAngularVelocity(0f);
                npcGangsta2.update_Level3(); npcGangsta2.setAngle(0f); npcGangsta2.setAngularVelocity(0f);
                npcGangsta3.update_Level3(); npcGangsta3.setAngle(0f); npcGangsta3.setAngularVelocity(0f);
                npcGangsta4.update_Level3(); npcGangsta4.setAngle(0f); npcGangsta4.setAngularVelocity(0f);
                npcGangsta5.update_Level3(); npcGangsta5.setAngle(0f); npcGangsta5.setAngularVelocity(0f);
                npcGangsta6.update_Level3(); npcGangsta6.setAngle(0f); npcGangsta6.setAngularVelocity(0f);
                npcGangsta7.update_Level3(); npcGangsta7.setAngle(0f); npcGangsta7.setAngularVelocity(0f);
                npcGangsta8.update_Level3(); npcGangsta8.setAngle(0f); npcGangsta8.setAngularVelocity(0f);
                npcGangsta9.update_Level3(); npcGangsta9.setAngle(0f); npcGangsta9.setAngularVelocity(0f);
                npcGangsta10.update_Level3(); npcGangsta10.setAngle(0f); npcGangsta10.setAngularVelocity(0f);
                npcGangsta11.update_Level3(); npcGangsta11.setAngle(0f); npcGangsta11.setAngularVelocity(0f);
                npcGangsta12.update_Level3(); npcGangsta12.setAngle(0f); npcGangsta12.setAngularVelocity(0f);
                npcGangsta13.update_Level3(); npcGangsta13.setAngle(0f); npcGangsta13.setAngularVelocity(0f);
                npcGangsta14.update_Level3(); npcGangsta14.setAngle(0f); npcGangsta14.setAngularVelocity(0f);
                npcGangsta15.update_Level3(); npcGangsta15.setAngle(0f); npcGangsta15.setAngularVelocity(0f);
                npcGangsta16.update_Level3(); npcGangsta16.setAngle(0f); npcGangsta16.setAngularVelocity(0f);
                npcGangsta17.update_Level3(); npcGangsta17.setAngle(0f); npcGangsta17.setAngularVelocity(0f);
                npcGangsta18.update_Level3(); npcGangsta18.setAngle(0f); npcGangsta18.setAngularVelocity(0f);
                npcGangsta19.update_Level3(); npcGangsta19.setAngle(0f); npcGangsta19.setAngularVelocity(0f);
                npcGangsta20.update_Level3(); npcGangsta20.setAngle(0f); npcGangsta20.setAngularVelocity(0f);
                npcGangsta21.update_Level3(); npcGangsta21.setAngle(0f); npcGangsta21.setAngularVelocity(0f);
                npcGangsta22.update_Level3(); npcGangsta22.setAngle(0f); npcGangsta22.setAngularVelocity(0f);
                dynamicPlatform.update(); dynamicPlatform.setAngle(0f); dynamicPlatform.setAngularVelocity(0f);
                dynamicPlatform2.update(); dynamicPlatform2.setAngle(0f); dynamicPlatform2.setAngularVelocity(0f);
                dynamicPlatform3.update(); dynamicPlatform3.setAngle(0f); dynamicPlatform3.setAngularVelocity(0f);
                dynamicPlatform4.update(); dynamicPlatform4.setAngle(0f); dynamicPlatform4.setAngularVelocity(0f);
                views.setCentre(player.getPosition()); player.setAngle(0f); player.setAngularVelocity(0f);

            }

            @Override
            public void postStep(StepEvent e) {}
        });
        this.start();
    }
    static void main() {
    }
}
