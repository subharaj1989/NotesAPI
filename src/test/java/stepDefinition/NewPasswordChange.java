package stepDefinition;

import API_Payload.ResetPassword;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.APICall;
import utils.GlobalVariables;
import utils.SessionVariables;
import static io.restassured.RestAssured.given;

import org.junit.Assert;

public class NewPasswordChange {

	ResetPassword pgreset;
	@When("the user sends {string} and {string}")
	public void payload_passwordchange(String oldP,String newP)
	{
		pgreset=new ResetPassword();
		pgreset.setCurrentPassword(SessionVariables.Password);
		pgreset.setNewPassword(newP);
		GlobalVariables.requestspec=given().spec(GlobalVariables.requestspec).body(pgreset).log().all();
	}
	
	@Then("verify {string} {string} in change password response body")
	public void verify_newPAssword_changed(String code,String message)
	{
		pgreset=APICall.verifystatuscode(GlobalVariables.response, code).extract().as(ResetPassword.class);
		Assert.assertEquals(message, pgreset.getMessage());
	}
	
}
