package com.satish.stream.application;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionQueryService {
	
	
	private List<Transaction> transactions = AppDb.getAllTransactions();
	
	
	////Find all transactions in the year 2011 and sort them by value (small to high).
	public List<Transaction> getSortedTxOf2011(){		
		return transactions.stream()
				.filter(t -> t.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getAmount))
				.collect(Collectors.toList());
	}
	
	
	// What are all the unique cities where the traders work?
	public List<String> getAllTraderCities(){
		return transactions.stream()
		.map(t -> t.getTrader().getCity())
		.distinct().collect(Collectors.toList());
	}
	
	// Find all traders from Cambridge and sort them by name.
	public List<String> getAllSortedTradersFromCambridge(){
		return transactions.stream()
		.filter(t -> t.getTrader().getCity().equals("Cambridge"))
		.map(t -> t.getTrader().getName())
		.sorted()
		.collect(Collectors.toList());
	}
	
	
	// Return a string of all traders’ names sorted alphabetically delimited by comma.	
	public String getTraderNames(){
		return transactions.stream()
		.map(t -> t.getTrader().getName())
		.distinct()
		.sorted()
		.collect(Collectors.joining(","));
	}
	
	// Are any traders based in Milan?
	public boolean isAnyTraderInMilan(){
		return transactions.stream()
				.anyMatch(t -> t.getTrader().getCity().equals("Milan"));
	}
	
	//Print all transactions’ values from the traders living in Cambridge.	
	public void printAllTransactionValuesFromCambridge(){
		transactions.stream()
		.filter(t -> t.getTrader().getCity().equals("Cambridge"))
		.map(t -> t.getAmount())
		.forEach(System.out::println);
	}
	
	//What’s the highest value of all the transactions?
	
	public int getMaxTxValue(){
		return transactions.stream()
				.max(Comparator.comparing(Transaction::getAmount))
				.get().getAmount();
	}
	
	//Find the transaction with the smallest value.
	public Transaction getSmallestTx(){
		return  transactions.stream()
				.min(Comparator.comparing(Transaction::getAmount)).get();
	}
	
	

}
