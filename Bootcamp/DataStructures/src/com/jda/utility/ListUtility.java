/**
 * Purpose: Contains utility functions required for linked list programs
 * @author Apoorva Mishra
 */
package com.jda.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

class Node<T> {
	T data;
	Node<T> next;

	Node(T d) {
		data = d;
	}
}

public class ListUtility<T> {
	Node<T> head = null;

	/**
	 * Pushes the data at the beginning of linked list
	 * 
	 * @param d
	 *            is the data to be added to the linked list
	 */
	public void push(T d) {
		Node<T> newNode = new Node<T>(d);
		newNode.next = head;
		head = newNode;
	}

	/**
	 * Adds the data at the end of linked list
	 * 
	 * @param d
	 *            is the data to be added to the linked list
	 */
	public void append(T d) {
		Node<T> newNode = new Node<T>(d);
		Node<T> temp = head;
		if (head == null) {
			head = newNode;
			return;
		}
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
	}

	/**
	 * Adds the data in an ordered list
	 * @param d is the data to be added
	 */
	public void addOrdered(T d) {
		Node<T> newNode = new Node<T>(d);
		if (head == null) {
			head = newNode;
			return;
		}
		Node<T> temp = head;
		if (size() == 1) {
			if (temp.data.toString().compareTo(d.toString()) > 0) {
				head = newNode;
				newNode.next = temp;
			} else {
				temp.next = newNode;
			}
			return;
		}
		while (temp != null) {
			if (temp.next == null) {
				temp.next = newNode;
				newNode.next = null;
				return;
			}
			if (temp.next.data.toString().compareTo(d.toString()) > 0) {
				newNode.next = temp.next;
				temp.next = newNode;
				return;
			}
			temp = temp.next;
		}
	}

	/**
	 * Removes the data from the linked list
	 * 
	 * @param d
	 *            is the data to be removed from the list
	 */
	public void remove(T d) {
		Node<T> newNode = head;
		if (newNode.data.equals(d)) {
			head = newNode.next;
			return;
		}
		while (newNode != null) {
			if (newNode.next.data.equals(d)) {
				newNode.next = newNode.next.next;
				return;
			}
			newNode = newNode.next;
		}
	}

	/**
	 * Prints the data from the linked list
	 */
	public void print() {
		Node<T> newNode = head;
		while (newNode != null) {
			System.out.print(newNode.data + " ");
			newNode = newNode.next;
		}
	}

	/**
	 * Searches the list for a value.
	 * 
	 * @param d
	 *            is the value to be searched
	 * @return true if the value is present, and false otherwise
	 */
	public boolean search(T d) {
		Node<T> newNode = head;
		while (newNode != null) {
			if (newNode.data.equals(d)) {
				return true;
			}
			newNode = newNode.next;
		}
		return false;
	}

	/**
	 * Checks if the list is empty
	 * 
	 * @return true if the list is empty, and false otherwise
	 */
	public boolean isEmpty() {
		return (head == null);
	}

	/**
	 * Calculates the size of the linked list
	 * 
	 * @return integer value containing the size of the list
	 */
	public int size() {
		int count = 0;
		Node<T> newNode = head;
		while (newNode != null) {
			count++;
			newNode = newNode.next;
		}
		return count;
	}

	/**
	 * Finds the position of a given value in the linked list
	 * 
	 * @param d
	 *            is the value to be found
	 * @return integer containing the position of the value
	 */
	public int position(T d) {
		int count = 0;
		Node<T> newNode = head;
		while (newNode != null) {
			count++;
			if (newNode.data.equals(d)) {
				return count;
			}
			newNode = newNode.next;
		}
		return -1;
	}

	/**
	 * Inserts a value at a given position
	 * 
	 * @param pos
	 *            the position to insert the value
	 * @param item
	 *            the value to be added
	 */
	public void insert(int pos, T item) {
		Node<T> newNode = head;
		int count = 1;
		Node<T> temp = new Node<T>(item);
		if (pos == 1) {
			temp.next = newNode.next;
			newNode.next = temp;
			return;
		}
		while (newNode.next != null) {
			count++;
			if (count == pos) {
				temp.next = newNode.next;
				newNode.next = temp;
				return;
			}
			newNode = newNode.next;
		}
	}

	/**
	 * pops the last element of the linked list
	 * 
	 * @return the removed element's data
	 */
	public T pop() {
		Node<T> newNode = head;
		if (newNode.next == null) {
			return newNode.data;
		}
		while (newNode.next.next != null) {
			newNode = newNode.next;
		}
		T data = newNode.next.data;
		newNode.next = null;
		return data;
	}

	/**
	 * Removes the element present at a given position
	 * 
	 * @param pos
	 *            the position to remove the element
	 * @return the data of the popped element
	 */
	public T pop(int pos) {
		Node<T> newNode = head;
		T data;
		if (pos == 1) {
			data = newNode.data;
			head = newNode.next;
			return data;
		}
		int count = 1;
		while (newNode.next != null) {
			count++;
			if (count == pos) {
				data = newNode.next.data;
				newNode.next = newNode.next.next;
				return data;
			}
			newNode = newNode.next;
		}
		return null;
	}

	/**
	 * Reads data from a given CSV file
	 * 
	 * @param file
	 *            the path of the CSV file
	 * @return String[] containing all the words present in the file
	 * @throws FileNotFoundException
	 */
	public String[] readFromCsvFile(File file) throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		String totalData = "";
		while (sc.hasNextLine()) {
			totalData += sc.nextLine() + ",";
		}
		String[] words = totalData.split(",");
		return words;
	}

	/**
	 * Writes all the values present in the linked list to a given CSV file
	 * separated by commas
	 * 
	 * @param file
	 *            - the path of the file
	 * @throws FileNotFoundException
	 */
	public void writeToCsvFile(File file) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(file);
		Node<T> temp = head;
		while (temp != null) {
			if (temp.next == null) {
				pw.append((CharSequence) temp.data);
				temp = temp.next;
			} else {
				pw.append((CharSequence) temp.data);
				pw.append(",");
				temp = temp.next;
			}
		}
		pw.flush();
		pw.close();
	}

}
