package com.worldline.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import com.worldline.helper.DataValueConstants;
import com.worldline.onlinestore.ReminderService;
import com.worldline.onlinestore.ReportService;
import com.worldline.onlinestore.ServiceFactory;

import static org.hamcrest.CoreMatchers.instanceOf;



public class ServiceFactoryTest {

	@Test
	public void testInstanceOfReminder() {
		ServiceFactory serviceFactory = new ServiceFactory();
		assertThat(serviceFactory.getService(DataValueConstants.REMINDER_SERVICE), instanceOf(ReminderService.class));		
		
	}
	
	@Test
	public void testInstanceOfReport() {
		ServiceFactory serviceFactory = new ServiceFactory();
		assertThat(serviceFactory.getService(DataValueConstants.REPORT_SERVICE), instanceOf(ReportService.class));		
		
	}

}
