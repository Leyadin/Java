//Jason Rutledge
//Lab 2
//Purpose:  ComplexNumber class with an implemented add functionality
//			This class was created in lab1, used for JUnit testing here

package lab1;

public class ComplexNumber {
	
	private double real = 0;
	private double imaginary = 0;
	
	public ComplexNumber() {
		//Empty constructor
	}
	
	public ComplexNumber(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}	
	
	//Calls the inner calculator class to add two complex numbers
	public ComplexNumber ComplexAdd(ComplexNumber b) {
		ComplexCalculator temp = new ComplexCalculator();
		temp.add(b);
		return this;
	}
	
	//Return a string representation of the complex number
	@Override
	public String toString( ) {
		if (imaginary == 0)
			return real + "";
		if (real == 0)
			return imaginary + "i";
		if (imaginary < 0)
			return real +  " - " + imaginary * -1 + "i";
		return real +  " + " + imaginary + "i";
	}
	
	//Calculator helper class
	class ComplexCalculator {
		//Calculator add functionality
		public void add(ComplexNumber b) {
			ComplexNumber.this.real = ComplexNumber.this.real + b.real;
			ComplexNumber.this.imaginary = ComplexNumber.this.imaginary + b.imaginary;			
		}
	}

	public static void main(String[] args) {
		ComplexNumber test1 = new ComplexNumber(5, 3);
		ComplexNumber test2 = new ComplexNumber(1, -4);
		
		//(5 + 3i) + (1 + 2i) should return 6 + 5i;
		System.out.println(new ComplexNumber(6, -1));
		//(6 + 5i) + (-4 - 7i) should return 2 - 2i;
		System.out.println(test1.ComplexAdd(test2));
	}

}