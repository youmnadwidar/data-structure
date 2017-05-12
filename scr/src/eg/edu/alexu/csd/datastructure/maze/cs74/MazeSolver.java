package eg.edu.alexu.csd.datastructure.maze.cs74;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.transform.Templates;

import eg.edu.alexu.csd.datastructure.maze.IMazeSolver;
import eg.edu.alexu.csd.datastructure.queue.cs74.LQueue;
import eg.edu.alexu.csd.datastructure.stack.cs74.Stack;

/**
 *
 * @author HP.
 *
 */
public class MazeSolver implements IMazeSolver {
  /**
   * start point.
   */
  Point start = null;
  /**
   * end point.
   */
  Point end = null ;
  /**
   * the maze array.
   */
  char[][] mazeArray;

  /**
   * Read the maze file, and solve it using Breadth First Search.
   * 
   * @param maze
   *          maze file
   * @return the coordinates of the found path from point 'S' to point 'E'
   *         inclusive, or null if no path found. coordinates indexes are zero
   *         based.
   */
  public int[][] solveBFS(final File maze) {
    mazeArray = readFile(maze);
    if(end == null || start == null || mazeArray == null) 
    {
      return null;
    }
    LQueue operate = new LQueue();
    LQueue path = new LQueue();
    boolean found = false;
    boolean[][] visited = new boolean[mazeArray.length][mazeArray[0].length];
    operate.enqueue(start);
    while (operate.size() != 0) {
      Point temp = (Point) operate.dequeue();
      visited[temp.x][temp.y] = true;
      path.enqueue(temp);
      if (temp.equals(end)) {
        found = true;
        break;
      }

      if (checkValid(new Point(temp.x, temp.y - 1), visited)) {
        operate.enqueue(new Point(temp.x, temp.y - 1));
        visited[temp.x][temp.y - 1] = true;
      }
      if (checkValid(new Point(temp.x, temp.y + 1), visited)) {
        operate.enqueue(new Point(temp.x, temp.y + 1));
        visited[temp.x][temp.y + 1] = true;
      }
      if (checkValid(new Point(temp.x - 1, temp.y), visited)) {
        operate.enqueue(new Point(temp.x - 1, temp.y));
        visited[temp.x - 1][temp.y] = true;
      }
      if (checkValid(new Point(temp.x + 1, temp.y), visited)) {
        operate.enqueue(new Point(temp.x + 1, temp.y));
        visited[temp.x + 1][temp.y] = true;
      }
    }
    if (found) {
      return getPath(path);

    } else
      return null;
  }

  /**
   * Read the maze file, and solve it using Depth First Search.
   * 
   * @param maze
   *          maze file
   * @return the coordinates of the found path from point 'S' to point 'E'
   *         inclusive, or null if no path found. coordinates indexes are zero
   *         based.
   */
  public final int[][] solveDFS(final File maze) {
    mazeArray = readFile(maze);
    if(end == null || start == null || mazeArray == null) 
    {
      return null;
    }
    Stack operate = new Stack();
    LQueue path = new LQueue();
    boolean[][] visited = new boolean[mazeArray.length][mazeArray[0].toString()
        .length()];
    operate.push(start);
    while (operate.size() != 0) {
      Point temp;
      temp = (Point) operate.pop();
      path.enqueue(temp);
      visited[temp.x][temp.y] = true;
      if (temp.equals(end)) {
        operate.push(temp);
        break;
      }

      if (checkValid(new Point(temp.x, temp.y - 1), visited)) {
        operate.push(new Point(temp.x, temp.y - 1));
        visited[temp.x][temp.y - 1] = true;
      }
      if (checkValid(new Point(temp.x, temp.y + 1), visited)) {
        operate.push(new Point(temp.x, temp.y + 1));
        visited[temp.x][temp.y + 1] = true;
      }
      if (checkValid(new Point(temp.x - 1, temp.y), visited)) {
        operate.push(new Point(temp.x - 1, temp.y));
        visited[temp.x - 1][temp.y] = true;
      }
      if (checkValid(new Point(temp.x + 1, temp.y), visited)) {
        operate.push(new Point(temp.x + 1, temp.y));
        visited[temp.x + 1][temp.y] = true;
      }

    }
    if (operate.size() == 0) {
      return null;
    } else {
      Point ended = (Point) operate.peek();
      if (ended.equals(end)) {
        return getPath(path);
      } else {
        return null;
      }
    }

  }

  /**
   * read a file.
   * 
   * @param maze
   *          the file
   * @return the file read in char 2D array.
   */
  public char[][] readFile(final File maze) {
    try (BufferedReader read = new BufferedReader(new FileReader(maze))) {
      String currentLine;
      currentLine = read.readLine();
      String[] parts = currentLine.split(" ");
      int rows = Integer.parseInt(parts[0]);
      parts = new String[rows];
      int i = 0;
      int counter = 0 ;
      while ((currentLine = read.readLine()) != null && counter < rows) {
        if (currentLine.contains("S")) {
          start = new Point(i, currentLine.indexOf("S")); 
        }
        if (currentLine.contains("E")) {
          
          end = new Point(i, currentLine.indexOf("E"));
        
        }
        parts[i] = currentLine;
counter++;
        i++;
      }
      char[][] text = new char[parts.length][];
      for (int j = 0; j < parts.length; j++) {
        text[j] = parts[j].toCharArray();
        
      }
      if(counter>=rows){
        return null ;
      }
      return text;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
   
  }

  /**
   * check the point.
   * 
   * @param temp
   *          the point
   * @param visit
   *          visited or not
   * @return is this point valid,
   */
  public final boolean checkValid(final Point temp, final boolean[][] visit) {
    if (temp.x > mazeArray.length - 1 || temp.y > mazeArray[0].length - 1
        || temp.y < 0 || temp.x < 0 || visit[temp.x][temp.y]
        || mazeArray[temp.x][temp.y] == '#') {
      return false;
    }
    return true;

  }

  /**
   * .
   * 
   * @param path
   *          the solution path.
   * @return the path in 2D array.
   */
  public final int[][] getPath(final LQueue path) {
    int[][] answer = new int[path.size()][2];
    int i = 0;
    while (path.size() != 0) {
      Point temp = (Point) path.dequeue();
      answer[i][0] = temp.x;
      answer[i][1] = temp.y;
      i++;
    }
    return answer;
  }
}
