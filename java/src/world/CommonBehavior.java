package world;

import game.GameEngine;

/*Behavior class for common tiles*/
public class CommonBehavior implements TileBehavior {

    /*Enter a common tile
     * engine: game with common tile to enter*/
    @Override
    public void enter(GameEngine engine) {
        if (Math.random() < 0.2)
            engine.startBattle();
        else
            System.out.println("The area seems peaceful...for now.");
    }

    /*Is the common tile accessible?
     * returns: true because common tiles are accessible*/
    @Override
    public boolean isAccessible() {
        return true;
    }
}
