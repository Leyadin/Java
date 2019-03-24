//Jason Rutledge
//Assignment 4
//Purpose:
//	driver for Point class
//	Generates 100 random points and sorts them in order by X and then Y

package assignment4;

import java.util.Arrays;

public class driverPoint {

	public static void main(String[] args) {
		Point[] pointArr = new Point[100];
		
		for (int i = 0; i < 100; i++) {
			pointArr[i] = new Point((int) (Math.random() * 100), (int) (Math.random() * 100));
		}
		
		//Random points
		System.out.print("Generated array...");
		for (int i = 0; i < 100; i++) {
			if (i % 10 == 0)
				System.out.println();
			
			System.out.print(pointArr[i].toString() + " ");
		}
		System.out.println();
		System.out.println();
		
		//Sorted by X
		Arrays.sort(pointArr);
		System.out.print("Sorted array by x... (left to right)");
		for (int i = 0; i < 100; i++) {
			if (i % 10 == 0)
				System.out.println();
			
			System.out.print(pointArr[i].toString() + " ");
		}
		System.out.println();
		System.out.println();
		
		//Sorted by Y
		Arrays.sort(pointArr, new PointY());
		System.out.print("Sorted array by y... (left to right)");
		for (int i = 0; i < 100; i++) {
			if (i % 10 == 0)
				System.out.println();
			
			System.out.print(pointArr[i].toString() + " ");
		}
	}

}
