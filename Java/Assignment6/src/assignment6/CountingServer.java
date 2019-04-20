//Jason Rutledge
//Assignement 6
//Purpose: Server program that keeps track of how many times it has been accessed
//		Sends the number of times accessed as an int

package assignment6;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;

public class CountingServer {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		File count = new File("counter.dat");
		
		try (ServerSocket socket = new ServerSocket(7777)) {
			System.out.println("Starting counting server...");

			while(true) {
				Socket incoming = socket.accept();
				DataOutputStream oStream = new DataOutputStream(incoming.getOutputStream());
				
				if(count.createNewFile()) {
					RandomAccessFile file = new RandomAccessFile(count, "rw");
					file.writeInt(1);
					oStream.writeInt(1);
					file.close();
				}
				else {
					RandomAccessFile file = new RandomAccessFile(count, "rw");
					int counter = file.readInt();
					counter++;
					file.seek(0);
					file.writeInt(counter);
					oStream.writeInt(counter);
					file.close();
				}
			}
		}
	}

}
