

package com.restassured.testcases;

import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.Assert;

import io.restassured.filter.log.RequestLoggingFilter;
import java.util.Map;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.io.File;

import com.restassured.constants.Constants;
import com.restassured.inputdata.userdata;
import java.util.HashMap;

public class Mapping_Upload_CSV extends BaseTest
{
    @Test(priority = 9, description = "To verify the mapping upload CSV API   ")
    public void Get_Mapping_Upload_CSV() throws IOException, InterruptedException {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("bu_id", userdata.buid);
        parameters.put("tenant_id", userdata.teamid);
        
        File testUploadFile = new File("C:\\Users\\raghunandan.g\\eclipse-workspace\\EDM_API_Framework\\resources\\mapping.csv");
        
        Response response=	given().params(parameters).when().multiPart(testUploadFile)
				.filter(new RequestLoggingFilter(captor))
				.headers(httpHeaderManager())
				.log()
				.all()
				.get(Constants.AV_BASEURL+Constants.Mapping_Get_Data)
				.then()
				.extract().response();
        Assert.assertEquals(response.getStatusCode(), 200);
        writeRequestAndResponseInReport(Mapping_Upload_CSV.writer.toString(), response.prettyPrint(), "Mapping Upload CSV Executed Successfully!");
    }
}
