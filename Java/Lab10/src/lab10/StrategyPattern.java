//Jason Rutledge
//Comp 232
//Purpose:
//	Use the strategy pattern to choose between two display methods

package lab10;

import java.util.Scanner;

public class StrategyPattern {

	public static void main(String[] args) {
		System.out.print("Write to (f)ile or (c)onsole? ");
		Scanner input = new Scanner(System.in);
		String in = input.next();
		String message = "Hello Milky Way";
		Choice pattern = new Choice();
		
		pattern.write(in, message);

		input.close();
	}

}
