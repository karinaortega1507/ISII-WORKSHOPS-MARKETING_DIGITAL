package ec.edu.espol.workshops;

import static org.junit.Assert.*;

import org.junit.Test;

public class PathCoverageTest {
	
	@Test
	public void testPath1() {
		int expectedValue = 300;
		int resultValue = 0;
		CarInsurance objectpremium = new CarInsurance(18, 'F',
	            CarInsurance.convertCharToBool('T'));
		resultValue = objectpremium.premiumCalculation(objectpremium);
		assertEquals(expectedValue, resultValue);
	}
	
	@Test
	public void testPath2() {
		int expectedResult = -1;
		int actualResult = 0;
		actualResult = CarInsurance.checkInformation("0", 'M', 'T', 'T');
		 System.out.println("Invalid data. Cannot proceed with calculation");
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testPath3() {
		int expectedValue = 300;
		int resultValue = 0;
		int res = CarInsurance.checkInformation("18", 'M', 'F', 'T');
        assertEquals(0, res);
        CarInsurance premium = new CarInsurance(18, 'M', CarInsurance.convertCharToBool('T'));
        resultValue = premium.premiumCalculation(premium);
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
		int res = CarInsurance.checkInformation("50", 'F', 'T', 'T');
        assertEquals(0, res);
        CarInsurance premium = new CarInsurance(50, 'F', CarInsurance.convertCharToBool('T'));
        resultValue = premium.premiumCalculation(premium);
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
	
	@Test
	public void testPath8() {
		int expectedValue = 500;
		int resultValue = 0;
		boolean validCard;
		CarInsurance objectpremium = new CarInsurance(65, 'M',
	            CarInsurance.convertCharToBool('F'));
		validCard = objectpremium.isValidCarInsurance(objectpremium, true);
		assertEquals(true, validCard);
		resultValue = objectpremium.premiumCalculation(objectpremium);
		assertEquals(expectedValue, resultValue);
	}
		
	
}
