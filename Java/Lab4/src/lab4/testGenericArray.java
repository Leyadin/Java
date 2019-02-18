package lab4;

import java.util.Scanner;

public class testGenericArray {

	public static void main(String[] args) {
		final int SIZE = 5;
		GenericStack<String> stack = new GenericStack<String>(String[].class, SIZE);
		
		System.out.print("Enter " + SIZE + " strings: ");
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < SIZE; i++)
			stack.push(input.next());
		
		System.out.println("Input in reverse order...");
		for (int i = 0; i < SIZE; i++) {
			System.out.println(stack.pop());
		}
		
		System.out.println();
		
		input.close();
	}

}
