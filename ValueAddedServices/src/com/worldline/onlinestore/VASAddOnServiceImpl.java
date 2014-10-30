package com.worldline.onlinestore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.worldline.helper.DataValueConstants;
import com.worldline.helper.JSONLoader;
import com.worldline.serviceavailability.RolloutCheckerImpl;
import com.worldline.serviceavailability.ServiceFailureException;


/**
 * Facade class for getting the service add ons
 * @author VGarg
 *
 */
public class VASAddOnServiceImpl implements VASAddOnService  {
	public List<String> checkForServiceAddOns(Basket basket, String siteno) throws InvalidSiteException{
		
		List<String> basketProducts = new ArrayList<String>();
		String siteStatus = null;
		
		basketProducts = getServiceAddons(basket);
		
		//No services with add-ons
		if (basketProducts.size() == 0) {
			return null;
		}
		
		
		try {
			siteStatus = checkSite(siteno);
		}
		catch (ServiceFailureException e) {
			return null;
		}
		
		//Site has been rolled out and there are services with add-ons in the basket
		if (siteStatus == DataValueConstants.SERVICE_ROLLEDOUT) {
			return basketProducts;
		}
		//Site number is invalid
		else if (siteStatus == DataValueConstants.SITE_INVALID) {
			throw new InvalidSiteException("The given site is invalid");
		}
		else { //Currently not in rolled out area
			return null;
		}
	}
		
	
	
	private String checkSite(String siteno) throws ServiceFailureException {
		String siteStatus = null;
		
		//Check the status of rollout 
		RolloutCheckerImpl rolloutChecker = new RolloutCheckerImpl();
		siteStatus = rolloutChecker.getRolloutStatus(siteno);	
		
		return siteStatus;
	}
	
	/*
	 * 
	 */
	
	private List<String> getServiceAddons(Basket basket) {
		List<Service> basketItems = new ArrayList<Service>(); 
		List<String> addOnList = new ArrayList<String>();
		Object addOnItem = null;
		ArrayList jsonList = new ArrayList();
		
				
		basketItems = basket.getBasketItems();
		
		
		//Iterate through the items and get add on
		
		for (int i = 0; i < basketItems.size(); i++) {						
			
			JSONLoader jsonLoader = new JSONLoader();		
			addOnItem = jsonLoader.getJSONValue("C:\\Workspace\\ValueAddedServices\\data\\ServiceAddOn.json", basketItems.get(i).getServiceType());
			
			if (addOnItem instanceof String) {
				if (!(((String)addOnItem).equals("") ||((String) addOnItem) == null)) {
					addOnList.add((String)addOnItem);
				}
			}
			else {
				jsonList = (ArrayList)addOnItem;
				Iterator<String> iterator = jsonList.iterator();
				while (iterator.hasNext()) {
					//System.out.println(iterator.next());
					addOnList.add(iterator.next());
				}
			}
			
			
		}

	    return addOnList;
	}



}
