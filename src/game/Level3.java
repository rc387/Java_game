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

public class Level3 extends GameWorld {
    private int timeRemaining = 180;
    private Timer levelTimer;
    private SoundClip Level3SoundClip;
    public Level3(){
        Character player = new Character(this);
        player.setPosition(new Vec2(260f, 2)); player.setLinearVelocity(new Vec2(0, 0));
        player.setAngularVelocity(0); player.setAngle(0);

        GameWorldBackground views = new GameWorldBackground(this,640,595,new ImageIcon("data/background(1)_level3.jpg").getImage(),player,"Expect surprise zoom ins & screen rotations!!",false,false);

        final JFrame frames = new JFrame("Level3"); frames.add(views); frames.pack(); frames.repaint();
        frames.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); frames.setLocationByPlatform(true);
        frames.setResizable(false); frames.revalidate(); frames.setVisible(true); frames.setBackground(Color.BLACK);

        DeathShape deathShape = new DeathShape(this);
        deathShape.setPosition(new Vec2(-1, -100));

        Shape platformShape = new BoxShape(7, 1);
        StaticBody platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(-2.75f, -4.5f));
        platform.addImage(new BodyImage("data/platform_level3.png", 11.5f));

        platformShape = new BoxShape(7, 1);
        platform = new StaticBody(this, platformShape); platform.setPosition(new Vec2(20, -4f));
        platform.addImage(new BodyImage("data/platform_level3.png", 11.5f));

        Zombie_Enemy npcGangsta = new Zombie_Enemy(this, 15, 18,3);
        npcGangsta.setPosition(new Vec2(16, -2f));
        npcGangsta.setAngularVelocity(0); npcGangsta.setAngle(0); npcGangsta.addCollisionListener(npcGangsta);

        Zombie_Enemy npcGangsta1 = new Zombie_Enemy(this, 21, 24.5f,3);
        npcGangsta1.setPosition(new Vec2(22, -2f));
        npcGangsta1.setAngularVelocity(0); npcGangsta1.setAngle(0); npcGangsta1.addCollisionListener(npcGangsta);

        Dynamic_Platform dynamicPlatform = new Dynamic_Platform(this, 40, -20,new BodyImage("data/platform_level3.png",10));
        dynamicPlatform.setPosition(new Vec2(35, -4f));
        dynamicPlatform.setLinearVelocity(new Vec2(0, 0));
        dynamicPlatform.setAngularVelocity(0); dynamicPlatform.setAngle(0);

        platformShape = new BoxShape(8, 1);
        platform = new StaticBody(this, platformShape); platform.setPosition(new Vec2(55, -12f));
        platform.addImage(new BodyImage("data/platform_level3.png", 12f));

        Zombie_Enemy npcGangsta2 = new Zombie_Enemy(this, 50, 54f,3);
        npcGangsta2.setPosition(new Vec2(51, -10f));
        npcGangsta2.setAngularVelocity(0); npcGangsta2.setAngle(0); npcGangsta2.addCollisionListener(npcGangsta);

        Zombie_Enemy npcGangsta3 = new Zombie_Enemy(this, 58f, 62f,3);
        npcGangsta3.setPosition(new Vec2(59f, -10f));
        npcGangsta3.setAngularVelocity(0); npcGangsta3.setAngle(0); npcGangsta3.addCollisionListener(npcGangsta);

        platformShape = new BoxShape(3.5f, 0.5f);
        platform = new StaticBody(this, platformShape); platform.setPosition(new Vec2(70, -7f));
        platform.addImage(new BodyImage("data/platform_level3.png", 6f));

        platformShape = new BoxShape(6, 1);
        platform = new StaticBody(this, platformShape); platform.setPosition(new Vec2(83, -3f));
        platform.addImage(new BodyImage("data/platform_level3.png", 10f));

        Zombie_Enemy npcGangsta4 = new Zombie_Enemy(this, 78, 82f,3);
        npcGangsta4.setPosition(new Vec2(79.5f, -1f));
        npcGangsta4.setAngularVelocity(0); npcGangsta4.setAngle(0); npcGangsta4.addCollisionListener(npcGangsta);

        Zombie_Enemy npcGangsta5 = new Zombie_Enemy(this, 85f, 89f,3);
        npcGangsta5.setPosition(new Vec2(85f, -1f));
        npcGangsta5.setAngularVelocity(0); npcGangsta5.setAngle(0); npcGangsta5.addCollisionListener(npcGangsta);

        Dynamic_Platform dynamicPlatform2 = new Dynamic_Platform(this, 40, -20,new BodyImage("data/platform_level3.png",10));
        dynamicPlatform2.setPosition(new Vec2(97, -3f));
        dynamicPlatform2.setLinearVelocity(new Vec2(0, 20));
        dynamicPlatform2.setAngularVelocity(0); dynamicPlatform2.setAngle(0);

        platformShape = new BoxShape(9, 1);
        platform = new StaticBody(this, platformShape); platform.setPosition(new Vec2(113, -14f));
        platform.addImage(new BodyImage("data/platform_level3.png", 13f));

        Zombie_Enemy npcGangsta6 = new Zombie_Enemy(this, 105, 109,3);
        npcGangsta6.setPosition(new Vec2(106f, -12f));
        npcGangsta6.setAngularVelocity(0); npcGangsta6.setAngle(0); npcGangsta6.addCollisionListener(npcGangsta);

        Zombie_Enemy npcGangsta7 = new Zombie_Enemy(this, 111f, 115f,3);
        npcGangsta7.setPosition(new Vec2(112f, -12f));
        npcGangsta7.setAngularVelocity(0); npcGangsta7.setAngle(0); npcGangsta7.addCollisionListener(npcGangsta);

        platformShape = new BoxShape(4.5f, 0.5f);
        platform = new StaticBody(this, platformShape); platform.setPosition(new Vec2(125, -9f));
        platform.addImage(new BodyImage("data/platform_level3.png", 7.5f));

        Zombie_Enemy npcGangsta8 = new Zombie_Enemy(this, 121.5f, 125f,3);
        npcGangsta8.setPosition(new Vec2(120f, -7f));
        npcGangsta8.setAngularVelocity(0); npcGangsta8.setAngle(0); npcGangsta8.addCollisionListener(npcGangsta);

        platformShape = new BoxShape(4.5f, 0.5f);
        platform = new StaticBody(this, platformShape); platform.setPosition(new Vec2(135, -4f));
        platform.addImage(new BodyImage("data/platform_level3.png", 7.5f));

        Zombie_Enemy npcGangsta9 = new Zombie_Enemy(this, 134.5f, 140f,3);
        npcGangsta9.setPosition(new Vec2(134f, -2f));
        npcGangsta9.setAngularVelocity(0); npcGangsta9.setAngle(0); npcGangsta9.addCollisionListener(npcGangsta);

        platformShape = new BoxShape(8, 1);
        platform = new StaticBody(this, platformShape); platform.setPosition(new Vec2(143, -13f));
        platform.addImage(new BodyImage("data/platform_level3.png", 12f));

        Zombie_Enemy npcGangsta10 = new Zombie_Enemy(this, 138, 142f,3);
        npcGangsta10.setPosition(new Vec2(139f, -11f));
        npcGangsta10.setAngularVelocity(0); npcGangsta10.setAngle(0); npcGangsta10.addCollisionListener(npcGangsta);

        Zombie_Enemy npcGangsta11 = new Zombie_Enemy(this, 144f, 148f,3);
        npcGangsta11.setPosition(new Vec2(145f, -11f));
        npcGangsta11.setAngularVelocity(0); npcGangsta11.setAngle(0); npcGangsta11.addCollisionListener(npcGangsta);

        Dynamic_Platform dynamicPlatform3 = new Dynamic_Platform(this, 40, -20,new BodyImage("data/platform_level3.png",10));
        dynamicPlatform3.setPosition(new Vec2(160, -13f));
        dynamicPlatform3.setLinearVelocity(new Vec2(0, 20));
        dynamicPlatform3.setAngularVelocity(0); dynamicPlatform3.setAngle(0);

        platformShape = new BoxShape(7, 1);
        platform = new StaticBody(this, platformShape); platform.setPosition(new Vec2(173, -6f));
        platform.addImage(new BodyImage("data/platform_level3.png", 11f));

        Zombie_Enemy npcGangsta12 = new Zombie_Enemy(this, 167, 170,3);
        npcGangsta12.setPosition(new Vec2(168.5f, -4f));
        npcGangsta12.setAngularVelocity(0); npcGangsta12.setAngle(0); npcGangsta12.addCollisionListener(npcGangsta);

        platformShape = new BoxShape(3.5f, 0.5f);
        platform = new StaticBody(this, platformShape); platform.setPosition(new Vec2(185, -3f));
        platform.addImage(new BodyImage("data/platform_level3.png", 6f));

        Dynamic_Platform dynamicPlatform4 = new Dynamic_Platform(this, 40, -20,new BodyImage("data/platform_level3.png",10));
        dynamicPlatform4.setPosition(new Vec2(200, -3f));
        dynamicPlatform4.setLinearVelocity(new Vec2(0, 20));
        dynamicPlatform4.setAngularVelocity(0); dynamicPlatform4.setAngle(0);

        platformShape = new BoxShape(10, 1);
        platform = new StaticBody(this, platformShape); platform.setPosition(new Vec2(215, -14f));
        platform.addImage(new BodyImage("data/platform_level3.png", 14f));

        Zombie_Enemy npcGangsta13 = new Zombie_Enemy(this, 206.5f, 208.2f,3);
        npcGangsta13.setPosition(new Vec2(207.5f, -12f));
        npcGangsta13.setAngularVelocity(0); npcGangsta13.setAngle(0); npcGangsta13.addCollisionListener(npcGangsta);

        Zombie_Enemy npcGangsta14 = new Zombie_Enemy(this, 218.5f, 220.5f,3);
        npcGangsta14.setPosition(new Vec2(219.5f, -12f));
        npcGangsta14.setAngularVelocity(0); npcGangsta14.setAngle(0); npcGangsta14.addCollisionListener(npcGangsta);

        platformShape = new BoxShape(6, 1);
        platform = new StaticBody(this, platformShape); platform.setPosition(new Vec2(232, -8f));
        platform.addImage(new BodyImage("data/platform_level3.png", 10f));

        platformShape = new BoxShape(6, 1);
        platform = new StaticBody(this, platformShape); platform.setPosition(new Vec2(242, -3f));
        platform.addImage(new BodyImage("data/platform_level3.png", 10f));

        platformShape = new BoxShape(12, 1);
        platform = new StaticBody(this, platformShape); platform.setPosition(new Vec2(255, -14f));
        platform.addImage(new BodyImage("data/platform_level3.png", 14f));

        Enemy_attack stave = new Enemy_attack(this);
        stave.setPosition(new Vec2(15f, 100f)); stave.setAngle(0f); stave.setAngularVelocity(0f);
        int x = 30; int y = 175;
        for (int i = 0; i < 35; i++) {
            x = x + 5;
            stave = new Enemy_attack(this);
            stave.setPosition(new Vec2(x+ 7.5f, y + 50 ));
        }

        Flag flagImage = new Flag(this); flagImage.setPosition(new Vec2(250, -10));
        flagImage.addImage(new BodyImage("data/Flag(1).png", 5.5f));

        Shape GoldCoin = new BoxShape(2, 10);
        StaticBody GoldCoinBody = new StaticBody(this, GoldCoin);
        GoldCoinBody.setPosition(new Vec2(255, 2.5f));
        GoldCoinBody.addImage(new BodyImage("data/PNG/Gold/Gold_21.png", 5));

        Hearts heart = new Hearts(this);
        heart.setPosition(new Vec2(20, -4));
        heart.addImage(new BodyImage("data/PNG/Bronze/Bronze_11.png",1.5f));
        int x1 = 30;
        for (int i = 0; i < 15; i++) {
            x1 = x1 + 15;
            heart = new Hearts(this);
            heart.setPosition(new Vec2(x1 + 40, 5.5f)); heart.setAngle(0f); heart.setAngularVelocity(0f);
            heart.addImage(new BodyImage("data/PNG/Bronze/Bronze_11.png",1.5f));
        }

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
        try {
            Level3SoundClip = new SoundClip("data/4-gotham-at-night.wav");
            Level3SoundClip.loop();
        }catch (Exception e){
            e.printStackTrace();
        }

        final double[] z = {1};
        Level3SoundClip.setVolume(z[0]);
        player.gainLife();
        final boolean[] moveRight = {false}; final boolean[] moveLeft = {false}; final boolean[] pauseState = {false};
        PlayerCollision listener = new PlayerCollision(player);
        player.addCollisionListener(listener);
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
                    player.addImage( new BodyImage("data/Shinobi/Jump(1).png", 5.5f));
                }

                else if (e.getKeyCode() == KeyEvent.VK_S) {
                    listener.setShield(true);
                    player.setLinearVelocity(new Vec2(player.getLinearVelocity().x, player.getLinearVelocity().y));
                    player.removeAllImages();
                    player.addImage(new BodyImage("data/Shinobi/Shield(1).png", 5.5f));
                }

                else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
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
                    Level3SoundClip.pause();
                } else if (e.getKeyCode() == KeyEvent.VK_U) {
                    Level3SoundClip.resume();
                }else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    Level3SoundClip.setVolume(z[0] += 0.1);
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    Level3SoundClip.setVolume(z[0] -= 0.1);
                } else if (e.getKeyCode() == KeyEvent.VK_P) {
                    if(!pauseState[0]) {
                        Level3.this.stop();
                        pauseState[0] = true;
                        views.setPaused(true);
                        Level3SoundClip.pause();
                    } else {
                        Level3.this.start();
                        pauseState[0] = false;
                        views.setPaused(false);
                        Level3SoundClip.resume();
                    }} else if (e.getKeyCode() == KeyEvent.VK_R) {
                    Level3.this.stop();
                    levelTimer.stop();
                    Level3SoundClip.close();
                    frames.dispose();
                    new Level3();
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

                else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    listener.setCanDamage(false);
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
            if(!pauseState[0]) {
            if (timeRemaining >= 0) {
                timeRemaining--;
            } else {
                levelTimer.stop(); ((Timer)e.getSource()).stop();
                player.loseLife(); player.loseLife(); player.loseLife(); player.playerDeath();
                player.setLinearVelocity(new Vec2(0f,0f));
                Level3SoundClip.close(); listener.setCanDamage(false);
            }
        }});
        levelTimer.start();

        Enemy_attack finalStave = stave;
        Hearts finalHeart = heart;
        this.addStepListener(new StepListener() {
            public void preStep(StepEvent e) {
                if (moveRight[0]) { player.setLinearVelocity(new Vec2(10, player.getLinearVelocity().y));}
                else if (moveLeft[0]) { player.setLinearVelocity(new Vec2(-10, player.getLinearVelocity().y));}
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
                dynamicPlatform.update(); dynamicPlatform.setAngle(0f); dynamicPlatform.setAngularVelocity(0f);
                dynamicPlatform2.update(); dynamicPlatform2.setAngle(0f); dynamicPlatform2.setAngularVelocity(0f);
                dynamicPlatform3.update(); dynamicPlatform3.setAngle(0f); dynamicPlatform3.setAngularVelocity(0f);
                dynamicPlatform4.update(); dynamicPlatform4.setAngle(0f); dynamicPlatform4.setAngularVelocity(0f);
                finalStave.setAngle(0f); finalStave.setAngularVelocity(0f);
                finalHeart.setAngle(0); finalHeart.setAngularVelocity(0f);
                views.setCentre(player.getPosition()); player.setAngle(0f); player.setAngularVelocity(0f);
                views.setZoom(10f);

                if(player.getPosition().x > 30 && player.getPosition().x < 50){ views.setZoom(30f);}
                else if (player.getPosition().x > 152 && player.getPosition().x < 165) { views.setZoom(-23f);}
                else if (player.getPosition().x > 177 && player.getPosition().x < 197) { views.setZoom(17f);}
                else if (player.getPosition().x > 214 && player.getPosition().x < 233) { views.setZoom(-41f);}
                else if (player.getPosition().x > 242 && player.getPosition().x < 252) { views.setZoom(6f);}
                else if (player.getPosition().x > 266 && player.getPosition().x < 274) { views.setZoom(33f);}
                if(player.getPosition().x > 250 && player.getPosition().y > -14.5f){
                    Level3.this.stop();
                    levelTimer.stop();
                    Level3SoundClip.close();
                    frames.dispose();
                    Level4.main();
                }
            }

            @Override
            public void postStep(StepEvent e) {}
        });
        this.start();
    }
    static void main() {
        new Level3();
    }
}
