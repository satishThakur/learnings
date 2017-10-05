package com.satish.lambda.probs;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class FileUtilities {

	/**
	 * Method prints all the subdir from a given path.
	 * Use lambda instead of FileFilter and finally use method expression.
	 * @param path
	 */
	public static void listSubdirs(String path){

		File homeDir = Paths.get(path).toFile();		
		File[] files = homeDir.listFiles(new FileFilter() {

			@Override
			public boolean accept(File pathname) {
				return pathname.isDirectory();
			}
		});		
		Stream.of(files).forEach(System.out::println);	
	}

	//Solution
	public static void listSubDirs(String path){
		File homeDir = Paths.get(path).toFile();	
		File[] files = homeDir.listFiles(File::isDirectory);
		Stream.of(files).forEach(System.out::println);
	}

	/**
	 * The program prints all files/dir with specified extension.
	 * Convert it to lambda expression.
	 * @param path
	 * @param extn
	 */
	public static void listFilesWithExtn(String path, String extn){
		File homeDir = Paths.get(path).toFile();	
		File[] files = homeDir.listFiles(new FilenameFilter() {		
			@Override
			public boolean accept(File dir, String name) {			
				return name.endsWith(extn);
			}
		});
		Stream.of(files).forEach(System.out::println);
	}

	//Solution. Observe for the closure.
	public static void listFilesWithExtention(String path, String extn){
		File homeDir = Paths.get(path).toFile();	
		File[] files = homeDir.listFiles((file,name) -> name.endsWith(extn));
		Stream.of(files).forEach(System.out::println);
	}

	/**
	 * Implement the method so that files are sorted by directory first, and 
	 * within each group based on file path.
	 * Do not use comparator in final solution, use lambda
	 * @param files
	 */
	//solution
	public static void sortFiles(List<File> files){

		files.sort(
				Comparator.comparing(File::isFile)
				.thenComparing(File::getAbsolutePath)
				);
	}





	public static void main(String[] args) {
		//listSubDirs("/Users/satish");
		//listFilesWithExtn("/Users/satish/tmp", "java");
		//listFilesWithExtention("/Users/satish/tmp", "java");

		File homeDir = Paths.get("/Users/satish").toFile();
		List<File> files = Arrays.asList(homeDir.listFiles());

		sortFiles(files);

		files.forEach(System.out::println);

	}

}
