package com.automation;

import java.util.ArrayList;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FetchName {
@Test
public void check()
{
	String reqCountry="India";
	Response res=RestAssured.get("http://restcountries.eu/rest/v2/all");
	ArrayList<Object> allcountryName=res.jsonPath().get("name");
	System.out.println(allcountryName);
	if(allcountryName.contains(reqCountry))
	{
		System.out.println("hi");
	}
}
}
