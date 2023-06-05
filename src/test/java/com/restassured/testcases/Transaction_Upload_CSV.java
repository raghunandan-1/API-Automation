package com.restassured.testcases;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.restassured.constants.Constants;
import com.restassured.inputdata.userdata;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.Response;

public class Transaction_Upload_CSV extends BaseTest {
	 @Test(priority = 34, description = "To verify the Transaction upload CSV API   ")
	    public void Get_Transaction_Upload_CSV() throws IOException, InterruptedException {
	        final Map<String, String> parameters = new HashMap<String, String>();
	        parameters.put("bu_id", userdata.buid);
	        parameters.put("tenant_id", userdata.teamid);
	        parameters.put("snop_id", userdata.snopid);
	        File testUploadFile = new File("C:\\Users\\raghunandan.g\\eclipse-workspace\\EDM_API_Framework\\resources\\transaction.csv");
	       
	        Map<String,Object> pathParams = new HashMap<String,Object>();
			pathParams.put("routeType","forecast");
			
	        Response response=	given().params(parameters).pathParams(pathParams).when().multiPart(testUploadFile)
					.filter(new RequestLoggingFilter(captor))
					.headers(httpHeaderManager())
					.log()
					.all()
					.get(Constants.AV_BASEURL+Constants.Transaction_Get_Data)
					.then()
					.extract().response();
	        Assert.assertEquals(response.getStatusCode(), 200);
	        
	        writeRequestAndResponseInReport(Location_Upload_CSV.writer.toString(), response.prettyPrint(), "Transaction Upload CSV Executed Successfully!");
	    }
}
