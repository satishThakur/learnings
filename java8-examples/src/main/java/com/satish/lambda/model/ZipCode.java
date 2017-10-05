package com.satish.lambda.model;

import java.util.Optional;

public class ZipCode {
	
	private String zipCode;
	
	public Optional<String> getLastFourDigits(){
		if(zipCode == null || zipCode.length() < 4){
			return Optional.empty();
		}
		return Optional.of(zipCode.substring(zipCode.length() -4, zipCode.length()));
	}

}
