

package com.restassured.testcases;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import org.testng.Assert;

import io.restassured.filter.log.RequestLoggingFilter;
import java.util.Map;

import io.restassured.response.Response;

import com.restassured.constants.Constants;
import com.restassured.inputdata.userdata;
import java.util.HashMap;

public class Location_Get_Data extends BaseTest
{
    @Test(priority = 3, description = "To verify the Get Location Data API   ")
    public void Get_Location_DownloadTemplate() throws IOException, InterruptedException {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("bu_id", userdata.buid);
        parameters.put("tenant_id", userdata.teamid);
        
        Response response=	given().params(parameters)
				.filter(new RequestLoggingFilter(captor))
				.headers(httpHeaderManager())
				.log()
				.all()
				.get(Constants.AV_BASEURL+Constants.Location_Get_Data)
				.then()
				.extract().response();
		
        
        Assert.assertEquals(response.getStatusCode(), 200);
        writeRequestAndResponseInReport(Location_Get_Data.writer.toString(), response.prettyPrint(), "Get Location Data Fetched Successfully!");
    }
}