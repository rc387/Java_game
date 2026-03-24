package game;
import city.cs.engine.*;

import org.jbox2d.common.Vec2;

public class Enemy_Level2 extends Character {
    private static final Shape CharacterShape = new BoxShape(1,2.5f);
    private static final BodyImage image = new BodyImage("data/Gangsters_2/Idle(1).png", 5.5f);
    private int direction = 1;
    private int frameCounter = 0;
    private final float leftBound;
    private final float rightBound;
    private int lives = 2;
    public Enemy_Level2(World world, float leftBound, float rightBound) {
        super(world);
        this.leftBound = leftBound;
        this.rightBound = rightBound;
        removeAllImages();
        addImage(image);
        setFixedRotation(true);
        setAngle(0f);
    }
    public void lose_Life(){
        lives--;
        if (lives <= 0) {
            destroy();
        }
    }

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
    private int animationTick = 0;

    public void update_Level2(){
        float x = getPosition().x;
        if (x > rightBound) direction = -1;
        if (x < leftBound) direction = 1;

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
        } else {
            addImage(walkFrames2[frameCounter % walkFrames2.length]);
        }
        frameCounter = (frameCounter + 1) % walkFrames2.length;
    }

    private void setFixedRotation(boolean b) {}
}
