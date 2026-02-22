package game;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;
import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import city.cs.engine.BodyImage;

public class GameWorld extends World {
    private int timeRemaining = 90;
    private Timer levelTimer;
    private Timer destroyTimer;
    public GameWorld() {
        GameWorldBackground view = new GameWorldBackground(this,640,565); //Initialises the width and height of object view.

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
        platform.setPosition(new Vec2(32.5f, -10.5f));
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

        Enemy npcGangsta1 = new Enemy(this, 73, 77); // Bounds are used to define the X position the npc can't go beyond.
        npcGangsta1.setPosition(new Vec2(74, -6));
        npcGangsta1.setAngularVelocity(0); npcGangsta1.setAngle(0);

        Enemy npcGangsta2 = new Enemy(this, 78.5f, 82.5f);
        npcGangsta2.setPosition(new Vec2(82, -6));
        npcGangsta2.setAngularVelocity(0); npcGangsta2.setAngle(0);

        platformShape = new BoxShape(5, 0.5f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(92, -3));
        platform.addImage(new BodyImage("data/platform(1).png", 8));

        Enemy npcGangsta3 = new Enemy(this, 88, 96.5f);
        npcGangsta3.setPosition(new Vec2(92, -1));
        npcGangsta3.setAngularVelocity(0); npcGangsta3.setAngle(0);

        platformShape = new BoxShape(7, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(110, -12));
        platform.addImage(new BodyImage("data/platform(2).png", 11));

        Enemy npcGangsta4 = new Enemy(this, 102, 106);
        npcGangsta4.setPosition(new Vec2(106, -10));
        npcGangsta4.setAngularVelocity(0); npcGangsta4.setAngle(0);

        Enemy npcGangsta5 =  new Enemy(this, 110.5f, 114.5f);
        npcGangsta5.setPosition(new Vec2(114, -10));
        npcGangsta5.setAngularVelocity(0); npcGangsta5.setAngle(0);

        platformShape = new BoxShape(6, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(128, -6));
        platform.addImage(new BodyImage("data/platform(1).png", 10));

        platformShape = new BoxShape(8, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(150, -14));
        platform.addImage(new BodyImage("data/platform(2).png", 12));

        Enemy npcGangsta6 = new Enemy(this, 142, 144.5f);
        npcGangsta6.setPosition(new Vec2(146, -12));
        npcGangsta6.setAngularVelocity(0); npcGangsta6.setAngle(0);

        Enemy npcGangsta7 = new Enemy(this, 147.5f, 150);
        npcGangsta7.setPosition(new Vec2(150.5f, -12));
        npcGangsta7.setAngularVelocity(0); npcGangsta7.setAngle(0);

        Enemy npcGangsta8 = new Enemy(this, 152, 154.5f);
        npcGangsta8.setPosition(new Vec2(155.5f, -12));
        npcGangsta8.setAngularVelocity(0); npcGangsta8.setAngle(0);

        platformShape = new BoxShape(5, 0.5f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(168, -8));
        platform.addImage(new BodyImage("data/platform(1).png", 8));

        platformShape = new BoxShape(5, 0.5f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(182, -4));
        platform.addImage(new BodyImage("data/platform(1).png", 8));

        Enemy npcGangsta9 = new Enemy(this, 178, 183.5f);
        npcGangsta9.setPosition(new Vec2(182, -2));
        npcGangsta9.setAngularVelocity(0); npcGangsta9.setAngle(0);

        platformShape = new BoxShape(7, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(200, -14));
        platform.addImage(new BodyImage("data/platform(2).png", 11));

        Enemy npcGangsta10 = new Enemy(this, 192, 198);
        npcGangsta10.setPosition(new Vec2(196, -12));
        npcGangsta10.setAngularVelocity(0); npcGangsta10.setAngle(0);

        Enemy npcGangsta11 = new Enemy(this, 200, 206);
        npcGangsta11.setPosition(new Vec2(204, -12));
        npcGangsta11.setAngularVelocity(0); npcGangsta11.setAngle(0);

        platformShape = new BoxShape(6, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(220, -9));
        platform.addImage(new BodyImage("data/platform(1).png", 10));

        platformShape = new BoxShape(5, 0.5f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(235, -4));
        platform.addImage(new BodyImage("data/platform(1).png", 8));

        Enemy npcGangsta12 = new Enemy(this, 231, 239);
        npcGangsta12.setPosition(new Vec2(235, -2));
        npcGangsta12.setAngularVelocity(0); npcGangsta12.setAngle(0);

        platformShape = new BoxShape(9, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(255, -14));
        platform.addImage(new BodyImage("data/platform(2).png", 13));

        Enemy npcGangsta13 = new Enemy(this, 247, 249.5f);
        npcGangsta13.setPosition(new Vec2(251, -12));
        npcGangsta13.setAngularVelocity(0); npcGangsta13.setAngle(0);

        Enemy npcGangsta14 = new Enemy(this, 252, 254.5f);
        npcGangsta14.setPosition(new Vec2(255, -12));
        npcGangsta14.setAngularVelocity(0); npcGangsta14.setAngle(0);

        Enemy npcGangsta15 = new Enemy(this, 257.5f, 260);
        npcGangsta15.setPosition(new Vec2(260, -12));
        npcGangsta15.setAngularVelocity(0); npcGangsta15.setAngle(0);

        platformShape = new BoxShape(12, 1);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(285, -14));
        platform.addImage(new BodyImage("data/platform(2).png", 11.5f));

        Flag flagimage = new Flag(this); // Initialises the object flagimage.
        flagimage.setPosition(new Vec2(290, -10));
        flagimage.addImage(new BodyImage("data/Flag(1).png", 5.5f));

        setGravity(9.8f);

        final JFrame frame = new JFrame("Game world");
        frame.add(view);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        frame.setBackground(Color.BLACK);
        final int[] frameCounter = {0}; // Initialises the array of integers used for frameCounter.
        final Timer[] runTimer = {null}; // Initialises the array of integers used for runTimer.

        BodyImage[] runFrames = new BodyImage[]{
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

        final boolean[] moveRight = {false}; // Boolean flag used to determine if the player can move right or not.
        final boolean[] moveLeft = {false}; // Boolean flag used to determine if the player can move left or not.
        final boolean[] canDamage = { false }; // Boolean flag used to determine if the player can move damage an enemy or not.
        PlayerCollision listener = new PlayerCollision(player); // Initialises the object listener.
        player.addCollisionListener(listener); // Used to allow the player's collisions to have an effect with other objects in game.
        frame.addKeyListener(new KeyAdapter() { //Used to allow key inputs to affect the player image.
            @Override
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
                player.addImage( new BodyImage("data/Fighter/Jump(3.2).png", 5.5f));
               }

            else if (e.getKeyCode() == KeyEvent.VK_S) {
                if(player.getPosition().x > 270){
                    player.setLinearVelocity(new Vec2(0f, 0f));
                }
                listener.setShield(true);
                player.setLinearVelocity(new Vec2(player.getLinearVelocity().x, player.getLinearVelocity().y));
                player.removeAllImages();
                player.addImage(new BodyImage("data/Fighter/Shield(1).png", 5.5f));
                }

            else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                if(player.getPosition().x > 270){
                    player.setLinearVelocity(new Vec2(0f, 0f));
                }
                listener.setCanDamage(true);
                player.setLinearVelocity(new Vec2(player.getLinearVelocity().x, player.getLinearVelocity().y));
                player.removeAllImages();
                player.addImage(new BodyImage("data/Fighter/Attack_3(2).png", 5.5f));
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
            @Override
            public void preStep(StepEvent e) { // Used to handle all horizontal movement for a dynamic object.
                if (moveRight[0] && !(player.getPosition().x >270)) {
                    player.setLinearVelocity(new Vec2(10, player.getLinearVelocity().y));
                }
                else if (moveLeft[0] && !(player.getPosition().x >270)) {
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
