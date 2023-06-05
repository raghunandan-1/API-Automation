

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

public class Location_Upload_JSON extends BaseTest
{
    @Test(priority = 5, description = "To verify the location upload JSON API   ")
    public void Get_Location_Upload_JSON() throws IOException, InterruptedException {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("bu_id", userdata.buid);
        parameters.put("tenant_id", userdata.teamid);
        Map<String, Object> jsonAsMap = new HashMap<String, Object>();
        jsonAsMap.put("Location Code", "LC10110");
        jsonAsMap.put("Location Name", "Ln1Edit");
        jsonAsMap.put("Location Type", "Lt1");
        jsonAsMap.put("Latitude", "1010.1");
        jsonAsMap.put("Longitude", "1010.1");
        jsonAsMap.put("Manufacturing Capacity UOM", "test1");
        jsonAsMap.put("Manufacturing Capacity", 1);
        jsonAsMap.put("Manufacturing Operating Hours", 1.1);
        jsonAsMap.put("Manufacturing Weekly Schedule", "test2");
        jsonAsMap.put("Warehouse Capacity UOM", "test11");
        jsonAsMap.put("Warehouse Capacity", 11);
        jsonAsMap.put("Warehouse Operating Hours", 1.3);
        jsonAsMap.put("Warehouse Weekly Schedule", "wws1");
        jsonAsMap.put("Location Status", false);
        jsonAsMap.put("Location Start Date", "21/11/2021");
        jsonAsMap.put("Location Sunset Date", "11/11/2011");
        jsonAsMap.put("Location End Date", "01/01/2001");
        jsonAsMap.put("Area", "11edit");
        jsonAsMap.put("City", "111");
        jsonAsMap.put("State", "1111");
        jsonAsMap.put("Region", "1111");
        jsonAsMap.put("lolc", "1");
        
        Response response=	given().params(parameters).body(jsonAsMap)
				.filter(new RequestLoggingFilter(captor))
				.headers(httpHeaderManager())
				.log()
				.all()
				.get(Constants.AV_BASEURL+Constants.Location_Get_Data)
				.then()
				.extract().response();
        
       Assert.assertEquals(response.getStatusCode(), 200);
        writeRequestAndResponseInReport(Location_Upload_JSON.writer.toString(), response.prettyPrint(), "Location Upload JSON Executed Successfully!");
    }
}
