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

public class Level1 extends GameWorld {
    private int timeRemaining = 180;
    private Timer levelTimer;
    private SoundClip soundClip;
    public Level1()
    {
        Character player = new Character(this); // Initialises the object player.
        player.setPosition(new Vec2(-7.25f, 2));
        player.setLinearVelocity(new Vec2(0, 0)); player.setAngularVelocity(0); player.setAngle(0);

        GameWorldBackground view = new GameWorldBackground(this,640,595,new ImageIcon("data/background(1).jpg").getImage(),player,"As you progress in levels, expect some surprises",false,false); //Initialises the width and height of object view.

        Gangster_Enemy npcGangsta = new Gangster_Enemy(this, 44,68,1); // Initialises the leftBound & rightBound of the object npcGangsta.
        npcGangsta.setPosition(new Vec2(67, -14));
        npcGangsta.setLinearVelocity(new Vec2(0, 0)); npcGangsta.setAngularVelocity(0); npcGangsta.setAngle(0);

        DeathShape deathShape = new DeathShape(this); // Initialises the object deathShape.
        deathShape.setPosition(new Vec2(-1, -100));

        Shape platformShape = new BoxShape(7, 1); // Initialises the object platformShape.
        StaticBody platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(-2.75f, -4.5f));
        platform.addImage(new BodyImage("data/platform(1).png", 11.5f));

        platformShape = new BoxShape(7, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(20, -4));
        platform.addImage(new BodyImage("data/platform(1).png", 11.5f));

        platformShape = new BoxShape(7, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(20, -14));
        platform.addImage(new BodyImage("data/platform(1).png", 11.5f));

        platformShape = new BoxShape(5.5f, 0.5f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(33.5f, -10.5f));
        platform.addImage(new BodyImage("data/platform(1).png", 9));

        platformShape = new BoxShape(7.5f, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(50, -14));
        platform.addImage(new BodyImage("data/platform(1).png", 11.5f));

        platformShape = new BoxShape(7.5f, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(63.25f, -14));
        platform.addImage(new BodyImage("data/platform(2).png", 11.5f));

        platformShape = new BoxShape(6, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(78, -7.5f));
        platform.addImage(new BodyImage("data/platform(1).png", 10));

        Gangster_Enemy npcGangsta1 = new Gangster_Enemy(this, 73, 77,1); // Bounds are used to define the X position the npc can't go beyond.
        npcGangsta1.setPosition(new Vec2(74, -6)); npcGangsta1.setAngularVelocity(0); npcGangsta1.setAngle(0);

        Gangster_Enemy npcGangsta2 = new Gangster_Enemy(this, 78.5f, 82.5f,1);
        npcGangsta2.setPosition(new Vec2(82, -6)); npcGangsta2.setAngularVelocity(0); npcGangsta2.setAngle(0);

        platformShape = new BoxShape(5, 0.5f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(92, -3));
        platform.addImage(new BodyImage("data/platform(1).png", 8));

        Gangster_Enemy npcGangsta3 = new Gangster_Enemy(this, 88, 96.5f,1);
        npcGangsta3.setPosition(new Vec2(92, -1)); npcGangsta3.setAngularVelocity(0); npcGangsta3.setAngle(0);

        platformShape = new BoxShape(7, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(110, -12));
        platform.addImage(new BodyImage("data/platform(2).png", 11));

        Gangster_Enemy npcGangsta4 = new Gangster_Enemy(this, 102, 106,1);
        npcGangsta4.setPosition(new Vec2(106, -10)); npcGangsta4.setAngularVelocity(0); npcGangsta4.setAngle(0);

        Gangster_Enemy npcGangsta5 =  new Gangster_Enemy(this, 110.5f, 114.5f,1);
        npcGangsta5.setPosition(new Vec2(114, -10)); npcGangsta5.setAngularVelocity(0); npcGangsta5.setAngle(0);

        platformShape = new BoxShape(6, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(128, -6));
        platform.addImage(new BodyImage("data/platform(1).png", 10));

        platformShape = new BoxShape(8, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(150, -14));
        platform.addImage(new BodyImage("data/platform(2).png", 12));

        Gangster_Enemy npcGangsta6 = new Gangster_Enemy(this, 142, 144.5f,1);
        npcGangsta6.setPosition(new Vec2(146, -12)); npcGangsta6.setAngularVelocity(0); npcGangsta6.setAngle(0);

        Gangster_Enemy npcGangsta7 = new Gangster_Enemy(this, 147.5f, 150,1);
        npcGangsta7.setPosition(new Vec2(151.5f, -12)); npcGangsta7.setAngularVelocity(0); npcGangsta7.setAngle(0);

        Gangster_Enemy npcGangsta8 = new Gangster_Enemy(this, 152, 154.5f,1);
        npcGangsta8.setPosition(new Vec2(156, -12)); npcGangsta8.setAngularVelocity(0); npcGangsta8.setAngle(0);

        platformShape = new BoxShape(5, 0.5f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(168, -8));
        platform.addImage(new BodyImage("data/platform(1).png", 8));

        platformShape = new BoxShape(5, 0.5f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(182, -4));
        platform.addImage(new BodyImage("data/platform(1).png", 8));

        Gangster_Enemy npcGangsta9 = new Gangster_Enemy(this, 178, 183.5f,1);
        npcGangsta9.setPosition(new Vec2(182, -2)); npcGangsta9.setAngularVelocity(0); npcGangsta9.setAngle(0);

        platformShape = new BoxShape(7, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(200, -14));
        platform.addImage(new BodyImage("data/platform(2).png", 11));

        Gangster_Enemy npcGangsta10 = new Gangster_Enemy(this, 192, 198,1);
        npcGangsta10.setPosition(new Vec2(196, -12)); npcGangsta10.setAngularVelocity(0); npcGangsta10.setAngle(0);

        Gangster_Enemy npcGangsta11 = new Gangster_Enemy(this, 200, 206,1);
        npcGangsta11.setPosition(new Vec2(204, -12)); npcGangsta11.setAngularVelocity(0); npcGangsta11.setAngle(0);

        platformShape = new BoxShape(6, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(220, -9));
        platform.addImage(new BodyImage("data/platform(1).png", 10));

        platformShape = new BoxShape(5, 0.5f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(235, -4));
        platform.addImage(new BodyImage("data/platform(1).png", 8));

        Gangster_Enemy npcGangsta12 = new Gangster_Enemy(this, 231, 239,1);
        npcGangsta12.setPosition(new Vec2(235, -2)); npcGangsta12.setAngularVelocity(0); npcGangsta12.setAngle(0);

        platformShape = new BoxShape(9, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(255, -14));
        platform.addImage(new BodyImage("data/platform(2).png", 13));

        Gangster_Enemy npcGangsta13 = new Gangster_Enemy(this, 247, 249.5f,1);
        npcGangsta13.setPosition(new Vec2(251, -12));
        npcGangsta13.setAngularVelocity(0); npcGangsta13.setAngle(0);

        Gangster_Enemy npcGangsta14 = new Gangster_Enemy(this, 252, 254.5f,1);
        npcGangsta14.setPosition(new Vec2(255, -12));
        npcGangsta14.setAngularVelocity(0); npcGangsta14.setAngle(0);

        Gangster_Enemy npcGangsta15 = new Gangster_Enemy(this, 257.5f, 260,1);
        npcGangsta15.setPosition(new Vec2(260, -12));
        npcGangsta15.setAngularVelocity(0); npcGangsta15.setAngle(0);

        platformShape = new BoxShape(8, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(280, -14));
        platform.addImage(new BodyImage("data/platform(2).png", 11.5f));

        Flag flagImage = new Flag(this); // Initialises the object flagImage.
        flagImage.setPosition(new Vec2(286, -10));
        flagImage.addImage(new BodyImage("data/Flag(1).png", 5.5f));

        Shape GoldCoin = new BoxShape(2,10); // Initialises the object GoldCoin.
        StaticBody GoldCoinBody = new StaticBody(this, GoldCoin); // Used to indicate end of level.
        GoldCoinBody.setPosition(new Vec2(286, 2.5f));
        GoldCoinBody.addImage(new BodyImage("data/PNG/Gold/Gold_21.png", 5));

        Hearts heart = new Hearts(this); // Initialises the object heart.
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

        final JFrame frame = new JFrame("Level 1");
        frame.add(view); frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); frame.setLocationByPlatform(true);
        frame.setResizable(false); frame.pack(); frame.setVisible(true); frame.setBackground(Color.BLACK);
        frame.repaint(); frame.revalidate();
        final int[] frameCounter = {0}; // Initialises the array of integers used for frameCounter.
        final Timer[] runTimer = {null}; // Initialises the array of integers used for runTimer.

        BodyImage[] runFrames = new BodyImage[]{ // Use of AI:idea of using array to store images.
                new BodyImage("data/Fighter/Run(1).png", 5.5f),
                new BodyImage("data/Fighter/Run(2).png", 5.5f),
                new BodyImage("data/Fighter/Run(3).png", 5.5f),
                new BodyImage("data/Fighter/Run(4).png", 5.5f),
                new BodyImage("data/Fighter/Run(5).png", 5.5f),
                new BodyImage("data/Fighter/Run(6).png", 5.5f),
                new BodyImage("data/Fighter/Run(7).png", 5.5f),
                new BodyImage("data/Fighter/Run(8).png", 5.5f),
        }; // Initialises the array of images used for the animation of the player running in the right direction.

        BodyImage[] leftFrames = new BodyImage[]{
                new BodyImage("data/Fighter/RunLeft(1).png", 5.5f),
                new BodyImage("data/Fighter/RunLeft(2).png", 5.5f),
                new BodyImage("data/Fighter/RunLeft(3).png", 5.5f),
                new BodyImage("data/Fighter/RunLeft(4).png", 5.5f),
                new BodyImage("data/Fighter/RunLeft(5).png", 5.5f),
                new BodyImage("data/Fighter/RunLeft(6).png", 5.5f),
                new BodyImage("data/Fighter/RunLeft(7).png", 5.5f),
                new BodyImage("data/Fighter/RunLeft(8).png", 5.5f),
        }; // Initialises the array of images used for the animation of the player running in the left direction.

        try {
            soundClip = new SoundClip("data/7-dessert.wav"); // Used to initialise the background music.
            soundClip.loop();
        } catch (Exception e) {
            e.printStackTrace();
        }

        final double[] x = {1};
        soundClip.setVolume(x[0]);
        final boolean[] moveRight = {false}; // Boolean flag used to determine if the player can move right or not.
        final boolean[] moveLeft = {false}; // Boolean flag used to determine if the player can move left or not.
        final boolean[] pauseState = {false}; // Boolean flag used to determine if the game has been paused or not.
        PlayerCollision listener = new PlayerCollision(player); // Initialises the object listener.
        player.addCollisionListener(listener); // Used to allow the player's collisions to have an effect with other objects in game.
        SoundClip damage;
        try {
            damage = new SoundClip("data/damage1.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
        listener.setLevelSoundClip(damage);
        frame.addKeyListener(new  KeyAdapter() { //Used to allow key inputs to affect the player image.
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    moveRight[0] = true;
                    if (runTimer[0] == null) { // Used to keep the animation running whilst the D key is pressed.
                        frameCounter[0] = 0;
                        runTimer[0] = new Timer(75, _ -> { // Used to make the animation speed look presentable.
                            player.removeAllImages(); // Used to remove idle image of player.
                            player.addImage(runFrames[frameCounter[0] % runFrames.length]); // Add the right run frames.
                            frameCounter[0] = (frameCounter[0] + 1) % runFrames.length;
                        });
                        runTimer[0].start();
                    } }

                else if (e.getKeyCode() == KeyEvent.VK_W && listener.canJump()) {
                    player.applyImpulse(new Vec2(0f, 0f));
                    listener.setCanJump(false); // Used to prevent the player from jumping whilst already in the air.
                    player.applyImpulse(new Vec2(0f, 110f)); // Impulse is used as it's only applied once when the W key is pressed.
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
                    if (moveRight[0]){
                        player.addImage(new BodyImage("data/Fighter/Attack_3(2).png", 5.5f));}
                    else if (moveLeft[0]){
                        player.addImage((new BodyImage("data/Fighter/LeftAttack_3(2).png", 5.5f)));
                    }else {
                        player.addImage(new BodyImage("data/Fighter/Attack_3(2).png", 5.5f));
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
                    soundClip.pause();
                } else if (e.getKeyCode() == KeyEvent.VK_U) {
                    soundClip.resume();
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    soundClip.setVolume(x[0] += 0.1);
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    soundClip.setVolume(x[0] -= 0.1);
                } else if (e.getKeyCode() == KeyEvent.VK_P) {
                    if(!pauseState[0]) {
                    Level1.this.stop();
                    pauseState[0] = true;
                    view.setPaused(true);
                    soundClip.pause();
                    } else {
                        Level1.this.start();
                        pauseState[0] = false;
                        view.setPaused(false);
                        soundClip.resume();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_R) {
                        Level1.this.stop();
                        levelTimer.stop();
                        soundClip.close();
                        frame.dispose();
                        new Level1();
                } else if (e.getKeyCode() == KeyEvent.VK_Q) {
                    MainMenu.main(new String[]{""}); // Used to call the main menu class.
                }
            }

            public void keyReleased(KeyEvent e) {
                if  (e.getKeyCode() == KeyEvent.VK_D) {
                    moveRight[0]= false; // Used to make sure player doesn't keep moving when the D key is released.
                    if (runTimer[0] != null) {
                        runTimer[0].stop();
                        runTimer[0] = null; // Used to reset the runTimer value from Timer back to null so the animation can restart.
                    }
                    player.removeAllImages();
                    player.addImage(new BodyImage("data/Fighter/Idle(1).png", 5.5f)); // Idle image is returned.
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
                    listener.setCanDamage(false);
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

        levelTimer = new Timer(1000, e -> { // Mimics the same timer in Background class.
            if(!pauseState[0]){ // Used to stop the timer if the game is paused.
            if (timeRemaining >= 0) {timeRemaining--;}
            else {
                levelTimer.stop(); // This timer actually affects the player if 0.
                ((Timer)e.getSource()).stop();
                player.loseLife(); // Calls the method loseLife in the Character class.
                player.loseLife(); player.loseLife(); moveRight[0] = false; moveLeft[0] = false;
                listener.setCanDamage(false);
                player.playerDeath(); // Calls the method playerDeath in the Character class.
                player.setLinearVelocity(new Vec2(0f,0f)); soundClip.stop();
            }
        }});
        levelTimer.start();


        Hearts finalHeart = heart;
        this.addStepListener(new StepListener() {
            public void preStep(StepEvent e) { // Used to handle all horizontal movement for a dynamic object.
                if (moveRight[0]) {player.setLinearVelocity(new Vec2(10, player.getLinearVelocity().y));}
                else if (moveLeft[0]) { player.setLinearVelocity(new Vec2(-10, player.getLinearVelocity().y));}
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
                finalHeart.setAngle(0f); finalHeart.setAngularVelocity(0f);
                view.setCentre(player.getPosition()); player.setAngle(0f); player.setAngularVelocity(0f);
                if(player.getPosition().x > 275 && player.getPosition().y > -14.5f){
                    Level1.this.stop();
                    levelTimer.stop();
                    soundClip.close();
                    frame.dispose();
                    Level2.main();
                }
            }

            @Override
            public void postStep(StepEvent e) {}
        });
        this.start();
    }
    static void main() {
        new Level1();
    }
}

