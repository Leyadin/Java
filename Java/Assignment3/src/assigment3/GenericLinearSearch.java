//Jason Rutledge
//Assigment 3
//Purpose: Implement a linear search using a generic array

package assigment3;

import java.util.Arrays;

public class GenericLinearSearch {
	public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
		//Linear search algorithm
		//returns the index of a matching value
		for (int i = 0; i < list.length; i++)
			if (key.equals(list[i]))
				return i;
		
		//return -1 if key is found
		return -1;
	}
	
	//Test code
	public static void main(String[] args) {
		Integer[] test = {1, 2, 3, 4, 5, 7, 12, 13, 14, 14, 22, 27, 28, 45, 46};
		
		System.out.println("Test array: " + Arrays.toString(test));
		//Testing middle, expected - 7
		System.out.println("Searching for 12: " + linearSearch(test, 13));
		//Testing lower, expected - 2
		System.out.println("Searching for 3: " + linearSearch(test, 3));
		//Testing upper, expected - 12
		System.out.println("Searching for 28: " + linearSearch(test, 28));
		//Testing a value not in array, expected - -1
		System.out.println("Searching for 6: " + linearSearch(test, 6));
		
		System.out.println();
		System.out.println();
		
		String[] test2 = {"a", "b", "c", "d", "e", "g", "i", "j", "j", "k", "n", "o", "q", "y", "z"};
		System.out.println("Test array: " + Arrays.toString(test2));
		//Testing middle, expected - 7
		System.out.println("Searching for j: " + linearSearch(test2, "j"));
		//Testing lower, expected - 0
		System.out.println("Searching for a: " + linearSearch(test2, "a"));
		//Testing upper, expected - 13
		System.out.println("Searching for y: " + linearSearch(test2, "y"));
		//Testing a value not in array, expected - -1
		System.out.println("Searching for h: " + linearSearch(test2, "h"));
	}

}
