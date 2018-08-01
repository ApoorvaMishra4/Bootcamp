package com.jda.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.jda.utility.AlgorithmUtility;

public class SearchAndSortFromFile {
	public static void main(String args[]) throws FileNotFoundException {
		File file = new File("/home/bridgelabz/java-program/functional-program/functional/input.csv");
		Scanner sc = new Scanner(file);
		String totalData ="";
		while (sc.hasNextLine())
		{
			totalData +=sc.nextLine()+',';
		}
		String[] allWords = totalData.split(",");
		System.out.println("Enter 1 for binary search, 2 for bubble sort, 3 for insertion sort:");
		int number = AlgorithmUtility.getInt();
		switch(number)
		{
		case 1:
		{
			System.out.print("Enter the word to search:");
			String key = AlgorithmUtility.getString();
			System.out.println(AlgorithmUtility.binarySearchString(allWords, key));
		}
		break;
		case 2:
		{
			allWords = AlgorithmUtility.bubbleSortString(allWords);
		}
		break;
		case 3:
		{
			allWords = AlgorithmUtility.insertionSortString(allWords);
		}
		}
		System.out.println("\n");
		for (int i=0; i<allWords.length; i++)
			{
			System.out.print(allWords[i]);
			}
			}
}
