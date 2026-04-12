package game;
import city.cs.engine.*;
import city.cs.engine.Shape;
import city.cs.engine.DynamicBody;
import javax.swing.*;
import java.awt.*;

public class Character extends DynamicBody  {
    private static final Shape CharacterShape = new BoxShape(1f, 2.5f);
    private static final BodyImage image = new BodyImage("data/Fighter/Idle(1).png", 5.5f);
    private static final Image heart = new ImageIcon("data/PNG/Bronze/Bronze_11.png").getImage();
    private static final Image bullets = new ImageIcon("data/Shots_icon.png").getImage();
    private int lives = 3;
    private int shots = 3;

    public Character(World world) {
        super(world, CharacterShape);
        addImage(image);
        setFixedRotation();
        setAngle(0f);
    }

    public void loseLife() { // Used to deduct a life when method is called.
        lives--;
        if (lives <= 0) { playerDeath();}
    }

    public void gainLife(){ // Used to add a life when method is called.
         lives++;
    }

    public static void shieldLife(){
        // Used to keep the lives value to same in case a collision caused a life to be deducted erroneously.
    }

    private void setFixedRotation() {}

    public void hearts(Graphics2D g) { // Used to show how many lives the player has.
        for(int i = 0; i < lives; i++){ g.drawImage(heart,i*50, i,50,50,null);}}

    public void playerDeath(){ // Used to destroy the player.
        removeAllImages();
        if(lives == 0){ destroy();}}

    public void Shots(Graphics2D g){ // Used to show how many shots the player has.
        int y = 55;
        for(int i = 0; i < shots; i++){ g.drawImage(bullets,i*50,y,50,50,null);}}

    public void gainShots(){ // Called when player makes contact with a shot icon.
        shots++;
        if (shots % 5 == 0){ gainLife();}}

    public void loseShots(){ // Called when the player shoots a shot.
        shots--;
        if(shots <= 0){ loseLife();}}
}
// Author: Jonathan Ross
