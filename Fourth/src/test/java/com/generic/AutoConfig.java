package com.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import  io.restassured.response.Response;

public class AutoConfig {
	 private String[] keyValuePairArray;
	 public String getApiData(String apitestName) throws IOException
	 {
		 FileInputStream fis=new FileInputStream("D:\\eclips123\\Fourth\\src\\test\\java\\com\\apidata\\TestData.properties");
		 Properties prop=new Properties();
		 prop.load(fis);
		 String apiData=prop.getProperty(apitestName);
		 return apiData;
	 }
	 public Response getExecutable(String apiData)
	 {
		Response res=null;
		String[] apidataarray=apiData.split(";");
		if(apidataarray[0].equals("get"))
		{
			res=given().param("userId","2").when().get(apidataarray[1]);
		}
		else if(apidataarray[0].equals("post"))
		{
			String jsonData=createjson(apidataarray[2]);
			res=given().body(jsonData).contentType(ContentType.JSON).when().post(apidataarray[1]);
		}
		else if(apidataarray[0].equals("put"))
		{
			String jsonData=createjson(apidataarray[2]);
			res=given().body(jsonData).contentType(ContentType.JSON).when().put(apidataarray[1]);
		}
		else if(apidataarray[0].equals("patch"))
		{
			String jsonData=createjson(apidataarray[2]);
			res=given().body(jsonData).contentType(ContentType.JSON).when().patch(apidataarray[1]);
		}
		else if(apidataarray[0].equals("delete"))
		{
			String jsonData=createjson(apidataarray[2]);
			res=given().when().delete(apidataarray[1]);
		}
		return res;
	 }
	 private String createjson(String apiD)
	 {
		 JSONObject jobj=new JSONObject();
		 String[] jsonArray=apiD.split(",");
		 for(int i=0;i<jsonArray.length;i++)
		 {
			 keyValuePairArray=jsonArray[i].split(":");
			 jobj.put(keyValuePairArray[0],keyValuePairArray[1]);
		 }
		 return jobj.toJSONString();
	 }
	 public Response bulkExecute(String apiData) throws IOException
	 {
		 String[] apiArray=apiData.split(";");
		 if(apiArray[0].equals("post"))
		 {
			 File f=new File(apiArray[2]);
			 FileInputStream fis=new FileInputStream(f);
			 String jsondata=IOUtils.toString(fis,"UTF-8");
			 Response res=given().body(jsondata).contentType(ContentType.JSON).when().post(apiArray[1]);
			 return res;
			 
			 
		 }
		 else
		 {
			 throw new RuntimeException("invalid http method");
		 }
				
	 }

}
