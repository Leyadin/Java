//Jason Rutledge
//Assignment 1
//Purpose:  Approximate the value of e using BigDecimal

package assignment1;

import java.math.BigDecimal;

public class ApproxE {

	public static void main(String[] args) {
        for (int i = 100; i <= 1000; i += 100) {
            System.out.println("The value of e with i = " + i + ": " + approx(i));
        }

    }

    public static BigDecimal approx (int num) {
        
    	BigDecimal e = BigDecimal.ONE;
		
    	//Each iteration is a fraction of the summation
		for (int i = 1; i <= num; i++) {
			//Get the BigDecimal of the current fraction
			BigDecimal fraction = factorial(i);		
			fraction = BigDecimal.ONE.divide(fraction, 25, BigDecimal.ROUND_CEILING);
			e = e.add(fraction);
        }
        
        return e;
    }

    //Function for creating a BigDecimal factorial
    public static BigDecimal factorial (int num) {

        BigDecimal value = BigDecimal.ONE;

        for (int i = 1; i <= num; i++) {
            BigDecimal temp = new BigDecimal(i);
            value = value.multiply(temp);
        }

        return value;    

    }

}