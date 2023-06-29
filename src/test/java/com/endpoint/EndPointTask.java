package com.endpoint;

import org.testng.annotations.Test;

import com.base.BaseClass;

import io.restassured.response.Response;

public class EndPointTask extends BaseClass {

	@Test(priority = 1)

	public void getAllUsers() {

		addHeader("accept", "application/json");

		Response response = requestType("GET", "https://reqres.in/api/users?page=2");

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);

		String resBodyPrettyString = getResBodyPrettyString(response);
		System.out.println(resBodyPrettyString);

	}

	@Test(priority = 2)

	public void createUser() {

		addHeader("accept", "application/json");
		addBody("{\r\n" + "    \"email\": \"eve.holt@reqres.in\",\r\n" + "    \"password\": \"pistol\"\r\n" + "}");
		Response response = requestType("POST", "https://reqres.in/api/register");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		String resBodyPrettyString = getResBodyPrettyString(response);
		System.out.println(resBodyPrettyString);

	}

	@Test(priority = 3)

	public void updateUser() {

		addHeader("accecpt", "application/json");

		addBody("{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"zion resident\"\r\n" + "}");

		Response response = requestType("PUT", "https://reqres.in/api/users/2");

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);

		String resBodyPrettyString = getResBodyPrettyString(response);

		System.out.println(resBodyPrettyString);

	}

	@Test(priority = 4)

	public void deleteUser() {

		addHeader("accecpt", "application/json");

		addPathParam("page", "2");

		Response response = requestType("DELETE", "https://reqres.in/api/users/{page}");

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);

		String resBodyPrettyString = getResBodyPrettyString(response);
		System.out.println(resBodyPrettyString);

	}
}
