package stepDefinition;

import org.apache.http.client.methods.RequestBuilder;
import org.testng.Assert;

import API_Payload.LoginUser;
import API_Payload.RegistrationUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.LogSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.APICall;
import utils.GlobalVariables;
import utils.Logging;
import utils.SessionVariables;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegisterUserSteps {
	
	static RequestSpecification requestspec;
	static ResponseSpecification responsespec;
	static Response response;
	static int statusCode;
	RegistrationUser pgregister;
	LoginUser pglogin;
	/*
	 * @Given("the user sets the Base URL") public void the_user_sets_the_base_url()
	 * {
	 * 
	 * GlobalVariables.buildBaseUri();
	 * 
	 * }
	 */

	@Given("The user provides payload {string} {string} {string}")
	public void the_user_provides_payload(String name, String email, String password) {
		this.requestspec=GlobalVariables.requestspec;
	   pgregister=new RegistrationUser();
	   pgregister.setName(name);
	   pgregister.setEmail(email);
	   pgregister.setPassword(password);
	   SessionVariables.userName=pgregister.getName();
		SessionVariables.email=pgregister.getEmail();
	   requestspec=  given().spec(requestspec).body(pgregister).log().all();
		GlobalVariables.requestspec=requestspec;	  
	    
	}	

	@Then("verify {string} {string} in registerpage response body")
	public void message_in_the_response_body_is_user_account_created_successfully(String code,String message) {
		pgregister=APICall.verifystatuscode(GlobalVariables.response, code).extract().as(RegistrationUser.class);
		SessionVariables.userID=pgregister.getData().getId();
		Assert.assertEquals(message, pgregister.getMessage()) ;
		
		
	}

}
