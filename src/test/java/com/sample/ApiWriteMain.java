package com.sample;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.ApiWrite;
import com.pojo.Data;
import com.pojo.Support1;

public class ApiWriteMain {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {

		File file = new File("C:\\Users\\User\\eclipse-workspace\\JsonPractice\\src\\test\\resources\\arrayWrite.json");

		ObjectMapper mapper = new ObjectMapper();
		
		List<Data> data = new ArrayList<Data>();
		Data d = new Data(7, "michael.lawson@reqres.in", "Michael", "Lawson", "https://reqres.in/img/faces/7-image.jpg");
		Data d1 = new Data(8, "lindsay.ferguson@reqres.in", "Lindsay", "Ferguson", "https://reqres.in/img/faces/8-image.jpg");
		Data d2 = new Data(9, "tobias.funke@reqres.in", "Tobias", "Funke", "https://reqres.in/img/faces/9-image.jpg");
		Data d3 = new Data(10, "byron.fields@reqres.in", "Byron", "Fields", "https://reqres.in/img/faces/10-image.jpg");
		Data d4 = new Data(11, "george.edwards@reqres.in", "George", "Edwards", "https://reqres.in/img/faces/11-image.jpg");
		Data d5 = new Data(12, "rachel.howell@reqres.in", "Rachel", "Howell", "https://reqres.in/img/faces/12-image.jpg");

		data.add(d);
		data.add(d1);
		data.add(d2);
		data.add(d3);
		data.add(d4);
		data.add(d5);
		
		Support1 s = new Support1("https://reqres.in/#support-heading", "To keep ReqRes free, contributions towards server costs are appreciated!");
        ApiWrite a = new ApiWrite(1, 2, 3, 4, data, s);
        mapper.writeValue(file, a);
		

	}
}
