package com.worldline.testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.junit.Test;

import com.worldline.helper.JSONLoader;

public class JSONLoaderTest {

	@Test
	public void testGetJSONValueAsString() {
		JSONLoader jsonLoader = new JSONLoader();		
		assertEquals(jsonLoader.getJSONValue("C:\\Workspace\\ValueAddedServices\\data\\ServiceAddOn.json", "REMINDERS"),"");
		
	}
	
	@Test
	public void testGetJSONObject() {
		JSONLoader jsonLoader = new JSONLoader();	
		ArrayList value = null;
		ArrayList addons = new ArrayList();
				
		addons.add("Report Site Performance");
		addons.add("Report Test Counts");
		
		
		value = (JSONArray)jsonLoader.getJSONValue("C:\\Workspace\\ValueAddedServices\\data\\ServiceAddOn.json", "REPORTS");
		
		assertTrue("value does not contain all add ons", value.containsAll(addons));
		assertTrue("addons does not contain all value", addons.containsAll(value));
		
	}	
	

}
