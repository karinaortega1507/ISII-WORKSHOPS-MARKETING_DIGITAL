package ec.edu.espol.workshops;

import static org.junit.Assert.*;

import org.junit.Test;

public class PathCoverageTest {
	
	@Test
	public void testPath1() {
		int expectedValue = 300;
		int resultValue = 0;
		CarInsurance objectpremium = new CarInsurance(18, 'f',
	            CarInsurance.convertCharToBool('T'));
		resultValue = objectpremium.premiumCalculation(objectpremium);
		assertEquals(expectedValue, resultValue);
	}
	
	@Test
	public void testPath2() {
		String expectedMessage = "Invalid data. Cannot proceed with calculation";
		String resultMessage = "";
		resultMessage = String.valueOf(CarInsurance.checkInformation("0", 'M', 'T', 'T'));
		assertEquals(expectedMessage, resultMessage);
	}
	
	@Test
	public void testPath3() {
		int expectedValue = 300;
		int resultValue = 0;
		CarInsurance objectpremium = new CarInsurance(21, 'f',
	            CarInsurance.convertCharToBool('F'));
		resultValue = objectpremium.premiumCalculation(objectpremium);
		assertEquals(expectedValue, resultValue);
	}
	
	@Test
	public void testPath4() {
		boolean expectedValidCard = false;
		boolean resultValidCard;
		CarInsurance objectpremium = new CarInsurance(35, 'M',
	            CarInsurance.convertCharToBool('F'));
		resultValidCard = objectpremium.isValidCarInsurance(objectpremium, false);
		assertEquals(expectedValidCard, resultValidCard);
	}
	
	@Test
	public void testPath5() {
		boolean expectedValidCard = false;
		boolean resultValidCard;
		CarInsurance objectpremium = new CarInsurance(85, 'F',
	            CarInsurance.convertCharToBool('T'));
		resultValidCard = objectpremium.isValidCarInsurance(objectpremium, true);
		assertEquals(expectedValidCard, resultValidCard);
	}
	
	@Test
	public void testPath6() {
		int expectedValue = 200;
		int resultValue = 0;
		CarInsurance objectpremium = new CarInsurance(50, 'f',
	            CarInsurance.convertCharToBool('T'));
		resultValue = objectpremium.premiumCalculation(objectpremium);
		assertEquals(expectedValue, resultValue);
	}
	
	@Test
	public void testPath7() {
		int expectedValue = 2000;
		int resultValue = 0;
		CarInsurance objectpremium = new CarInsurance(24, 'M',
	            CarInsurance.convertCharToBool('F'));
		resultValue = objectpremium.premiumCalculation(objectpremium);
		assertEquals(expectedValue, resultValue);
	}

}
