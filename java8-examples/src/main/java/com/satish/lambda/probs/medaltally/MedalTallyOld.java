package com.satish.lambda.probs.medaltally;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MedalTallyOld {


	public static void main(String[] args) {
		String[] stats = {
				"Pakistan,0,0,0", 
				"GBR,27,23,17", 
				"USA,46,37,38", 
				"Egypt,0,0,3", 
				"China,26,18,26", 
				"Russia,19,18,19", 
				"India,0,1,1"
		};

		List<CountryTally> conuntrystandings = new ArrayList<>();
		for(String stat : stats){
			conuntrystandings.add(new CountryTally(stat));
		}

		conuntrystandings.sort(new Comparator<CountryTally>() {

			@Override
			public int compare(CountryTally o2, CountryTally o1) {
				int result = Integer.compare(o1.getGold(), o2.getGold());
				if(result != 0){
					return result;
				}

				result = Integer.compare(o1.getSilver(), o2.getSilver());
				if(result != 0){
					return result;
				}

				result = Integer.compare(o1.getBronze(), o2.getBronze());
				if(result != 0){
					return result;
				}

				return o1.getCountry().compareTo(o2.getCountry());
			}
		});

		for(CountryTally country : conuntrystandings){
			System.out.println(country);
		}

	}

}
