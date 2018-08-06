package com.jda.utility;

public class StackLinkedList<T> {
	private class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data) {
			super();
			this.data = data;
			this.next = null;
		}
	}

	// head of the list
	private Node<T> head;

	/**
	 * Inserts data into linked list
	 * 
	 * @param value
	 *            Generic value
	 */
	public void push(T value) {
		Node<T> newNode = new Node<T>(value);
		if (head == null) {
			newNode.next = null;
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	/**
	 * Prints the elements of the list
	 */
	public void printList() {
		Node<T> current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.print("\n");
	}

	/**
	 * Pops an element from list
	 * 
	 * @param item
	 */
	public T pop() {
		if (head == null) {
			return null;
		}
		T data = head.data;
		head = head.next;
		return data;
	}

	/**
	 * Finds the element at the top of the stack
	 * 
	 * @return
	 */
	public T peek() {
		if (head == null) {
			return null;
		}
		return head.data;
	}

	/**
	 * Checks if the stack is empty
	 * 
	 * @return true if the stack is empty, false otherwise
	 */
	public boolean isEmpty() {
		if (head == null)
			return true;
		return false;
	}
}
