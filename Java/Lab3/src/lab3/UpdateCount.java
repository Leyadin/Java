//Jason Rutledge
//Lab 3
//Purpose: 	Create a file that counts how many times a program has been run
//			Display that file

package lab3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class UpdateCount {

	public static void main(String[] args) throws IOException {
		File count = new File("lab02-02.dat");
		if(count.exists() == false)  
			try (FileOutputStream output = new FileOutputStream("lab02-02.dat");) {
				output.write(1);
			}
		else {
			int counter = 0;
			try (FileInputStream input = new FileInputStream("lab02-02.dat");) {
				int temp;
				while ((temp = input.read()) != -1)
					counter = ++temp;
			}
			try (FileOutputStream output = new FileOutputStream("lab02-02.dat");) {
				output.write(counter);
			}
		}
			
		System.out.println("I'm a program.");
		
		try (FileInputStream input = new FileInputStream("lab02-02.dat");) {
			int temp;
			while ((temp = input.read()) != -1)
				System.out.println("Number of times ran: " + temp);;
		}
	}

}
