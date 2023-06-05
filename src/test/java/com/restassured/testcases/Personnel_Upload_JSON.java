

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

public class Personnel_Upload_JSON extends BaseTest
{
    @Test(priority = 20, description = "To verify the personnel upload JSON API   ")
    public void Get_Personnel_Upload_JSON() throws IOException, InterruptedException {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("bu_id", userdata.buid);
        parameters.put("tenant_id", userdata.teamid);
        
        Map<String, Object> jsonAsMap = new HashMap<String, Object>();
        jsonAsMap.put("Brand", "b2Editj");
        jsonAsMap.put("City", "c2Editj");
        jsonAsMap.put("ASM", "a2EDIT");
        jsonAsMap.put("ASM Email Address", "aem2EDit json");
        jsonAsMap.put("LSM", "12");
        jsonAsMap.put("LSM Email Address", "lem2");
        jsonAsMap.put("PSM", "p2EDIT");
        jsonAsMap.put("PSM Email Address", "pem2");
        jsonAsMap.put("DD1", "d2");
        jsonAsMap.put("DD1 Email Address", "dea2EDIT");
        jsonAsMap.put("DD2", "d201");
        jsonAsMap.put("DD2 Email Address", "dem201");
        jsonAsMap.put("DD3", "d301");
        jsonAsMap.put("DD3 Email Address", "dem301");
        
        Response response=	given().params(parameters).body(jsonAsMap)
				.filter(new RequestLoggingFilter(captor))
				.headers(httpHeaderManager())
				.log()
				.all()
				.get(Constants.AV_BASEURL+Constants.Personnel_Get_Data)
				.then()
				.extract().response();
        Assert.assertEquals(response.getStatusCode(), 200);
        writeRequestAndResponseInReport(Personnel_Upload_JSON.writer.toString(), response.prettyPrint(), "Personnel Upload JSON Executed Successfully!");
    }
}