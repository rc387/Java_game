package game;

import city.cs.engine.BodyImage;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public class Zombie_Enemy extends Enemy {
    private float direction = 1;
    private int frameCounter = 0;
    public Zombie_Enemy(World world, float leftBound, float rightBound, int lives) {
        super(world, leftBound, rightBound, lives);
    }

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

    private int animationTick = 0;

    public void update_Level3(){
        float x = getPosition().x;
        if (x > rightBound) direction = -1; if (x < leftBound) direction = 1;
        if (lives < 3 && x > rightBound) direction = -0.1f; if (lives < 3 && x < leftBound) direction = 0.1f;

        setLinearVelocity(new Vec2(3 * direction, 0));
        animationTick++; // Used to control the speed of the animation.
        if (direction == 1 || direction == -1) {
            if (animationTick % 10 == 0) { // Use of AI:animationTick, to control the speed of the animation using modulus.
                animate_Level3();
            }} else if (direction == 0.1f || direction == -0.1f) {
            if (animationTick % 5 == 0) {
                animate_Level3();
            }}
    }

    public void animate_Level3(){
        removeAllImages();
        if (direction == -1) { addImage(leftWalkFrames3[frameCounter % leftWalkFrames3.length]);}
        else if (direction == 1) { addImage(walkFrames3[frameCounter % walkFrames3.length]);}
        else if(direction == -0.1f) {
            frameCounter = (frameCounter + 1) % hurtFrames3.length;
            addImage(hurtFrames3[frameCounter % hurtFrames3.length]);
        } else if (direction == 0.1f) {
            frameCounter = (frameCounter + 1) % leftHurtFrames3.length;
            addImage(leftHurtFrames3[frameCounter % leftHurtFrames3.length]);
        }
        frameCounter = (frameCounter + 1) % walkFrames3.length;
    }
}
