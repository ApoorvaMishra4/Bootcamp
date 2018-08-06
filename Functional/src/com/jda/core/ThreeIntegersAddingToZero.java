package com.jda.core;

import java.util.ArrayList;

import com.jda.utility.FunctionalUtility;

public class ThreeIntegersAddingToZero {
	public static void main(String args[]) {
		System.out.println("Enter the number of elements:");
		int n = FunctionalUtility.getInt();
		System.out.println("Enter the  individual elements:");
		int[] numbersArray = FunctionalUtility.get1DIntArray(n);
		int count = 0;
		ArrayList<Integer> triplets = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					if (numbersArray[i] + numbersArray[j] + numbersArray[k] == 0) {
						triplets.add(numbersArray[i]);
						triplets.add(numbersArray[j]);
						triplets.add(numbersArray[k]);
						count++;
					}
				}
			}
		}
		System.out.println("The triplets are:");
		for (int i = 0; i < triplets.size(); i += 3) {
			System.out.print(triplets.get(i));
			System.out.print(",");
			System.out.print(triplets.get(i + 1));
			System.out.print(",");
			System.out.print(triplets.get(i + 2));
			System.out.print("\n");
		}
		System.out.println("The total number of triplets is : " + count);
	}
}
