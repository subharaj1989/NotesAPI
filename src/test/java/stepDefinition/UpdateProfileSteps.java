package stepDefinition;

import API_Payload.UpdateUser;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APICall;
import utils.GlobalVariables;

import static io.restassured.RestAssured.given;

import org.junit.Assert;

public class UpdateProfileSteps {

	UpdateUser pgupdate;
	static RequestSpecification requestspec;
	static Response r;
	@When("the user updates {string} {string} {string}")
	public void the_user_details(String name,String phone,String company)
	{
		this.requestspec=GlobalVariables.requestspec;
		pgupdate=new UpdateUser();
		pgupdate.setName(name);
		pgupdate.setPhone(phone);
		pgupdate.setCompany(company);
		GlobalVariables.requestspec=given().spec(requestspec).body(pgupdate).log().all();
		
		
	}
	
	
	
	@Then("verify {string} {string} in updateprofile response body")
	public void verify_message(String statuscode,String message)
	{
		pgupdate=APICall.verifystatuscode(GlobalVariables.response, statuscode).extract().as(UpdateUser.class);
		System.out.println(pgupdate.getData().getName());
		System.out.println(pgupdate.getMessage());
		Assert.assertEquals(message, pgupdate.getMessage());
		
	}
}
