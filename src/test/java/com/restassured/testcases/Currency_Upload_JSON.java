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

public class Currency_Upload_JSON extends BaseTest{
	@Test(priority = 30, description = "To verify the currency upload JSON API   ")
    public void Get_Currency_Upload_JSON() throws IOException, InterruptedException {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("bu_id", userdata.buid);
        parameters.put("tenant_id", userdata.teamid);
        Map<String, Object> jsonAsMap = new HashMap<String, Object>();
        jsonAsMap.put("Base Currency", "India");
        jsonAsMap.put("Converstion Rate", "30");
        jsonAsMap.put("From Date", "2023-05-21");
        jsonAsMap.put("To Date", "2023-05-21");
        jsonAsMap.put("Is Active", "true");
        
        
        Response response=	given().params(parameters).body(jsonAsMap)
				.filter(new RequestLoggingFilter(captor))
				.headers(httpHeaderManager())
				.log()
				.all()
				.get(Constants.AV_BASEURL+Constants.Currency_Get_Data)
				.then()
				.extract().response();
        
       Assert.assertEquals(response.getStatusCode(), 200);
        writeRequestAndResponseInReport(Location_Upload_JSON.writer.toString(), response.prettyPrint(), "Currency Upload JSON Executed Successfully!");
    }

}
