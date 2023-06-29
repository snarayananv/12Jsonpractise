package com.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.payload.address.AddressPayload;
import com.pojo.AddUserAddress_Output_Pojo;
import com.pojo.CityList;
import com.pojo.CityList_Output_Pojo;
import com.pojo.DeleteUserAddress_Input_Pojo;
import com.pojo.DeleteUserAddress_Output_Pojo;
import com.pojo.GetUserAddres_Output_Pojo;
import com.pojo.Login_Output_Pojo;
import com.pojo.StatList_Output_Pojo;
import com.pojo.StateList;
import com.pojo.UpdateUserAddress_Output_Pojo;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class EndPointAddress extends BaseClass {
	String logtoken;
	int stateIdNum;
	String state_id;
	int cityId;
	String address_id;

	@Test(priority = 7)

	public void deleteUserAddress() {

		List<Header> listHeaders = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");

		listHeaders.add(h1);
		listHeaders.add(h2);
		listHeaders.add(h3);

		Headers headers = new Headers(listHeaders);
		addHeaders(headers);

		DeleteUserAddress_Input_Pojo deleteUserAddress_Input_Pojo = new DeleteUserAddress_Input_Pojo(address_id);
		addBodyObject(deleteUserAddress_Input_Pojo);

		Response response = requestType("DELETE", Endpoints.DELETEADDRESS);

		int actStatusCode = getStatusCode(response);
		System.out.println(actStatusCode);
		Assert.assertEquals(actStatusCode, 200, "Verify the StatusCode");

		DeleteUserAddress_Output_Pojo deleteUserAddress_Output_Pojo = response.as(DeleteUserAddress_Output_Pojo.class);
		String actMessage = deleteUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals(actMessage, "Address deleted successfully", "Verify Address deleted successfully");

	}

	@Test(priority = 6)

	public void getUserAddress() {

		List<Header> listHeaders = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);

		listHeaders.add(h1);
		listHeaders.add(h2);

		Headers headers = new Headers(listHeaders);
		addHeaders(headers);

		Response response = requestType("GET", Endpoints.GETADDRESS);

		int actStatusCode = getStatusCode(response);
		System.out.println(actStatusCode);
		Assert.assertEquals(actStatusCode, 200, "Verify the StatusCode");

		GetUserAddres_Output_Pojo getUserAddres_Output_Pojo = response.as(GetUserAddres_Output_Pojo.class);
		String actMessage = getUserAddres_Output_Pojo.getMessage();
		Assert.assertEquals(actMessage, "OK", "Verifyied");

	}

	@Test(priority = 5)

	public void updateUserAddress() {

		List<Header> listHeaders = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");

		listHeaders.add(h1);
		listHeaders.add(h2);
		listHeaders.add(h3);

		Headers headers = new Headers(listHeaders);
		addHeaders(headers);

		addBodyObject(AddressPayload.getUpdateAddress(address_id, "Suriya", "V", "9790383744", "Villa", stateIdNum,
				cityId, 13, "626117", "Chennai", "Home"));

		Response response = requestType("PUT", Endpoints.UPDATEADDRESS);

		int actStatusCode = getStatusCode(response);
		System.out.println(actStatusCode);
		Assert.assertEquals(actStatusCode, 200, "Verify the StatusCode");

		UpdateUserAddress_Output_Pojo updateUserAddress_Output_Pojo = response.as(UpdateUserAddress_Output_Pojo.class);
		String actMessage = updateUserAddress_Output_Pojo.getMessage();

		Assert.assertEquals(actMessage, "Address updated successfully", "Verify Address updated successfully");

	}

	@Test(priority = 4)

	public void addUserAddress() {

		List<Header> listHeaders = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");

		listHeaders.add(h1);
		listHeaders.add(h2);
		listHeaders.add(h3);

		Headers headers = new Headers(listHeaders);
		addHeaders(headers);

		addBodyObject(AddressPayload.getAddAddressPayload("Suriya", "V", "9790383744", "Villa", stateIdNum, cityId, 13,
				"626117", "Chennai", "Home"));

		Response response = requestType("POST", Endpoints.ADDADDRESS);

		int actStatusCode = getStatusCode(response);
		System.out.println(actStatusCode);
		Assert.assertEquals(actStatusCode, 200, "Verify the StatusCode");

//		String resBodyPrettyString = getResBodyPrettyString(response);
//		System.out.println(resBodyPrettyString);

		AddUserAddress_Output_Pojo addUserAddress_Output_Pojo = response.as(AddUserAddress_Output_Pojo.class);
		String actMessage = addUserAddress_Output_Pojo.getMessage();

		int addressIdNum = addUserAddress_Output_Pojo.getAddress_id();
		address_id = String.valueOf(addressIdNum);

		Assert.assertEquals(actMessage, "Address added successfully", "Verify the Address added successfully");

	}

	@Test(priority = 3)

	public void getCityList() {

		List<Header> listHeaders = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		listHeaders.add(h1);
		listHeaders.add(h2);
		Headers headers = new Headers(listHeaders);
		addHeaders(headers);
		addBodyObject(AddressPayload.getCityPayload(state_id));

		Response response = requestType("POST", Endpoints.CITYLIST);

		int actStatusCode = getStatusCode(response);
		System.out.println(actStatusCode);
		Assert.assertEquals(actStatusCode, 200, "Verify the StatusCode");

		CityList_Output_Pojo cityList_Output_Pojo = response.as(CityList_Output_Pojo.class);
		ArrayList<CityList> cityList = cityList_Output_Pojo.getData();
		for (CityList eachCityList : cityList) {

			String actCityName = eachCityList.getName();
			if (actCityName.equals("Yercaud")) {

				cityId = eachCityList.getId();

				System.out.println(cityId);
				Assert.assertEquals(actCityName, "Yercaud", "Verified");
				break;

			}

		}

	}

	@Test(priority = 2)

	public void getStateList() {
		addHeader("accept", "application/json");
		Response response = requestType("GET", Endpoints.STATELIST);

		int actStatusCode = getStatusCode(response);
		System.out.println(actStatusCode);
		Assert.assertEquals(actStatusCode, 200, "Verify the StatusCode");

		StatList_Output_Pojo statList_Output_Pojo = response.as(StatList_Output_Pojo.class);
		ArrayList<StateList> listStateList = statList_Output_Pojo.getData();

		for (StateList eachStateList : listStateList) {
			String actStateName = eachStateList.getName();

			if (actStateName.equals("Tamil Nadu")) {
				stateIdNum = eachStateList.getId();
				state_id = String.valueOf(stateIdNum);
				System.out.println(stateIdNum);
				Assert.assertEquals(actStateName, "Tamil Nadu", "Verify");
				break;
			}
		}

	}

	@Test(priority = 1)
	public void login() {

		addHeader("accept", "application/json");
		addBasicAuth("suriyanarayananv5@gmail.com", "Vikr@v@n23");

		Response response = requestType("POST", Endpoints.POSTMANBASICAUTH);
		int actStatusCode = getStatusCode(response);
		System.out.println(actStatusCode);
		Assert.assertEquals(actStatusCode, 200, "Verify the StatusCode");

		Login_Output_Pojo login_Output_Pojo = response.as(Login_Output_Pojo.class);
		String actFirst_name = login_Output_Pojo.getData().getFirst_name();
		System.out.println(actFirst_name);

		Assert.assertEquals(actFirst_name, "Suriya", "Verify FirstName");
		logtoken = login_Output_Pojo.getData().getLogtoken();

	}

}
