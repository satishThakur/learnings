package com.satish.lambda.probs.medaltally;

public class CountryTally {

	private final String country;

	private final int gold;

	private final int silver;

	private final int bronze;


	public CountryTally(String rawTally){
		String[] tokens = rawTally.split(",");	
		this.country = tokens[0]; 
		this.gold = Integer.parseInt(tokens[1]);
		this.silver = Integer.parseInt(tokens[2]); 
		this.bronze = Integer.parseInt(tokens[3]);
	}


	public CountryTally(String country, int gold, int silver, int bronze) {
		super();
		this.country = country;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
	}


	public String getCountry() {
		return country;
	}


	public int getGold() {
		return gold;
	}


	public int getSilver() {
		return silver;
	}


	public int getBronze() {
		return bronze;
	}


	@Override
	public String toString() {
		return String.format("%10s  %5d  %5d  %5d", country, gold, silver, bronze);
	}

}
