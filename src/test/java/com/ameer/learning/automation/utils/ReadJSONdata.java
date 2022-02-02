package com.ameer.learning.automation.utils;

import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadJSONdata {

	public static String getJSONdata() {
		String SearchItem=null, selectItem =null;
		JSONParser parser = new JSONParser();
		
		try {
			Object obj = parser.parse(new FileReader("C:\\Users\\Ameer\\Documents\\GitHub\\automation\\Datafiles\\SearchItems.json"));
			JSONObject jsonObject= (JSONObject) obj;
			SearchItem = (String) jsonObject.get("searchItem");
			selectItem =(String) jsonObject.get("selectItem");
//			String course = (String) jsonObject.get("course");
//			JSONArray subjects = (JSONArray) jsonObject.get("Subjects");
			System.out.println("SearchItem: " + SearchItem);
			System.out.println("SelectItem: " + selectItem);
//			System.out.println("course" + course);
//			System.out.println("Subjects:");
//			Iterator iterator =subjects.iterator();
//			while(iterator.hasNext()) {
//				System.out.println(iterator.next());
		
		return SearchItem;
		
		} catch(Exception e) {
			e.printStackTrace();
		} 
		return SearchItem;
		 
	}  
	public static void main(String[] args) {
		getJSONdata();
	}
}
