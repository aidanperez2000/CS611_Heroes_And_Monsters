package world;

import game.GameEngine;

/*Class for keeping track of tiles*/
public class Tile {
    private final TileBehavior behavior;

    public Tile(TileBehavior behavior) {
        this.behavior = behavior;
    }

    /*Enter a tile
    * engine: game with tile to enter*/
    public void enter(GameEngine engine) {
        behavior.enter(engine);
    }

    /*Is the tile accessible?
    * returns: true if tile is accessible and false otherwise*/
    public boolean isAccessible() {
        return behavior.isAccessible();
    }

    /*Get tile behavior
    * returns: tile behavior*/
    public TileBehavior getBehavior() {
        return behavior;
    }
}
