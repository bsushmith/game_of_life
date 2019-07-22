import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Cell> cells = new HashSet<>();

        String line;
        while (!(line = sc.nextLine()).isEmpty()) {
            String[] input = line.replaceAll("\\s+", "").split(",");

            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            Cell cell = new Cell(new Location(x, y), CellState.ALIVE);
            cells.add(cell);
        }
        Universe universe = Universe.create(cells);
        System.out.println("Current Generation: " + "\n" + universe.toString());

        universe.tick();
        System.out.println("Future Generation: " + "\n" + universe.toString());
    }
}
