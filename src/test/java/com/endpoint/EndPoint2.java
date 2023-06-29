package com.endpoint;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class EndPoint2 extends BaseClass {
	@Test
	public void getUser() {
		addHeader("accept", "application/json");
		Response response = requestType("GET", "https://reqres.in/api/users?page=2");
		int statusCode = getStatusCode(response);
		System.out.println("StatusCode - " + statusCode);
		SoftAssert s = new SoftAssert();
		s.assertEquals(statusCode, 200, "Verify status code");
//		Assert.assertEquals(statusCode, 200, "Verify status code");
		JsonPath path = response.jsonPath();
		Object object = path.get("data[4].first_name");
		String firstName = (String) object;
		System.out.println("firstName - " + firstName);
		s.assertEquals(firstName, "George", "Verified Name");
//		Assert.assertEquals(firstName, "George", "Verified Name");
		Object object2 = path.get("data[0].email");
		String email = (String) object2;
		System.out.println("Email - " + email);
		s.assertEquals(email, "michael.lawson@reqres.in", "Verified EMAIL");
//		Assert.assertEquals(email, "michael.lawson@reqres.in", "Verified EMAIL");
		Object object3 = path.get("data[0].id");
		Integer id = (Integer) object3;
		System.out.println("ID - " + id);
		Object object4 = path.get("data.id");	
		List<Integer> li = (List<Integer>)object4;
		System.out.println("ID is - " + li);
		s.assertEquals(li, "7, 8, 9, 10, 11, 12", "Id is Verified");
//		Assert.assertEquals(li, "[7, 8, 9, 10, 11, 12]", "Id is Verified");

	}

}
