package com.restassured.testcases;


import static io.restassured.RestAssured.given;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.jayway.jsonpath.JsonPath;
import com.restassured.constants.Constants;
import com.restassured.inputdata.userdata;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.Response;

public class Login extends BaseTest
{
	
	@Test(priority = -1,description = "To verify the Login API for Valid Creds   ")
	public void Login_user() throws IOException, InterruptedException 
	{
		
		Map<String, Object> mapuser = new HashMap<String,Object>();
		mapuser.put("email",userdata.username);
		mapuser.put("password",userdata.pwd);

		Response response=	given()
				.filter(new RequestLoggingFilter(captor)) 
				.header("Content-Type","application/json")
				.log()
				.all()
				.body(mapuser)
				.post(Constants.BASEURL+Constants.LOG_IN_ENDPOINT)
				.then()
				.extract().response();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		userdata.jsonAsString = response.asString(); // this line will convert JSON response into the string 
		userdata.token = JsonPath.read(userdata.jsonAsString, "$.data.access"); // this line will extract the token from Response
		userdata.User_id = JsonPath.read(userdata.jsonAsString, "$.data.user_id"); // this line will extract the User Id from Response
		writeRequestAndResponseInReport(writer.toString(), response.prettyPrint(),"Login Succesfully!");
	
	}
	
	@Test(priority = 0,description = "To verify the Token API   ")
	public void Verify_token() throws IOException, InterruptedException 
	{
		
		Map<String, Object> maptoken = new HashMap<String,Object>();
		maptoken.put("token",userdata.token);
		
		Response response=	given()
				.filter(new RequestLoggingFilter(captor)) 
				.header("Content-Type","application/json")
				.log()
				.all()
				.body(maptoken)
				.post(Constants.BASEURL+Constants.TOKEN_ENDPOINT)
				.then()
				.extract().response();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		writeRequestAndResponseInReport(writer.toString(), response.prettyPrint(),"Token verified Succesfully!");
		
	}

}
