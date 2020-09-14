package com.automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class AssertionT {
	@Test
	public void assertv()
	{
		Response res=given().param("userId", "4").when().get("https://jsonplaceholder.typicode.com/posts");
		int statusCode=res.getStatusCode();
		System.out.println("status code is="+ statusCode);
		Assert.assertEquals(statusCode, 200);
         res.then().log().all();  
         String content=res.getContentType();
         System.out.println("content type is="+content);
         Assert.assertEquals(content, "application/json; charset=utf-8");
         long time=res.getTime();
         System.out.println("time is ="+ time);
         Assert.assertTrue(time<5000);;
         Object obj=res.jsonPath().get("title[1]");
         System.out.println("title is ="+ obj);
         Assert.assertEquals(obj, "doloremque illum aliquid sunt");
	}

}
