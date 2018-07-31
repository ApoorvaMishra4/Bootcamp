package com.jda.core;

import com.jda.utility.Deque;
import com.jda.utility.Utility;

/**
 * Purpose: Checks if a word is a palindrome using deque
 * 
 * @author Apoorva Mishra
 */
public class PalindromeChecker {
	static Deque<Character> queue = new Deque<Character>();

	public static void main(String[] args) {
		System.out.println("Enter the word:");
		String input = Utility.getString();
		while (input.trim().isEmpty()) {
			System.out.println("Invalid input! Enter the word again:");
			input = Utility.getString();
		}
		char[] word = input.toCharArray();
		// adds all the characters of the word to the queue in the same order
		for (int i = 0; i < word.length; i++) {
			queue.addRear(word[i]);
		}
		while (!queue.isEmpty()) {
			// Only compare front and rear if the number of characters are
			// greater than equal to 2
			if (queue.size() >= 2) {
				char front = queue.removeFront();
				char rear = queue.removeRear();
				if (front != rear) {
					System.out.println("Not a palindrome");
					return;
				}
			}
			// If only one character present or left after the removals
			else if (queue.size() == 1) {
				break;
			}
		}
		System.out.println("Palindrome");
	}
}
