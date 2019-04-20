//Jason Rutledge
//Assignment 6
//Purpose: Server program to calculate monthly interest rate
//		Allows multiple connections by using threads
//		Sends annual interest rate, number of years and a principle amount
//		Receives monthly payment and total cost of loan

package assignment6;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoanServerThreaded  {
	public static void main(String[] args)  throws ClassNotFoundException  {
		
		
		try (ServerSocket socket = new ServerSocket(9999)) {
			System.out.println("Starting loan server...");

			while(true) {
				Socket incoming = socket.accept();
				
				ExecutorService pool = Executors.newCachedThreadPool();
				LoanServerHandler handle = new LoanServerHandler(incoming);
				pool.execute(handle);
			}

		} catch (BindException e) {
			System.out.println("Port already in use");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}

}

