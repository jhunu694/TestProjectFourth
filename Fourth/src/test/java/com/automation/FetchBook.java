package com.automation;

import java.util.ArrayList;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FetchBook {
	@Test
	public void fetch()
	{
		String reqTitle="Alan Turing: Life and Legacy of a Great Thinker";
		Response res=RestAssured.get("https://www.googleapis.com/books/v1/volumes?q=turing");
		ArrayList<Object> allTitle=res.jsonPath().get("items.volumeInfo.title");
		System.out.println(allTitle);
		if(allTitle.contains(reqTitle))
		{
			int index=allTitle.indexOf(reqTitle);
			System.out.println(index);
			Object obj=res.jsonPath().get("items.volumeInfo.publishedDate["+index+"]");
			System.out.println(reqTitle+"of publishedDate is"+obj);
			Object obj1=res.jsonPath().get("items.volumeInfo.pageCount["+index+"]");
			System.out.println(reqTitle+"of pagecount is"+obj1);
			Object obj2=res.jsonPath().get("items.saleInfo.retailPrice["+index+"]");
			System.out.println(reqTitle+"of retails price  is"+obj2);
			Object obj3=res.jsonPath().get("items.saleInfo.retailPrice.amount["+index+"]");
			
			System.out.println(reqTitle+"of amount  is"+obj3);
		}
			
			
	}

}
