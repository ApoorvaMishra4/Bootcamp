package com.jda.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import com.jda.utility.ListUtility;
import com.jda.utility.Utility;

/**
 * Purpose: Searches a number by hashing
 * 
 * @author Apoorva Mishra
 */
public class SearchNumberByHashing {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("/home/bridgelabz/java-programs/Text Files/numbers.csv");
		String[] numbers = Utility.readFromCsvFile(file);
		int index; // calculates the key for the hashmap
		Map<Integer, ListUtility<Integer>> slotNumbers = new HashMap<>();
		ListUtility<Integer> linkedList;
		for (int i = 0; i < numbers.length; i++) {
			index = Integer.parseInt(numbers[i]) % 11;
			// case when map does not have the key added yet
			if (!slotNumbers.containsKey(index)) {
				linkedList = new ListUtility<>();
				linkedList.addOrdered(Integer.parseInt(numbers[i]));
				slotNumbers.put(index, linkedList);
			}
			// case when map already contains the key and it's corresponding values
			else {
				linkedList = slotNumbers.get(index);
				linkedList.addOrdered(Integer.parseInt(numbers[i]));
				slotNumbers.put(index, linkedList);
			}
		}
		System.out.println("Enter the number to be searched:");
		int key = Utility.getInt();
		linkedList = slotNumbers.get(key % 11);
		// case when the number is present in the linked list of values
		if (linkedList.search(key)) {
			linkedList.pop(linkedList.position(key));
		}
		// case when the number is not present in the linked list of values
		else {
			linkedList.addOrdered(key);
		}
		// prints the map
		for (int i = 0; i < 10; i++) {
			System.out.print(i + "->");
			if (slotNumbers.containsKey(i)) {
				linkedList = slotNumbers.get(i);
				linkedList.print();
			}
			System.out.print("\n");
		}
	}
}
