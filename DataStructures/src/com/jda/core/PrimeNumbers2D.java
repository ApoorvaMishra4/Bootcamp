package com.jda.core;

import com.jda.utility.QueueLinkedList;
import com.jda.utility.StackLinkedList;

/**
 * Purpose: To find the prime numbers between 0-1000 and store them in a 2D
 * array
 * 
 * @author Apoorva Mishra
 *
 */
public class PrimeNumbers2D {
	// boolean array to check which numbers are prime
	static boolean[] PRIME_OR_NOT = new boolean[1000];

	// 2D array to store the prime numbers
	static int[][] PRIMES = new int[10][];

	/**
	 * Function to mark the numbers which are prime with the value true
	 */
	public static void markPrimes() {
		PRIME_OR_NOT[0] = true;
		PRIME_OR_NOT[1] = true;
		for (int i = 2; i < 500; i++) {
			for (int j = 2; i * j < 1000; j++) {
				PRIME_OR_NOT[i * j] = true;
			}
		}
	}

	/**
	 * Function to find the number of prime numbers in a given range and hence
	 * find the size of the row
	 * 
	 * @param i
	 *            the value of the iterator
	 * @return integer value containing the size of the row
	 */
	public static int sizeOfPrimeRow(int i) {
		int size = 0;
		for (int k = i * 100; k < i * 100 + 100; k++) {
			if (!PRIME_OR_NOT[k]) {
				size++;
			}
		}
		return size;
	}

	/**
	 * Function to store the prime numbers in a 2D array
	 */
	public static void makeArray() {
		for (int i = 0; i < PRIMES.length; i++) {
			int size = sizeOfPrimeRow(i);
			PRIMES[i] = new int[size];
			int j = 0;
			for (int k = i * 100; k < i * 100 + 100; k++) {
				if (!PRIME_OR_NOT[k]) {
					PRIMES[i][j] = k;
					j++;
				}
			}
		}
	}

	public static boolean[] anagrams = new boolean[1000];

	/**
	 * Reverses a given number
	 * 
	 * @param i
	 *            given number
	 * @return integer value containing the reverse number
	 */
	public static int reverseNumber(int i) {
		StringBuilder sb = new StringBuilder();
		String number = Integer.toString(i);
		sb.append(number);
		sb.reverse();
		String reverse = sb.toString();
		int reverseNumber = Integer.parseInt(reverse);
		return reverseNumber;
	}

	/**
	 * Marks all anagrams as false
	 */
	public static void markAnagrams() {
		for (int i = 10; i < 1000; i++) {
			if (!PRIME_OR_NOT[i]) {
				int reverseNumber = reverseNumber(i);
				if (!PRIME_OR_NOT[reverseNumber]) {
					anagrams[i] = true;
					anagrams[reverseNumber] = true;
				}
			}
		}
	}

	public static int allAnagrams[][] = new int[10][];

	public static int sizeOfAnagramRow(int i) {
		int size = 0;
		for (int k = i * 100; k < i * 100 + 100; k++) {
			if (anagrams[k]) {
				size++;
			}
		}
		return size;
	}

	/**
	 * Makes anagram array
	 */
	public static void makeAnagramArray() {
		for (int i = 0; i < allAnagrams.length; i++) {
			int size = sizeOfAnagramRow(i);
			allAnagrams[i] = new int[size];
			int j = 0;
			for (int k = i * 100; k < i * 100 + 100; k++) {
				if (anagrams[k]) {
					allAnagrams[i][j] = k;
					j++;
				}
			}
		}
	}

	/**
	 * Function to print the prime numbers
	 */
	public static void printPrimes() {
		for (int i = 0; i < PRIMES.length; i++) {
			for (int j = 0; j < PRIMES[i].length; j++) {
				System.out.print(PRIMES[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

	public static void printAnagrams() {
		for (int i = 0; i < allAnagrams.length; i++) {
			int j;
			for (j = 0; j < allAnagrams[i].length; j++) {
				System.out.print(allAnagrams[i][j] + " ");
			}
			if (allAnagrams[i].length > 0) {
				System.out.print("\n");
			}
		}
	}

	/**
	 * Prints the anagrams in reverse order
	 */
	public static void reverseAnagrams() {
		StackLinkedList<Integer> stack = new StackLinkedList<>();
		for (int i = 0; i < anagrams.length; i++) {
			if (anagrams[i]) {
				stack.push(i);
			}
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	public static void queueAnagrams() {
		QueueLinkedList<Integer> queue = new QueueLinkedList<>();
		for (int i = 0; i < 1000; i++) {
			if (anagrams[i]) {
				queue.push(i);
			}
		}
		while (queue.size != 0) {
			System.out.print(queue.pop() + " ");
		}
	}

	public static void main(String[] args) {
		markPrimes();
		makeArray();
		printPrimes();
		System.out.println("ANAGRAMS:");
		markAnagrams();
		makeAnagramArray();
		printAnagrams();
		System.out.println("REVERSE ANAGRAMS:");
		reverseAnagrams();
		System.out.println("\nQUEUE ANAGRAMS:");
		queueAnagrams();
	}

}
