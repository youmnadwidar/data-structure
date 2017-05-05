package eg.edu.alexu.csd.datastructure.iceHockey;

import java.awt.Point;
/**
 * @author HP.
 *
 */
public interface IPlayersFinder {
  /**
   * Search for players locations at the given photo.
   * @param photo Two dimension array of photo contents
   *  Will contain between 1 and 50 elements,
   *          inclusive
   * @param team
   *          Identifier of the team
   * @param threshold
   *          Minimum area for an element Will be between 1 and 10000, inclusive
   * @return Array of players locations of the given team
   */
  java.awt.Point[] findPlayers(String[] photo, int team, int threshold);

  /**
   * find the players by DFS.
   * @param row
   *          the row the index of the cell
   * @param col
   *          the column index of the cell
   * @param photo Two dimension array of photo contents
   *           Will contain between 1 and 50 elements,
   *          inclusive
   * @param team the number of the wanted team
   * @return the center point of the player
   */
  Point players(int row, int col, String[] photo, int team);
}
