/**
 * 
 */
package ec.edu.espol.workshops;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

import static org.junit.Assert.*;

/**
 * @author edwineras
 *
 */
public class StepsDefs {
	private String today;
	private String actualAnswer;
	
	@Given("today is Sunday")
	public void today_is_Sunday() {
		today = "Sunday";
	}
	
	@Given("today is {string}")
	public void today_is(String today) {
		this.today = today;
	}
	
	@When("I ask whether it's Friday yet")
	public void i_ask_whether_it_s_Friday_yet() {
		actualAnswer = IsItFriday.isItFriday(today);
	}
	
	@Then("I should be told {string}")
	public void i_should_be_told(String expectedAnswer) {
		assertEquals(expectedAnswer, actualAnswer);
		} 
	}