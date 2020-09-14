package com.automation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;

public class AddNew2 {
	@Test
	public void data()
	{
		RequestSpecification reqs=RestAssured.given();
		JSONObject jobj1=new JSONObject();
		jobj1.put("selenium", "expert");
		jobj1.put("java", "proficient");
		JSONObject jobj2=new JSONObject();
		jobj2.put("name", "ram");
		jobj2.put("id", 12);
		jobj2.put("skill",jobj1 );
		JSONObject jobj3=new JSONObject();
		jobj3.put("employee",jobj2);
		String jsonData=jobj3.toJSONString();
		reqs.body(jsonData);
		reqs.contentType(ContentType.JSON);
        RequestSender sender=reqs.when();
        Response res=sender.post("http://localhost:3000/posts");
        res.then().log().all();
        res.prettyPrint();
		
	}

}
