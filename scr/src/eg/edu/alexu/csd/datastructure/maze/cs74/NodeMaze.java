package eg.edu.alexu.csd.datastructure.maze.cs74;

import java.awt.Point;
/**
 * .
 * @author HP
 *
 */
public class NodeMaze {
  /**
   * .
   */
Point position;
/**
 * .
 */
NodeMaze parent;
/**
 * @param position1 node.
 * @param parent1 node.
 */
public NodeMaze(final Point position1, final NodeMaze parent1) {
  super();
  this.position = position1;
  this.parent = parent1;
}

}
