//Jason Rutledge
//Lab 2
//Purpose:  Simple JUnit test program

package lab2;

public class JUnitTest {
	public int multiply(int x, int y) {
		if (x > 999) {
			throw new IllegalArgumentException("x should be less than 1000");
		}
		
		return x * y;
	}

}
