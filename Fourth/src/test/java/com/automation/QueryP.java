package com.automation;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryP {
	@Test
	public void checkp(){
	given().param("userId","7").pathParam("x", "posts").when().get("https://jsonplaceholder.typicode.com/{x}").then().log().all();
	}

}
