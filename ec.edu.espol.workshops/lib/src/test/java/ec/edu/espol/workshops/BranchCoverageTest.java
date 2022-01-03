package ec.edu.espol.workshops;

import static org.junit.Assert.*;

import org.junit.Test;

public class BranchCoverageTest {
    
    // BC-001
    @Test
    public void invalidAge() {
        String age = "a";
        char sex = 'M';
        char married = 'F';
        char validCard = 'T';
        
        System.out.println("BC-001");
        
        int res = CarInsurance.checkInformation(age, sex, married, validCard);
        assertEquals(-1, res);
        
        System.out.println("Invalid data. Cannot proceed with calculation\n");        
    }
    
    // BC-002
    @Test
    public void invalidCard() {
        String age = "20";
        char sex = 'M';
        char married = 'F';
        char validCard = 'F';
        
        int res = CarInsurance.checkInformation(age, sex, married, validCard);
        assertEquals(0, res);
        
        CarInsurance p = new CarInsurance(Integer.parseInt(age), sex, CarInsurance.convertCharToBool(married));
        
        System.out.println("BC-002");
        boolean validCI = p.isValidCarInsurance(p, CarInsurance.convertCharToBool(validCard));    
        assertFalse(validCI);
    }
    
    // BC-003
    @Test
    public void ageOver80() {
        String age = "85";
        char sex = 'M';
        char married = 'F';
        char validCard = 'T';
        
        int res = CarInsurance.checkInformation(age, sex, married, validCard);
        assertEquals(0, res);
        
        CarInsurance p = new CarInsurance(Integer.parseInt(age), sex, CarInsurance.convertCharToBool(married));
        
        System.out.println("BC-003");
        boolean validCI = p.isValidCarInsurance(p, CarInsurance.convertCharToBool(validCard));    
        assertFalse(validCI);     
    }
    
    // BC-004
    @Test
    public void getMaxPrime() {
        String age = "20";
        char sex = 'M';
        char married = 'F';
        char validCard = 'T';
        
        int res = CarInsurance.checkInformation(age, sex, married, validCard);
        assertEquals(0, res);
        
        CarInsurance p = new CarInsurance(Integer.parseInt(age), sex, CarInsurance.convertCharToBool(married));
        
        System.out.println("BC-004");
        boolean validCI = p.isValidCarInsurance(p, CarInsurance.convertCharToBool(validCard));
        assertTrue(validCI);
        
        int premium = p.premiumCalculation(p);
        assertEquals(2000, premium);
        
        System.out.println("The car insurance premium is: $ " + premium + "\n");
    }
    
    // BC-005
    @Test
    public void getMinPrime() {
        String age = "50";
        char sex = 'F';
        char married = 'T';
        char validCard = 'T';
        
        int res = CarInsurance.checkInformation(age, sex, married, validCard);
        assertEquals(0, res);
        
        CarInsurance p = new CarInsurance(Integer.parseInt(age), sex, CarInsurance.convertCharToBool(married));
        
        System.out.println("BC-005");
        boolean validCI = p.isValidCarInsurance(p, CarInsurance.convertCharToBool(validCard));
        assertTrue(validCI);
        
        int premium = p.premiumCalculation(p);
        assertEquals(200, premium);
        
        System.out.println("The car insurance premium is: $ " + premium + "\n");
    }
    
}
