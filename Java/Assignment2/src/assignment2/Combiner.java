//Jason Rutledge
//Assignment 2
//Purpose: Combine split binary files into a single file

package assignment2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class Combiner {
	String sourceFile;
	String targetFile;
	
	Combiner() {};	
	Combiner(String _sourceFile, String _targetFile) {
		this.sourceFile = _sourceFile;
		this.targetFile = _targetFile;;
	}
	
	void combine() throws FileNotFoundException, IOException {
		//Check to see if the first file for combining exists, 
		//exits if it does not
		File file = new File(sourceFile + ".part0000");		
		if (file.exists() == false || file.isFile() == false) {
			System.out.println("File does not exist.");
			System.exit(1);
		}
		//Check to see if the target file already exists
		//Gives a warning if it does
		file = new File(targetFile);		
		if (file.exists()) {
			System.out.println("WARNING: Target file already exists, this will alter "
					+ "that file and likely cause errors.");
			System.out.println("Do you still want to continue? (Y/N) ");
			Scanner input = new Scanner(System.in);
			char check = input.next().charAt(0);
			while (check != 'y' || check != 'Y') {
				if (check == 'n' || check == 'N') {
					System.out.print("Quitting...");
					System.exit(0);
				}
				else {
					System.out.print("Please enter Y or N only: ");
					check = input.next().charAt(0);
				}				
			}
			input.close();
		}

		
		//Create a list of the file names to be combined, uses format: sourceFile.part000x
		//or sourceFile.part00xx
		int counter = 0;
		Vector<String> fileNames = new Vector<>();
		while (true) {
			String checkName = String.format("%s.part%04d", sourceFile, counter);
			File check = new File(checkName);
			if (check.exists()) {
				fileNames.add(checkName);
				counter++;
			}				
			else
				break;
		}
		
		//Combines each file into the target file, appending the data
		//WARNING: If the target file already exists, it will be appended on the end
		for (int i = 0; i < counter; i++) {
			File inputFile = new File(fileNames.elementAt(i));
			File target = new File(targetFile);			
			
			try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(inputFile));) {
				byte[] section = new byte[(int) inputFile.length()];
				input.read(section, 0 , (int) inputFile.length());
				try (BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(target, true));) {
					output.write(section);
				}
			}
		}
	}
}
