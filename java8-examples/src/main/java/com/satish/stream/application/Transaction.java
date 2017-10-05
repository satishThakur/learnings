package com.satish.stream.application;

import java.util.Objects;

public class Transaction {
	
	private final Trader trader;
	
	private final int year;
	
	private final int amount;

	public Transaction(Trader trader, int year, int amount) {
		super();
		this.trader = trader;
		this.year = year;
		this.amount = amount;
	}

	public Trader getTrader() {
		return trader;
	}

	public int getYear() {
		return year;
	}

	public int getAmount() {
		return amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((trader == null) ? 0 : trader.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return Objects.equals(trader, other.trader) &&
				Objects.equals(year, other.year) &&
				Objects.equals(amount, other.amount);
	}

	@Override
	public String toString() {
		return "Transaction [trader=" + trader + ", year=" + year + ", amount=" + amount + "]";
	}
	
	

}
