package com.worldline.onlinestore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.worldline.helper.DataValueConstants;

/*
 * Test harness for the user story
 */

public class Client {

	public static void main(String[] args) {
		Basket basket = new Basket();		
		List<Service> items = new ArrayList<Service>();
		List<String> addons = new ArrayList<String>();
		
		
		//Add items to shopping basket
		basket.addToBasket(ServiceFactory.getService(DataValueConstants.REMINDER_SERVICE));
		basket.addToBasket(ServiceFactory.getService(DataValueConstants.REPORT_SERVICE));
		
		items = basket.getBasketItems();
		
		//List the items in the basket
		System.out.println("The items in your shopping basket are:");		
		for (int i = 0; i < items.size(); i++) {
			System.out.println(items.get(i).getServiceType());
		}
		
		//Get add-ons for services
		VASAddOnServiceImpl vasAddOnServiceImpl = new VASAddOnServiceImpl();
		
		try {
			addons = vasAddOnServiceImpl.checkForServiceAddOns(basket, "4000A");
			
			if (addons == null || addons.size()==0) {
				System.out.println("There are no add-ons available");
			}
			else {
			
				System.out.println("The add-ons available are:");
				Iterator<String> iterator = addons.iterator();
			
				while(iterator.hasNext()) {
					System.out.println(iterator.next());
				}
			}
		}
		catch(InvalidSiteException e) {
			System.out.println("Site does not exist");
		}

	}

}
