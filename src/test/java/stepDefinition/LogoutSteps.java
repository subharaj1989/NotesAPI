package stepDefinition;

import org.junit.Assert;

import API_Payload.LoginUser;
import API_Payload.ResetPassword;
import io.cucumber.java.en.Then;
import utils.APICall;
import utils.GlobalVariables;

public class LogoutSteps {

	LoginUser pglogin;
	@Then("verify {string} {string} in the response body")
	public void verify_logout(String code,String message)
	{
		pglogin=APICall.verifystatuscode(GlobalVariables.response, code).extract().as(LoginUser.class);
		Assert.assertEquals(message, pglogin.getMessage());
	}
}
