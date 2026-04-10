package game;

import city.cs.engine.*;

import javax.swing.*;


public abstract class GameWorld extends World {
    private static final Shape PlatformShape = new BoxShape(1f, 2f);
    private Timer levelTimer;
    private final boolean[] moveRight = {false}; // Boolean flag used to determine if the player can move right or not.
    private final boolean[] moveLeft = {false}; // Boolean flag used to determine if the player can move left or not.
    public GameWorld() {

    }
    static void main(String[] args) {

    }
}
// Author: Jonathan Ross