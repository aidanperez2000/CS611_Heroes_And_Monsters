package world;

/*Class for building world map*/
public class WorldMap {
    private final Tile[][] grid;
    private final int rows;
    private final int cols;

    public WorldMap(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new Tile[rows][cols];
        generate();
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

    /*Get the number of rows in the map
    * returns: number of rows in the map*/
    public int getRows() {
        return rows;
    }

    /*Get the number of columns in the map
    * returns: number of columns in the map*/
    public int getCols() {
        return cols;
    }

    /*Print a map of the world
    * playerRow: current player row
    * playerCol: current player col*/
    public void printMap(int playerRow, int playerCol) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
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

    /*Generate the map*/
    private void generate() {
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                double roll = Math.random();

                if (roll < 0.2)
                    grid[x][y] = new Tile(new InaccessibleBehavior());
                else if (roll < 0.5)
                    grid[x][y] = new Tile(new MarketBehavior());
                else
                    grid[x][y] = new Tile(new CommonBehavior());
            }
        }
    }
}
