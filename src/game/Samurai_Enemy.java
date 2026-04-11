package game;

import city.cs.engine.BodyImage;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public class Samurai_Enemy extends Enemy {
    private float direction = 1;
    private int frameCounter = 0;
    public Samurai_Enemy(World world, float leftBound, float rightBound, int lives) {
        super(world, leftBound, rightBound, lives);
    }

    BodyImage[] walkFrames4 = new BodyImage[]{
            new BodyImage("data/Samurai_L4/Walk(1).png", 5.5f),
            new BodyImage("data/Samurai_L4/Walk(2).png", 5.5f),
            new BodyImage("data/Samurai_L4/Walk(3).png", 5.5f),
            new BodyImage("data/Samurai_L4/Walk(4).png", 5.5f),
            new BodyImage("data/Samurai_L4/Walk(5).png", 5.5f),
            new BodyImage("data/Samurai_L4/Walk(6).png", 5.5f),
            new BodyImage("data/Samurai_L4/Walk(7).png", 5.5f),
            new BodyImage("data/Samurai_L4/Walk(8).png", 5.5f),
            new BodyImage("data/Samurai_L4/Walk(9).png", 5.5f),
    };
    BodyImage[] LeftWalkFrames4 = new BodyImage[]{
            new BodyImage("data/Samurai_L4/LeftWalk(1).png", 5.5f),
            new BodyImage("data/Samurai_L4/LeftWalk(2).png",5.5f),
            new BodyImage("data/Samurai_L4/LeftWalk(3).png", 5.5f),
            new BodyImage("data/Samurai_L4/LeftWalk(4).png", 5.5f),
            new BodyImage("data/Samurai_L4/LeftWalk(5).png", 5.5f),
            new BodyImage("data/Samurai_L4/LeftWalk(6).png", 5.5f),
            new BodyImage("data/Samurai_L4/LeftWalk(7).png", 5.5f),
            new BodyImage("data/Samurai_L4/LeftWalk(8).png", 5.5f),
            new BodyImage("data/Samurai_L4/LeftWalk(9).png", 5.5f),
    };
    BodyImage[] HurtFrames4 = new BodyImage[]{
            new BodyImage("data/Samurai_L4/Hurt(1).png", 5.5f),
            new BodyImage("data/Samurai_L4/Hurt(2).png",5.5f),
            new BodyImage("data/Samurai_L4/Hurt(3).png", 5.5f),
    };
    BodyImage[] LeftHurtFrames4 = new BodyImage[]{
            new BodyImage("data/Samurai_L4/LeftHurt(1).png", 5.5f),
            new BodyImage("data/Samurai_L4/LeftHurt(2).png",5.5f),
            new BodyImage("data/Samurai_L4/LeftHurt(3).png", 5.5f),
    };

    private int animationTick = 0;

    public void update_Level4(){
        float x = getPosition().x;
        if (x > rightBound) direction = -1; if (x < leftBound) direction = 1;
        if (lives < 3 && x > rightBound) direction = -0.1f; if (lives < 3 && x < leftBound) direction = 0.1f;

        setLinearVelocity(new Vec2(3 * direction, 0));
        animationTick++;
        if (direction == 1 || direction == -1) {
            if (animationTick % 10 == 0) { // Use of AI:animationTick, to control the speed of the animation using modulus.
                animate_Level4();
            }} else if (direction == 0.1f || direction == -0.1f) {
            if (animationTick % 5 == 0) {
                animate_Level4();
            }}
    }

    public void animate_Level4(){
        removeAllImages();
        if (direction == -1) { addImage(LeftWalkFrames4[frameCounter % LeftWalkFrames4.length]);}
        else if (direction == 1) { addImage(walkFrames4[frameCounter % walkFrames4.length]);}
        else if(direction == -0.1f) {
            frameCounter = (frameCounter + 1) % HurtFrames4.length;
            addImage(HurtFrames4[frameCounter % HurtFrames4.length]);
        } else if (direction == 0.1f) {
            frameCounter = (frameCounter + 1) % LeftHurtFrames4.length;
            addImage(LeftHurtFrames4[frameCounter % LeftHurtFrames4.length]);
        }
        frameCounter = (frameCounter + 1) % walkFrames4.length;
    }

}
