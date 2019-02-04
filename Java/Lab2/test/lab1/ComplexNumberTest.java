package lab1;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ComplexNumberTest {
	
	@BeforeClass
	public static void testSetup() {
		
	}
	
	@AfterClass
	public static void testCleanup() {
		//Teardown for data used by the unit tests
	}

	@Test
	public void testComplexAdd() {
		ComplexNumber test1 = new ComplexNumber(5, 3);
		ComplexNumber test2 = new ComplexNumber(1, -4);
		//using the toString method to check for equality
		assertEquals("(5 + 3i) plus (1 - 4) equals (6 - i)", (new ComplexNumber(6, -1)).toString(), test1.ComplexAdd(test2).toString());
	}

}
