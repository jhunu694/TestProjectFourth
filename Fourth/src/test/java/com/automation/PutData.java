package com.automation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;

public class PutData {
	@Test
	public void putD()
	{
	 RequestSpecification reqs	=RestAssured.given();
	 JSONObject job=new JSONObject();
	 job.put("name", "jhunu1");
	 String jsondata=job.toJSONString();
	 reqs.body(jsondata);
	 reqs.contentType(ContentType.JSON);
	  RequestSender sendr=reqs.when();
	  Response res=sendr.put("http://localhost:3000/posts/7");
	  ValidatableResponse vr=res.then();
	  vr.log().all();
	}

}
