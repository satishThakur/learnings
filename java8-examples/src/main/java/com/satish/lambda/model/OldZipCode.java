package com.satish.lambda.model;

public class OldZipCode {
	
	private String zip;

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public String getLastFourZipCode(){
		if(zip == null || zip.length() < 4)
			return null;
		return zip.substring(zip.length() -4, zip.length());
	}

}
