package com.automation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;

public class CreateData {
	@Test
	public void crd()
	{
	RequestSpecification reqs	=RestAssured.given();
	JSONObject jobj=new JSONObject();
	jobj.put("id", 7);
	jobj.put("name", "jhunu");
	jobj.put("skill", "automation");
	String jsonData=jobj.toJSONString();
	reqs.body(jsonData);
	reqs.contentType(ContentType.JSON);
	RequestSender sender=reqs.when();
	Response res=reqs.post("http://localhost:3000/posts");
	ValidatableResponse vr=res.then();
	vr.log().all();
	
	}

}
