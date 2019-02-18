//Jason Rutledge
//Assignment 2
//Purpose: Split a binary file into multiple parts

package assignment2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Splitter {
	private String fName;
	private int chunks;
	
	Splitter() {}
	Splitter(String _fName, int _chunks){
		this.fName = _fName;
		this.chunks = _chunks;
	}
	
	void splitFile() throws FileNotFoundException, IOException {
		File file = new File(fName);
		//Check to see if the file exists, exits if it does not
		if (file.exists() == false || file.isFile() == false) {
			System.out.println("File does not exist.");
			System.exit(1);
		}
		
		long fileSize = file.length();
		//Get the chunk size based on total file size and the number of files desired
		//The last file will be smaller if it's not an even split
		int chunkSize = (int) Math.ceil((fileSize / (double) chunks));
		int counter = 0;
		
		try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(fName));) {
			while (fileSize > 0) {
				//If the rest of the file is smaller than the chunkSize, 
				//use the size of what is left in the file instead
				if (fileSize < chunkSize)
					chunkSize = (int) fileSize;
				
				//Byte array to hold the section of data
				byte[] section = new byte[chunkSize];
				//Decrement fileSize by the number of bytes read
				//also read the section of data into the byte array
				fileSize -= input.read(section, 0, chunkSize);
				
				//String name is padded with 0's for simple sorting when putting back together
				String newName = String.format("%s.part%04d", fName, counter);
				//Write the byte array into a new file
				try (BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(new File(newName)));) {
					output.write(section);
				}
				//Keep track of how many times the file has been split
				counter++;
				
			}
		}
	}
}
