package com.restassured.constants;

public class Constants 
{

	private Constants() 
	{}

	public static final String EXTENTREPORTPATH = System.getProperty("user.dir")+"/ExtentReports/index.html";

	public static final String EXTENTCONFIGFILEPATH = System.getProperty("user.dir")
			+"/resources/extentreport.xml";

	// Baseurl for Login
	public static final String BASEURL = "https://scai-dev-iam.3sc.ai";
	public static final String AV_BASEURL="https://scai-dev-api.3sc.ai";
	public static final java.lang.String Product_Template = "/entities/product/v1/template";
	 
	  public static final java.lang.String Product_Download_CSV = "/entities/product/v1/csv";
	  
	  public static final java.lang.String Product_Get_Data = "/entities/product/v1";
	  
	  
	  public static final java.lang.String Location_Template = "/entities/location/v1/template";
	  
	
	  public static final java.lang.String Location_Download_CSV = "/entities/location/v1/csv";
	  
	  
	  public static final java.lang.String Location_Get_Data = "/entities/location/v1";
	  
	 
	  public static final java.lang.String Network_Template = "/entities/network/v1/template";
	  
	  
	  public static final java.lang.String Network_Download_CSV = "/entities/network/v1/csv";
	  
	  
	  public static final java.lang.String Network_Get_Data = "/entities/network/v1";
	  
	  
	  public static final java.lang.String Mapping_Template = "/entities/mapping/v1/template";
	  
	 
	  public static final java.lang.String Mapping_Download_CSV = "/entities/mapping/v1/csv";
	  
	 
	  public static final java.lang.String Mapping_Get_Data = "/entities/mapping/v1";
	  
	  
	  public static final java.lang.String Personnel_Template = "/entities/personnel/v1/template";
	  
	 
	  public static final java.lang.String Personnel_Download_CSV = "/entities/personnel/v1/csv";
	  
	  
	  public static final java.lang.String Personnel_Get_Data = "/entities/personnel/v1";
	  
	  public static final java.lang.String Currency_Template= "/entities/currency/v1/template";
	  
	  public static final java.lang.String Currency_Download_CSV= "/entities/currency/v1/csv";
	  
	  public static final java.lang.String Currency_Get_Data = "/entities/currency/v1";
	  
	  public static final java.lang.String Transaction_Template = "/transaction/{routeType}/v1/template";
	  
	  public static final java.lang.String Transaction_Download_CSV = "/transaction/{routeType}/v1/csv";
	  
	  public static final java.lang.String Transaction_Get_Data = "/transaction/{routeType}/v1";
	  
	  
	  
	  
	  
	  




	//Endpoints for Login
	public static final String LOG_IN_ENDPOINT = "/api/v1/users/login/";
	public static final String TOKEN_ENDPOINT = "/api/v1/users/token/verify/";

	

}
