package com.jda.core;

import java.io.File;
import java.io.FileNotFoundException;

import com.jda.utility.ListUtility;
import com.jda.utility.Utility;

/**
 * Purpose : Reads words from a file and deletes the word to be searched if
 * already present in the file otherwise, adds the word to the file
 * 
 * @author Apoorva Mishra
 */
public class UnorderedList {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("/home/bridgelabz/java-programs/Text Files/words.csv");
		ListUtility<String> allWords = new ListUtility<String>();
		String[] words = allWords.readFromCsvFile(file);
		for (int i = 0; i < words.length; i++) {
			allWords.append(words[i]);
		}
		System.out.println("\nEnter the word to be searched:");
		String key = Utility.getString();
		if (allWords.search(key)) {
			allWords.remove(key);
		} else {
			allWords.append(key);
		}
		allWords.writeToCsvFile(file);
	}
}
