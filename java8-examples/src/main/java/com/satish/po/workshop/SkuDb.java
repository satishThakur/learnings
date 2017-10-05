package com.satish.po.workshop;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SkuDb {

	public static List<DailySkuData> getAllSkuData(){
		ClassLoader classLoader = SkuDb.class.getClassLoader();
		Path path =null;
		try{
		 path = Paths.get(classLoader.getResource("po_data.txt").toURI());
		 List<String> lines = Files.readAllLines(path);
		 
			Predicate<String> isEmptyLine = (line -> line.trim().isEmpty());
			Predicate<String> isComment = line -> line.trim().startsWith("#");

			return lines.stream().filter(isEmptyLine.negate())
					.filter(isComment.negate())
					.map(DailySkuData::new)
					.collect(Collectors.toList());
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}

}
