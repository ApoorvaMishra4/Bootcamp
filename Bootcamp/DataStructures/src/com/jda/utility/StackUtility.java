package com.jda.utility;

/**
 * Purpose: Contains utility functions required for stack programs
 * 
 * @author Apoorva Mishra
 */
public class StackUtility<T> {
	ListUtility<Character> linkedList = new ListUtility<>();
	public char[] charArray;
	public int top;
	public int capacity;

	public StackUtility(int size) {
		top = -1;
		capacity = size;
		charArray = new char[size];
	}

	/**
	 * Checks if the stack is full
	 * 
	 * @return true if full, false otherwise
	 */
	public boolean isFull() {
		return (top == capacity - 1);
	}

	/**
	 * Checks if the stack is empty
	 * 
	 * @return true if empty, false otherwise
	 */
	public boolean isEmpty() {
		return (top == -1);
	}

	/**
	 * Pushes data in a stack
	 * 
	 * @param data
	 *            the value to be pushed
	 */
	public void push(char data) {
		if (isFull()) {
			return;
		}
		top = top + 1;
		charArray[top] = data;
	}

	/**
	 * Pops the value at the top of the stack
	 * 
	 * @return character value present at the top of the stack
	 */
	public char pop() {
		char data = charArray[top];
		top = top - 1;
		return data;
	}

	/**
	 * Displays the value at the top of the stack
	 * 
	 * @return character value present at the top of the stack
	 */
	public char peek() {
		return charArray[top];
	}

	/**
	 * Searches for a value in the stack
	 * 
	 * @param key
	 *            the value to be searched
	 * @return integer value containing the position where 1 means the top of
	 *         the stack
	 */
	public int search(char key) {
		for (int i = capacity - 1; i >= 0; i--) {
			if (charArray[i] == key) {
				return capacity - i;
			}
		}
		return -1;
	}
}
