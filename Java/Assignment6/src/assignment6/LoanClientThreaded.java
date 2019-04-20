//Jason Rutledge
//Assignment 6
//Purpose: Client program for accessing LoanServer
//		Sends annual interest rate, number of years and a principle amount
//		Receives monthly payment and total cost of loan

package assignment6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class LoanClientThreaded {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		try (Socket socket = new Socket("localhost", 9999)) {
			DataOutputStream oStream = new DataOutputStream(socket.getOutputStream());
			DataInputStream iStream = new DataInputStream(socket.getInputStream());
			
			System.out.print("Enter annual interest rate: ");
			double annualInterestRate = input.nextDouble();
			System.out.print("Enter number of years: ");
			double numYears = input.nextDouble();
			System.out.print("Enter loan amount: ");
			double loanAmount = input.nextDouble();
		
			oStream.writeDouble(annualInterestRate);
			oStream.writeDouble(numYears);
			oStream.writeDouble(loanAmount);
			oStream.flush();
			
			double monthlyPayment = iStream.readDouble();
			System.out.println();
			System.out.print("Monthly payment: ");
			System.out.printf("%.3f", monthlyPayment);
			
			double totalPayment = iStream.readDouble();
			System.out.println();
			System.out.print("Total payment: ");
			System.out.printf("%.3f", totalPayment);
			
		} catch (ConnectException e) {
			System.out.println("Could not find server.");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			input.close();
		}
		
		
	}

}
