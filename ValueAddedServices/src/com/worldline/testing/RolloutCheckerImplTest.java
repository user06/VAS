package com.worldline.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import com.worldline.serviceavailability.RolloutCheckerImpl;
import com.worldline.serviceavailability.ServiceFailureException;
import com.worldline.helper.DataValueConstants;

public class RolloutCheckerImplTest {

	
	@Test //(expected= ServiceFailureException.class) 
	public void testServiceAvailable() throws ServiceFailureException {
		RolloutCheckerImpl rollChecker = new RolloutCheckerImpl();
		assertEquals(rollChecker.getRolloutStatus("4000A"),DataValueConstants.SERVICE_ROLLEDOUT);
	}
	
	@Test //(expected= ServiceFailureException.class) 
	public void testServiceUnAvailable() throws ServiceFailureException {
		RolloutCheckerImpl rollChecker = new RolloutCheckerImpl();
		assertEquals(rollChecker.getRolloutStatus("5000A"),DataValueConstants.SERVICE_NOTROLLEDOUT);
	}
	
	@Test //(expected= ServiceFailureException.class) 
	public void testServicePlanned() throws ServiceFailureException {
		RolloutCheckerImpl rollChecker = new RolloutCheckerImpl();
		assertEquals(rollChecker.getRolloutStatus("6000A"),DataValueConstants.SERVICE_PLANNED);
	}
	
	@Test
	public void testInvalidSite() throws ServiceFailureException {
		RolloutCheckerImpl rollChecker = new RolloutCheckerImpl();
		assertEquals(rollChecker.getRolloutStatus("3000"),DataValueConstants.SITE_INVALID);
	}

}
