package com.worldline.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import com.worldline.serviceavailability.Site;

public class SiteTest {

	@Test
	public void testCheckActive() {
		Site site = new Site();
		assertTrue("Site is not rolled out properly",site.checkActive("4000A"));
		assertFalse("Site is not rolled out properly",site.checkActive("4007A"));
	}
	
	@Test
	public void testCheckInActive() {
		Site site = new Site();
		assertTrue("Site is not inactivated properly",site.checkInActive("5000A"));
		assertFalse("Site is not inactivated properly",site.checkInActive("5007A"));
	}
	
	
	@Test
	public void testCheckPlanned() {
		Site site = new Site();
		assertTrue("Site is not planned properly",site.checkPlanned("6000A"));
		assertFalse("Site is not planned properly",site.checkPlanned("6007A"));
	}

}
