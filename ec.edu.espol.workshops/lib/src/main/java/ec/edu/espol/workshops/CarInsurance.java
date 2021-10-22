/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ec.edu.espol.workshops;

import java.util.Scanner;

//CAR INSURANCE CLASS
public class CarInsurance {
	private int age; //AGE OF CUSTOMER FOR CARINSURANCE
	private char sex; //SEX OF CUSTOMER FOR CARINSURANCE
	private boolean married; //MARRIED STATUS OF CUSTOMER FOR CARINSURANCE
	private static int BASE_PREMIUM = 500; //BASE_PREMIUM OF CUSTOMER FOR CARINSURANCE
	
	//INITIALIZE METHOD FOR CLASS CARINSURANCE
	public CarInsurance(int age, char sex, boolean married) {
		this.age = age;
		this.sex = sex;
		this.married = married;
	}
	
	//GETTERS & SETTERS
	public int getAge() {
		return this.age;
	}
	
	//SET AGE OF CUSTOMER
	public void setAge(int age) {
		this.age = age;
	}
	
	//GET SEX OF CUSTOMER
	public char getSex() {
		return this.sex;
	}
	
	//SET SEX OF CUSTOMER
	public void setSex(char sex) {
		this.sex = sex;
	}
	
	//GET MARRIED STATUS OF CUSTOMER
	public boolean getMarried() {
		return this.married;
	}
	
	//SET MARRIED STATUS OF CUSTOMER
	public void setMarried(boolean married) {
		this.married = married;
	}
	
	//GET BASE PREMIUM OF CUSTOMER 
	public int getBasePremium() {
		return this.BASE_PREMIUM;
	}
	
	//METHODS
	@Override
	public String toString() {
		return "\nage: " + this.age + " sex: " + this.sex + " married: " + this.married; 
	}
	
	//MAKE OPERATIONS TO GIVE THE CORRECT PREMIUM VALUE BASE ON CUSTOMER
	public int premiumCalculation(CarInsurance customer) {
		int premiumValue = this.BASE_PREMIUM;
		if(customer.getAge()<25 && customer.getSex() == 'M' && !customer.getMarried()) {
			premiumValue += 1500;
		}else if(customer.getSex() == 'F' || customer.getMarried()){
			premiumValue -= 200;
		}else if(customer.getAge()>=45 && customer.getAge()<65) {
			premiumValue -= 100;
		}
		return premiumValue;
	}
	
	//CHECK THAT THE PERSON HAS A VALID LICENSE AND A CORRECT AGE FOR INSURANCE
	public boolean isValidCarInsurance(CarInsurance customer, boolean validCard) {
		if(customer.getAge() >= 80) {
			printInfo(
					"   ------------------------------------------ "
					+"Sorry, we cannot sell car insurance to people over 80 years old."
					+"   ------------------------------------------ "
			);
			return false;
		}else if(!validCard) {
			printInfo(
					"   ------------------------------------------ "
					+"Sorry, your driving licence is invalid."
					+"   ------------------------------------------ "
			);
			return false;
		}
		return true;
		
	}
	
	//CHECK INFORAMTION BASED ON AGE, SEX, MARRIED STATUS AND LICENSE
	public static int checkInformation(String age, char sex, char married, char validCard) {
		try {
			if(Integer.parseInt(age) > 0 && (sex == 'F' || sex == 'M') && (married == 'T' || married == 'F') && (validCard == 'T' || validCard == 'F')) {
				return 0;
			}
			return -1;	
		}catch(RuntimeException ex) {
			printInfo(ex.getMessage());
			return -1;
		}
	}
	
	//CONVERT CHARACTER INPUT TO BOOLEAN TYPE
	public static boolean convertCharToBool(char arg) {
		boolean argBool = false;
		if(arg == 'T') {
			argBool = true;
		}
		return argBool;
	}
	
	//INITIALIZE THE CARINSURANCE CLASS FOR CUSTOMER USE AND CHECK INFORMATION
	public static void initCarInsurance() {
		int premiumValue = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("     *****   Premium Calculation   *****");
		printInfo("	Please input age: ");
		String age = sc.next();
		printInfo("	Please input sex (M) or (F): ");
		char sex = Character.toUpperCase(sc.next().charAt(0));
		printInfo("	Please indicate if you are married (T) or not (F): ");
		char married = Character.toUpperCase(sc.next().charAt(0));
		printInfo("	Please confirm if the driving license is valid (T) or invalid (F): ");
		char validCard = Character.toUpperCase(sc.next().charAt(0));
		
		if(CarInsurance.checkInformation(age, sex, married, validCard) >= 0) {
			CarInsurance premium = new CarInsurance(Integer.parseInt(age), sex, CarInsurance.convertCharToBool(married));
			if (premium.isValidCarInsurance(premium, CarInsurance.convertCharToBool(validCard))) {
				premiumValue = premium.premiumCalculation(premium);
				printInfo(
						"   ------------------------------------------ "
						+"     The car insurance premium is: $ " + premiumValue
						+"   ------------------------------------------ "
				);
			} 
		} else {
			printInfo(
					"   ------------------------------------------\n"
					+"	Invalid data. Cannot proceed with calculation\n"
					+"   ------------------------------------------\n"
			);
		}	
	}
	
	//PRINT OUT SOME INFORMATION
	public static void printInfo(String string) {
		System.out.print(string);
	}
	
	//STATIC METHOD MAIN THAT RUNS INSURANCECAR CLASS
	public static void main(String[] args) {
		printInfo("Guardado 1");
		initCarInsurance();		
	}
	
}
