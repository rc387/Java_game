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
    private static SoundClip soundClip;

    public Character(World world) {
        super(world, CharacterShape);
        addImage(image);
        setFixedRotation(true);
        setAngle(0f);
    }

    public void loselife() { // Used to deduct a life when method is called.
        lives--;
        if (lives <= 0) {
        playerDeath();
        }
    }

    public static void shieldLife(){
        // Used to keep the lives value to same in case a collision caused a life to be deducted erroneously.
    }

    private void setFixedRotation(boolean b) {}

    public static void hearts(Graphics2D g) {
        for(int i = 0; i < lives; i++){
            g.drawImage(heart,i*50, i,50,50,null);
        }
    }

    public void playerDeath(){ // Used to destroy the player.
        removeAllImages();
        if(lives == 0){
            destroy();
            soundClip.stop();
        }

    }

    public void finish(){
        soundClip.stop();
    }

    public void nextLevel(){
        soundClip.play();
    }

    public static void setSoundClip() {
        try {
            soundClip = new SoundClip("data/7-dessert.wav"); // Used to initialise the background music.
            soundClip.loop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setSoundClip_Level2() {
        try {
            soundClip = new SoundClip("data/11-gt-force.wav");
            soundClip.loop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
// Author: Jonathan Ross
