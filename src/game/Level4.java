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
    private Character_attack bullet;
    public Level4(){
        GameWorldBackground views = new GameWorldBackground(this,640,595,new ImageIcon("data/background(1)_level4.jpg").getImage());

        final JFrame frames = new JFrame("Level4"); frames.add(views); frames.pack(); frames.repaint();
        frames.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); frames.setLocationByPlatform(true);
        frames.setResizable(false); frames.revalidate(); frames.setVisible(true); frames.setBackground(Color.BLACK);

        Character player = new Character(this);
        player.setPosition(new Vec2(-7.25f, 2));
        player.setLinearVelocity(new Vec2(0, 0));
        player.setAngularVelocity(0);
        player.setAngle(0);

        Enemy npcGangsta = new Enemy(this, 44,69,4);
        npcGangsta.setPosition(new Vec2(68, -14));
        npcGangsta.setLinearVelocity(new Vec2(0, 0));
        npcGangsta.setAngularVelocity(0);
        npcGangsta.setAngle(0);

        DeathShape deathShape = new DeathShape(this);
        deathShape.setPosition(new Vec2(-1, -100));

        Shape platformShape = new BoxShape(7, 2f);
        StaticBody platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(-2.75f, -4.5f));
        platform.addImage(new BodyImage("data/snow_platform.png", 4f));

        platformShape = new BoxShape(7, 2f);
        platform = new StaticBody(this, platformShape);
        platform.setPosition(new Vec2(20, -4));
        platform.addImage(new BodyImage("data/snow_platform.png", 4f));

        Enemy npcGangsta1 = new Enemy(this, 73, 77,4);
        npcGangsta1.setPosition(new Vec2(74, -6));
        npcGangsta1.setAngularVelocity(0); npcGangsta1.setAngle(0);

        Enemy_attack stave = new Enemy_attack(this);
        stave.setPosition(new Vec2(15f, 100f)); stave.setAngle(0f); stave.setAngularVelocity(0f);
        int x = 30; int y = 175;
        for (int i = 0; i < 35; i++) {
            x = x + 5; y = y + 190;
            stave = new Enemy_attack(this);
            stave.setPosition(new Vec2(x+ 7.5f, y + 200 ));
        }


        Flag flagimage = new Flag(this);
        flagimage.setPosition(new Vec2(290, -10));
        flagimage.addImage(new BodyImage("data/Flag(1).png", 5.5f));

        Shape GoldCoin = new BoxShape(2,10);
        StaticBody GoldCoinBody = new StaticBody(this, GoldCoin);
        GoldCoinBody.setPosition(new Vec2(300, 2.5f));
        GoldCoinBody.addImage(new BodyImage("data/PNG/Gold/Gold_21.png", 5));

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
                    moveRight[0] = !(player.getPosition().x > 270);
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
                    if(player.getPosition().x > 270){
                        player.setLinearVelocity(new Vec2(0f, 0f));
                        player.applyImpulse(new Vec2(0f, 0f));
                    }
                    listener.setCanJump(false);
                    player.applyImpulse(new Vec2(0f, 110f));
                    player.removeAllImages();
                    player.addImage( new BodyImage("data/Gangsters_3/Jump(1).png", 5.5f));
                }

                else if (e.getKeyCode() == KeyEvent.VK_S) {
                    if(player.getPosition().x > 270){
                        player.setLinearVelocity(new Vec2(0f, 0f));
                    }
                    listener.setShield(true);
                    player.setLinearVelocity(new Vec2(player.getLinearVelocity().x, player.getLinearVelocity().y));
                    player.removeAllImages();
                    player.addImage(new BodyImage("data/Gangsters_3/Shield.png", 5.5f));
                }

                else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if(player.getPosition().x > 270){
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
                } else if (e.getKeyCode() == KeyEvent.VK_SPACE && canShoot[0]) {
                    canShoot[0] = false;
                    bullet = new Character_attack(world);
                    bullet.setPosition(new Vec2(player.getPosition().x + 1, (player.getPosition().y+2 + player.getPosition().y)/2));
                    bullet.setAngle(0f); bullet.setAngularVelocity(0f); bullet.setLinearVelocity(new Vec2(20, 0));
                    shot[0] = true;
                    if(player.getPosition().x > 270){
                        player.setLinearVelocity(new Vec2(0f, 0f));
                    }
                    if (runTimer[0] == null) {
                        frameCounter[0] = 0;
                        runTimer[0] = new Timer(75, ev -> {
                            player.removeAllImages();
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
                        runTimer[0].start();
                        new Timer(1000, ev -> canShoot[0] = true).start();
                }
                }if(player.getPosition().x > 270){

                } else if (e.getKeyCode() == KeyEvent.VK_M) {

                } else if (e.getKeyCode() == KeyEvent.VK_U) {

                }
                if(player.getPosition().x > 270){
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
                    }
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
                player.loselife();
                player.loselife();
                player.loselife();
                player.playerDeath(); listener.setCanDamage(false);
                player.setLinearVelocity(new Vec2(0f,0f));
            }
        });
        levelTimer.start();


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
