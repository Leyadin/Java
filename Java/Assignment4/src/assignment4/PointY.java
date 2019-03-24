//Jason Rutledge
//Assignment 4
//Purpose:
//	Point class Comparator

package assignment4;

import java.util.Comparator;

public class PointY implements Comparator<Point> {

	@Override
	public int compare(Point a, Point b) {
		if (a.y == b.y) //If y values are equal, compare x values
			return a.x - b.x;
		else 
			return a.y - b.y;
	}

	

}
