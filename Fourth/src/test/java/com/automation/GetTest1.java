package com.automation;

import java.util.ArrayList;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetTest1 {
	@Test
	public void checkData()
	{
		Response res=RestAssured.get("http://localhost:3000/posts");
		ArrayList<Object> obj=res.jsonPath().get("employee.skill");
		System.out.println("employee skills are:"+obj);
		System.out.println("1st employee skill are:"+obj.get(0));
		Object obj2=res.jsonPath().get("employee.skill.java[1]");
		System.out.println("java 2nd rating is:"+obj2);
		ArrayList<Object> obj3=res.jsonPath().get("employee.skills");
		System.out.println("skills are:"+obj3);
	}

}
