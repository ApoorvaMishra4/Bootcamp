package com.jda.utility;

/**
 * Utility functions for deque
 * 
 * @author Apoorva Mishra
 */
public class Deque<T> {
	class Node<T> {
		T data;
		Node<T> next;
	}

	ListUtility<T> queue;
	Node<T> head;
	int size;

	public Deque() {
		ListUtility<T> queue = new ListUtility<>();
		size = 0;
	}

	/**
	 * Adds data to the front of the deque
	 * 
	 * @param data
	 *            the data to be added
	 */
	public void addFront(T data) {
		Node<T> newNode = new Node<>();
		newNode.data = data;
		size ++;
		// case when the deque is empty
		if (head == null) {
			head = newNode;
			return;
		}
		// case when deque contains elements already
		newNode.next = head;
		head = newNode;
	}

	/**
	 * Adds data to the rear of the deque
	 * 
	 * @param data
	 *            the data to be added
	 */
	public void addRear(T data) {
		Node<T> newNode = new Node<>();
		newNode.data = data;
		size = size + 1;
		// case when deque is empty
		if (head == null) {
			head = newNode;
			return;
		}
		// case when deque contains elements already
		Node<T> temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		newNode.next = temp.next;
		temp.next = newNode;
	}

	/**
	 * Removes the data present at the front of the deque
	 * 
	 * @return data at the front of the deque
	 */
	public T removeFront() {
		// case when deque is empty
		if (head == null) {
			return null;
		}
		// case when deque has elements
		size = size - 1;
		T data = head.data;
		head = head.next;
		return data;
	}

	/**
	 * Removes the data present at the rear of the deque
	 * 
	 * @return data at the rear of the deque
	 */
	public T removeRear() {
		// case when deque is empty
		if (head == null) {
			return null;
		}
		// case when deque has elements
		size = size - 1;
		T data;
		Node<T> temp = head;
		if (head.next == null) {
			data = head.data;
			head = null;
			return data;
		}
		while (temp.next.next != null) {
			temp = temp.next;
		}
		data = temp.next.data;
		temp.next = null;
		return data;
	}

	/**
	 * Checks if the deque is empty
	 * 
	 * @return true if the deque is empty, false otherwise
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Finds the size of the deque
	 * 
	 * @return integer value containing the size
	 */
	public int size() {
		return size;
	}
}
