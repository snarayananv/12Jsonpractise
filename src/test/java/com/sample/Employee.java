package com.sample;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.internal.matchers.Each;

public class Employee {

	public static void main(String[] args) throws IOException, ParseException {

		FileReader fileReader = new FileReader(
				"C:\\Users\\User\\eclipse-workspace\\JsonPractice\\src\\test\\resources\\sample.json");

		JSONParser jsonParser = new JSONParser();

		Object parse = jsonParser.parse(fileReader);

		JSONObject jsonObject = (JSONObject) parse;
		
		Object object = jsonObject.get("data");
		System.out.println(object);
		
		JSONObject jsonObject2 = (JSONObject) object;
		Object object2 = jsonObject2.get("id");
		System.out.println(object2);
		
		Object object3 = jsonObject2.get("email");
		System.out.println(object3);
		
		Object object4 = jsonObject2.get("first_name");
		System.out.println(object4);
		
		Object object5 = jsonObject2.get("last_name");
		System.out.println(object5);
		
		Object object6 = jsonObject2.get("avatar");
		System.out.println(object6);
		System.out.println("");				

		
		Object object1 = jsonObject.get("support");
		System.out.println(object1);
		JSONObject jsonObject3 = (JSONObject) object1;
		Object object8 = jsonObject3.get("url");
		System.out.println(object8);
		Object object9 = jsonObject3.get("text");
		System.out.println(object9);

	}

}
