package com.automation;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class IteratorFetchData {
	@Test
	public void checkData()
	{
		Response res=RestAssured.get("http://restcountries.eu/rest/v2/all");
		String requiredCountry="India";
		boolean flag=false;
		int count=0;
		ArrayList<Object> arr=res.jsonPath().get("name");
		Iterator<Object> itr=arr.iterator();
		while(itr.hasNext())
		{
			Object obj=itr.next();
			System.out.println("names are:"+arr);
			if(obj.equals(requiredCountry)){
			Object obj1= res.jsonPath().get("currencies.code["+count+"]");
			System.out.println("courency code is:"+obj1);
					flag=true;
					break;
		}
		
		count++;
		}
			if(!flag)
			{
				System.out.println("not present");
			}
	}

}
