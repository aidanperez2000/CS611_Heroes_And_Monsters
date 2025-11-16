package world;

/*Class for building world map*/
public class WorldMap {
    private final Tile[][] grid;

    public WorldMap(int rows, int cols) {
        grid = new Tile[rows][cols];
    }

    /*Get Tile at position
    * x: x-position of tile
    * y: y-position of tile
    * returns: tile at given position*/
    public Tile getTile(int x, int y) {
        return grid[x][y];
    }

    /*Set tile in grid to value
    * x: x-position of tile
    * y: y-position of tile
    * tile: tile to set*/
    public void setTile(int x, int y, Tile tile) {
        grid[x][y] = tile;
    }

    /*Get the number of rows in tile
    * returns: number of rows in tile*/
    public int getRows() {
        return grid.length;
    }

    /*Get the number of columns in tile
    * returns: number of columns in tile*/
    public int getCols() {
        return grid[0].length;
    }

    /*Print a map of the world
    * playerRow: current player row
    * playerCol: current player col*/
    public void printMap(int playerRow, int playerCol) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (r == playerRow && c == playerCol) {
                    System.out.print("P ");
                } else if (!grid[r][c].isAccessible()) {
                    System.out.print("X ");
                } else if (grid[r][c].getBehavior() instanceof MarketBehavior) {
                    System.out.print("M ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
