//Jason Rutledge
//Assignment 4
//Purpose:
//	Find the union, intersection and difference of two sets

package assignment4;

import java.util.Collections;
import java.util.HashSet;

public class HashSets {

	public static void main(String[] args) {
		HashSet<String> first = new HashSet<String>();
		Collections.addAll(first, "George", "Jim", "John", "Kevin", "Michael");
		
		HashSet<String> second = new HashSet<String>();
		Collections.addAll(second, "George", "Katie", "Kevin", "Michelle", "Ryan");
		
		//Initial sets
		System.out.println("Set 1: " + first.toString());
		System.out.println("Set 2: " + second.toString());
		System.out.println();
		
		//Union
		HashSet<String> union = new HashSet<String>(first);
		union.addAll(second);
		System.out.println("Union...");
		System.out.println(union.toString());
		System.out.println();
		
		//Difference
		HashSet<String> difference1 = new HashSet<String>(first);
		difference1.removeAll(second);
		HashSet<String> difference2 = new HashSet<String>(second);
		difference2.removeAll(first);
		difference1.addAll(difference2);
		System.out.println("Difference...");
		System.out.println(difference1.toString());
		System.out.println();
		
		//Intersection
		HashSet<String> intersection = new HashSet<String>(first);
		intersection.retainAll(second);
		System.out.println("Intersection...");
		System.out.println(intersection.toString());
		System.out.println();	
	}

}
