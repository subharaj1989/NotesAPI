package stepDefinition;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import API_Payload.LoginUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;
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
	    requestspec=  given().spec(requestspec).body(pglogin).log().all();
	    
	}
	@When("the user calls the post method with expected {string}")
	public void the_user_calls_the_post_method(String code) {
		pglogin=requestspec.when().log().all().post("/users/login")
		.then().log().all().statusCode(Integer.parseInt(code)).extract().as(LoginUser.class);
	}
	
	@Then("verify {string} in its loginpage response body")
	public void message_in_the_response_body_is_user_account_created_successfully(String message) {
		Assert.assertEquals(message, pglogin.getMessage()) ;
		SessionVariables.token= pglogin.getData().getToken();

}
}
