package com.sample;
import java.io.File;
import java.io.IOException;
import java.io.StreamCorruptedException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.Datum;
import com.pojo.Employee1;
import com.pojo.Support;
public class Arraypractise1 {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\User\\eclipse-workspace\\JsonPractice\\src\\test\\resources\\array1.json");
		ObjectMapper mapper = new ObjectMapper();

		Employee1 employee1 = mapper.readValue(file, Employee1.class);
		String page = employee1.getPage();
		System.out.println(page);
		String per_page = employee1.getPer_page();
		System.out.println(per_page);
		String total = employee1.getTotal();
		System.out.println(total);
		String total_pages = employee1.getTotal_pages();
		System.out.println(total_pages);
		ArrayList<Datum> data = employee1.getData();
		for (Datum data2 : data) {
			System.out.println(data2.getId());
			System.out.println(data2.getEmail());
			System.out.println(data2.getFirst_name());
			System.out.println(data2.getLast_name());
			System.out.println(data2.getAvatar());
			System.out.println("");
		}
		Support support = employee1.getSupport();
		System.out.println(support.getText());
		System.out.println(support.getUrl());
	}
}
