package com.jda.utility;

/**
 * Purpose: Contains utility functions required for queue programs
 * 
 * @author Apoorva Mishra
 *
 */
public class QueueUtility {
	int front, rear;
	int capacity;
	int size;
	int array[];

	public QueueUtility(int capacity) {
		this.capacity = capacity;
		size = 0;
		front = 0;
		rear = capacity - 1;
		array = new int[capacity];
	}

	/**
	 * returns the size of the queue
	 * 
	 * @return integer value containing the size of the queue
	 */
	public int size() {
		return size;
	}

	/**
	 * Checks if the queue is empty
	 * 
	 * @return true if the queue is empty, false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Checks if the queue is full
	 * 
	 * @return true if the queue is full, false otherwise
	 */
	public boolean isFull() {
		return capacity == size;
	}

	/**
	 * enqueues a value to the queue
	 * 
	 * @param data
	 *            the value to be added
	 */
	public void enqueue(int data) {
		if (isFull()) {
			System.out.println("The queue is full");
			return;
		}
		rear = (rear + 1) % capacity;
		array[rear] = data;
		size = size + 1;
	}

	/**
	 * dequeues a value from the front of the queue
	 * 
	 * @return integer value present at the front of the queue
	 */
	public int dequeue() {
		if (isEmpty()) {
			System.out.println("The queue is empty");
			return -1;
		}
		int data = array[front];
		front = (front + 1) % capacity;
		size = size - 1;
		return data;
	}

}
