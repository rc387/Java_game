package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import java.awt.*;

public class MainMenuBackground extends UserView {
    public MainMenuBackground(World w, int width, int height) {
        super(w, width, height);
    }

    protected void paintBackground(Graphics2D g) {
        g.setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR
        );
    }

    @Override
    public void setBackground(Color bgColor) { super.setBackground(Color.black);}

    @Override
    protected void paintForeground(Graphics2D g) {
        super.paintForeground(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Welcome to the main menu", 205, 20);
        g.drawString("Play: press P \n Main Menu : press Q " , 1, 70);
        g.drawString("P = pause, \n R = Restart Level ", 1, 170);
        g.drawString("Level 4: Space = shot, ", 1, 370);
        g.drawString("Would recommend to shield whilst attacking",1,520);
        g.drawString("Exit: press E ", 1, 570);
        g.setFont(new Font("Arial", Font.BOLD, 19));
        g.drawString("Controls: W = jump, \n A = left, \n S = shield, \n D = right, \n Enter = attack", 1, 270);
        g.setFont(new Font("Arial", Font.BOLD, 15));
        g.drawString("M = mute, U = unmute, Up Arrow = Increase volume, Down Arrow = Decrease volume", 1, 470);
    }

}
