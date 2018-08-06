package com.jda.core;

import com.jda.utility.StackUtility;
import com.jda.utility.Utility;

/**
 * Purpose: Checks if a given expression has balanced parentheses
 * 
 * @author Apoorva Mishra
 *
 */
public class BalancedParentheses {

	static StackUtility<Character> stack = new StackUtility<>(10);

	/**
	 * Checks if a pair exists
	 * 
	 * @param c
	 *            Stores closing bracket ), }, or ]
	 * @return true if a pair exists, false otherwise
	 */
	public static boolean isPair(char c) {
		if (stack.top >= 0) {
			if (c == ')' && stack.charArray[stack.top] == '(') {
				return true;
			} else if (c == '}' && stack.charArray[stack.top] == '{') {
				return true;
			} else if (c == ']' && stack.charArray[stack.top] == '[') {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println("Enter the expression:");
		String expression = Utility.getString();
		for (int i = 0; i < expression.length(); i++) {
			// If the character is an opening bracket i.e (, {, or [ then push
			// it in the stack
			if ((expression.charAt(i) == '(') || (expression.charAt(i) == '{') || (expression.charAt(i) == '[')) {
				stack.push(expression.charAt(i));
			}
			// If the character is a closing bracket i.e ), }, or ]
			else if ((expression.charAt(i) == ')') || (expression.charAt(i) == '}') || (expression.charAt(i) == ']')) {
				// If a pair does not exist
				if (!isPair(expression.charAt(i))) {
					System.out.println("The expression is not balanced");
					return;
				}
				// If a pair exists
				else {
					stack.top = stack.top - 1;
				}
			}
		}
		// If after pushing the opening brackets and popping them on finding a
		// pair, the stack is empty
		if (stack.isEmpty()) {
			System.out.println("The expression is balanced");
		}
	}
}