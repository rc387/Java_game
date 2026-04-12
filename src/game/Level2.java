package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Level2 extends GameWorld {
    private int timeRemaining = 180;
    private Timer levelTimer;
    private SoundClip Level2SoundClip;
    public Level2() {
        Character player = new Character(this);
        player.setPosition(new Vec2(-7.25f, 2));
        player.setLinearVelocity(new Vec2(0, 0)); player.setAngularVelocity(0); player.setAngle(0);

        GameWorldBackground views = new GameWorldBackground(this,640,595,new ImageIcon("data/background(1)_level2.jpg").getImage(),player,"Platforms are now dynamic" ,false,true);

        final JFrame frames = new JFrame("Level 2");
        frames.add(views); frames.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); frames.setLocationByPlatform(true);
        frames.setResizable(false); frames.pack(); frames.repaint(); frames.revalidate(); frames.setVisible(true);
        frames.setBackground(Color.BLACK);

        Shape platformShape = new BoxShape(7, 1);
        StaticBody platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(-2.75f, -4.5f));
        platform.addImage(new BodyImage("data/platform_level2.png", 11.5f));

        Raider_Enemy npcGangsta = new Raider_Enemy(this, 15, 19,1);
        npcGangsta.setPosition(new Vec2(16, -4));
        npcGangsta.setAngularVelocity(0); npcGangsta.setAngle(0);

        Raider_Enemy npcGangsta1 = new Raider_Enemy(this, 20,28.5f,1);
        npcGangsta1.setPosition(new Vec2(24, -4));
        npcGangsta1.setLinearVelocity(new Vec2(0, 0)); npcGangsta1.setAngularVelocity(0); npcGangsta1.setAngle(0);

        platformShape = new BoxShape(7, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(20, -4.5f));
        platform.addImage(new BodyImage("data/platform_level2.png", 11.5f));

        Dynamic_Platform dynamicPlatform = new Dynamic_Platform(this,40 ,-20,new BodyImage("data/platform_level2.png",10)); // Initialises the dynamicPlatform object.
        dynamicPlatform.setPosition(new Vec2(35, -5f));
        dynamicPlatform.setLinearVelocity(new Vec2(0, 0));
        dynamicPlatform.setAngularVelocity(0); dynamicPlatform.setAngle(0);

        platformShape = new BoxShape(7, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(55, -10f));
        platform.addImage(new BodyImage("data/platform_level2.png", 12f));

        Raider_Enemy npcGangsta2 = new Raider_Enemy(this, 50, 54,1);
        npcGangsta2.setPosition(new Vec2(51, -8f));
        npcGangsta2.setAngularVelocity(0); npcGangsta2.setAngle(0);

        Raider_Enemy npcGangsta3 = new Raider_Enemy(this, 58.5f, 62.5f,1);
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

        Raider_Enemy npcGangsta4 = new Raider_Enemy(this, 75, 84,1);
        npcGangsta4.setPosition(new Vec2(79, 0f));
        npcGangsta4.setAngularVelocity(0); npcGangsta4.setAngle(0);

        Dynamic_Platform dynamicPlatform2 = new Dynamic_Platform(this, 40 ,-20,new BodyImage("data/platform_level2.png",10));
        dynamicPlatform2.setPosition(new Vec2(95, -2f));
        dynamicPlatform2.setLinearVelocity(new Vec2(0, 20));
        dynamicPlatform2.setAngularVelocity(0); dynamicPlatform2.setAngle(0);

        platformShape = new BoxShape(9, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(115, 30f));
        platform.addImage(new BodyImage("data/platform_level2.png", 13f));

        Raider_Enemy npcGangsta5 = new Raider_Enemy(this, 107, 110,1);
        npcGangsta5.setPosition(new Vec2(108, 32f)); npcGangsta5.setAngularVelocity(0); npcGangsta5.setAngle(0);

        Raider_Enemy npcGangsta6 = new Raider_Enemy(this, 114, 118,1);
        npcGangsta6.setPosition(new Vec2(115, 32f)); npcGangsta6.setAngularVelocity(0); npcGangsta6.setAngle(0);

        platformShape = new BoxShape(5, 0.5f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(132, -10f));
        platform.addImage(new BodyImage("data/platform_level2.png", 8f));

        platformShape = new BoxShape(5, 0.5f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(145, -4f));
        platform.addImage(new BodyImage("data/platform_level2.png", 8f));

        Raider_Enemy npcGangsta7 = new Raider_Enemy(this, 141, 149,1);
        npcGangsta7.setPosition(new Vec2(144, -2f)); npcGangsta7.setAngularVelocity(0); npcGangsta7.setAngle(0);

        platformShape = new BoxShape(8, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(165, -13f));
        platform.addImage(new BodyImage("data/platform_level2.png", 12f));

        Raider_Enemy npcGangsta8 = new Raider_Enemy(this, 158, 162,1);
        npcGangsta8.setPosition(new Vec2(160, -10f)); npcGangsta8.setAngularVelocity(0); npcGangsta8.setAngle(0);

        Raider_Enemy npcGangsta9 = new Raider_Enemy(this, 165, 170,1);
        npcGangsta9.setPosition(new Vec2(168, -10f));
        npcGangsta9.setAngularVelocity(0); npcGangsta9.setAngle(0);

        Dynamic_Platform dynamicPlatform3 = new Dynamic_Platform(this,40,-20,new BodyImage("data/platform_level2.png",10f));
        dynamicPlatform3.setPosition(new Vec2(182, -12f));
        dynamicPlatform3.setLinearVelocity(new Vec2(0, 20));
        dynamicPlatform3.setAngularVelocity(0);dynamicPlatform3.setAngle(0);

        platformShape = new BoxShape(7, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(200, -6f));
        platform.addImage(new BodyImage("data/platform_level2.png", 11f));

        Raider_Enemy npcGangsta10 = new Raider_Enemy(this, 194, 198,1);
        npcGangsta10.setPosition(new Vec2(196, -4f));
        npcGangsta10.setAngularVelocity(0); npcGangsta10.setAngle(0);

        Raider_Enemy npcGangsta11 = new Raider_Enemy(this, 200, 205,1);
        npcGangsta11.setPosition(new Vec2(203, -4f));
        npcGangsta11.setAngularVelocity(0); npcGangsta11.setAngle(0);

        platformShape = new BoxShape(4, 0.5f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(218, -3f));
        platform.addImage(new BodyImage("data/platform_level2.png", 7f));

        platformShape = new BoxShape(10, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(240, -14f));
        platform.addImage(new BodyImage("data/platform_level2.png", 14f));

        Raider_Enemy npcGangsta12 = new Raider_Enemy(this, 232, 233.75f,1);
        npcGangsta12.setPosition(new Vec2(236, -12f));
        npcGangsta12.setAngularVelocity(0); npcGangsta12.setAngle(0);

        Raider_Enemy npcGangsta13 = new Raider_Enemy(this, 245.1f, 246.85f,1);
        npcGangsta13.setPosition(new Vec2(246, -12f));
        npcGangsta13.setAngularVelocity(0); npcGangsta13.setAngle(0);

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

        Flag flagImage = new Flag(this); flagImage.setPosition(new Vec2(290, -10));
        flagImage.addImage(new BodyImage("data/Flag(1).png", 5.5f));

        Shape GoldCoin = new BoxShape(2,10);
        StaticBody GoldCoinBody = new StaticBody(this, GoldCoin);
        GoldCoinBody.setPosition(new Vec2(300, 2.5f));
        GoldCoinBody.addImage(new BodyImage("data/PNG/Gold/Gold_21.png", 5));

        DeathShape deathShape = new DeathShape(this); deathShape.setPosition(new Vec2(-1, -100));

        Enemy_attack stave = new Enemy_attack(this);
        stave.setPosition(new Vec2(15f, 100f)); stave.setAngle(0f); stave.setAngularVelocity(0f);
        int x1 = 30; int y = 175;
        for (int i = 0; i < 15; i++) {
            x1 = x1 + 15;
            stave = new Enemy_attack(this);
            stave.setPosition(new Vec2(x1+ 17.5f, y + 50 ));
        }

        Hearts heart = new Hearts(this);
        heart.setPosition(new Vec2(20, -4));
        heart.addImage(new BodyImage("data/PNG/Bronze/Bronze_11.png",1.5f));
        int x2 = 30;
        for (int i = 0; i < 20; i++) {
            x2 = x2 + 10;
            heart = new Hearts(this);
            heart.setPosition(new Vec2(x2 + 30, 5.5f)); heart.setAngle(0f); heart.setAngularVelocity(0f);
            heart.addImage(new BodyImage("data/PNG/Bronze/Bronze_11.png",1.5f));
        }

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
        try {
            Level2SoundClip = new SoundClip("data/11-gt-force.wav");
            Level2SoundClip.loop();
        } catch (Exception e) {
            e.printStackTrace();
        }

        final double[] x = {1};
        Raider_Enemy.resetCount();
        Level2SoundClip.setVolume(x[0]);
        player.gainLife();
        final boolean[] moveRight = {false}; final boolean[] moveLeft = {false}; final boolean[] pauseState = {false};
        PlayerCollision listener = new PlayerCollision(player); player.addCollisionListener(listener);
        SoundClip damage;
        try {
            damage = new SoundClip("data/damage1.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
        listener.setLevelSoundClip(damage);
        frames.addKeyListener(new KeyAdapter() {
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
                    player.addImage( new BodyImage("data/Samurai/Jump(1).png", 5.5f));
                }

                else if (e.getKeyCode() == KeyEvent.VK_S) {
                    listener.setShield(true);
                    player.setLinearVelocity(new Vec2(player.getLinearVelocity().x, player.getLinearVelocity().y));
                    player.removeAllImages();
                    player.addImage(new BodyImage("data/Samurai/Shield(1).png", 5.5f));
                }

                else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    listener.setCanDamage(true);
                    player.setLinearVelocity(new Vec2(player.getLinearVelocity().x, player.getLinearVelocity().y));
                    player.removeAllImages();
                    if (moveRight[0]){
                        player.addImage(new BodyImage("data/Samurai/Attack_1(5).png", 5.5f));}

                    else if (moveLeft[0]){
                        player.addImage((new BodyImage("data/Samurai/LeftAttack_1(5).png", 5.5f)));
                    }else {
                        player.addImage(new BodyImage("data/Samurai/Attack_1(5).png", 5.5f));
                    }
                }

                else if (e.getKeyCode() == KeyEvent.VK_A) {
                    moveLeft[0] = true;
                    if (runTimer[0] == null) {
                        frameCounter[0] = 0;
                        runTimer[0] = new Timer(75, ev -> {
                            player.removeAllImages(); ev.paramString();
                            player.addImage(leftFrames[frameCounter[0] % leftFrames.length]);
                            frameCounter[0] = (frameCounter[0] + 1) % leftFrames.length;
                        });
                        runTimer[0].start();
                    }
                } if (e.getKeyCode() == KeyEvent.VK_M) {
                    Level2SoundClip.pause();
                } else if (e.getKeyCode() == KeyEvent.VK_U) {
                    Level2SoundClip.resume();
                }else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    Level2SoundClip.setVolume(x[0] += 0.1);
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    Level2SoundClip.setVolume(x[0] -= 0.1);
                }else if (e.getKeyCode() == KeyEvent.VK_P) {
                    if(!pauseState[0]) {
                        Level2.this.stop();
                        pauseState[0] = true;
                        views.setPaused(true);
                        Level2SoundClip.pause();
                    } else {
                        Level2.this.start();
                        pauseState[0] = false;
                        views.setPaused(false);
                        Level2SoundClip.resume();
                    }
                }else if (e.getKeyCode() == KeyEvent.VK_R) {
                    Level2.this.stop();
                    levelTimer.stop();
                    Level2SoundClip.close();
                    frames.dispose();
                    new Level2();
                }else if (e.getKeyCode() == KeyEvent.VK_Q) {
                    MainMenu.main(new String[]{""});
                }}

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
                    listener.setCanDamage(false);
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
            if(!pauseState[0]) {
            if (timeRemaining >= 0) { timeRemaining--;}
            else {
                levelTimer.stop(); ((Timer)e.getSource()).stop();
                player.loseLife(); player.loseLife(); player.loseLife(); player.playerDeath(); Level2SoundClip.close();
                player.setLinearVelocity(new Vec2(0f,0f));
            }
        }});
        levelTimer.start();


        Hearts finalHeart = heart;
        Enemy_attack finalStave = stave;
        this.addStepListener(new StepListener() {
            public void preStep(StepEvent e) {
                if (moveRight[0]) { player.setLinearVelocity(new Vec2(10, player.getLinearVelocity().y));}
                else if (moveLeft[0]) { player.setLinearVelocity(new Vec2(-10, player.getLinearVelocity().y));}
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
                views.setCentre(player.getPosition()); player.setAngle(0f); player.setAngularVelocity(0f);
                dynamicPlatform.update(); dynamicPlatform.setAngle(0f); dynamicPlatform.setAngularVelocity(0f);
                dynamicPlatform2.update(); dynamicPlatform2.setAngle(0f); dynamicPlatform2.setAngularVelocity(0f);
                dynamicPlatform3.update(); dynamicPlatform3.setAngle(0f); dynamicPlatform3.setAngularVelocity(0f);
                finalStave.setAngle(0f); finalStave.setAngularVelocity(0f);
                finalHeart.setAngle(0); finalHeart.setAngularVelocity(0f);
                if(player.getPosition().x > 285 && player.getPosition().y > -14.5f && Raider_Enemy.getEnemies_left_L2() == 0){ // Done so that every enemy has to be defeated before the level can be completed.
                    Level2.this.stop();
                    levelTimer.stop();
                    Level2SoundClip.close();
                    frames.dispose();
                    Level3.main();
                }
            }

            @Override
            public void postStep(StepEvent e) {}
        });
        this.start();
    }
    static void main() {
        new Level2();
    }
}
