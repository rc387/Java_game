package game;

import city.cs.engine.BodyImage;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public class Raider_Enemy extends Enemy{
    private float direction = 1;
    private int frameCounter = 0;
    private static int enemies_left_L2 = 17;
    public Raider_Enemy(World world, float leftBound, float rightBound, int lives) {
        super(world, leftBound, rightBound, lives);
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
    BodyImage[] hurtFrames2 =  new BodyImage[]{
            new BodyImage("data/Raider_3/Hurt(1).png", 5.5f),
    };
    BodyImage[] rightHurtFrames2 = new BodyImage[]{
            new BodyImage("data/Raider_3/RightHurt.png", 5.5f),
    };

    private int animationTick = 0;

    public void update_Level2(){
        float x = getPosition().x;
        if (x > rightBound) direction = -1;
        if (x < leftBound) direction = 1;
        if (lives == 1 && x > rightBound) direction = -0.1f;
        if (lives == 1 && x < leftBound) direction = 0.1f;

        setLinearVelocity(new Vec2(3 * direction, 0));
        animationTick++; // Used to control the speed of the animation.
        if (direction == 1 || direction == -1) {
            if (animationTick % 10 == 0) { // Use of AI:animationTick, to control the speed of the animation using modulus.
                animate_Level2();
            }}else{
            if (animationTick % 5 == 0) {
                animate_Level2();
            }
        }

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

    @Override
    protected void lose_enemy(){
        enemies_left_L2--;
    }

    public static void resetCount() {
        enemies_left_L2 = 17;
    }

    public static int getEnemies_left_L2() {
        return enemies_left_L2;
    }



}
