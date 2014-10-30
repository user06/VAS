package com.worldline.serviceavailability;

import com.worldline.helper.DataValueConstants;

public class RolloutCheckerImpl implements RolloutChecker {

	private boolean serviceAvailable = true;


	public String getRolloutStatus(String sitenumber) throws ServiceFailureException {
		if (!serviceAvailable){
			throw new  ServiceFailureException();
		}
		
		Site site = new Site();
		if (site.checkActive(sitenumber)) {
			return DataValueConstants.SERVICE_ROLLEDOUT;
		}
		
		if (site.checkInActive(sitenumber)) {
			return DataValueConstants.SERVICE_NOTROLLEDOUT;
		}
		
		if (site.checkPlanned(sitenumber)) {
			return DataValueConstants.SERVICE_PLANNED;
		}
		
				
		//TO DO: invoke a method to check whether site number exists or not
		return DataValueConstants.SITE_INVALID;
		
	}
	
	public void disableService() {
		this.serviceAvailable = false;
	}
}
