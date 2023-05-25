package utils;

import static io.restassured.RestAssured.given;

import API_Payload.RegistrationUser;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class APICall {

	//static RequestSpecification requestspec;
	static Response response;
	
	public static Response Apicall(RequestSpecification requestspec, String method,String resource)
	{
		if(method.equals("post"))
		{
			response= requestspec.when().post(resource);
		}
		else if(method.equals("get"))
		{
			response= requestspec.when().get(resource);
		}
		
		else if(method.equals("patch"))
		{
			response= requestspec.when().patch(resource);
		}
		else if(method.equals("delete"))
		{
			response= requestspec.when().delete(resource);
		}
		else if(method.equals("put"))
		{
			response= requestspec.when().put(resource);
		}
		return response;
	}
	
	public static  ValidatableResponse verifystatuscode(Response response,String code)
	{
		return response.then().log().all().assertThat().statusCode(Integer.parseInt(code));
		
	}
	
	/*
	 * public static void verify(Response response,String code,String page) {
	 * Class<?> classname = null; if (page.equals("Register")) {
	 * classname=RegistrationUser.class;
	 * 
	 * }
	 * response.then().log().all().assertThat().statusCode(Integer.parseInt(code)).
	 * extract().as(classname); }
	 */
	
	
	
}
