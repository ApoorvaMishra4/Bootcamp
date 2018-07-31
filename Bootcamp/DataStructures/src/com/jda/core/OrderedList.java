package com.jda.core;

import java.io.File;
import java.io.FileNotFoundException;

import com.jda.utility.ListUtility;
import com.jda.utility.Utility;

/**
 * Purpose : Reads numbers from a file after sorting and deletes the word to be
 * searched if already present in the file otherwise, adds the number to the
 * file at it's correct place
 * 
 * @author Apoorva Mishra
 *
 */
public class OrderedList {
	public static void main(String[] args) throws FileNotFoundException {
		ListUtility<String> allNumbers = new ListUtility<String>();
		File file = new File("/home/bridgelabz/java-programs/Text Files/numbers.csv");
		String[] numbers = allNumbers.readFromCsvFile(file);
		for (int i = 0; i < numbers.length; i++) {
			allNumbers.addOrdered(numbers[i]);
		}
		System.out.println("Enter the number to be searched:");
		String key = Utility.getString();
		// If the number to be searched is present
		if (allNumbers.search(key)) {
			allNumbers.remove(key);
		}
		// If the number is not present
		else {
			allNumbers.addOrdered(key);
		}
		// Write all the numbers to the file
		allNumbers.writeToCsvFile(file);
	}
}
