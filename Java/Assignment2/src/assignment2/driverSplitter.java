//Jason Rutledge
//Assignment 2
//Purpose: Driver for the Splitter class

package assignment2;

import java.io.FileNotFoundException;
import java.io.IOException;

public class driverSplitter {

	public static void main(String[] args) {
		String fName = "";
		int chunks = 0;
		if(args.length < 2)
	    {
	        System.out.println("Proper Usage is: java driverSplitter SourceFile numberOfPieces");
	        System.exit(1);
	    }
	    else {
	    	fName = args[0];
	    	chunks = Integer.parseInt(args[1]);
	    }
		
		Splitter split = new Splitter(fName, chunks);
		try {
			split.splitFile();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO Exception");
			e.printStackTrace();
		}
		
		System.out.println("File successful split.");

	}
}
