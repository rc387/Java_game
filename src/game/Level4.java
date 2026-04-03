package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Level4 extends World {
    private int timeRemaining = 180;
    private Timer levelTimer;
    private SoundClip Level4SoundClip;
    private Character_attack bullet = null;
    public Level4(){

        Character player = new Character(this); player.setPosition(new Vec2(-7.25f, 2));
        player.setLinearVelocity(new Vec2(0, 0)); player.setAngularVelocity(0); player.setAngle(0);

        GameWorldBackground views = new GameWorldBackground(this,640,595,new ImageIcon("data/background(1)_level4.jpg").getImage(),player);

        final JFrame frames = new JFrame("Level4"); frames.add(views); frames.pack(); frames.repaint();
        frames.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); frames.setLocationByPlatform(true);
        frames.setResizable(false); frames.revalidate(); frames.setVisible(true); frames.setBackground(Color.BLACK);

        DeathShape deathShape = new DeathShape(this); deathShape.setPosition(new Vec2(-1, -100));

        Shape platformShape = new BoxShape(7, 2f);
        StaticBody platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(-2.75f, -4.5f));
        platform.addImage(new BodyImage("data/snow_platform.png", 4f));

        platformShape = new BoxShape(7, 2f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(20, -4));
        platform.addImage(new BodyImage("data/snow_platform.png", 4f));

        Enemy npcGangsta = new Enemy(this, 15, 18, 4);
        npcGangsta.setPosition(new Vec2(16, -2f));
        npcGangsta.setAngularVelocity(0); npcGangsta.setAngle(0); npcGangsta.addCollisionListener(npcGangsta);

        Enemy npcGangsta1 = new Enemy(this, 21, 24.5f, 4);
        npcGangsta1.setPosition(new Vec2(22, -2f));
        npcGangsta1.setAngularVelocity(0); npcGangsta1.setAngle(0); npcGangsta1.addCollisionListener(npcGangsta1);

        Dynamic_Platform dynamicPlatform = new Dynamic_Platform(this, 40, -20, new BodyImage("data/snow_platform.png", 4f));
        dynamicPlatform.setPosition(new Vec2(35, -4f)); dynamicPlatform.setLinearVelocity(new Vec2(0, 0));
        dynamicPlatform.setAngularVelocity(0); dynamicPlatform.setAngle(0);

        platformShape = new BoxShape(8, 2f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(55, -12f));
        platform.addImage(new BodyImage("data/snow_platform.png", 4f));

        Enemy npcGangsta2 = new Enemy(this, 50, 54f, 4);
        npcGangsta2.setPosition(new Vec2(51, -10f));
        npcGangsta2.setAngularVelocity(0); npcGangsta2.setAngle(0); npcGangsta2.addCollisionListener(npcGangsta2);

        Enemy npcGangsta3 = new Enemy(this, 58f, 62f, 4);
        npcGangsta3.setPosition(new Vec2(59f, -10f));
        npcGangsta3.setAngularVelocity(0); npcGangsta3.setAngle(0); npcGangsta3.addCollisionListener(npcGangsta3);

        platformShape = new BoxShape(7, 2f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(75, -5f));
        platform.addImage(new BodyImage("data/snow_platform.png", 4f));

        Enemy npcGangsta4 = new Enemy(this, 70, 74f, 4);
        npcGangsta4.setPosition(new Vec2(71f, -3f));
        npcGangsta4.setAngularVelocity(0); npcGangsta4.setAngle(0); npcGangsta4.addCollisionListener(npcGangsta4);

        Enemy npcGangsta5 = new Enemy(this, 77f, 81f, 4);
        npcGangsta5.setPosition(new Vec2(76f, -3f));
        npcGangsta5.setAngularVelocity(0); npcGangsta5.setAngle(0); npcGangsta5.addCollisionListener(npcGangsta5);

        Dynamic_Platform dynamicPlatform2 = new Dynamic_Platform(this, 40, -20, new BodyImage("data/snow_platform.png", 4f));
        dynamicPlatform2.setPosition(new Vec2(92, -3f));
        dynamicPlatform2.setLinearVelocity(new Vec2(0, 20));
        dynamicPlatform2.setAngularVelocity(0); dynamicPlatform2.setAngle(0);

        platformShape = new BoxShape(7, 2f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(113, -14f));
        platform.addImage(new BodyImage("data/snow_platform.png", 4f));

        Enemy npcGangsta6 = new Enemy(this, 108, 112, 4);
        npcGangsta6.setPosition(new Vec2(109f, -12f));
        npcGangsta6.setAngularVelocity(0); npcGangsta6.setAngle(0); npcGangsta6.addCollisionListener(npcGangsta6);

        Enemy npcGangsta7 = new Enemy(this, 115f, 118f, 4);
        npcGangsta7.setPosition(new Vec2(116f, -12f));
        npcGangsta7.setAngularVelocity(0); npcGangsta7.setAngle(0); npcGangsta7.addCollisionListener(npcGangsta7);

        platformShape = new BoxShape(8, 2f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(141, -13f));
        platform.addImage(new BodyImage("data/snow_platform.png", 4f));

        Enemy npcGangsta8 = new Enemy(this, 136, 140f, 4);
        npcGangsta8.setPosition(new Vec2(137f, -11f));
        npcGangsta8.setAngularVelocity(0); npcGangsta8.setAngle(0); npcGangsta8.addCollisionListener(npcGangsta8);

        Enemy npcGangsta9 = new Enemy(this, 142f, 146f, 4);
        npcGangsta9.setPosition(new Vec2(143f, -11f));
        npcGangsta9.setAngularVelocity(0); npcGangsta9.setAngle(0); npcGangsta9.addCollisionListener(npcGangsta9);

        Dynamic_Platform dynamicPlatform3 = new Dynamic_Platform(this, 40, -20, new BodyImage("data/snow_platform.png", 4f));
        dynamicPlatform3.setPosition(new Vec2(158, -13f));
        dynamicPlatform3.setLinearVelocity(new Vec2(0, 20));
        dynamicPlatform3.setAngularVelocity(0); dynamicPlatform3.setAngle(0);

        platformShape = new BoxShape(7, 2f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(173, -6f));
        platform.addImage(new BodyImage("data/snow_platform.png", 4f));

        Enemy npcGangsta10 = new Enemy(this, 167, 170, 4);
        npcGangsta10.setPosition(new Vec2(168.5f, -4f));
        npcGangsta10.setAngularVelocity(0); npcGangsta10.setAngle(0); npcGangsta10.addCollisionListener(npcGangsta10);

        Dynamic_Platform dynamicPlatform4 = new Dynamic_Platform(this, 40, -20, new BodyImage("data/snow_platform.png", 4f));
        dynamicPlatform4.setPosition(new Vec2(195, -3f));
        dynamicPlatform4.setLinearVelocity(new Vec2(0, 20));
        dynamicPlatform4.setAngularVelocity(0); dynamicPlatform4.setAngle(0);

        platformShape = new BoxShape(8, 2f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(215, -14f));
        platform.addImage(new BodyImage("data/snow_platform.png", 4f));

        Enemy npcGangsta11 = new Enemy(this, 211.5f, 213.2f, 4);
        npcGangsta11.setPosition(new Vec2(212.5f, -12f));
        npcGangsta11.setAngularVelocity(0); npcGangsta11.setAngle(0); npcGangsta11.addCollisionListener(npcGangsta11);

        Enemy npcGangsta12 = new Enemy(this, 216f, 220f, 4);
        npcGangsta12.setPosition(new Vec2(217f, -12f));
        npcGangsta12.setAngularVelocity(0); npcGangsta12.setAngle(0); npcGangsta12.addCollisionListener(npcGangsta12);

        platformShape = new BoxShape(7f, 2f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(232, -8f));
        platform.addImage(new BodyImage("data/snow_platform.png", 4f));

        Enemy npcGangsta13 = new Enemy(this, 229f, 233f, 4);
        npcGangsta13.setPosition(new Vec2(231f, -6f));
        npcGangsta13.setAngularVelocity(0); npcGangsta13.setAngle(0); npcGangsta13.addCollisionListener(npcGangsta13);

        platformShape = new BoxShape(7f, 2f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(242, -3f));
        platform.addImage(new BodyImage("data/snow_platform.png", 4f));

        Enemy npcGangsta14 = new Enemy(this, 241.5f, 245.5f, 4);
        npcGangsta14.setPosition(new Vec2(242.5f, -1f));
        npcGangsta14.setAngularVelocity(0); npcGangsta14.setAngle(0); npcGangsta14.addCollisionListener(npcGangsta14);

        platformShape = new BoxShape(8, 2f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(255, -14f));
        platform.addImage(new BodyImage("data/snow_platform.png", 4f));

        platformShape = new BoxShape(8, 2f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(270, -1f));
        platform.addImage(new BodyImage("data/snow_platform.png", 4f));

        Shape characterShape = new BoxShape(1, 2f);
        StaticBody character = new StaticBody(this, characterShape);
        character.setPosition(new Vec2(271, 3.5f));
        character.addImage(new BodyImage("data/Fighter/Idle(1).png", 5.5f));

        characterShape = new BoxShape(1, 2f);
        character = new StaticBody(this, characterShape);
        character.setPosition(new Vec2(273, 3.5f));
        character.addImage(new BodyImage("data/Samurai/Idle(1).png", 5.5f));

        characterShape = new BoxShape(1, 2f);
        character = new StaticBody(this, characterShape);
        character.setPosition(new Vec2(275, 3.5f));
        character.addImage(new BodyImage("data/Shinobi/Idle(1).png", 5.5f));

        Enemy_attack stave = new Enemy_attack(this);
        stave.setPosition(new Vec2(15f, 100f)); stave.setAngle(0f); stave.setAngularVelocity(0f);
        stave.setLinearVelocity(new Vec2(5, 0));
        int x = 30; int y = 180;
        for (int i = 0; i < 35; i++) {
            x = x + 4; y = y + 190;
            stave = new Enemy_attack(this);
            stave.setPosition(new Vec2(x+ 8f, y + 200 ));
        }

        Flag flagimage = new Flag(this);
        flagimage.setPosition(new Vec2(290, -10));
        flagimage.addImage(new BodyImage("data/Flag(1).png", 5.5f));

        Shape GoldCoin = new BoxShape(2,10);
        StaticBody GoldCoinBody = new StaticBody(this, GoldCoin);
        GoldCoinBody.setPosition(new Vec2(300, 2.5f));
        GoldCoinBody.addImage(new BodyImage("data/PNG/Gold/Gold_21.png", 5));

        Bullets Bullet_L4 = new Bullets(this);
        Bullet_L4.setPosition(new Vec2(20, 5.5f)); Bullet_L4.setAngle(0f); Bullet_L4.setAngularVelocity(0f);
        Bullet_L4.addImage(new BodyImage("data/4.png",2));
        int x1 = 30;
        for (int i = 0; i < 20; i++) {
            x1 = x1 + 15;
            Bullet_L4 = new Bullets(this);
            Bullet_L4.setPosition(new Vec2(x1 + 20, 5.5f)); Bullet_L4.setAngle(0f); Bullet_L4.setAngularVelocity(0f);
            Bullet_L4.addImage(new BodyImage("data/4.png",2));
        }
        setGravity(9.8f);

        final int[] frameCounter = {0};
        final Timer[] runTimer = {null};

        BodyImage[] runFrames = new BodyImage[]{ // Use of AI:idea of using array to store images.
                new BodyImage("data/Gangsters_3/Run(1).png", 5.5f),
                new BodyImage("data/Gangsters_3/Run(2).png", 5.5f),
                new BodyImage("data/Gangsters_3/Run(3).png", 5.5f),
                new BodyImage("data/Gangsters_3/Run(4).png", 5.5f),
                new BodyImage("data/Gangsters_3/Run(5).png", 5.5f),
                new BodyImage("data/Gangsters_3/Run(6).png", 5.5f),
                new BodyImage("data/Gangsters_3/Run(7).png", 5.5f),
                new BodyImage("data/Gangsters_3/Run(8).png", 5.5f),
                new BodyImage("data/Gangsters_3/Run(9).png", 5.5f),
                new BodyImage("data/Gangsters_3/Run(10).png", 5.5f),
        };
        BodyImage[] leftFrames = new BodyImage[]{
                new BodyImage("data/Gangsters_3/LeftRun(1).png", 5.5f),
                new BodyImage("data/Gangsters_3/LeftRun(2).png", 5.5f),
                new BodyImage("data/Gangsters_3/LeftRun(3).png", 5.5f),
                new BodyImage("data/Gangsters_3/LeftRun(4).png", 5.5f),
                new BodyImage("data/Gangsters_3/LeftRun(5).png", 5.5f),
                new BodyImage("data/Gangsters_3/LeftRun(6).png", 5.5f),
                new BodyImage("data/Gangsters_3/LeftRun(7).png", 5.5f),
                new BodyImage("data/Gangsters_3/LeftRun(8).png", 5.5f),
                new BodyImage("data/Gangsters_3/LeftRun(9).png", 5.5f),
                new BodyImage("data/Gangsters_3/LeftRun(10).png", 5.5f),
        };
        BodyImage[] shotFrames = new BodyImage[]{
                new BodyImage("data/Gangsters_3/Shot(1).png", 5.5f),
                new BodyImage("data/Gangsters_3/Shot(2).png", 5.5f),
                new BodyImage("data/Gangsters_3/Shot(3).png", 5.5f),
                new BodyImage("data/Gangsters_3/Shot(4).png", 5.5f),
                new BodyImage("data/Gangsters_3/Shot(5).png", 5.5f),
                new BodyImage("data/Gangsters_3/Shot(6).png", 5.5f),
                new BodyImage("data/Gangsters_3/Shot(7).png", 5.5f),
                new BodyImage("data/Gangsters_3/Shot(8).png", 5.5f),
                new BodyImage("data/Gangsters_3/Shot(9).png", 5.5f),
                new BodyImage("data/Gangsters_3/Shot(10).png", 5.5f),
                new BodyImage("data/Gangsters_3/Shot(11).png", 5.5f),
                new BodyImage("data/Gangsters_3/Shot(12).png", 5.5f),
        };
        BodyImage[] LeftShotFrames = new BodyImage[]{
                new BodyImage("data/Gangsters_3/LeftShot(1).png", 5.5f),
                new BodyImage("data/Gangsters_3/LeftShot(2).png", 5.5f),
                new BodyImage("data/Gangsters_3/LeftShot(3).png", 5.5f),
                new BodyImage("data/Gangsters_3/LeftShot(4).png", 5.5f),
                new BodyImage("data/Gangsters_3/LeftShot(5).png", 5.5f),
                new BodyImage("data/Gangsters_3/LeftShot(6).png", 5.5f),
                new BodyImage("data/Gangsters_3/LeftShot(7).png", 5.5f),
                new BodyImage("data/Gangsters_3/LeftShot(8).png", 5.5f),
                new BodyImage("data/Gangsters_3/LeftShot(9).png", 5.5f),
                new BodyImage("data/Gangsters_3/LeftShot(10).png", 5.5f),
                new BodyImage("data/Gangsters_3/LeftShot(11).png", 5.5f),
                new BodyImage("data/Gangsters_3/LeftShot(12).png", 5.5f),
        };
        try {
            Level4SoundClip = new SoundClip("data/53-mii-maker-mii-editor-gamepad.wav");
            Level4SoundClip.loop();
        }catch (Exception e){
            e.printStackTrace();
        }
        player.gainLife();
        final boolean[] moveRight = {false};
        final boolean[] moveLeft = {false};
        final boolean[] shot = {false};
        final boolean[] canShoot = {true};
        PlayerCollision listener = new PlayerCollision(player);
        player.addCollisionListener(listener);
        Level4 world = this;
        frames.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    moveRight[0] = !(player.getPosition().x > 260);
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
                    if(player.getPosition().x > 260){
                        player.setLinearVelocity(new Vec2(0f, 0f));
                        player.applyImpulse(new Vec2(0f, 0f));
                    }
                    listener.setCanJump(false);
                    player.applyImpulse(new Vec2(0f, 110f));
                    player.removeAllImages();
                    player.addImage( new BodyImage("data/Gangsters_3/Jump(1).png", 5.5f));
                }

                else if (e.getKeyCode() == KeyEvent.VK_S) {
                    if(player.getPosition().x > 260){
                        player.setLinearVelocity(new Vec2(0f, 0f));
                    }
                    listener.setShield(true);
                    player.setLinearVelocity(new Vec2(player.getLinearVelocity().x, player.getLinearVelocity().y));
                    player.removeAllImages();
                    player.addImage(new BodyImage("data/Gangsters_3/Shield.png", 5.5f));
                }

                else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if(player.getPosition().x > 260){
                        player.setLinearVelocity(new Vec2(0f, 0f));
                    }
                    listener.setCanDamage(true);
                    player.setLinearVelocity(new Vec2(player.getLinearVelocity().x, player.getLinearVelocity().y));
                    player.removeAllImages();
                    if (moveRight[0]){
                        player.addImage(new BodyImage("data/Gangsters_3/Attack(3).png", 5.5f));}
                    else if (moveLeft[0]){
                        player.addImage((new BodyImage("data/Gangsters_3/LeftAttack(3).png", 5.5f)));
                    }else {
                        player.addImage(new BodyImage("data/Gangsters_3/Attack(3).png", 5.5f));
                    }
                }

                else if (e.getKeyCode() == KeyEvent.VK_A) {
                    moveLeft[0] = true;
                    if(player.getPosition().x > 260){
                        player.setLinearVelocity(new Vec2(0f, 0f));
                    }
                    if (runTimer[0] == null) {
                        frameCounter[0] = 0;
                        runTimer[0] = new Timer(75, ev -> {
                            player.removeAllImages(); ev.paramString();
                            player.addImage(leftFrames[frameCounter[0] % leftFrames.length]);
                            frameCounter[0] = (frameCounter[0] + 1) % leftFrames.length;
                        });
                        runTimer[0].start();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_SPACE && canShoot[0] && bullet == null) {
                    canShoot[0] = false;
                    bullet = new Character_attack(world);
                    if (moveRight[0]){
                    bullet.setPosition(new Vec2(player.getPosition().x + 1, (player.getPosition().y+2 + player.getPosition().y)/2));
                    bullet.setAngle(0f); bullet.setAngularVelocity(0f);bullet.setLinearVelocity(new Vec2(15, 0));
                    }else if (moveLeft[0]){
                        bullet.setPosition(new Vec2(player.getPosition().x - 1, (player.getPosition().y+2 + player.getPosition().y)/2));
                        bullet.setAngle(0f); bullet.setAngularVelocity(0f);
                        bullet.setLinearVelocity(new Vec2(-15, 0));
                    } else {
                        bullet.setPosition(new Vec2(player.getPosition().x + 1, (player.getPosition().y+2 + player.getPosition().y)/2));
                        bullet.setAngle(0f); bullet.setAngularVelocity(0f);
                        bullet.setLinearVelocity(new Vec2(15, 0));
                    }
                    shot[0] = true;
                    player.loseShots();
                    player.setLinearVelocity(new Vec2(0f, 0f));

                    if (runTimer[0] == null) {
                        frameCounter[0] = 0;
                        runTimer[0] = new Timer(75, ev -> {
                            player.removeAllImages(); ev.paramString();
                            if (moveRight[0]) {
                            player.addImage(shotFrames[frameCounter[0] % shotFrames.length]);
                            frameCounter[0] = (frameCounter[0] + 1) % shotFrames.length;}
                            else if (moveLeft[0]) {
                                player.addImage(LeftShotFrames[frameCounter[0] % LeftShotFrames.length]);
                                frameCounter[0] = (frameCounter[0] + 1) % LeftShotFrames.length;
                            } else {
                                player.addImage(shotFrames[frameCounter[0] % shotFrames.length]);
                                frameCounter[0] = (frameCounter[0] + 1) % shotFrames.length;
                            }
                        });
                        runTimer[0].start();canShoot[0] = true;
                        new Timer(1000, ev -> canShoot[0] = true).start();

                }
                } if (e.getKeyCode() == KeyEvent.VK_M) {
                    Level4SoundClip.pause();
                } else if (e.getKeyCode() == KeyEvent.VK_U) {
                    Level4SoundClip.resume();
                }
                if(player.getPosition().x > 260){
                    Level4SoundClip.stop();
                    moveRight[0] = false; moveLeft[0] = false; canShoot[0] = false;
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
                    player.addImage(new BodyImage("data/Gangsters_3/Idle(1).png", 5.5f));
                    player.setLinearVelocity(new Vec2(0, player.getLinearVelocity().y));}

                else if (e.getKeyCode() == KeyEvent.VK_W) {
                    player.removeAllImages();
                    player.addImage(new BodyImage("data/Gangsters_3/Idle(1).png", 5.5f));
                }

                else if (e.getKeyCode() == KeyEvent.VK_S) {
                    listener.setShield(false);
                    player.removeAllImages();
                    player.addImage( new BodyImage("data/Gangsters_3/Idle(1).png", 5.5f));
                }

                else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    listener.setCanDamage(false);
                    player.removeAllImages();
                    player.addImage( new BodyImage("data/Gangsters_3/Idle(1).png", 5.5f));
                }

                else if (e.getKeyCode() == KeyEvent.VK_A) {
                    moveLeft[0] = false;
                    if (runTimer[0] != null) {
                        runTimer[0].stop();
                        runTimer[0] = null;
                    }
                    player.removeAllImages();
                    player.addImage(new BodyImage("data/Gangsters_3/Idle(1).png", 5.5f));
                    player.setLinearVelocity(new Vec2(0, player.getLinearVelocity().y));
                }
                else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    shot[0] = false;
                    if (runTimer[0] != null) {
                        runTimer[0].stop();
                        runTimer[0] = null;
                    }bullet = null;
                    player.removeAllImages();
                    player.addImage( new BodyImage("data/Gangsters_3/Idle(1).png", 5.5f));
                }
            }
        });
        levelTimer = new Timer(1000, e -> {
            if (timeRemaining >= 0) {
                timeRemaining--;
            } else {
                levelTimer.stop();
                ((Timer)e.getSource()).stop();
                player.loselife(); player.loselife(); player.loselife();
                player.playerDeath(); listener.setCanDamage(false);
                moveRight[0] = false; moveLeft[0] = false; canShoot[0] = false;
                player.setLinearVelocity(new Vec2(0f,0f));
            }
        });
        levelTimer.start();


        Bullets finalBullet_L = Bullet_L4;
        this.addStepListener(new StepListener() {
            public void preStep(StepEvent e) {
                if (moveRight[0] && !(player.getPosition().x >270)) {
                    player.setLinearVelocity(new Vec2(10, player.getLinearVelocity().y));
                }
                else if (moveLeft[0] && !(player.getPosition().x >270)) {
                    player.setLinearVelocity(new Vec2(-10, player.getLinearVelocity().y));
                }
                npcGangsta.update_Level4(); npcGangsta.setAngle(0f); npcGangsta.setAngularVelocity(0f);
                npcGangsta1.update_Level4(); npcGangsta1.setAngle(0f); npcGangsta1.setAngularVelocity(0f);
                npcGangsta2.update_Level4(); npcGangsta2.setAngle(0f); npcGangsta2.setAngularVelocity(0f);
                npcGangsta3.update_Level4(); npcGangsta3.setAngle(0f); npcGangsta3.setAngularVelocity(0f);
                npcGangsta4.update_Level4(); npcGangsta4.setAngle(0f); npcGangsta4.setAngularVelocity(0f);
                npcGangsta5.update_Level4(); npcGangsta5.setAngle(0f); npcGangsta5.setAngularVelocity(0f);
                npcGangsta6.update_Level4(); npcGangsta6.setAngle(0f); npcGangsta6.setAngularVelocity(0f);
                npcGangsta7.update_Level4(); npcGangsta7.setAngle(0f); npcGangsta7.setAngularVelocity(0f);
                npcGangsta8.update_Level4(); npcGangsta8.setAngle(0f); npcGangsta8.setAngularVelocity(0f);
                npcGangsta9.update_Level4(); npcGangsta9.setAngle(0f); npcGangsta9.setAngularVelocity(0f);
                npcGangsta10.update_Level4(); npcGangsta10.setAngle(0f); npcGangsta10.setAngularVelocity(0f);
                npcGangsta11.update_Level4(); npcGangsta11.setAngle(0f); npcGangsta11.setAngularVelocity(0f);
                npcGangsta12.update_Level4(); npcGangsta12.setAngle(0f); npcGangsta12.setAngularVelocity(0f);
                npcGangsta13.update_Level4(); npcGangsta13.setAngle(0f); npcGangsta13.setAngularVelocity(0f);
                npcGangsta14.update_Level4(); npcGangsta14.setAngle(0f); npcGangsta14.setAngularVelocity(0f);
                dynamicPlatform.update(); dynamicPlatform.setAngle(0f); dynamicPlatform.setAngularVelocity(0f);
                dynamicPlatform2.update(); dynamicPlatform2.setAngle(0f); dynamicPlatform2.setAngularVelocity(0f);
                dynamicPlatform3.update(); dynamicPlatform3.setAngle(0f); dynamicPlatform3.setAngularVelocity(0f);
                dynamicPlatform4.update(); dynamicPlatform4.setAngle(0f); dynamicPlatform4.setAngularVelocity(0f);
                if (bullet != null) {
                    if (bullet.getPosition().x >= player.getPosition().x + 30) {
                        bullet.destroyed();
                        bullet = null;
                    }
                }
                finalBullet_L.setAngle(0f); finalBullet_L.setAngularVelocity(0f);
                views.setCentre(player.getPosition()); player.setAngle(0f); player.setAngularVelocity(0f);
                System.out.println(player.getPosition().x);
            }

            @Override
            public void postStep(StepEvent e) {}
        });
        this.start();
    }
    static void main() {
    }
}
