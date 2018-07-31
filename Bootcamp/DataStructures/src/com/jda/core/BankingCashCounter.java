package com.jda.core;

import com.jda.utility.QueueUtility;
import com.jda.utility.Utility;

/**
 * Purpose: Program simulates a banking cash counter with the help of a queue
 * 
 * @author Apoorva Mishra
 *
 */
public class BankingCashCounter {
	public static void main(String[] args) {
		QueueUtility queue = new QueueUtility(10);
		int balance = 1000; // initial amount in the bank
		while (true) {
			System.out.println("Enter 1 for enqueue, 0 for dequeue");
			int queueType = Utility.getInt();
			switch (queueType) {
			// Dequeue case
			case 0: {
				// Dequeue only if the queue has elements
				if (!queue.isEmpty()) {
					int enquiryType;
					System.out.println("Enter 1 for deposit, 0 for withdraw");
					enquiryType = Utility.getInt();
					switch (enquiryType) {
					// Withdraw case
					case 0: {
						System.out.println("Enter the amount to withdraw:");
						int amount = Utility.getInt();
						if (amount <= balance) {
							balance = balance - amount;
						} else {
							System.out.println("The bank does not have sufficent amount");
						}
						break;
					}
					// Deposit case
					case 1: {
						System.out.println("Enter the amount to deposit:");
						int amount = Utility.getInt();
						balance = balance + amount;
						break;
					}
					}
					// Dequeue the person as he has completed his task
					queue.dequeue();
				}
				// The queue is empty
				else {
					System.out.println("There are no people left in the queue!");
					return;
				}
			}

				break;

			// Enqueue case
			case 1: {
				int people;
				System.out.println("Enter the number of people to enter the queue:");
				people = Utility.getInt();
				for (int i = 0; i < people; i++) {
					// enqueue only if the queue is not full
					if (!queue.isFull()) {
						queue.enqueue(1);
					}
					// The queue is full
					else {
						System.out.println("The queue is full");
					}
				}
				break;
			}
			}
		}
	}
}
