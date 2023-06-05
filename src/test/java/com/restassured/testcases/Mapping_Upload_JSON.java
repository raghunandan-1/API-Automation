

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

public class Mapping_Upload_JSON extends BaseTest
{
    @Test(priority = 10, description = "To verify the mapping upload JSON API   ")
    public void Get_Mapping_Upload_JSON() throws IOException, InterruptedException {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("bu_id", userdata.buid);
        parameters.put("tenant_id", userdata.teamid);
        Map<String, Object> jsonAsMap = new HashMap<String, Object>();
        jsonAsMap.put("Sku Code", "sc2");
        jsonAsMap.put("Sku Name", "sn2");
        jsonAsMap.put("Location Code", "lc2");
        jsonAsMap.put("Location Name", "ln2");
        jsonAsMap.put("Is Demand Node", true);
        jsonAsMap.put("Is Distribution Node", false);
        jsonAsMap.put("Is Manufacturing Node", true);
        jsonAsMap.put("Cycle Time Manufacturing UOM", "ctmfu2");
        jsonAsMap.put("Cycle Time Manufacturing Unit", 21);
        jsonAsMap.put("Cost Manufacturing UOM", "cmfU2");
        jsonAsMap.put("Cost Manufacturing Unit", 22);
        jsonAsMap.put("Units Manufactured Full Utilization Day", 24);
        jsonAsMap.put("Cycle Time Warehouse UOM", "ctwU2");
        jsonAsMap.put("Cycle Time Warehouse Unit", 25);
        jsonAsMap.put("Cost Warehouse UOM", "cwhU2");
        jsonAsMap.put("Cost Warehouse Unit", 2);
        jsonAsMap.put("Units Warehoused Full Utilization Day", "28");
        jsonAsMap.put("Mapping Life Cycle Status", true);
        jsonAsMap.put("Mapping Start Date", "01/01/2001");
        jsonAsMap.put("Mapping Sunset Date", "11/11/2011");
        jsonAsMap.put("Mapping End Date", "21/12/2022");
      
        Response response=	given().params(parameters).body(jsonAsMap)
				.filter(new RequestLoggingFilter(captor))
				.headers(httpHeaderManager())
				.log()
				.all()
				.get(Constants.AV_BASEURL+Constants.Mapping_Get_Data)
				.then()
				.extract().response();
        Assert.assertEquals(response.getStatusCode(), 200);
        writeRequestAndResponseInReport(Mapping_Upload_JSON.writer.toString(), response.prettyPrint(), "Mapping Upload JSON Executed Successfully!");
    }
}
