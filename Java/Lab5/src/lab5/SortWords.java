//Jason Rutledge
//Lab 5
//Purpose:
//	Sort and display the words from a text file

package lab5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SortWords {

	public static void main(String[] args) throws IOException {
		if (args.length == 0) {
			System.out.println("Requires an argument to run (text file name)");
			System.exit(1);
		}
		
		String fileName = args[0];
		
		File file = new File(fileName);		
		if (file.exists() == false || file.isFile() == false) {
			System.out.println("File does not exist.");
			System.exit(1);
		}
		
		try(BufferedReader input = new BufferedReader(new FileReader(file))){
			List<String> wordList = new ArrayList<>();
			String nextLine;
			
			while ((nextLine = input.readLine()) != null) {
				//Replace hyphens with spaces
				//This is not always correct, but is more correct than leaving them
				//or removing them
				nextLine = nextLine.replaceAll("-", " ");
				
				//Remove punctuation (leaves apostrophes)
				nextLine = nextLine.replaceAll("[\\p{P}&&[^\u0027]]", ""); 
				
				//Remove return character
				nextLine = nextLine.replace("\\n", "");
				
				//Convert all to lower case
				nextLine = nextLine.toLowerCase();	
				
				//Turn the line into a string array and add each word, which is separated by a space
				for (String item: nextLine.split(" ")) {
					if (item.length() > 0) //Remove the return characters or punctuation surrounded by spaces
						wordList.add(item);	
				}								
			}
			
			wordList.sort(null);
			
			for (String item: wordList)
				System.out.println(item);
		}
	}
}
