package game;
import city.cs.engine.*;
import city.cs.engine.Shape;
import city.cs.engine.DynamicBody;

import javax.swing.*;
import java.awt.*;

public class Character extends DynamicBody  {
    private static final Shape CharacterShape = new BoxShape(1,2.5f);
    private static final BodyImage image = new BodyImage("data/Fighter/Idle(1).png", 5.5f);
    private static final Image heart = new ImageIcon("data/PNG/Bronze/Bronze_11.png").getImage();
    private static int lives = 3;
    private int frameCounter = 0;

    public Character(World world) {
        super(world, CharacterShape);
        addImage(image);
        setFixedRotation(true);
        setAngle(0f);
    }

    public int getLives() {
        return lives;
    }

    public  void loselife() {
        lives--;
        if (lives <= 0) {
        playerDeath();
        }
    }

    public static void shieldLife(){
        lives = lives;
    }

    private void setFixedRotation(boolean b) {}

    public static void hearts(Graphics2D g) {
        for(int i = 0; i < lives; i++){
            g.drawImage(heart,i*50,i*1,50,50,null);
        }
    }

    BodyImage[] DeadFrames = new BodyImage[]{
            new BodyImage("data/Fighter/Dead(1).png", 5.5f),
            new BodyImage("data/Fighter/Dead(2).png", 5.5f),
            new BodyImage("data/Fighter/Dead(3).png", 5.5f),
    };

    public void playerDeath(){
        removeAllImages();
        if(lives == 0){
            addImage(DeadFrames[frameCounter % DeadFrames.length]);
            frameCounter =  (frameCounter + 1) % DeadFrames.length;
            destroy();
        }

    }

}

