package com.satish.po.workshop;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SkuQueryService {

	
	private static List<DailySkuData> skuData = SkuDb.getAllSkuData();

	//Get Margins by months for given year
	public static Map<Integer, Integer> getRevenueByMonth(int year){
		return skuData.stream()
				.filter(data -> data.getDate().getYear() == year)
				.collect(Collectors.groupingBy(d -> d.getDate().getMonthValue(),
						Collectors.summingInt(DailySkuData::getRevenue)
						));		
	}
	

	public static Map<Integer, Integer> getMarginsByMonth(int year){
		return skuData.stream()
				.filter(data -> data.getDate().getYear() == year)
				.collect(Collectors.groupingBy(d -> d.getDate().getMonthValue(),
						Collectors.summingInt(DailySkuData::getMargin)
						));		
	}
	
	//revenue by year and category
	
	public static Map<Integer, Map<String, Integer>>  getRevenueByYearAndCat(){
		
		return skuData.stream()
		.collect(Collectors.groupingBy(d -> d.getDate().getYear()
				, Collectors.groupingBy(d -> d.getCategory(), 
						Collectors.summingInt(DailySkuData::getRevenue))));
	}


	//on promo vs non promo revenue by Year and category
	public static Map<String, Map<Boolean, Integer>> getOnPromoRevenuePerYearAndCat(){
		return skuData.stream()
		.collect(Collectors.groupingBy(
				d -> "" + d.getDate().getYear() + "-" + d.getCategory()
				, Collectors.partitioningBy(d -> d.isPromo()
						, Collectors.summingInt(DailySkuData::getRevenue))));		
	}


	public static void main(String[] args) {
		System.out.println(getRevenueByMonth(2016));

		System.out.println(getMarginsByMonth(2016));
		
		getOnPromoRevenuePerYearAndCat().forEach((k,v) -> {
			System.out.println(k + " : \n");
			v.forEach((p,r) -> System.out.println("\t" + (p ? "Promo" : "NonPromo") 
					+ "" + "\t" + r));
		});
		
		System.out.println(getRevenueByYearAndCat());
	}

}
