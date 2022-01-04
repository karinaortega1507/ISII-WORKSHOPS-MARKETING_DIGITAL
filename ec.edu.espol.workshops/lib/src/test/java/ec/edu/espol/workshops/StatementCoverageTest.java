package ec.edu.espol.workshops;

import static org.junit.Assert.*;

import org.junit.Test;

public class StatementCoverageTest {

	// SC-001
    @Test
    public void testSC1() {
        String age = "a";
        char sex = 1;
        char married = 'T';
        char validCard = 'T';
        
        System.out.println("SC-001");
        
        int res = CarInsurance.checkInformation(age, sex, married, validCard);
        assertEquals(-1, res);
        
        System.out.println("Invalid data. Cannot proceed with calculation\n");        
    }
    
    // SC-002
    @Test
    public void testSC2() {
        String age = "20";
        char sex = 'M';
        char married = 'T';
        char validCard = 'F';
        
        int res = CarInsurance.checkInformation(age, sex, married, validCard);
        assertEquals(0, res);
        
        CarInsurance p = new CarInsurance(Integer.parseInt(age), sex, CarInsurance.convertCharToBool(married));
        
        System.out.println("BC-002");
        boolean validCI = p.isValidCarInsurance(p, CarInsurance.convertCharToBool(validCard));    
        assertFalse(validCI);
    }
    
    // SC-003
    @Test
    public void testSC3() {
        String age = "85";
        char sex = 'M';
        char married = 'T';
        char validCard = 'T';
        
        int res = CarInsurance.checkInformation(age, sex, married, validCard);
        assertEquals(0, res);
        
        CarInsurance p = new CarInsurance(Integer.parseInt(age), sex, CarInsurance.convertCharToBool(married));
        
        System.out.println("SC-003");
        boolean validCI = p.isValidCarInsurance(p, CarInsurance.convertCharToBool(validCard));    
        assertFalse(validCI);     
    }
    
    // SC-004
    @Test
    public void testSC4() {
        String age = "50";
        char sex = 'F';
        char married = 'T';
        char validCard = 'T';
        
        int res = CarInsurance.checkInformation(age, sex, married, validCard);
        assertEquals(0, res);
        
        CarInsurance p = new CarInsurance(Integer.parseInt(age), sex, CarInsurance.convertCharToBool(married));
        
        System.out.println("SC-004");
        boolean validCI = p.isValidCarInsurance(p, CarInsurance.convertCharToBool(validCard));
        assertTrue(validCI);
        
        int premium = p.premiumCalculation(p);
        assertEquals(200, premium);
        
        System.out.println("The car insurance premium is: $ " + premium + "\n");
    }
    
    // SC-005
    @Test
    public void testSC5() {
        String age = "20";
        char sex = 'M';
        char married = 'F';
        char validCard = 'T';
        
        int res = CarInsurance.checkInformation(age, sex, married, validCard);
        assertEquals(0, res);
        
        CarInsurance p = new CarInsurance(Integer.parseInt(age), sex, CarInsurance.convertCharToBool(married));
        
        System.out.println("SC-005");
        boolean validCI = p.isValidCarInsurance(p, CarInsurance.convertCharToBool(validCard));
        assertTrue(validCI);
        
        int premium = p.premiumCalculation(p);
        assertEquals(2000, premium);
        
        System.out.println("The car insurance premium is: $ " + premium + "\n");
    }

}
