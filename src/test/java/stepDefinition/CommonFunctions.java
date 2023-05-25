package stepDefinition;

import static io.restassured.RestAssured.given;

import org.junit.Assert;

import API_Payload.LoginUser;
import API_Payload.RegistrationUser;
import API_Payload.UpdateUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import utils.APICall;
import utils.GlobalVariables;
import utils.SessionVariables;

public class CommonFunctions {

	static RequestSpecification requestspec;
	static Response response;
	RegistrationUser pgregister;
	LoginUser pglogin;
	UpdateUser pgupdate;
	
	@Given("the user sets the Base URL")
	public void the_user_sets_the_base_url() {
	
		GlobalVariables.buildBaseUri();
		
	}
	@When("user calls the API using {string} and  {string}")
	public void user_calls_the_post_method_to_register_the_user_to_the_application(String method,String resource) {
			//requestspec=GlobalVariables.requestspec;	
		    GlobalVariables.response= APICall.Apicall(GlobalVariables.requestspec,method,resource);
	}
	
	@Given("the user is loggedin")
	public void the_userloggedin()
	{
		this.requestspec=GlobalVariables.requestspec;
		GlobalVariables.requestspec=given().spec(requestspec).header("x-auth-token",SessionVariables.token).log().all();
		
		
	}
	
	
}
