package com.apiTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.generic.AutoConfig;
import com.generic.Base;

import io.restassured.response.Response;

public class FetchTest extends Base {
	@Test
	public void demo() throws IOException
	{
	AutoConfig config=new AutoConfig();
	String name=config.getApiData("getEmployeeData");
	Response res=config.getExecutable(name);
	res.then().log().all();

}}
