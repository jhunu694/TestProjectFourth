package com.automation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteData {
	@Test
	public void dt()
	{
		Response res=RestAssured.delete("http://localhost:3000/posts/8");
		int stcode=res.getStatusCode();
		System.out.println("status code is"+stcode);
		System.out.println("-----------------");
		long time=res.getTime();
		System.out.println("time is"+time+"ms");
		System.out.println("-----------------");
		String contentty=res.contentType();
		System.out.println("content type is"+contentty);
		System.out.println("---------------------");
		String actualcn=res.asString();
		System.out.println("actual content is"+actualcn);
	}

}
