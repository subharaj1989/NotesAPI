package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import API_Payload.ResetPassword;
import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APICall;
import utils.GlobalVariables;
import utils.SessionVariables;
import webpages.EmailInboxPage;
import static io.restassured.RestAssured.given;

public class VerifyTokenPassword {

	
	EmailInboxPage pgemail;
	ResetPassword pgreset;
	static Response response;
	
	static RequestSpecification req;
	@Given("the user checks the email for the token")
	public void check_email()
	{
		pgreset=new ResetPassword();
		Hooks.driversetup();
		pgemail=new EmailInboxPage(Hooks.driver);
		String token=pgemail.mailaccess();
		pgreset.setToken(token);
		SessionVariables.newPassword_token=pgreset.getToken();
		req=GlobalVariables.requestspec;
		GlobalVariables.requestspec=given().spec(req).body(pgreset).when().log().all();
		
	}
	
	@Given("verify if token is valid {string} {string}")
	public void verify_token(String code,String message)
	{
		pgreset=APICall.verifystatuscode(GlobalVariables.response, code).extract().as(ResetPassword.class);
		Assert.assertEquals(pgreset.getMessage(),message);
		
		
	}
}
