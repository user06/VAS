package com.worldline.onlinestore;

import java.util.ArrayList;
import java.util.List;

/*
 * Shopping Basket
 * 
 * This class holds the services added to the shopping cart
 */

public class Basket {

	private List<Service> basketItems = new ArrayList<Service>(); 
	

	
	public void addToBasket(Service service){
		basketItems.add(service);
	}
	
	
	//TO DO remove from Basket
	
	
	public List<Service> getBasketItems() {
		return basketItems;
	}
}
