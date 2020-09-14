package com.automation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;

public class AddNewData {
	@Test
	public void addnew()
	{
		RequestSpecification reqs=RestAssured.given();
		JSONObject jobj1=new JSONObject();
		jobj1.put("java", "very good");
		jobj1.put("selenium", "good");
	JSONObject jobj2=new JSONObject();
	jobj2.put("name", "jhunu");
	jobj2.put("id", 70);
	jobj2.put("skill", jobj1);
	JSONObject jobj3=new JSONObject();
	jobj3.put("employee",jobj2);
	String jsonData=jobj3.toJSONString();
	reqs.body(jsonData);
	reqs.contentType(ContentType.JSON);
	RequestSender sender=reqs.when();
	Response res=reqs.post("http://localhost:3000/posts");
	res.then().log().all();
	}

}
