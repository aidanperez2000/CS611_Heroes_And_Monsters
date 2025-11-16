package world;

import game.GameEngine;

/*Behavior class for inaccessible tiles*/
public class InaccesibleBehavior implements TileBehavior {

    /*Attempt to enter an inaccessible tile
     * engine: game with inaccessible tile to enter*/
    @Override
    public void enter(GameEngine engine) {
        System.out.println("This tile is inaccessible.");
    }

    /*Is the inaccessible tile accessible?
     * returns: false because inaccessible tiles are not accessible*/
    @Override
    public boolean isAccessible() {
        return false;
    }
}
