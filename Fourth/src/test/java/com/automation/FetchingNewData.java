package com.automation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;

public class FetchingNewData {
	@Test
	public void check()
	{
		//Response res=RestAssured.delete("https://dummy.restapiexample.com/api/v1/employees");
		//res.then().log().all();
		RequestSpecification reqs=RestAssured.given();
		JSONObject jobj=new JSONObject();
		jobj.put("employee_name", "jhunu");
		jobj.put("employee_salary",25000);
		jobj.put("employee_age", 25);
		jobj.put("profile_image", "");
		String jsonData=jobj.toJSONString();
		reqs.body(jsonData);
		reqs.contentType(ContentType.JSON);
		RequestSender sender=reqs.when();
		Response res=sender.post("https://dummy.restapiexample.com/api/v1/create");
		res.then().log().all();
		//Response res1=RestAssured.delete("https://dummy.restapiexample.com/api/v1/create");
		//res1.then().log().all();
		Response res3=RestAssured.get("https://dummy.restapiexample.com/api/v1/employee/3");
		res3.then().log().all();
		
		
		
	}

}
