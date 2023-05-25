package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APICall;
import utils.GlobalVariables;
import utils.SessionVariables;

import static io.restassured.RestAssured.given;

import org.junit.Assert;

import API_Payload.LoginUser;
import API_Payload.UpdateUser;

public class RetreiveUserProfile {

	static RequestSpecification requestspec;
	static Response r;
	LoginUser pglogin;
	
	@Then("verify {string} {string} in response body")
    public void verify_user_info_is_correct(String code,String message)
    {
		pglogin=APICall.verifystatuscode(GlobalVariables.response, code).extract().as(LoginUser.class);
		Assert.assertEquals(pglogin.getMessage(),message);
    }
}
