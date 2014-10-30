package com.worldline.onlinestore;

import com.worldline.helper.DataValueConstants;
import com.worldline.onlinestore.ReminderService;

/*
 * This class uses factory method pattern
 * It is used to create the services to be added to the basket
 */

public class ServiceFactory {
	
	public static Service getService(String servicetype) {
		if (servicetype==null || servicetype=="") {
			return null;
		}
		
		if (servicetype.equals(DataValueConstants.REMINDER_SERVICE)) {
			return new ReminderService();
		}
		
		if (servicetype.equals(DataValueConstants.REPORT_SERVICE)) {
			return new ReportService();
		}
		return null;
		
	}

}
