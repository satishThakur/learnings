package com.satish.lambda.model;

import java.util.Optional;

public class Address {
	
	private ZipCode zipcode;

	public Optional<ZipCode> getZipcode() {
		return Optional.ofNullable(zipcode);
	}

	public void setZipcode(ZipCode zipcode) {
		this.zipcode = zipcode;
	}
	

}
