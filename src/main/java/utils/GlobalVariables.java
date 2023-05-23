package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GlobalVariables {

	public static RequestSpecification requestspec;
	public static ResponseSpecification responsespec;
	
	public static void buildBaseUri()
	{
		requestspec=new RequestSpecBuilder().setBaseUri("https://practice.expandtesting.com/notes/api").addHeader("Content-Type","application/json").build();
		//	responsespec=new ResponseSpecBuilder().expectStatusCode(statusCode).build();
	}
}
