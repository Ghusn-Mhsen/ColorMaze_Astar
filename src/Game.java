
import java.util.Scanner;

public class Game {
    Grid grid;

    AStar astar;
    Scanner input;

    public Game() {
        grid = new Grid(5, 5, new Cell(0, 0));
        input = new Scanner(System.in);

        astar = new AStar();
    }

    void StartGame() {
        System.out.println("Enter ( 1 ) For AStar :");
        System.out.println("Enter ( 2 For Exit :");

        switch (input.nextInt()) {
                case 1:
                    System.out.println("The Optimal Solution is : ");
                    System.out.println(astar.AStarSearch(grid));

                    break;
            case 2:

                System.exit(0);
            default:
                System.out.println("Wrong choice , Try Again");

        }


    }
}
