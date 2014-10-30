package com.worldline.onlinestore;

/**
 * Exception thrown when the site number entered does not exist
 */

public class InvalidSiteException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InvalidSiteException(String msg) {
		super(msg);
		
	}

}
