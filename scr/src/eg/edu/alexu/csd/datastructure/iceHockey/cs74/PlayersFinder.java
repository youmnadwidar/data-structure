package eg.edu.alexu.csd.datastructure.iceHockey.cs74;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;

public class PlayersFinder implements IPlayersFinder {

	public int numofsquaresrequired;
	public int numofsquares;
	Point min=new Point();
	Point max=new Point ();
	boolean visited[][] ;

	@Override
	public Point players(int row, int col, String[] photo, int team) {

		if (min.x > row) {
			min.x = row;
		}
		if (min.y > col)
			min.y = col;
		if (max.x < row)
			max.x = row;
		if (max.y < col)
			max.y = col;
         if(col+1 < photo[1].length()){
		if (photo[row].charAt(col + 1) == (team + '0') && visited[row][col + 1] == false) {
			
			numofsquares++;
			 visited[row][col + 1] =true;
			
			players(row, col + 1, photo, team);
		}
		}
		if( (col-1 >= 0)){
		if (photo[row].charAt(col-1) == team + '0' && visited[row][col - 1] == false ) {
			numofsquares++;
			visited[row][col-1]=true;

			players(row, col - 1, photo, team);
		}
		}
		if(row+1 < photo.length){
		if (photo[row + 1].charAt(col) == team + '0' && visited[row + 1][col] == false ) {
			numofsquares++;
			visited[row+1][col]=true;
			players(row + 1, col, photo, team);
		}
		}
		if(row-1 >= 0)
		{
		if (photo[row - 1].charAt(col) == team + '0' && visited[row - 1][col] == false ) {
			numofsquares++;
			visited[row-1][col]=true;

			players(row - 1, col, photo, team);
		}
		}
		
		if (numofsquares*4 >= numofsquaresrequired) {

			
		return new Point(min.y+max.y+1,min.x+max.x+1);//*2+2 then /2 gives us this resault 
		}else{
			return null;
		}
	}
	

	public Point[] findPlayers(String[] photo, int team, int threshold) {
		//if(photo.length==0)
		//	return new Point[0];
		if(photo==null)
			return null;
		else if (photo.length==0)
			return new Point[0];
		
		numofsquaresrequired = threshold;
		
		
		ArrayList<Point>  places = new ArrayList<Point>();
		Point temp=new Point();
		visited= new boolean[photo.length][photo[1].length()];
		for (int i = 0; i < photo.length; i++) {
			for (int j = 0; j < photo[i].length(); j++) {
				if (visited[i][j] == false) {
					visited[i][j]=true;

					if ((photo[i].charAt(j)) == team + '0') {
						numofsquares = 1;
						min.setLocation(i, j);
						max.setLocation(i, j);
						temp =players(i, j, photo, team);
						if(temp!=null){
                      places.add(temp);
                     
				}
			}
		}
			}
		}
				Point [] finalplaces=new Point[places.size()];

			finalplaces = places.toArray(finalplaces);
			
Arrays.sort(finalplaces, new Comparator<Point>()
{
	 public int compare(Point a,Point b)
	{
		int ans=Integer.compare(a.x,b.x);
		if(ans==0)
			return Integer.compare(a.y, b.y);
		else 
			return ans;
	}
}
);

	
		return finalplaces;

	}
	}



	


