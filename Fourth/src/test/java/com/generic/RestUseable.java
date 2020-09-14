package com.generic;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestUseable {
	public  void validStatusCode(Response res,int expectedstatuscode)
	{
		res.then().assertThat().statusCode(expectedstatuscode);
		System.out.println("status code validation is successfull");
	}
	public void validContentType(Response res)
	{
		res.then().assertThat().contentType(ContentType.JSON);
		System.out.println("contentType validation is successfull");
	}
	public void validateTime(Response res,long range)
	{
		res.then().assertThat().time(Matchers.lessThan(range));
		System.out.println("time validation is successfull");
	}
	public void validText(Response res,String jsonpath,String expected)
	{
		Object obj=res.jsonPath().get(jsonpath);
		String actualValue=obj.toString();
		Assert.assertEquals(actualValue, expected);
	}

}
