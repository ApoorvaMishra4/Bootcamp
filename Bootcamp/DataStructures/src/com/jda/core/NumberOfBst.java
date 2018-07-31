package com.jda.core;

import com.jda.utility.Utility;

/**
 * Finds the number of BST possible given the number of nodes
 * 
 * @author Apoorva Mishra
 */
public class NumberOfBst {

	/**
	 * Calculates the factorial of a given number
	 * 
	 * @param n
	 *            the given number
	 * @return factorial of the number
	 */
	public static long factorial(long n) {
		long factorial = 1;
		while (n > 1) {
			factorial = factorial * n;
			n--;
		}
		return factorial;
	}

	/**
	 * Calculates the binomial coefficient
	 * 
	 * @param n
	 *            given number
	 * @param k
	 *            given number
	 * @return binomial coefficient
	 */
	public static long binomial(long n, long k) {
		long numerator = factorial(n);
		long denominator = factorial(k) * factorial(n - k);
		return numerator / denominator;
	}

	/**
	 * Calculates the catalan number for a given number
	 * 
	 * @param n
	 *            given number
	 * @return catalan number calculated
	 */
	public static long catalanNumber(int n) {
		long c = binomial(2 * n, n);
		return c / (n + 1);
	}

	public static void main(String[] args) {
		System.out.println("Enter the number of nodes:");
		int n = Utility.getInt();
		// Case when user inputs a number less than 0
		while (n < 0) {
			System.out.println("Invalid number! Enter number of nodes again:");
			n = Utility.getInt();
		}
		System.out.println("The number of BST possible are : " + catalanNumber(n));
	}
}
