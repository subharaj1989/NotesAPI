package stepDefinition;

import API_Payload.ResetPassword;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.APICall;
import utils.GlobalVariables;
import utils.SessionVariables;
import static io.restassured.RestAssured.given;

import org.junit.Assert;

public class ResetPasswordSteps {

	ResetPassword pgreset;
	@When("the user sends token and {string}")
	public void payload(String password)
	{
		pgreset=new ResetPassword();
		pgreset.setToken(SessionVariables.newPassword_token);
		pgreset.setNewPassword(password);
		GlobalVariables.requestspec=given().spec(GlobalVariables.requestspec).body(pgreset).log().all();
	}
	
	@Then("verify if the password changed successfully {string} and {string}")
	public void verifyPaswordChange(String code,String message)
	{
		pgreset=APICall.verifystatuscode(GlobalVariables.response, code).extract().as(ResetPassword.class);
		Assert.assertEquals(message, pgreset.getMessage());
	}
	
}
