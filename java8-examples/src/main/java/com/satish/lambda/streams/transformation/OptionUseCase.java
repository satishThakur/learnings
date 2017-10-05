package com.satish.lambda.streams.transformation;

import java.util.Optional;

import com.satish.lambda.model.Address;
import com.satish.lambda.model.Employee;
import com.satish.lambda.model.OldAddress;
import com.satish.lambda.model.OldEmployee;
import com.satish.lambda.model.OldZipCode;
import com.satish.lambda.model.ZipCode;

public class OptionUseCase {
	
	public static String getZipCode(OldEmployee emp){
		if(emp != null){
			OldAddress add = emp.getAddress();
			if(add != null){
				OldZipCode zip = add.getZipCode();
				if(zip != null){
					return zip.getLastFourZipCode();
					
				}
			}
		}
		return null;
	}
	
	
	public static Optional<String> getZipCode(Employee emp){
		return Optional.ofNullable(emp)
		.flatMap(Employee::getAddress)
		.flatMap(Address::getZipcode)
		.flatMap(ZipCode::getLastFourDigits);
	}

}
