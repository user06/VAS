package com.worldline.helper;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * Class that loads the JSON data from json file
 */
 
public class JSONLoader {
	
	     
	/** Returns the JSON value corresponding to a key
	 * @param fileName
	 * @param key
	 * @returns Object
	 */
	public Object getJSONValue(String fileName, String key) {
 
		Object value = null;
		JSONArray msg = null;
		JSONParser parser = new JSONParser();
 
		try {
 
			Object obj = parser.parse(new FileReader(fileName));
 
			JSONObject jsonObject = (JSONObject) obj; 
			
			if (jsonObject.get(key) instanceof String) {
				value = (String) jsonObject.get(key);				
			}
			else {
				value = (JSONArray) jsonObject.get(key);				
			}
	
  
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return value;
	 
	}	
	
	
}