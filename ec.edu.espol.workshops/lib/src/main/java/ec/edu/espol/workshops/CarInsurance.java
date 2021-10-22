/*
 * This Java source file was generated by the Gradle 'init' task.
 */

package ec.edu.espol.workshops;

import java.util.Scanner;

/**
 * Class representing car insurance.
 * @author MarketingDigital.
 */
public class CarInsurance {
    private int age;
    private char sex;
    private boolean married;
    private int base = 500;

    /** 
     * Construct the class object
     * 
     * @param age user's age
     * @param sex user gender
     * @param married user's marital status
     */
    public CarInsurance(int age, char sex, boolean married) {
        this.age = age;
        this.sex = sex;
        this.married = married;
    }

    // GETTERS & SETTERS
    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return this.sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public boolean getMarried() {
        return this.married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public int getBase() {
        return base;
    }

    // METHODS
    @Override public String toString() {
        return "\nage: " + this.age + " sex: " + this.sex + " married: " + this.married;
    }

    /**
     * Calculate Car Insurance Premium
     * 
     * @param customer
     * @return
     */
    public int premiumCalculation(CarInsurance customer) {
        int premiumValue = base;
        if (customer.getAge() < 25 && customer.getSex() == 'M' && !customer.getMarried()) {
            premiumValue += 1500;
        } else if (customer.getSex() == 'F' || customer.getMarried()) {
            premiumValue -= 200;
        } else if (customer.getAge() >= 45 && customer.getAge() < 65) {
            premiumValue -= 100;
        }
        return premiumValue;
    }
    
    /**
     * Validate if the car insurance is valid according to the user's data
     * 
     * @param customer
     * @param validCard
     * @return
     */
    public boolean isValidCarInsurance(CarInsurance customer, boolean validCard) {
        if (customer.getAge() >= 80) {
            System.out.println("   ------------------------------------------ ");
            System.out.println("Sorry, we cannot sell car insurance to people over 80 years old.");
            System.out.println("   ------------------------------------------ ");
            return false;
        } else if (!validCard) {
            System.out.println("   ------------------------------------------ ");
            System.out.println("Sorry, your driving licence is invalid.");
            System.out.println("   ------------------------------------------ ");
            return false;
        }
        return true;

    }
    
    /**
     * Validate the information entered by the user
     * 
     * @param age age entered by the user in the system
     * @param sex sex entered by the user in the system
     * @param married marital status entered by the user in the system
     * @param validCard driving license entered by the user in the system
     * @return
     */
    public static int checkInformation(String age, char sex, char married, char validCard) {
        try {
            if (Integer.parseInt(age) > 0 && (sex == 'F' || sex == 'M') && (married == 'T' || married == 'F') && (validCard == 'T' || validCard == 'F')) {
                return 0;
            }
            return -1;
        } catch (Exception ex) {
            return -1;
        }
    }
    
    /**
     * Converts a char value to boolean
     * 
     * @param arg T or F depending on the boolean value
     * @return
     */
    public static boolean convertCharToBool(char arg) {
        boolean argBool = false;
        if (arg == 'T') {
            argBool = true;
        }
        return argBool;
    }
    
    /**
     * Initializes the system showing the questions for the Car Insurance Calculation
     */
    public static void initCarInsurance() {
        int premiumValue = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("     *****   Premium Calculation   *****");
        System.out.print("	Please input age: ");
        String age = sc.next();
        System.out.print("	Please input sex (M) or (F): ");
        char sex = Character.toUpperCase(sc.next().charAt(0));
        System.out.print("	Please indicate if you are married (T) or not (F): ");
        char married = Character.toUpperCase(sc.next().charAt(0));
        System.out.print("	Please confirm if the driving license is valid (T) or invalid (F): ");
        char validCard = Character.toUpperCase(sc.next().charAt(0));

        if (CarInsurance.checkInformation(age, sex, married, validCard) >= 0) {
            CarInsurance premium = new CarInsurance(Integer.parseInt(age), sex,
                    CarInsurance.convertCharToBool(married));
            if (premium.isValidCarInsurance(premium, CarInsurance.convertCharToBool(validCard))) {
                premiumValue = premium.premiumCalculation(premium);
                System.out.println("   ------------------------------------------ ");
                System.out.println("     The car insurance premium is: $ " + premiumValue);
                System.out.println("   ------------------------------------------ ");
            }
        } else {
            System.out.println("   ------------------------------------------ ");
            System.out.println("	Invalid data. Cannot proceed with calculation");
            System.out.println("   ------------------------------------------ ");
        }
        sc.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        initCarInsurance();
    }

}
