//Jason Rutledge
//Lab 7
//Purpose: Server for calculating monthly interest rate
//		Receives annual interest rate, number of years and a principle amount
//		Sends monthly payment and total cost of loan

package lab7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

public class LoanServer {
	public static void main(String[] args) throws ClassNotFoundException {
		//Create a ServerSocket
		try (ServerSocket socket = new ServerSocket(8888)) {
			System.out.println("Starting loan server...");

			while (true) {
				try (Socket incoming = socket.accept()) {
					DataInputStream iStream = new DataInputStream(incoming.getInputStream());
					DataOutputStream oStream = new DataOutputStream(incoming.getOutputStream());
					
					//Receive data, requires 3 doubles
					double annualInterestRate = iStream.readDouble();
					double numYears = iStream.readDouble();
					double PV = iStream.readDouble();
					
					//Close server if -1 is received for annualInterestRate
					if (annualInterestRate == -1) {
						System.out.println("Recieved -1");
						System.out.print("Closing server...");
						socket.close();
						break;
					}
					
					double r = (annualInterestRate / 12) / 100;
					double n = numYears * 12;
					
					//Calculate the monthly payment
					double monthlyPayment = (r * PV) / (1 - Math.pow(1 + r, -n));
					oStream.writeDouble(monthlyPayment);
					
					//Calculate total cost
					double totalPayment = monthlyPayment * n;
					oStream.writeDouble(totalPayment);	
					oStream.flush();
				}
			}

		} catch (BindException e) {
			System.out.println("Port already in use");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		

	}

}
