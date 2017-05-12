package eg.edu.alexu.csd.datastructure.maze;
/**
 * .
 * @author HP
 *
 */
public interface IMazeSolver {
  /**
  * Read the maze file, and solve it using Breadth First Search.
  * @param maze maze file
  * @return the coordinates of the found path from point 'S'
  * to point 'E' inclusive, or null if no path found.
  * coordinates indexes are zero based.
  */
  int[][] solveBFS(java.io.File maze);
  /**
  * Read the maze file, and solve it using Depth First Search.
  * @param maze maze file
  * @return the coordinates of the found path from point 'S'
  * to point 'E' inclusive, or null if no path found.
  * coordinates indexes are zero based.
  */
  int[][] solveDFS(java.io.File maze);
  
}
