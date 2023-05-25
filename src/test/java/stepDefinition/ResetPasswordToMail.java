package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APICall;
import utils.GlobalVariables;
import utils.SessionVariables;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import API_Payload.LoggedinUserData;
import API_Payload.ResetPassword;

public class ResetPasswordToMail {

	static RequestSpecification req;
	static Response response;
	ResetPassword pgreset;
	@Given("the user enters {string} to send the link")
	public void the_user_enters_to_send_the_link(String email)
	{
		req=GlobalVariables.requestspec;
		pgreset=new ResetPassword();
		pgreset.setEmail(email);
		GlobalVariables.requestspec=given().urlEncodingEnabled(false).spec(req).body(pgreset).log().all();
	}
	
	
	
	@Then("verify {string} {string} in its ResetPasswordToMail reponse body")
	public void verify_message_in_its_ResetPasswordToMail_reponse_body(String code,String message)
	{
		pgreset=APICall.verifystatuscode(GlobalVariables.response, code).extract().as(ResetPassword.class);
		Assert.assertEquals(pgreset.getMessage(), message);
		
	}
}
