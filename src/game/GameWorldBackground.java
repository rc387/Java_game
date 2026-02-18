package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public class GameWorldBackground extends UserView {
    private Image background;
    public GameWorldBackground(World w, int width, int height) {
        super(w, width, height);
        background = new ImageIcon("data/background(1).jpg").getImage();
    }


    protected void paintBackground(Graphics2D g) {
        g.setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR
        );
        g.drawImage(background,0,-30,getWidth(), getHeight(),null);
    }
    @Override
    public void setBackground(Color bgColor) {
        super.setBackground(Color.black);
    }
    @Override
    protected void paintForeground(Graphics2D g) {
        Character.hearts(g);
    }
}
