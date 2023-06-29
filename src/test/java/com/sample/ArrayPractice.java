package com.sample;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ArrayPractice {
	public static void main(String[] args) throws IOException, ParseException {
		FileReader fileReader = new FileReader(
				"C:\\Users\\User\\eclipse-workspace\\JsonPractice\\src\\test\\resources\\array.json");
		JSONParser jsonParser = new JSONParser();
		Object parse = jsonParser.parse(fileReader);
		JSONObject jsonObject = (JSONObject) parse;
		Object object = jsonObject.get("page");
		System.out.println(object);
		Object object1 = jsonObject.get("per_page");
		System.out.println(object1);
		Object object2 = jsonObject.get("total");
		System.out.println(object2);
		Object object3 = jsonObject.get("total_pages");
		System.out.println(object3);
		System.out.println("");
		Object object4 = jsonObject.get("data");
		JSONArray array = (JSONArray) object4;
		for (int i = 0; i < array.size(); i++) {
			Object object5 = array.get(i);
			JSONObject jsonObject2 = (JSONObject) object5;
			Object object6 = jsonObject2.get("id");
			System.out.println("");
			System.out.println(object6);
			Object object7 = jsonObject2.get("email");
			System.out.println(object7);
			Object object8 = jsonObject2.get("first_name");
			System.out.println(object8);
			Object object9 = jsonObject2.get("last_name");
			System.out.println(object9);
			Object object10 = jsonObject2.get("avatar");
			System.out.println(object10);
		}
		Object object5 = jsonObject.get("support");
		JSONObject jsonObject3 = (JSONObject) object5;
		Object object6 = jsonObject3.get("url");
		System.out.println("");
		System.out.println(object6);
		Object object7 = jsonObject3.get("text");
		System.out.println(object7);

	}
}
