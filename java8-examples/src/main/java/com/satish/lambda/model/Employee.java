package com.satish.lambda.model;

import java.util.Optional;

public class Employee {
	
	private Address address;

	public Optional<Address> getAddress() {
		
		return Optional.ofNullable(address);
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
