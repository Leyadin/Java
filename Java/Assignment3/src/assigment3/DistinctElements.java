//Jason Rutledge
//Assigment 3
//Purpose: Take an ArrayList and generate a new one with no duplicates

package assigment3;

import java.util.ArrayList;

public class DistinctElements {
	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
		ArrayList<E> noDupes = new ArrayList<E>();
		
		for (E item: list)
			if (noDupes.contains(item) == false)
				noDupes.add(item);
		
		return noDupes;
	}	
	
	public static void main(String[] args) {
		ArrayList<Integer> test = new ArrayList<Integer>();
		
		for (int i = 0; i < 30; i++)
			test.add((int) (Math.random() * 10));
		
		System.out.println("Test generated...");
		System.out.println(test.toString());
		test = removeDuplicates(test);
		System.out.println("Duplicates removed...");
		System.out.println(test.toString());
	}

}
