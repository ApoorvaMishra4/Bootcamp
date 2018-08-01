/**************************************************************************************
 * Purpose : Determines if two strings are anagrams
 * @author Apoorva Mishra
 **************************************************************************************/

package com.jda.core;

import com.jda.utility.AlgorithmUtility;

/**
 * ALPHABET_PRESENT - boolean array which shows which alphabets are present
 * initialiseArray()
 * equalLengths()
 * alphabetsPresent()
 * main()
 */
public class Anagram {

	static boolean[] ALPHABET_PRESENT = new boolean[26];
	
	/**
	 * Function to check if the strings are of equal lengths
	 * 
	 * @param a - first input string
	 * @param b - second input string
	 * @return true if lengths are equal, otherwise returns false
	 */
	public static boolean equalLengths(String a, String b) {
		return a.length() == b.length();
	}

	/**
	 * Function to initialise ALPHABET_PRESENT with all values equal to false
	 */
	public static void initialiseArray() {
		for (int i = 0; i < 26; i++) {
			ALPHABET_PRESENT[i] = false;
		}
	}

	/**
	 * Function to modify the array with value equal to true if the alphabet is present in string a
	 * and then compare to check if the same alphabets are present in string b
	 * 
	 * @param a - first input string
	 * @param b - second input string
	 * @return true if the alphabets match, otherwise return false
	 */
	public static boolean alphabetsPresent(String a, String b) {
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i)>'a' && a.charAt(i)<'z')
			{
				ALPHABET_PRESENT[a.charAt(i) - 'a'] = true;
			}
			else if (a.charAt(i)>'A' && a.charAt(i)<'Z')
			{
				ALPHABET_PRESENT[a.charAt(i) - 'A'] = true;
			}
		}
		for (int i = 0; i < b.length(); i++) {
			if (b.charAt(i)>'a' && b.charAt(i)<'z')
			{
				if (ALPHABET_PRESENT[b.charAt(i) - 'a'] != true) {
					return false;
				}
			}
			else if (b.charAt(i)>'A' && b.charAt(i)<'Z')
			{
				if (ALPHABET_PRESENT[b.charAt(i) - 'A'] != true) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Function to input strings, call methods and print the final result
	 */
	public static void main(String args[]) {
		System.out.println("Enter string 1 :");
		String a = AlgorithmUtility.getString();
		System.out.println("Enter string 2 :");
		String b = AlgorithmUtility.getString();
		if (equalLengths(a, b) == false) {
			System.out.println("The strings are not anagrams");
			return;
		}
		initialiseArray();
		if (alphabetsPresent(a, b) == false) {
			System.out.println("The strings are not anagrams");
			return;
		}
		System.out.println("The strings are anagrams");
	}
}
