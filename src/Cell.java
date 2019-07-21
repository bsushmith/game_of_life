import java.util.Objects;

public class Cell {

    private Location location;
    private CellState state;

    public Cell(Location location, CellState state) {
        this.location = location;
        this.state = state;
    }

    public Location getLocation() {
        return location;
    }

    public void setState(CellState state) {
        this.state = state;
    }

    public boolean isAlive() {
        return (state == CellState.ALIVE);
    }

    public boolean isAliveNextGeneration(int aliveNeighbourCount) {
        if (isAlive() && (aliveNeighbourCount == 2 || aliveNeighbourCount == 3))
            return true;
        return !isAlive() && aliveNeighbourCount == 3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return Objects.equals(location, cell.location) &&
                state == cell.state;
    }

}
