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
    
    /* ADITIONAL TESTS */
    
    // BC-006  
    @Test
    public void invalidCharactersToCheckInformation() {
        String age = "20";
        String invalidAge = "-20";
        
        char sex = 'M';
        char invalidSex = 'P';
        
        char married = 'F';
        char invalidMarried = 'P';
        
        char validCard = 'T';
        char invalidCard = 'P';
        
        System.out.println("BC-006");
        
        // Invalid Sex
        int res1 = CarInsurance.checkInformation(age, invalidSex, married, validCard);
        assertEquals(-1, res1);
        System.out.println("Invalid data. Cannot proceed with calculation"); 
        
        // Invalid Married
        int res2 = CarInsurance.checkInformation(age, sex, invalidMarried, validCard);
        assertEquals(-1, res2);
        System.out.println("Invalid data. Cannot proceed with calculation"); 
        
        // Invalid ValidCard
        int res3 = CarInsurance.checkInformation(age, sex, married, invalidCard);
        assertEquals(-1, res3);
        System.out.println("Invalid data. Cannot proceed with calculation"); 
        
        // Invalid Age
        int res4 = CarInsurance.checkInformation(invalidAge, sex, married, invalidCard);
        assertEquals(-1, res4);
        System.out.println("Invalid data. Cannot proceed with calculation\n"); 
    }
    
    // BC-007
    @Test
    public void getPremiumWithoutChanges() {
        String age = "70";
        char sex = 'M';
        char married = 'F';
        char validCard = 'T';
        
        int res = CarInsurance.checkInformation(age, sex, married, validCard);
        assertEquals(0, res);
        
        CarInsurance p = new CarInsurance(Integer.parseInt(age), sex, CarInsurance.convertCharToBool(married));
        
        System.out.println("BC-007");
        boolean validCI = p.isValidCarInsurance(p, CarInsurance.convertCharToBool(validCard));
        assertTrue(validCI);
        
        int premium = CarInsurance.premiumCalculation(p);
        assertEquals(500, premium);
        
        System.out.println("The car insurance premium is: $ " + premium + "\n");
    }
    
    // BC-008
    @Test
    public void getPremiumMaleMarried() {
        String age = "30";
        char sex = 'M';
        char married = 'T';
        char validCard = 'T';
        
        int res = CarInsurance.checkInformation(age, sex, married, validCard);
        assertEquals(0, res);
        
        CarInsurance p = new CarInsurance(Integer.parseInt(age), sex, CarInsurance.convertCharToBool(married));
        
        System.out.println("BC-008");
        boolean validCI = p.isValidCarInsurance(p, CarInsurance.convertCharToBool(validCard));
        assertTrue(validCI);
        
        int premium = CarInsurance.premiumCalculation(p);
        assertEquals(300, premium);
        
        System.out.println("The car insurance premium is: $ " + premium + "\n");
    }
    
    
    // BC-009
    @Test
    public void getPremiumYoungMaleMarried() {
        String age = "20";
        char sex = 'M';
        char married = 'T';
        char validCard = 'T';
        
        int res = CarInsurance.checkInformation(age, sex, married, validCard);
        assertEquals(0, res);
        
        CarInsurance p = new CarInsurance(Integer.parseInt(age), sex, CarInsurance.convertCharToBool(married));
        
        System.out.println("BC-009");
        boolean validCI = p.isValidCarInsurance(p, CarInsurance.convertCharToBool(validCard));
        assertTrue(validCI);
        
        int premium = CarInsurance.premiumCalculation(p);
        assertEquals(300, premium);
        
        System.out.println("The car insurance premium is: $ " + premium + "\n");
    }
    
    // BC-010
    @Test
    public void getPremiumYoungFemaleMarried() {
        String age = "20";
        char sex = 'F';
        char married = 'T';
        char validCard = 'T';
        
        int res = CarInsurance.checkInformation(age, sex, married, validCard);
        assertEquals(0, res);
        
        CarInsurance p = new CarInsurance(Integer.parseInt(age), sex, CarInsurance.convertCharToBool(married));
        
        System.out.println("BC-010");
        boolean validCI = p.isValidCarInsurance(p, CarInsurance.convertCharToBool(validCard));
        assertTrue(validCI);
        
        int premium = CarInsurance.premiumCalculation(p);
        assertEquals(300, premium);
        
        System.out.println("The car insurance premium is: $ " + premium + "\n");
    }
    
}
