package com.satish.po.workshop;

import java.time.LocalDate;

//sku, category, transaction date, units sold, selling price, cost, isOnPromo
public class DailySkuData {
	
	private final String skuId;
	
	private final String category;
	
	private final LocalDate date;
	
	private final int unitSold;
	
	private final int sellingPrice;
	
	private final int cost;
	
	private final boolean isPromo;
	
	public DailySkuData(String rawRecord){
		String[] tokens = rawRecord.split(",");	
		skuId = tokens[0].trim();
		category = tokens[1].trim();
		date = LocalDate.parse(tokens[2].trim());
		unitSold = Integer.parseInt(tokens[3].trim());
		sellingPrice = Integer.parseInt(tokens[4].trim());
		cost = Integer.parseInt(tokens[5].trim());
		isPromo = Boolean.parseBoolean(tokens[6].trim());
	}

	public DailySkuData(String skuId, String category, LocalDate date, 
			int unitSold, int sellingPrice, int cost,boolean isPromo) {
		super();
		this.skuId = skuId;
		this.category = category;
		this.date = date;
		this.unitSold = unitSold;
		this.sellingPrice = sellingPrice;
		this.cost = cost;
		this.isPromo = isPromo;
	}

	public String getSkuId() {
		return skuId;
	}

	public String getCategory() {
		return category;
	}

	public LocalDate getDate() {
		return date;
	}

	public int getUnitSold() {
		return unitSold;
	}

	public int getSellingPrice() {
		return sellingPrice;
	}

	public int getCost() {
		return cost;
	}

	public boolean isPromo() {
		return isPromo;
	}
	
	public int getRevenue(){
		return unitSold * sellingPrice;
	}
	
	public int getMargin(){
		return (sellingPrice - cost) * unitSold;
	}

	@Override
	public String toString() {
		return "DailySkuData [skuId=" + skuId + ", category=" + category + ", date=" + date + ", unitSold=" + unitSold
				+ ", sellingPrice=" + sellingPrice + ", cost=" + cost + ", isPromo=" + isPromo + "]";
	}
	
}
