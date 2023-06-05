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

public class Currency_Download_CSV extends BaseTest{
	@Test(priority = 26, description = "To verify the currency download csv API   ")
    public void Get_Currency_DownloadCSV() throws IOException, InterruptedException {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("bu_id", userdata.buid);
        parameters.put("tenant_id", userdata.teamid);
        
        Response response=	given().params(parameters)
				.filter(new RequestLoggingFilter(captor))
				.headers(httpHeaderManager())
				.log()
				.all()
				.get(Constants.AV_BASEURL+Constants.Currency_Download_CSV)
				.then()
				.extract().response();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	    writeRequestAndResponseInReport(writer.toString(), response.prettyPrint(),"Currency Download CSV working as intended!");
	}

}
