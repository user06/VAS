package com.worldline.onlinestore;

import java.util.List;

public interface VASAddOnService {
	public List<String> checkForServiceAddOns(Basket basket, String siteno) throws InvalidSiteException;
}
