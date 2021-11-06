Feature: What is the car insurance prime for a given customer?

Scenario: Customer does not have a valid card license.
		  Given that the customer does not have a valid card license
		  And the customer gender is male/female
		  And the costumer is married
		  And the customer is between 26 - 80 years old 
		  When I  calculate Car Insurance
		  Then I should be told "Sorry, your driving licence is invalid."

Scenario: Customer gets the highest value premium.
		  Given that the customer have a valid card license
		  And the customer gender is male
		  And the costumer is not married
		  And the customer is under 25 years old
		  When I  calculate Car Insurance
		  Then I should be told "2000"
		  
Scenario: Customer is over 80 years old.
		  Given that the customer odes not have a valid card license
		  And the costumer is married
		  And the customer is over 80 years old 
		  When I  calculate Car Insurance
		  Then I should be told "Sorry, we cannot sell car insurance to people over 80 years old."
		  
Scenario Outline: I want to know my car insurance.
		 Given my license card is valid is "<license>" 
		 And my gender is "<gender>"
		 And I am married is "<married>"
		 And my age is "<age>"
		 
Examples:| gender | age | married | license | answer
		 | 'M' | 22 | 'F' | 'T' | 2000 |
		 | 'M' | 40 | 'T' | 'F' | "Sorry, your driving licence is invalid." |
		 | 'F' | 86 | 'T' | 'T' | "Sorry, we cannot sell car insurance to people over 80 years old." |
		 | "other" | "other" | "other" | "other" | "Invalid data. Cannot proceed with calculation" |