

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

public class Product_Upload_JSON extends BaseTest
{
    @Test(priority = 25, description = "To verify the product upload JSON API   ")
    public void Get_Product_Upload_JSON() throws IOException, InterruptedException {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("bu_id", userdata.buid);
        parameters.put("tenant_id", userdata.teamid);
        Map<String, Object> jsonAsMap = new HashMap<String, Object>();
        jsonAsMap.put("Sku Code", "sc3");
        jsonAsMap.put("Sku Name", "sn1");
        jsonAsMap.put("Sku Description", "sd1");
        jsonAsMap.put("Channel", "c11edit");
        jsonAsMap.put("Unit Price", 12.3);
        jsonAsMap.put("Sku Unit Of Measure", 123);
        jsonAsMap.put("Currency", "cu1");
        jsonAsMap.put("Gros Margin Unit Pct", "gmu1");
        jsonAsMap.put("EBIDTA Unit PCT", "ebidta1");
        jsonAsMap.put("Weight Unit Of Measure", "wu1Editnew");
        jsonAsMap.put("Weight", 120);
        jsonAsMap.put("Volume Unit Of Measure", "vum1");
        jsonAsMap.put("Volume", 1000);
        jsonAsMap.put("Product Lifecycle Status", "pls1");
        jsonAsMap.put("Lifecycle Start Date", "20/10/2025");
        jsonAsMap.put("Lifecycle Sunset Date", "20/11/2025");
        jsonAsMap.put("Lifecycle End Date", "20/12/2025");
        jsonAsMap.put("Product", "p1");
        jsonAsMap.put("Product Description", "pd1");
        jsonAsMap.put("Sub-Category", "sc1");
        jsonAsMap.put("Sub-Category Description", "scd1");
        jsonAsMap.put("Category", "c1");
        jsonAsMap.put("Category Description", "cd1");
        jsonAsMap.put("Brand", "b1");
        jsonAsMap.put("Brand Description", "bd1Edit");
        jsonAsMap.put("Brand1", "b11");
        jsonAsMap.put("Brand1 Description", "bd1");
        jsonAsMap.put("test1", "test1");
        
        Response response=	given().params(parameters).body(jsonAsMap)
				.filter(new RequestLoggingFilter(captor))
				.headers(httpHeaderManager())
				.log()
				.all()
				.get(Constants.AV_BASEURL+Constants.Product_Get_Data)
				.then()
				.extract().response();
        Assert.assertEquals(response.getStatusCode(), 200);
        writeRequestAndResponseInReport(Product_Upload_JSON.writer.toString(), response.prettyPrint(), "Product Upload JSON Executed Successfully!");
    }
}
