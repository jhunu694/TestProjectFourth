package com.automation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FetchData {
	@Test
	public void getData()
	{
	Response res=RestAssured.get("http://localhost:3000/posts");
	int statuscode=res.getStatusCode();
	System.out.println("status code is"+statuscode);
	System.out.println("---------------------");
	String contenttype=res.getContentType();
	System.out.println("content type is "+contenttype);
    System.out.println("-----------------");
    long time=res.getTime();
    System.out.println("time is"+time+"ms");
    System.out.println("---------------------");
    String actualcontent=res.asString();
    System.out.println("actual content is "+actualcontent);
     
	}

}
