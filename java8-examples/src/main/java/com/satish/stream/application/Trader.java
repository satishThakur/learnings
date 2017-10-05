package com.satish.stream.application;

import java.util.Objects;

public class Trader {
	
	private final String name;

	private final String city;

	public Trader(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, city);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trader other = (Trader) obj;
		return Objects.equals(name, other.name) &&
				Objects.equals(city, other.city);
	}

	@Override
	public String toString() {
		return "Trader [name=" + name + ", city=" + city + "]";
	};
	
	
	

}
