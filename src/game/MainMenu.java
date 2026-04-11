package game;

import city.cs.engine.World;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainMenu extends World {

    public MainMenu() {

        MainMenuBackground view = new MainMenuBackground(this,640,595);

        final JFrame frame = new JFrame("Main Menu");
        frame.add(view);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        frame.setBackground(Color.BLACK);

        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_P) {
                    frame.dispose();
                    Level1.main();
                }

                if (e.getKeyCode() == KeyEvent.VK_E) {
                    frame.dispose();
                }
            }
        });
    }

    static void main(String[] args) {
        new MainMenu();
    }
}


