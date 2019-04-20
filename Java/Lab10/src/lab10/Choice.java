package lab10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

class Choice {
	
	Choice() {
	}
	
	public void write (String type, String message) {
		if (type.equals("c")) {
			System.out.println(message);
		} else if (type.equals("f")) {
			String destination = "tmp";
			String fname = "message.txt";
			
			File directory = new File(destination);
		    if (! directory.exists()){
		        directory.mkdir();
		    }
			
			try (PrintWriter pw = new PrintWriter(destination + "/" + fname, "UTF-8")) {
				pw.write(message);
				System.out.println("Writen to file...");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		} else {
			System.out.println("Invalid type - try again");
		}
	}

}
