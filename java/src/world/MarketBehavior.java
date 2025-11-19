package world;

import game.GameEngine;

/*Behavior class for market tiles*/
public class MarketBehavior implements TileBehavior {

    /*Enter a market tile
    * engine: game with market tile to enter*/
    @Override
    public void enter(GameEngine engine) {
        System.out.println("You stepped onto a market tile! Press " +
                GameEngine.MARKET + " if you want to enter the market.");
    }

    /*Is the market tile accessible?
    * returns: true because market tiles are accessible*/
    @Override
    public boolean isAccessible() {
        return true;
    }
}
