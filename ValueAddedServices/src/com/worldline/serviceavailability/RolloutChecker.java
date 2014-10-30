package com.worldline.serviceavailability;

public interface RolloutChecker {
	String getRolloutStatus(String sitenumber) throws ServiceFailureException;

}
