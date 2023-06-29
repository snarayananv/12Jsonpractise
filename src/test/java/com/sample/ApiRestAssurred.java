package com.sample;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiRestAssurred {

	public static void main(String[] args) {

		RequestSpecification reqSpec;

		reqSpec = RestAssured.given();

		reqSpec = reqSpec.header("accept", "application/json");
	

		reqSpec = reqSpec
				.body("{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"zion resident\"\r\n" + "}");

		Response response = reqSpec.put("https://reqres.in/api/users");

		int statusCode = response.statusCode();
		System.out.println(statusCode);

		String asPrettyString = response.asPrettyString();
		System.out.println(asPrettyString);

	}

}
