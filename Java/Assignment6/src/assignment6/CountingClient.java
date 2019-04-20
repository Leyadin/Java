//Jason Rutledge
//Assignment 6
//Purpose: Pings CountingServer and receives how many times CountingServer has been accessed

package assignment6;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class CountingClient {

	public static void main(String[] args) {
		try (Socket socket = new Socket("localhost", 7777)) {
			DataInputStream iStream = new DataInputStream(socket.getInputStream());
			
			int count = iStream.readInt();
			System.out.println("The server has been accessed " + count + " times.");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
