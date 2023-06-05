package com.restassured.testcases;

import java.awt.Desktop;



import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.output.WriterOutputStream;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.restassured.constants.Constants;
import com.restassured.inputdata.*;
import com.restassured.reports.ExtentReport;
import com.restassured.reports.LogStatus;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class BaseTest {
	
	protected static StringWriter writer;
	protected PrintStream captor;
	boolean flag = true;
	
	/*
	 * Initializing the extent report
	 */
	@BeforeSuite
	public void setUpSuite() {
		ExtentReport.initialize();
			
	}
	protected void formatAPIAndLogInReport(String content) {

		String prettyPrint = content.replace("\n", "<br>");
		LogStatus.info("<pre>" + prettyPrint + "</pre>");

	}
	/*
	 * Flushing the extent report
	 * Opening the extent report automatically after the test suite execution.
	 */
	
	@AfterSuite
	public void afterSuite() throws IOException 
	{
		ExtentReport.report.flush();
		File htmlFile = new File(Constants.EXTENTREPORTPATH);
		
		if(flag==true)
		{
			Desktop.getDesktop().browse(htmlFile.toURI());
//			emailReport er = new emailReport();
//			er.test();
		}
		else
		{
			System.out.println("Report will save in ExtentReports folder inside the project.");
		}

	}
	/*
	 * This method helps to write the request and response to the extent report
	 */
	@BeforeMethod
	public void setUp() {
		
		writer = new StringWriter();
		captor = new PrintStream(new WriterOutputStream(writer), true);
	}

	
	/* Function for handling header*/
	public static Headers httpHeaderManager(){
		
	    
	    Header authorization = new Header("Authorization", "Bearer "+userdata.token);
	    List<Header> headerList = new ArrayList<Header>();
	   
	    headerList.add(authorization);
	    Headers header = new Headers(headerList);
		return header;

	}


	/*
	 * Read the json file and convert to String
	 * @param  : filepath
	 */
	public String generateStringFromResource(String path) throws IOException {
		String temp="";
		try {
			temp= new String(Files.readAllBytes(Paths.get(path)));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return temp;

	}
	public void writeRequestAndResponseInReport(String request,String response,String message) {

		LogStatus.info("---- Request ---");
		formatAPIAndLogInReport(request);
		LogStatus.info("---- Response ---");
		formatAPIAndLogInReport(response);
		LogStatus.info("---- Message ---");
		formatAPIAndLogInReport(message);
	}
	
	public void writeMessageInReport(String message) {

		LogStatus.info("---- Message ---");
		formatAPIAndLogInReport(message);
	}
	
	

	
}
