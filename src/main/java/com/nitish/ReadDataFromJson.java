package com.nitish;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class ReadDataFromJson {

	public void fileReader() throws ParseException, IOException {
		JSONParser jsonparser = new JSONParser();
		ObjectMapper objectMapper=new ObjectMapper();
		FileReader reader = null;
		try {

			reader = new FileReader(".\\JsonFile\\employee.json");

			Object obj = jsonparser.parse(reader); // Normal Object,we need to JSON Object
			System.out.println("Object ->" + obj);
			JSONObject empJsonObject = (JSONObject) obj; // Here we Convert Normal Object to Json Object
			String fName = (String) empJsonObject.get("firstName");
			String lName = (String) empJsonObject.get("lastName");
			System.out.println("First Name :" + fName + "\n" + "Last Name :" + lName);
			String writeValueAsString = objectMapper.writeValueAsString(reader);
			System.out.println("WriteValueAsString --->" +writeValueAsString);
	//		JSONObject jsonObject=new JSONObject(writeValueAsString);
	
			
	//		JSONObject object = (JSONObject) empJsonObject.get("bookingDetails").toString();
			
			

//			System.out.println("booking_details1 -> " + object);

			JSONArray tab = (JSONArray) empJsonObject.get("tab");
			for (int i = 0; i < tab.size(); i++) {
		//		List<String> lst = new ArrayList<>();

				String tab1 = (String) tab.get(i);
			//	lst.add((String) tab.get(i));
			//	System.out.println("List of TAB  :" + lst);
				System.out.println(" TAB :" + tab1);
			}

			JSONArray array = (JSONArray) empJsonObject.get("address");
			for (int i = 0; i < array.size(); i++) {
				JSONObject address = (JSONObject) array.get(i);
				System.out.println(address);
				String street = (String) address.get("street");
				String city = (String) address.get("city");
				String state = (String) address.get("state");

				// System.out.println("street :" +street+ "\n" + "city :" +city + "\n" + "state
				// :" +state);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}

//	try {
//		JSONParser jsonparser=new JSONParser();
//			
//		FileReader reader=new FileReader(".\\JsonFile\\employee.json");
//	}
//	catch(FileNotFoundException e)
//	{
//	e.printStackTrace();	
//	}
