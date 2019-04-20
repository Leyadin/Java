//Jason Rutledge
//Assignment 8
//Purpose:
//	Use a Stream to find the number of vowels and consonants in a text file

package assignment8;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class CountConsVowels {

	public static void main(String[] args) {
		Set <Character> vowels = new HashSet<>();
		Collections.addAll(vowels, 'A', 'E', 'I', 'O', 'U');
		System.out.print("Enter a text file name: ");
		Scanner input = new Scanner(System.in);
		String fileName = input.next();
		
		File file = new File(fileName);
		if (!file.exists()) {
			System.out.println("File not found");
			System.exit(1);
		}
		
		try {
			final int vowelCount[] = new int[1]; 
			final int consCount[] = new int[1];
			
			Stream<String> iStream = Files.lines(file.toPath());
			iStream.map(e -> e.toUpperCase()).map(e -> e.replaceAll("[^a-zA-Z]", "")).
				forEach(e -> {
					for (int i = 0; i < e.length(); i++) {
						if (vowels.contains(e.charAt(i)))
							vowelCount[0]++;
						else
							consCount[0]++;
					}
				});
			
			System.out.println("Number of vowels: " + vowelCount[0]);
			System.out.println("Number of consonants: " + consCount[0]);
			
			iStream.close();
		} catch (IOException e) {
			System.out.println("IOException");
			e.printStackTrace();
		}
		
		input.close();

	}

}
