package stepDefinition;

import API_Payload.UpdateUser;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.GlobalVariables;

import static io.restassured.RestAssured.given;

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
		
		
	}
	
	@When("the user calls the post method")
	public void the_user_calls_post()
	{
		r=requestspec.body(pgupdate).when().log().all().patch("/users/profile");
	}
	
	@Then("verify {string} {string} its updateprofile response body")
	public void verify_message(String statuscode,String message)
	{
		pgupdate=r.then().log().all().statusCode(Integer.parseInt(statuscode)).extract().as(UpdateUser.class);
		System.out.println(pgupdate.getData().getName());
		System.out.println(pgupdate.getMessage());
		
	}
}
