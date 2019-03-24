//Jason Rutledge
//Assignment 4
//Purpose:
//	Define the Point class

package assignment4;

public class Point implements Comparable<Point> {
	int x, y;
	
	public Point() {
		this.x = 0;
		this.y = 0;
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "(" + Integer.toString(x) + ", " + Integer.toString(y) + ")";
	}

	@Override
	public int compareTo(Point b) {
		if (this.x > b.x)
			return 1;
		else if (this.x < b.x)
			return -1;
		else {
			if (this.y > b.y)
				return 1;
			else if (this.y < b.y)
				return -1;
			else
				return 0; //return 0 if both x and y are equal
		}
	}
	
	
}
