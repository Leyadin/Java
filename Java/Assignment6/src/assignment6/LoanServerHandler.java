package assignment6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
//Jason Rutledge
//Assignment 6
//Purpose: Implements Runnable class for LoanServerThreaded

import java.net.Socket;

public class LoanServerHandler implements Runnable {
	Socket incoming;
	
	LoanServerHandler(Socket i) {
		this.incoming = i;
	}

	@Override
	public void run() {
		try (DataInputStream iStream = new DataInputStream(incoming.getInputStream());
			DataOutputStream oStream = new DataOutputStream(incoming.getOutputStream());) {
			
			double annualInterestRate = iStream.readDouble();
			double numYears = iStream.readDouble();
			double PV = iStream.readDouble();
			
			double r = (annualInterestRate / 12) / 100;
			double n = numYears * 12;
			
			double monthlyPayment = (r * PV) / (1 - Math.pow(1 + r, -n));
			oStream.writeDouble(monthlyPayment);
			
			double totalPayment = monthlyPayment * n;
			oStream.writeDouble(totalPayment);	
			oStream.flush();
			
			incoming.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

}
