package com.jda.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Utility {
	static Scanner sc = new Scanner(System.in);

	public static String getString() {
		String word = sc.nextLine();
		return word;
	}

	public static int getInt() {
		int number = sc.nextInt();
		return number;
	}
	
	/**
	 * Reads data from a given CSV file
	 * 
	 * @param file
	 *            the path of the CSV file
	 * @return String[] containing all the words present in the file
	 * @throws FileNotFoundException
	 */
	public static String[] readFromCsvFile(File file) throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		String totalData = "";
		while (sc.hasNextLine()) {
			totalData += sc.nextLine() + ",";
		}
		String[] words = totalData.split(",");
		return words;
	}
}
