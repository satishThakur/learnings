package com.satish.java8.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;

//Date without timezone information. Should be used most of the times.
public class LocalDateExample {
	
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		System.out.println(date);
		
		date = LocalDate.parse("2016-08-01");
		System.out.println(date.getYear() + "-" + date.getMonthValue() + "-" + date.getDayOfMonth() );
		
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime);
	}

}
