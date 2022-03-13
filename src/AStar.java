import java.util.*;

public class AStar {
    static ArrayList<Grid> VisitedGrid;
    PriorityQueue<Grid> Queue_State;

    public AStar() {
        VisitedGrid = new ArrayList<>();
        this.Queue_State = new PriorityQueue<>(new CompareGrid());
    }


    public Grid AStarSearch(Grid Maze) {

        Maze.setF(Maze.getG() + Maze.Cost);
        Grid solution = new Grid(Maze);

        Queue_State.add(Maze);

        System.out.println(Maze.f);
        System.out.println(Maze);
        while (!Queue_State.isEmpty()) {
            Grid Current = Queue_State.poll();
            if (!VisitedGrid.contains(Current)) {
                VisitedGrid.add(Current);
            }

            if (Current.EndOfGame() == GameState.Player_is_Winner) {
                solution = new Grid(Current);
                System.out.println(solution.f);
                return solution;


            } else {

                PriorityQueue<Grid> children = Current.GetNextGridUniformCost();


                for (Grid grid : children) {

                    if (grid.EndOfGame() == GameState.Player_is_Winner) {
                        solution = new Grid(grid);
                        System.out.println(solution.f);
                        return solution;
                    }

                    if (!VisitedGrid.contains(grid)) {
                        Queue_State.add(grid);
                        VisitedGrid.add(grid);
                    }
//                    else {
//
//                        // Compare Child With all Grid Visited and Remove Grid With height Cost
//                        for (Grid iterator : VisitedGrid) {
//
//                            if (iterator.Cost > grid.Cost) {
//
//                                VisitedGrid.remove(iterator);
//
//                                VisitedGrid.add(grid);
//
//                                Queue_State.add(grid);
//
//                            }
//                        }
//                    }


                }
            }
        }
        System.out.println(solution.f);
        return solution;

    }


}