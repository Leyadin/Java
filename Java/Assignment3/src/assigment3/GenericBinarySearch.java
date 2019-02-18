//Jason Rutledge
//Assigment 3
//Purpose: Implement a binary search using a generic array

package assigment3;

import java.util.Arrays;

public class GenericBinarySearch {
	public static <E extends Comparable<E>> int binarySearch(E[] list, E key) {
		int min = 0, max = list.length - 1;
		
		//Binary search algorithm
		//returns the index of a matching value
		while (min <= max) {
			int mid = (min + max) / 2;	
			if (key.equals(list[mid]))
				return mid;
			else if (key.compareTo(list[mid]) < 0)
				max = mid - 1;
			else if (key.compareTo(list[mid]) > 0)
				min = mid + 1;
		}
		
		//return -1 if key is not found
		return -1;
	}
	
	//Test code
	public static void main(String[] args) {
		Integer[] test = {1, 2, 3, 4, 5, 7, 12, 13, 14, 14, 22, 27, 28, 45, 46};
		
		System.out.println("Test array: " + Arrays.toString(test));
		//Testing middle, expected - 7
		System.out.println("Searching for 12: " + binarySearch(test, 13));
		//Testing lower, expected - 2
		System.out.println("Searching for 3: " + binarySearch(test, 3));
		//Testing upper, expected - 12
		System.out.println("Searching for 28: " + binarySearch(test, 28));
		//Testing a value not in array, expected - -1
		System.out.println("Searching for 6: " + binarySearch(test, 6));
		
		System.out.println();
		System.out.println();
		
		String[] test2 = {"a", "b", "c", "d", "e", "g", "i", "j", "j", "k", "n", "o", "q", "y", "z"};
		System.out.println("Test array: " + Arrays.toString(test2));
		//Testing middle, expected - 7
		System.out.println("Searching for j: " + binarySearch(test2, "j"));
		//Testing lower, expected - 0
		System.out.println("Searching for a: " + binarySearch(test2, "a"));
		//Testing upper, expected - 13
		System.out.println("Searching for y: " + binarySearch(test2, "y"));
		//Testing a value not in array, expected - -1
		System.out.println("Searching for h: " + binarySearch(test2, "h"));
	}

}
