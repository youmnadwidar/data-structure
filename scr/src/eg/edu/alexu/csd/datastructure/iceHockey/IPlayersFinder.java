package eg.edu.alexu.csd.datastructure.iceHockey;

import java.awt.Point;

public interface IPlayersFinder {
	java.awt.Point[] findPlayers(String[] photo, int team, int threshold);

	Point players(int row, int col, String[] photo, int team);
}
