

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

public class Network_Upload_JSON extends BaseTest
{
    @Test(priority = 15, description = "To verify the network upload JSON API   ")
    public void Get_Network_Upload_JSON() throws IOException, InterruptedException {
        final Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("bu_id", userdata.buid);
        parameters.put("tenant_id", userdata.teamid);
        final Map<String, Object> jsonAsMap = new HashMap<String, Object>();
        jsonAsMap.put("Sku Code", "sc101000");
        jsonAsMap.put("Sku Name", "sn101");
        jsonAsMap.put("Start Node", "sNode101");
        jsonAsMap.put("End Node", "en101");
        jsonAsMap.put("Mode", "m101");
        jsonAsMap.put("Mode Type", "mt101");
        jsonAsMap.put("Carrier", "c101");
        jsonAsMap.put("Contract Type", "ct101");
        jsonAsMap.put("Asset Type", "at101");
        jsonAsMap.put("Asset Capacity UOM", "acu101");
        jsonAsMap.put("Asset Capacity", 131);
        jsonAsMap.put("Cycle Time UOM", "ctU101");
        jsonAsMap.put("Cycle Time", 101);
        jsonAsMap.put("Fixed Cost UOM", "fcU101");
        jsonAsMap.put("Fixed Cost", 111);
        jsonAsMap.put("Variable Cost UOM", "vcu101");
        jsonAsMap.put("Variable Cost", 121);
        jsonAsMap.put("Contract Life Cycle Status", true);
        jsonAsMap.put("Contract Start Date", "01/01/2001");
        jsonAsMap.put("Contract Sunset Date", "11/11/2011");
        jsonAsMap.put("Contract End Date", "21/01/2021");
      
        Response response=	given().params(parameters).body(jsonAsMap)
				.filter(new RequestLoggingFilter(captor))
				.headers(httpHeaderManager())
				.log()
				.all()
				.get(Constants.AV_BASEURL+Constants.Network_Get_Data)
				.then()
				.extract().response();
        Assert.assertEquals(response.getStatusCode(), 200);
        writeRequestAndResponseInReport(Network_Upload_JSON.writer.toString(), response.prettyPrint(), "Network Upload JSON Executed Successfully!");
    }
}