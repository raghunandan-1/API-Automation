package com.restassured.testcases;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.restassured.constants.Constants;
import com.restassured.inputdata.userdata;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.Response;

public class Transaction_Get_DownloadTemplate extends BaseTest{
	 @Test(priority=33, description="To verify the Transaction Get DownloadTemplate API   ")
	    public void Get_Transaction_DownloadTemplate() throws IOException, InterruptedException {
	        HashMap<String, String> parameters = new HashMap<String, String>();
	        parameters.put("bu_id", userdata.buid);
	        parameters.put("tenant_id", userdata.teamid);
	        parameters.put("snop_id", userdata.snopid);
	        
	        Map<String,Object> pathParams = new HashMap<String,Object>();
			pathParams.put("routeType","forecast");
			
	        Response response=	given().params(parameters).pathParams(pathParams)
					.filter(new RequestLoggingFilter(captor))
					.headers(httpHeaderManager())
					.log()
					.all()
					.get(Constants.AV_BASEURL+Constants.Transaction_Template)
					.then()
					.extract().response();
	        Assert.assertEquals(response.getStatusCode(), 200);
	        writeRequestAndResponseInReport(writer.toString(), response.prettyPrint(), "Transaction Template Fetched Successfully!");
	    }
}
