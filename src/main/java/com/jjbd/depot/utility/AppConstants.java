
package com.jjbd.depot.utility;

public enum AppConstants {

	DEPOT_NOT_FOUND("Test Exception."),DEPOT_NOT_ADDED("Depot Data is Invalid. Use Correct data"),EXPIRY_DATE_NOT_FOUND("Given User does not have any product with ExpiryDate."), DEPOTTYPE_NOT_EXISTS(
			"Type does not exists."), INCORRECT_TEST_STATUS(
					"depot Status is Invalid. Use Correct Status."), TEST_DTO_NOT_CORRECT(
							"%s is not correct for adding a depot"), TARGETUSER(
									"targetUser"), DEPOTDATA("depotData"), SERVICE("service");

	private String value;

	private AppConstants(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}

