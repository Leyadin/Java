//Jason Rutledge
//Lab 3
//Purpose: Create a binary file and test it by reading it

package lab3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryIO {
	
	public static void main(String[] args) throws IOException {
		try (FileOutputStream output = new FileOutputStream("lab02-01.dat", true);) {
			for (int i = 0; i < 10; i++) {
				output.write((int) (Math.random() * 20));
			}
		}
		
		try (FileInputStream input = new FileInputStream("lab02-01.dat");) {
			int value;
			while ((value = input.read()) != -1)
				System.out.print(value + " ");
		}

	}

}
