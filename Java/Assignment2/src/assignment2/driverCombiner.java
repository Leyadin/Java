//Jason Rutledge
//Assignment 2
//Purpose: Driver for the combiner class

package assignment2;

import java.io.FileNotFoundException;
import java.io.IOException;

public class driverCombiner {

	public static void main(String[] args) {
		String sourceFile = "", targetFile = "";
		
		// Check how many arguments were passed in
	    if(args.length < 2)
	    {
	        System.out.println("Proper Usage is: java driverCombiner sourceFile targetFile");
	        System.exit(1);
	    }
	    else {
	    	sourceFile = args[0];
	    	targetFile = args[1];
	    }
		
		Combiner combine = new Combiner(sourceFile, targetFile);
		try {
			combine.combine();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO Exception");
			e.printStackTrace();
		}		
		
		System.out.println("File successful combined.");

	}

}
