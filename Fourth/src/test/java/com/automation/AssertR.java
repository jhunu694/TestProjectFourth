package com.automation;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AssertR {
	@Test
	public void checkRest(){
		Response res=given().param("userId", "4").when().get("https://jsonplaceholder.typicode.com/posts");
res.then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().time(Matchers.lessThan(5000L));
//res.then().log().all();
	}

}
