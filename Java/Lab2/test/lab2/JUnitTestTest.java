package lab2;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.BeforeClass;
import org.junit.AfterClass;
public class JUnitTestTest {
	
	@BeforeClass
	public static void testSetup() {
		
	}
	
	@AfterClass
	public static void testCleanup() {
		//Teardown for data used by the unit tests
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionisThrown() {
		JUnitTest tester = new JUnitTest();
		tester.multiply(1000, 5);
	}
	
	@Test
	public void testMultiply() {
		JUnitTest tester = new JUnitTest();
		assertEquals("10 x 5 must be 50", 50, tester.multiply(10, 5));
	}

}
