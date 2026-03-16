package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Level2 extends World {
    private int timeRemaining = 90;
    private Timer levelTimer;
    private Timer destroyTimer;
    public Level2()
    {
        GameWorldBackground_Level2 views = new GameWorldBackground_Level2(this,640,565);

        final JFrame frames = new JFrame("Level2");
        frames.add(views);
        frames.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frames.setLocationByPlatform(true);
        frames.setResizable(false);
        frames.pack();
        frames.repaint();
        frames.revalidate();
        frames.setVisible(true);
        frames.setBackground(Color.BLACK);

        Character player = new Character(this); // Initialises the object player.
        player.setPosition(new Vec2(-7.25f, 2));
        player.setLinearVelocity(new Vec2(0, 0));
        player.setAngularVelocity(0);
        player.setAngle(0);

        Enemy npcGangsta = new Enemy(this, 44,69); // Initialises the leftBound & rightBound of the object npcGangsta.
        npcGangsta.setPosition(new Vec2(68, -14));
        npcGangsta.setLinearVelocity(new Vec2(0, 0));
        npcGangsta.setAngularVelocity(0);
        npcGangsta.setAngle(0);

        DeathShape deathShape = new DeathShape(this); // Initialises the object deathShape.
        deathShape.setPosition(new Vec2(-1, -100));

        city.cs.engine.Shape platformShape = new BoxShape(7, 1); // Initialises the object platformShape.
        StaticBody platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(-2.75f, -4.5f));
        platform.addImage(new BodyImage("data/Level2_platform.v1.png", 11.5f));

        platformShape = new BoxShape(7, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(20, -4));
        platform.addImage(new BodyImage("data/Level2_platform.v1.png", 11.5f));

        Enemy npcGangsta1 = new Enemy(this, 73, 77); // Bounds are used to define the X position the npc can't go beyond.
        npcGangsta1.setPosition(new Vec2(74, -6));
        npcGangsta1.setAngularVelocity(0); npcGangsta1.setAngle(0);



        Flag flagimage = new Flag(this); // Initialises the object flagimage.
        flagimage.setPosition(new Vec2(290, -10));
        flagimage.addImage(new BodyImage("data/Flag(1).png", 5.5f));

        Shape GoldCoin = new BoxShape(2,10); // Initialises the object GoldCoin.
        StaticBody GoldCoinBody = new StaticBody(this, GoldCoin); // Used to indicate end of level.
        GoldCoinBody.setPosition(new Vec2(300, 2.5f));
        GoldCoinBody.addImage(new BodyImage("data/PNG/Gold/Gold_21.png", 5));

        setGravity(9.8f);

        final int[] frameCounter = {0}; // Initialises the array of integers used for frameCounter.
        final Timer[] runTimer = {null}; // Initialises the array of integers used for runTimer.

        BodyImage[] runFrames = new BodyImage[]{ // Use of AI:idea of using array to store images.
                new BodyImage("data/Samurai/Run(1).png", 5.5f),
                new BodyImage("data/Samurai/Run(2).png", 5.5f),
                new BodyImage("data/Samurai/Run(3).png", 5.5f),
                new BodyImage("data/Samurai/Run(4).png", 5.5f),
                new BodyImage("data/Samurai/Run(5).png", 5.5f),
                new BodyImage("data/Samurai/Run(6).png", 5.5f),
                new BodyImage("data/Samurai/Run(7).png", 5.5f),
                new BodyImage("data/Samurai/Run(8).png", 5.5f),
        }; // Initialises the array of images used for the animation of the player running in the right direction.

        BodyImage[] leftFrames = new BodyImage[]{
                new BodyImage("data/Samurai/RunLeft(1).png", 5.5f),
                new BodyImage("data/Samurai/RunLeft(2).png", 5.5f),
                new BodyImage("data/Samurai/RunLeft(3).png", 5.5f),
                new BodyImage("data/Samurai/RunLeft(4).png", 5.5f),
                new BodyImage("data/Samurai/RunLeft(5).png", 5.5f),
                new BodyImage("data/Samurai/RunLeft(6).png", 5.5f),
                new BodyImage("data/Samurai/RunLeft(7).png", 5.5f),
                new BodyImage("data/Samurai/RunLeft(8).png", 5.5f),
        }; // Initialises the array of images used for the animation of the player running in the left direction.

        final boolean[] moveRight = {false}; // Boolean flag used to determine if the player can move right or not.
        final boolean[] moveLeft = {false}; // Boolean flag used to determine if the player can move left or not.
        final boolean[] canDamage = { false }; // Boolean flag used to determine if the player can move damage an enemy or not.
        PlayerCollision listener = new PlayerCollision(player); // Initialises the object listener.
        player.addCollisionListener(listener); // Used to allow the player's collisions to have an effect with other objects in game.
        frames.addKeyListener(new KeyAdapter() { //Used to allow key inputs to affect the player image.

            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    moveRight[0] = !(player.getPosition().x > 270); // Used to make moveRight false when player reaches the end of the level.
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
                    if(player.getPosition().x > 270){
                        player.setLinearVelocity(new Vec2(0f, 0f));
                        player.applyImpulse(new Vec2(0f, 0f));
                    }
                    listener.setCanJump(false); // Used to prevent the player from jumping whilst already in the air.
                    player.applyImpulse(new Vec2(0f, 110f)); // Impulse is used as it's only applied once when the W key is pressed.
                    player.removeAllImages();
                    player.addImage( new BodyImage("data/Samurai/Jump(1).png", 5.5f));
                }

                else if (e.getKeyCode() == KeyEvent.VK_S) {
                    if(player.getPosition().x > 270){
                        player.setLinearVelocity(new Vec2(0f, 0f));
                    }
                    listener.setShield(true);
                    player.setLinearVelocity(new Vec2(player.getLinearVelocity().x, player.getLinearVelocity().y));
                    player.removeAllImages();
                    player.addImage(new BodyImage("data/Samurai/Shield(1).png", 5.5f));
                }

                else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if(player.getPosition().x > 270){
                        player.setLinearVelocity(new Vec2(0f, 0f));
                    }
                    listener.setCanDamage(true);
                    player.setLinearVelocity(new Vec2(player.getLinearVelocity().x, player.getLinearVelocity().y));
                    player.removeAllImages();
                    player.addImage(new BodyImage("data/Samurai/Attack_1(5).png", 5.5f));
                }

                else if (e.getKeyCode() == KeyEvent.VK_A) {
                    moveLeft[0] = true;
                    if(player.getPosition().x > 270){
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
                } if(player.getPosition().x > 270){ // Used to stop music when player reaches end of the level.
                    player.finish();
                } else if (e.getKeyCode() == KeyEvent.VK_M) {
                    player.finish();
                } else if (e.getKeyCode() == KeyEvent.VK_U) {
                    Character.setSoundClip_Level2();
                }
                if(player.getPosition().x > 270){
                    new Level2();
                    frames.getContentPane().removeAll();
                    frames.setVisible(false);
                    player.finish();}

            }

            public void keyReleased(KeyEvent e) {
                if  (e.getKeyCode() == KeyEvent.VK_D) {
                    moveRight[0]= false; // Used to make sure player doesn't keep moving when the D key is released.
                    if (runTimer[0] != null) {
                        runTimer[0].stop();
                        runTimer[0] = null; // Used to reset the runTimer value from Timer back to null so the animation can restart.
                    }
                    player.removeAllImages();
                    player.addImage(new BodyImage("data/Samurai/Idle(1).png", 5.5f)); // Idle image is returned.
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

                else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
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
        levelTimer = new Timer(1000, e -> { // Mimics the same timer in Background class.
            if (timeRemaining >= 0) {
                timeRemaining--;
            } else {
                levelTimer.stop(); // This timer actually affects the player if 0.
                ((Timer)e.getSource()).stop();
                player.loselife(); // Calls the method loselife in the Character class.
                player.loselife();
                player.loselife();
                player.playerDeath(); // Calls the method playerDeath in the Character class.
                player.setLinearVelocity(new Vec2(0f,0f));
                destroyTimer = new Timer(1000, f -> { // Used to allow the playerDeath animation to end before destroying the player.
                    player.destroy();
                });destroyTimer.start();
            }
        });
        levelTimer.start();


        this.addStepListener(new StepListener() {
            public void preStep(StepEvent e) { // Used to handle all horizontal movement for a dynamic object.
                if (moveRight[0] && !(player.getPosition().x >270)) {
                    player.setLinearVelocity(new Vec2(10, player.getLinearVelocity().y));
                }
                else if (moveLeft[0] && !(player.getPosition().x >270)) {
                    player.setLinearVelocity(new Vec2(-10, player.getLinearVelocity().y));
                }
                npcGangsta.update_Level2(); npcGangsta.setAngle(0f); npcGangsta.setAngularVelocity(0f);
                npcGangsta1.update_Level2(); npcGangsta1.setAngle(0f); npcGangsta1.setAngularVelocity(0f);
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
