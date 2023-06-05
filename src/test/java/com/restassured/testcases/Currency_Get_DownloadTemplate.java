package com.restassured.testcases;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.restassured.constants.Constants;
import com.restassured.inputdata.userdata;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.Response;

public class Currency_Get_DownloadTemplate extends BaseTest{

	 @Test(priority=28, description="To verify the Currency Get DownloadTemplate API   ")
	    public void Get_Currency_DownloadTemplate() throws IOException, InterruptedException {
	        HashMap<String, String> parameters = new HashMap<String, String>();
	        parameters.put("bu_id", userdata.buid);
	        parameters.put("tenant_id", userdata.teamid);
	        
	        Response response=	given().params(parameters)
					.filter(new RequestLoggingFilter(captor))
					.headers(httpHeaderManager())
					.log()
					.all()
					.get(Constants.AV_BASEURL+Constants.Currency_Template)
					.then()
					.extract().response();
	        Assert.assertEquals(response.getStatusCode(), 200);
	        writeRequestAndResponseInReport(writer.toString(), response.prettyPrint(), "Currency Template Fetched Successfully!");
	    }
}
