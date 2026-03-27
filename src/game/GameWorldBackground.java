package game;

import city.cs.engine.UserView;
import city.cs.engine.World;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GameWorldBackground extends UserView {
    private final Image background;
    private int timeRemaining = 180;
    private Timer levelTimer;

    public GameWorldBackground(World w, int width, int height, Image background) {
        super(w, width, height);
        this.background = background;
        background = new ImageIcon("data/background(1).jpg").getImage();
        levelTimer = new Timer(1000, e -> { // Timer that's visible on screen.
            if (timeRemaining >= 0) {
                timeRemaining--;
            } else {
                levelTimer.stop();
                ((Timer)e.getSource()).stop();


            }
            repaint();
        });
        levelTimer.start();}

    public int getTimeRemaining() {
        return timeRemaining;
    }

    protected void paintBackground(Graphics2D g) {
        g.setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR
        );
        g.drawImage(background,0,0,getWidth(), getHeight(),null);
    }
    @Override
    public void setBackground(Color bgColor) {
        super.setBackground(Color.black);
    }
    @Override
    protected void paintForeground(Graphics2D g) {
        Character.hearts(g);
        super.paintForeground(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Time: " + getTimeRemaining(), 545, 20);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.drawString("W = jump, A = left, S = shield, D = right, Enter = attack",190,20);
    }
}
// Author: Jonathan Ross