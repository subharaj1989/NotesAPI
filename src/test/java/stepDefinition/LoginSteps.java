package stepDefinition;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import API_Payload.LoginUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;
import utils.APICall;
import utils.GlobalVariables;
import utils.SessionVariables;

public class LoginSteps {
	static RequestSpecification requestspec;
	   LoginUser pglogin;
	

	@Given("the user provides the Payload {string} {string}")
	public void the_user_provides_the_payload_with_previously_registered_user_details(String email,String password) {
		this.requestspec=GlobalVariables.requestspec;
	    pglogin=new LoginUser();
	    pglogin.setEmail(email);
	    pglogin.setPassword(password);
	    SessionVariables.Password=password;
	    requestspec= given().spec(requestspec).body(pglogin).log().all();
	    GlobalVariables.requestspec=requestspec;
	    
	}
	
	
	@Then("verify {string} {string} in loginpage response body")
	public void message_in_the_response_body_is_user_account_created_successfully(String code,String message)
	{
		pglogin=APICall.verifystatuscode(GlobalVariables.response,code).extract().as(LoginUser.class);
		Assert.assertEquals(message, pglogin.getMessage()) ;
		SessionVariables.token= pglogin.getData().getToken();

    }
}
