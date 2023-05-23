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
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.GlobalVariables;
import utils.SessionVariables;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegisterUserSteps {
	
	static RequestSpecification requestspec;
	static ResponseSpecification responsespec;
	static int statusCode;
	RegistrationUser pgregister;
	LoginUser pglogin;
	@Given("the user sets the Base URL")
	public void the_user_sets_the_base_url() {
	
		GlobalVariables.buildBaseUri();
		
	}

	@Given("The user provides payload {string} {string} {string}")
	public void the_user_provides_payload(String name, String email, String password) {
		this.requestspec=GlobalVariables.requestspec;
	   pgregister=new RegistrationUser();
	   pgregister.setName(name);
	   pgregister.setEmail(email);
	   pgregister.setPassword(password);
	   requestspec=  given().spec(requestspec).body(pgregister).log().all();
	    
	}

	@When("user calls the Post method to register the user to the application")
	public void user_calls_the_post_method_to_register_the_user_to_the_application() {
		statusCode=201;
		pgregister=requestspec.when().post("/users/register").then().log().all().statusCode(statusCode).extract().as(RegistrationUser.class);
	    
	}

	@Then("API status code should be {string}")
	public void api_status_code_should_be(String code) {
	
		SessionVariables.userID=pgregister.getId();
		SessionVariables.userName=pgregister.getName();
		SessionVariables.email=pgregister.getEmail();
		
		
		
		
	}

	@Then("verify {string} in its registerpage response body")
	public void message_in_the_response_body_is_user_account_created_successfully(String message) {
		
		Assert.assertEquals(message, pgregister.getMessage()) ;
		
		
	}

}
