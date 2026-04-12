package game;

import city.cs.engine.BodyImage;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public class Raider_Enemy extends Enemy{
    private float direction = 1;
    private int frameCounter = 0;
    private static int enemies_left_L2 = 14;
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


    private int animationTick = 0;

    public void update_Level2(){
        float x = getPosition().x;
        if (x > rightBound) direction = -1; if (x < leftBound) direction = 1;

        setLinearVelocity(new Vec2(2f * direction, 0));
        animationTick++; // Used to control the speed of the animation.
        if (direction == 1 || direction == -1) {
            if (animationTick % 10 == 0) { // Use of AI:animationTick, to control the speed of the animation using modulus.
                animate_Level2();
            }
        }

}
    public void animate_Level2(){
        removeAllImages();
        if (direction == -1) { addImage(leftWalkFrames2[frameCounter % leftWalkFrames2.length]);}
        else if (direction == 1) { addImage(walkFrames2[frameCounter % walkFrames2.length]);}

        frameCounter = (frameCounter + 1) % walkFrames2.length;
    }

    @Override
    protected void lose_enemy(){ // Deducted when an enemy is defeated.
        enemies_left_L2--;
    }

    public static void resetCount() { // Resets the counter when Level 2 starts.
        enemies_left_L2 = 14;
    }

    public static int getEnemies_left_L2() { // Method called to show on screen the counter.
        return enemies_left_L2;
    }
}
