//Jason Rutledge
//Assignment 4
//Purpose:
//	Count the number of consonants and vowels in a text file

package assignment4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ConsonantsAndVowels {

	public static void main(String[] args) throws IOException {
		Set<Character> vowelSet = new HashSet<Character>();
		Collections.addAll(vowelSet, 'A', 'E', 'I', 'O', 'U');
		String fileName;
		int vowels = 0, consonants = 0;
		
		System.out.print("Enter the text file name: ");
		Scanner input = new Scanner(System.in);
		fileName = input.next();
		
		//Block to deal with non-existent file
		File file = new File(fileName);		
		while (file.exists() == false || file.isFile() == false) {
			System.out.println("Invalid file");
			System.out.print("Enter the text file name: ");
			fileName = input.next();
		}
			
		try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
			int nextChar;						
			while ((nextChar = reader.read()) != -1) { 
				//Cast the int that was read into a char
				char letter = (char) nextChar; 
				//Convert to upper case to compare with vowel set
				letter = Character.toUpperCase(letter);
				//If the character isn't a letter, skip it
				if (!Character.isLetter(letter))
					continue; 
				else if (vowelSet.contains(letter))
					vowels++;
				else
					consonants++;
			}
			
			System.out.println(fileName + " has " + vowels + " vowels");
			System.out.println(fileName + " has " + consonants + " consonants");
			
			input.close();			
		} 
	}

}
