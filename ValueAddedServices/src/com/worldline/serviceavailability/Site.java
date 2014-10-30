package com.worldline.serviceavailability;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * This class provides site where service is active / inactive or planned
 * TO DO: Check for invalid sites. Get data from database.
 */

public class Site {
	
	public static ArrayList<String> activeSites() {
		ArrayList<String> active = new ArrayList<String>();
		active.add("4000A");
		active.add("4001A");
		active.add("4002A");
		active.add("4003A");
		active.add("4004A");
		active.add("4005A");
		return active;
	}
	
	
	public static ArrayList<String> inActiveSites() {
		ArrayList<String> inactive = new ArrayList<String>();
		inactive.add("5000A");
		inactive.add("5001A");
		inactive.add("5002A");
		inactive.add("5003A");
		inactive.add("5004A");
		inactive.add("5005A");
		return inactive;
	}

	
	public static ArrayList<String> plannedSites() {
		ArrayList<String> planned = new ArrayList<String>();
		planned.add("6000A");
		planned.add("6001A");
		planned.add("6002A");
		planned.add("6003A");
		planned.add("6004A");
		planned.add("6005A");
		return planned;
	}
	
	public boolean checkActive(String sitenumber) {
		ArrayList<String> active = activeSites();		
		Iterator it = active.iterator();
		while(it.hasNext()) {
			if (sitenumber.equals(it.next())){
				return true;
			}
		}
		return false;
	}
	
	public boolean checkInActive(String sitenumber) {
		ArrayList<String> inactive = inActiveSites();		
		Iterator it = inactive.iterator();
		while(it.hasNext()) {
			if (sitenumber.equals(it.next())){
				return true;
			}
		}
		return false;
	}
	
	public boolean checkPlanned(String sitenumber) {
		ArrayList<String> planned = plannedSites();		
		Iterator it = planned.iterator();
		while(it.hasNext()) {
			if (sitenumber.equals(it.next())){
				return true;
			}
		}
		return false;
	}

}
