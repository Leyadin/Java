package assignment7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.*;

public class SalaryDatabase {
	public static void main(String[] args) throws MalformedURLException, IOException, Exception {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/salary", "root", "password");
			System.out.println("Database connected");
			
			Statement statement = connection.createStatement();
			String create = "CREATE TABLE Salary"
					+ "(firstName varchar(100),  "
					+ "lastName varchar(100),  "
					+ "position varchar(15),  "
					+ "salary float)";
			statement.executeUpdate(create);
			
			PreparedStatement pstmt = connection.prepareStatement(
					"insert into Student(firstName, lastName, position, salary) values(?, ?, ?, ?)");
			try {
				File salary = new File("Salary-Data.txt");		
				if (salary.exists() == false || salary.isFile() == false) {
					System.out.println("File does not exist.");
					System.exit(1);
				}
				
				try (BufferedReader in = new BufferedReader( new FileReader(salary))) { 
					String line;
					while ((line = in.readLine()) != null) {
						String[] lineSplit = line.split(" ");
						pstmt.setString(1,  lineSplit[0]);
						pstmt.setString(2,  lineSplit[1]);
						pstmt.setString(3,  lineSplit[2]);
						pstmt.setString(4,  lineSplit[3]);
						pstmt.executeUpdate();
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			} finally {};
			
			
		} catch (SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
		

	}
}

