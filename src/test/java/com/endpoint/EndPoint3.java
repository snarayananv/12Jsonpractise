package com.endpoint;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pojo.Login_Output_Pojo;

import io.restassured.response.Response;

public class EndPoint3 extends BaseClass {
	@Test

	public void login() {

		addHeader("accept", "application/json");

		addBasicAuth("suriyanarayananv5@gmail.com", "Vikr@v@n23");

		Response response = requestType("POST", "https://omrbranch.com/api/postmanBasicAuthLogin");

		int actStatusCode = getStatusCode(response);
		System.out.println(actStatusCode);
		Assert.assertEquals(actStatusCode, 200, "Verify the StatusCode");

		Login_Output_Pojo login_Output_Pojo = response.as(Login_Output_Pojo.class);
		String actFirst_name = login_Output_Pojo.getData().getFirst_name();
		System.out.println(actFirst_name);

		Assert.assertEquals(actFirst_name, "Suriya", "Verify FirstName");

	}

}
