import java.util.Arrays;
import java.util.Set;

public class SpaceTime {

    private static final int GRID_LENGTH = 8;
    private static final int GRID_BREADTH = 8;

    private Cell[][] grid;

    private SpaceTime(Cell[][] grid) {
        this.grid = grid;
    }

    public static SpaceTime create(Set<Cell> cells) {
        Cell[][] grid = new Cell[GRID_LENGTH][GRID_BREADTH];

        for (Cell cell : cells) {
            int x = cell.getLocation().getX();
            int y = cell.getLocation().getY();
            grid[x][y] = cell;
        }

        for (int i = 0; i < GRID_LENGTH; i++) {
            for (int j = 0; j < GRID_BREADTH; j++) {
                if (grid[i][j] == null) {
                    grid[i][j] = new Cell(new Location(i, j), CellState.DEAD);
                }
            }
        }
        return new SpaceTime(grid);
    }

    public void tick() {

        Cell[][] nextGenGrid = new Cell[GRID_LENGTH][GRID_BREADTH];

        for (int i = 0; i < GRID_LENGTH; i++) {
            for (int j = 0; j < GRID_BREADTH; j++) {
                Cell cell = grid[i][j];
                Cell nextGenCell = new Cell(new Location(i, j), CellState.DEAD);
                if (cell.isAliveNextGeneration(getAliveNeighbourCount(cell))) {
                    nextGenCell.setState(CellState.ALIVE);
                }
                nextGenGrid[i][j] = nextGenCell;
            }
        }
        grid = nextGenGrid;
    }

    private int getAliveNeighbourCount(Cell cell) {
        int row = cell.getLocation().getX();
        int column = cell.getLocation().getY();

        int aliveNeighboursCount = 0;

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = column - 1; j <= column + 1; j++) {
                if (i < 0 || i == GRID_LENGTH)
                    continue;

                if (j < 0 || j == GRID_BREADTH)
                    continue;

                if (i == row && j == column)
                    continue;

                if (grid[i][j].isAlive())
                    ++aliveNeighboursCount;
            }
        }
        return aliveNeighboursCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpaceTime spaceTime = (SpaceTime) o;
        return Arrays.deepEquals(grid, spaceTime.grid);
    }

    @Override
    public String toString() {
        StringBuilder stringOutput = new StringBuilder();
        for (Cell[] x : grid) {
            for (Cell y : x) {
                int stateValue = 0;
                if (y.isAlive())
                    stateValue = 1;
                stringOutput.append(stateValue).append(" ");
            }
            stringOutput.append("\n");
        }
        return stringOutput.toString();
    }
}
