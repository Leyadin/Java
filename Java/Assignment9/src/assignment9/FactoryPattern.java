//Jason Rutledge
//Comp 232
//Purpose:
//	Use the factory method pattern to output text in a chosen language

package assignment9;

import java.util.Scanner;

public class FactoryPattern {

	public static void main(String[] args) {
		System.out.print("Select a language - (E)nglish, (F)rench or (S)panish: ");
		Scanner input = new Scanner(System.in);
		String lang = input.next();
		lang = lang.toUpperCase();
		
		ShowMessage output = Factory.getMessage(lang);
		
		if (output != null)
			output.displayMessage();
		
		input.close();
	}

}
