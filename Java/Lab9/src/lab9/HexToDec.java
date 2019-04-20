//Jason Rutledge
//Lab 9
//Purpose:
//	Use Stream’s reduce() method to convert a hex number to a decimal.

package lab9;

import java.util.Scanner;
import java.util.stream.*;

public class HexToDec {

	public static void main(String[] args) {
		System.out.print("Enter a hexidecimal: ");
		Scanner input = new Scanner(System.in);
		String hex = input.next();
		
		//Check for correct input
		boolean invalid;
		do {
			invalid = false;
			for (int i = 0; i < hex.length(); i++) {
				char check = hex.charAt(i);
				if (check >= '0' && check <= '9' ||
						check >= 'a' && check <= 'f' ||
						check >= 'A' && check <= 'F')
					continue;
				else {
					System.out.println("Invalid character. 0-9, a-f or A-F only.\n");
					System.out.print("Enter a hexidecimal: ");
					hex = input.next();
					invalid = true;
					break;
				}
			}
		} while (invalid == true);
		
		//Convert each character in the input string to its integer equivalent
		int convert[] = new int[hex.length()];
		for (int i = 0, pow = hex.length() - 1; i < hex.length(); i++, pow--) {
			if (Character.isDigit(hex.charAt(i))) {
				int temp = Integer.parseInt(hex.substring(i, i+1));
				convert[i] = (int) (temp * Math.pow(16, pow));
			}
			else {
				int temp = Character.toUpperCase(hex.charAt(i)) - 'A' + 10;
				convert[i] = (int) (temp * Math.pow(16, pow));
			}
		}
		
		//Print out the decimal equivalent using IntStream to reduce convert[]
		System.out.print("Decimal equivalent: ");
		IntStream.of(convert).reduce((x, y) -> x + y).
			ifPresent(e -> System.out.println(e));;
		
		input.close();

	}

}
