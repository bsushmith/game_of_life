import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SpaceTimeTest {

    @Test
    public void tick_expectsBlockPattern_whenGivenBlockPattern() {
        Cell cell1 = new Cell(new Location(1, 1), CellState.ALIVE);
        Cell cell2 = new Cell(new Location(1, 2), CellState.ALIVE);
        Cell cell3 = new Cell(new Location(2, 1), CellState.ALIVE);
        Cell cell4 = new Cell(new Location(2, 2), CellState.ALIVE);
        Set<Cell> cells = new HashSet<>();
        cells.add(cell1);
        cells.add(cell2);
        cells.add(cell3);
        cells.add(cell4);
        SpaceTime spaceTime = SpaceTime.create(cells);

        Cell expectedCell1 = new Cell(new Location(1, 1), CellState.ALIVE);
        Cell expectedCell2 = new Cell(new Location(1, 2), CellState.ALIVE);
        Cell expectedCell3 = new Cell(new Location(2, 1), CellState.ALIVE);
        Cell expectedCell4 = new Cell(new Location(2, 2), CellState.ALIVE);
        Set<Cell> expectedCells = new HashSet<>();
        expectedCells.add(expectedCell1);
        expectedCells.add(expectedCell2);
        expectedCells.add(expectedCell3);
        expectedCells.add(expectedCell4);
        SpaceTime expectedSpaceTime = SpaceTime.create(expectedCells);

        spaceTime.tick();

        assertEquals(expectedSpaceTime, spaceTime);
    }

    @Test
    public void tick_expectsBoatPattern_whenGivenBoatPattern() {
        Cell cell1 = new Cell(new Location(0, 1), CellState.ALIVE);
        Cell cell2 = new Cell(new Location(1, 0), CellState.ALIVE);
        Cell cell3 = new Cell(new Location(2, 1), CellState.ALIVE);
        Cell cell4 = new Cell(new Location(0, 2), CellState.ALIVE);
        Cell cell5 = new Cell(new Location(1, 2), CellState.ALIVE);
        Set<Cell> cells = new HashSet<>();
        cells.add(cell1);
        cells.add(cell2);
        cells.add(cell3);
        cells.add(cell4);
        cells.add(cell5);
        SpaceTime spaceTime = SpaceTime.create(cells);

        Cell expectedCell1 = new Cell(new Location(0, 1), CellState.ALIVE);
        Cell expectedCell2 = new Cell(new Location(1, 0), CellState.ALIVE);
        Cell expectedCell3 = new Cell(new Location(2, 1), CellState.ALIVE);
        Cell expectedCell4 = new Cell(new Location(0, 2), CellState.ALIVE);
        Cell expectedCell5 = new Cell(new Location(1, 2), CellState.ALIVE);
        Set<Cell> expectedCells = new HashSet<>();
        expectedCells.add(expectedCell1);
        expectedCells.add(expectedCell2);
        expectedCells.add(expectedCell3);
        expectedCells.add(expectedCell4);
        expectedCells.add(expectedCell5);
        SpaceTime expectedSpaceTime = SpaceTime.create(expectedCells);

        spaceTime.tick();

        assertEquals(expectedSpaceTime, spaceTime);
    }

    @Test
    public void tick_expectsBlinkerPatternTwo_whenGivenBlinkerPatternOneOscillator() {
        Cell cell1 = new Cell(new Location(1, 1), CellState.ALIVE);
        Cell cell2 = new Cell(new Location(1, 0), CellState.ALIVE);
        Cell cell3 = new Cell(new Location(1, 2), CellState.ALIVE);
        Set<Cell> cells = new HashSet<>();
        cells.add(cell1);
        cells.add(cell2);
        cells.add(cell3);
        SpaceTime spaceTime = SpaceTime.create(cells);

        Cell expectedCell1 = new Cell(new Location(1, 1), CellState.ALIVE);
        Cell expectedCell2 = new Cell(new Location(0, 1), CellState.ALIVE);
        Cell expectedCell3 = new Cell(new Location(2, 1), CellState.ALIVE);
        Set<Cell> expectedCells = new HashSet<>();
        expectedCells.add(expectedCell1);
        expectedCells.add(expectedCell2);
        expectedCells.add(expectedCell3);
        SpaceTime expectedSpaceTime = SpaceTime.create(expectedCells);

        spaceTime.tick();

        assertEquals(expectedSpaceTime, spaceTime);
    }

    @Test
    public void tick_expectsToadPatternTwo_whenGivenToadPatternOneOscillator() {
        Cell cell1 = new Cell(new Location(1, 1), CellState.ALIVE);
        Cell cell2 = new Cell(new Location(1, 2), CellState.ALIVE);
        Cell cell3 = new Cell(new Location(1, 3), CellState.ALIVE);
        Cell cell4 = new Cell(new Location(2, 2), CellState.ALIVE);
        Cell cell5 = new Cell(new Location(2, 3), CellState.ALIVE);
        Cell cell6 = new Cell(new Location(2, 4), CellState.ALIVE);
        Set<Cell> cells = new HashSet<>();
        cells.add(cell1);
        cells.add(cell2);
        cells.add(cell3);
        cells.add(cell4);
        cells.add(cell5);
        cells.add(cell6);
        SpaceTime spaceTime = SpaceTime.create(cells);

        Cell expectedCell1 = new Cell(new Location(0, 2), CellState.ALIVE);
        Cell expectedCell2 = new Cell(new Location(1, 1), CellState.ALIVE);
        Cell expectedCell3 = new Cell(new Location(1, 4), CellState.ALIVE);
        Cell expectedCell4 = new Cell(new Location(2, 1), CellState.ALIVE);
        Cell expectedCell5 = new Cell(new Location(2, 4), CellState.ALIVE);
        Cell expectedCell6 = new Cell(new Location(3, 3), CellState.ALIVE);
        Set<Cell> expectedCells = new HashSet<>();
        expectedCells.add(expectedCell1);
        expectedCells.add(expectedCell2);
        expectedCells.add(expectedCell3);
        expectedCells.add(expectedCell4);
        expectedCells.add(expectedCell5);
        expectedCells.add(expectedCell6);
        SpaceTime expectedSpaceTime = SpaceTime.create(expectedCells);

        spaceTime.tick();

        assertEquals(expectedSpaceTime, spaceTime);

    }

}