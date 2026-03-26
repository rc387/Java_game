package game;
import city.cs.engine.*;

import org.jbox2d.common.Vec2;

public class Enemy extends Character {
    private static final Shape CharacterShape = new BoxShape(1,2.5f);
    private static final BodyImage image = new BodyImage("data/Gangsters_2/Idle(1).png", 5.5f);
    private static final BodyImage hurt_image = new BodyImage("data/Raider_3/Hurt(1).png", 5.5f);
    private float direction = 1;
    private int frameCounter = 0;
    private final float leftBound;
    private final float rightBound;
    private int lives = 2;

    public Enemy(World world, float leftBound, float rightBound, int lives) {
        super(world);
        this.leftBound = leftBound;
        this.rightBound = rightBound;
        this.lives = lives;
        removeAllImages();
        addImage(image);
        setFixedRotation(true);
        setAngle(0f);
    }
    public void lose_Life(){
        lives--;
        if(lives == 0){
            destroy();
        }
    }

    BodyImage[] walkFrames = new BodyImage[]{
            new BodyImage("data/Gangsters_2/Walk(1).png", 5.5f),
            new BodyImage("data/Gangsters_2/Walk(2).png", 5.5f),
            new BodyImage("data/Gangsters_2/Walk(3).png", 5.5f),
            new BodyImage("data/Gangsters_2/Walk(4).png", 5.5f),
            new BodyImage("data/Gangsters_2/Walk(5).png", 5.5f),
            new BodyImage("data/Gangsters_2/Walk(6).png", 5.5f),
            new BodyImage("data/Gangsters_2/Walk(7).png", 5.5f),
            new BodyImage("data/Gangsters_2/Walk(8).png", 5.5f),
            new BodyImage("data/Gangsters_2/Walk(9).png", 5.5f),
            new BodyImage("data/Gangsters_2/Walk(10).png", 5.5f),
    };
    BodyImage[] leftWalkFrames = new BodyImage[]{
            new BodyImage("data/Gangsters_2/LeftWalk(1).png", 5.5f),
            new BodyImage("data/Gangsters_2/LeftWalk(2).png", 5.5f),
            new BodyImage("data/Gangsters_2/LeftWalk(3).png", 5.5f),
            new BodyImage("data/Gangsters_2/LeftWalk(4).png", 5.5f),
            new BodyImage("data/Gangsters_2/LeftWalk(5).png", 5.5f),
            new BodyImage("data/Gangsters_2/LeftWalk(6).png", 5.5f),
            new BodyImage("data/Gangsters_2/LeftWalk(7).png", 5.5f),
            new BodyImage("data/Gangsters_2/LeftWalk(8).png", 5.5f),
            new BodyImage("data/Gangsters_2/LeftWalk(9).png", 5.5f),
            new BodyImage("data/Gangsters_2/LeftWalk(10).png", 5.5f),
    };

    BodyImage[] walkFrames2 = new BodyImage[]{
            new BodyImage("data/Raider_3/Walk(1).png", 5.5f),
            new BodyImage("data/Raider_3/Walk(2).png", 5.5f),
            new BodyImage("data/Raider_3/Walk(3).png", 5.5f),
            new BodyImage("data/Raider_3/Walk(4).png", 5.5f),
            new BodyImage("data/Raider_3/Walk(5).png", 5.5f),
            new BodyImage("data/Raider_3/Walk(6).png", 5.5f),
            new BodyImage("data/Raider_3/Walk(7).png", 5.5f),
    };
    BodyImage[] leftWalkFrames2 = new BodyImage[]{
            new BodyImage("data/Raider_3/LeftWalk(1).png", 5.5f),
            new BodyImage("data/Raider_3/LeftWalk(2).png", 5.5f),
            new BodyImage("data/Raider_3/LeftWalk(3).png", 5.5f),
            new BodyImage("data/Raider_3/LeftWalk(4).png", 5.5f),
            new BodyImage("data/Raider_3/LeftWalk(5).png", 5.5f),
            new BodyImage("data/Raider_3/LeftWalk(6).png", 5.5f),
            new BodyImage("data/Raider_3/LeftWalk(7).png", 5.5f),
    };
    BodyImage[] hurtFrames2 =  new BodyImage[]{
            new BodyImage("data/Raider_3/Hurt(1).png", 5.5f),
    };
    BodyImage[] rightHurtFrames2 = new BodyImage[]{
            new BodyImage("data/Raider_3/RightHurt.png", 5.5f),
    };
    BodyImage[] walkFrames3 = new BodyImage[]{
            new BodyImage("data/Zombie_Man/Walk(1).png", 5.5f),
            new BodyImage("data/Zombie_Man/Walk(2).png", 5.5f),
            new BodyImage("data/Zombie_Man/Walk(3).png", 5.5f),
            new BodyImage("data/Zombie_Man/Walk(4).png", 5.5f),
            new BodyImage("data/Zombie_Man/Walk(5).png", 5.5f),
            new BodyImage("data/Zombie_Man/Walk(6).png", 5.5f),
            new BodyImage("data/Zombie_Man/Walk(7).png", 5.5f),
            new BodyImage("data/Zombie_Man/Walk(8).png", 5.5f),
    };
    BodyImage[] leftWalkFrames3 = new BodyImage[]{
            new BodyImage("data/Zombie_Man/LeftWalk(1).png", 5.5f),
            new BodyImage("data/Zombie_Man/LeftWalk(2).png", 5.5f),
            new BodyImage("data/Zombie_Man/LeftWalk(3).png", 5.5f),
            new BodyImage("data/Zombie_Man/LeftWalk(4).png", 5.5f),
            new BodyImage("data/Zombie_Man/LeftWalk(5).png", 5.5f),
            new BodyImage("data/Zombie_Man/LeftWalk(6).png", 5.5f),
            new BodyImage("data/Zombie_Man/LeftWalk(7).png", 5.5f),
            new BodyImage("data/Zombie_Man/LeftWalk(8).png", 5.5f),
    };
    BodyImage[] hurtFrames3 = new BodyImage[]{
            new BodyImage("data/Zombie_Man/Hurt(1).png", 5.5f),
            new BodyImage("data/Zombie_Man/Hurt(2).png", 5.5f),
            new BodyImage("data/Zombie_Man/Hurt(3).png", 5.5f),
    };
    BodyImage[] leftHurtFrames3 = new BodyImage[]{
            new BodyImage("data/Zombie_Man/LeftHurt3(1).png", 5.5f),
            new BodyImage("data/Zombie_Man/LeftHurt3(2).png", 5.5f),
            new BodyImage("data/Zombie_Man/LeftHurt3(3).png", 5.5f),
    };
    BodyImage[] attackFrames = new BodyImage[]{
            new BodyImage("data/Zombie_Man/Attack_2(1).png", 5.5f),
            new BodyImage("data/Zombie_Man/Attack_2(2).png",5.5f),
            new BodyImage("data/Zombie_Man/Attack_2(3).png", 5.5f),
            new BodyImage("data/Zombie_Man/Attack_2(4).png", 5.5f),
    };
    BodyImage[] LeftAttackFrames = new BodyImage[]{
            new BodyImage("data/Zombie_Man/LeftAttack_2(1).png", 5.5f),
            new BodyImage("data/Zombie_Man/LeftAttack_2(2).png",5.5f),
            new BodyImage("data/Zombie_Man/LeftAttack_2(3).png", 5.5f),
            new BodyImage("data/Zombie_Man/LeftAttack_2(4).png", 5.5f),
    };

    private int animationTick = 0;

    public void update() {
        float x = getPosition().x;
        if (x > rightBound) direction = -1;
        if (x < leftBound) direction = 1;

        setLinearVelocity(new Vec2(3 * direction, 0));

        animationTick++; // Used to control the speed of the animation.
        if (animationTick % 10 == 0) { // Used to that animate is only called 6 times per second.
            animate();
        }// Use of AI:animationTick, to control the speed of the animation using modulus.
    }

    public void animate() {
        removeAllImages();
        if (direction == -1) {
            addImage(leftWalkFrames[frameCounter % leftWalkFrames.length]);
        } else {
            addImage(walkFrames[frameCounter % walkFrames.length]);
        }
        frameCounter = (frameCounter + 1) % walkFrames.length;
    }

    public void update_Level2(){
        float x = getPosition().x;
        if (x > rightBound) direction = -1;
        if (x < leftBound) direction = 1;
        if (lives == 1 && x > rightBound) direction = -0.1f;
        if (lives == 1 && x < leftBound) direction = 0.1f;

        setLinearVelocity(new Vec2(3 * direction, 0));

        animationTick++; // Used to control the speed of the animation.
        if (animationTick % 10 == 0) { // Used to that animate is only called 6 times per second.
            animate_Level2();
        }// Use of AI:animationTick, to control the speed of the animation using modulus.
    }

    public void animate_Level2(){
        removeAllImages();
        if (direction == -1) {
            addImage(leftWalkFrames2[frameCounter % leftWalkFrames2.length]);
        } else if (direction == 1) {
            addImage(walkFrames2[frameCounter % walkFrames2.length]);
        }else if(direction == -0.1f) {
            frameCounter = (frameCounter + 1) % hurtFrames2.length;
            addImage(hurtFrames2[frameCounter % hurtFrames2.length]);
        } else if (direction == 0.1f) {
            frameCounter = (frameCounter + 1) % rightHurtFrames2.length;
            addImage(rightHurtFrames2[frameCounter % leftWalkFrames2.length]);
        }
        frameCounter = (frameCounter + 1) % walkFrames2.length;
    }

    public void update_Level3(){
        float x = getPosition().x;
        if (x > rightBound) direction = -1;
        if (x < leftBound) direction = 1;
        if (lives == 1 && x > rightBound) direction = -0.1f;
        if (lives == 1 && x < leftBound) direction = 0.1f;

        setLinearVelocity(new Vec2(3 * direction, 0));

        animationTick++;
        if (animationTick % 10 == 0) {
            animate_Level3();
        }// Use of AI:animationTick, to control the speed of the animation using modulus.
    }

    public void animate_Level3(){
        removeAllImages();
        if (direction == -1) {
            addImage(leftWalkFrames3[frameCounter % leftWalkFrames3.length]);
        } else if (direction == 1) {
            addImage(walkFrames3[frameCounter % walkFrames3.length]);
        }else if(direction == -0.1f) {
            frameCounter = (frameCounter + 1) % hurtFrames3.length;
            addImage(hurtFrames3[frameCounter % hurtFrames3.length]);
        } else if (direction == 0.1f) {
            frameCounter = (frameCounter + 1) % leftHurtFrames3.length;
            addImage(leftHurtFrames3[frameCounter % leftHurtFrames3.length]);
        }
        frameCounter = (frameCounter + 1) % walkFrames3.length;
    }

    private void setFixedRotation(boolean b) {}
}
