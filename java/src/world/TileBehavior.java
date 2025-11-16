package world;

import game.GameEngine;

/*Base interface for determining tile behavior*/
public interface TileBehavior {
    /*Enter a tile
    * engine: game with tile to enter*/
    void enter(GameEngine engine);

    /*Is the tile accessible?
    * returns: true if tile is accessible, false otherwise*/
    boolean isAccessible();
}
