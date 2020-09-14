package com.automation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;

public class PatchData {
	@Test
	public void patchd()
	{
	 RequestSpecification reqs=RestAssured.given();
	 JSONObject job=new JSONObject();
	 job.put("skill", "automation");
	 String jsonData=job.toJSONString();
	 reqs.body(jsonData);
	 reqs.contentType(ContentType.JSON);
	 RequestSender  sender=reqs.when();
	  Response res=sender.patch("http://localhost:3000/posts/7");
	 ValidatableResponse vr=res.then();
	 vr.log().all();
	 
	}
	

}
