package com.jda.utility;

public class QueueLinkedList<T> {
	public static class Node<T> {
		public T data;
		public Node<T> next;

		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	public Node<T> head;
	public int size = 0;

	public void push(T x) {
		Node newNode = new Node(x);
		if (head == null) {
			head = newNode;
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
		size = size + 1;
	}

	public T pop() {
		if (head == null) {
			return null;
		}
		T data = head.data;
		head = head.next;
		size = size - 1;
		return data;
	}

	public T pop(T input) {
		if (head == null) {
			return null;
		}
		Node node = head;
		T data = null;
		while (node != null) {
			if (node.next.data == input) {
				data = (T) node.next.data;
				node.next = node.next.next;
				break;
			}
			node = node.next;
		}
		size = size - 1;
		return data;
	}

	public boolean isEmpty() {
		return head == null;
	}
}
