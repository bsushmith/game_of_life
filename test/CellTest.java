import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CellTest {

    @Test
    public void isAliveNextGeneration_expectsTrue_whenAliveCellHasExactlyTwoNeighbouringAliveCells() {
        Location location = new Location(0, 0);
        Cell cell = new Cell(location, CellState.ALIVE);

        boolean result = cell.isAliveNextGeneration(2);

        assertTrue(result);
    }

    @Test
    public void isAliveNextGeneration_expectsTrue_whenAliveCellHasExactlyThreeNeighbouringAliveCells() {
        Location location = new Location(0, 0);
        Cell cell = new Cell(location, CellState.ALIVE);

        boolean result = cell.isAliveNextGeneration(3);

        assertTrue(result);
    }

    @Test
    public void isAliveNextGeneration_expectsFalse_whenAliveCellHasExactlyOneNeighbouringAliveCells() {
        Location location = new Location(0, 0);
        Cell cell = new Cell(location, CellState.ALIVE);

        boolean result = cell.isAliveNextGeneration(1);

        assertFalse(result);
    }

    @Test
    public void isAliveNextGeneration_expectsFalse_whenDeadCellHasExactlyOneNeighbouringAliveCells() {
        Location location = new Location(0, 0);
        Cell cell = new Cell(location, CellState.DEAD);

        boolean result = cell.isAliveNextGeneration(1);

        assertFalse(result);
    }

    @Test
    public void isAliveNextGeneration_expectsFalse_whenDeadCellHasExactlyTwoNeighbouringAliveCells() {
        Location location = new Location(0, 0);
        Cell cell = new Cell(location, CellState.DEAD);

        boolean result = cell.isAliveNextGeneration(2);

        assertFalse(result);
    }

    @Test
    public void isAliveNextGeneration_expectsTrue_whenDeadCellHasExactlyThreeNeighbouringAliveCells() {
        Location location = new Location(0, 0);
        Cell cell = new Cell(location, CellState.DEAD);

        boolean result = cell.isAliveNextGeneration(3);

        assertTrue(result);
    }

    @Test
    public void isAliveNextGeneration_expectsFalse_whenDeadCellHasNoAliveNeighbourCells() {
        Location location = new Location(0, 0);
        Cell cell = new Cell(location, CellState.DEAD);

        boolean result = cell.isAliveNextGeneration(0);

        assertFalse(result);
    }

    @Test
    public void isAliveNextGeneration_expectsFalse_whenAliveCellHasNoAliveNeighbourCells() {
        Location location = new Location(0, 0);
        Cell cell = new Cell(location, CellState.ALIVE);

        boolean result = cell.isAliveNextGeneration(0);

        assertFalse(result);
    }

}
