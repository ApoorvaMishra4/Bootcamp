package com.jda.core;

import com.jda.utility.FunctionalUtility;

public class Stopwatch {
	public static void main(String[] args) {
		System.out.println("Enter any number to start:");
		int number = FunctionalUtility.getInt();
		long startTime = System.nanoTime();
		System.out.println("Enter any number to stop:");
		number = FunctionalUtility.getInt();
		long endTime = System.nanoTime();
		long diff = endTime - startTime;
		System.out.println("Time taken :" + diff);
	}
}
