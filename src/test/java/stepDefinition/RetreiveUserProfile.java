package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.GlobalVariables;
import utils.SessionVariables;

import static io.restassured.RestAssured.given;

public class RetreiveUserProfile {

	static RequestSpecification requestspec;
	static Response r;
	@Given("the user loggedin")
	public void the_userloggedin()
	{
		this.requestspec=GlobalVariables.requestspec;
		GlobalVariables.requestspec=given().spec(requestspec).header("x-auth-token",SessionVariables.token).log().all();
		
	}
	@When("the user calls Get method")
	 public void the_user_calls_Get_method()
	{
		r=requestspec.when().log().all().get("/users/profile");
	}
	@Then("verify user info is correct")
    public void verify_user_info_is_correct()
    {
		r.then().log().all().statusCode(200);
    }
}
