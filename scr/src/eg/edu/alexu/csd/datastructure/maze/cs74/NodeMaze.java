package eg.edu.alexu.csd.datastructure.maze.cs74;

import java.awt.Point;

public class NodeMaze {
Point position;
NodeMaze parent;
public NodeMaze(Point position, NodeMaze parent) {
  super();
  this.position = position;
  this.parent = parent;
}

}
