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

public class Transaction_Upload_JSON extends BaseTest{
	@Test(priority = 35, description = "To verify the transaction upload JSON API   ")
    public void Get_Transaction_Upload_JSON() throws IOException, InterruptedException {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("bu_id", userdata.buid);
        parameters.put("tenant_id", userdata.teamid);
        parameters.put("snop_id", userdata.snopid);
        
        Map<String,Object> pathParams = new HashMap<String,Object>();
		pathParams.put("routeType","forecast");
        
        Map<String, Object> jsonAsMap = new HashMap<String, Object>();
        jsonAsMap.put("Period", "s3edit45");
        jsonAsMap.put("Category", "a1");
        jsonAsMap.put("City", "l1");
        jsonAsMap.put("Temprature", "b1");
        jsonAsMap.put("Precipitation", "ac1");
        jsonAsMap.put("Name", "n1");
        jsonAsMap.put("Description", "d1");
        
         
        Response response=	given().params(parameters).pathParams(pathParams).body(jsonAsMap)
				.filter(new RequestLoggingFilter(captor))
				.headers(httpHeaderManager())
				.log()
				.all()
				.get(Constants.AV_BASEURL+Constants.Transaction_Get_Data)
				.then()
				.extract().response();
        
       Assert.assertEquals(response.getStatusCode(), 200);
        writeRequestAndResponseInReport(Location_Upload_JSON.writer.toString(), response.prettyPrint(), "Transaction Upload JSON Executed Successfully!");
    }
}
