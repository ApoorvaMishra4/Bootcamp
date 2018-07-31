package com.jda.core;

import com.jda.utility.QueueLinkedList;
import com.jda.utility.StackLinkedList;

public class Calendar {

	public static int dayOfWeek(int m, int d, int y) {
		int y1 = y - (14 - m) / 12;
		int x = y1 + y1 / 4 - y1 / 100 + y1 / 400;
		int m1 = m + 12 * ((14 - m) / 12) - 2;
		int d1 = (d + x + 31 * m1 / 12) % 7;
		return d1;
	}

	public static int daysInMonth(int month) {
		int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		return daysInMonth[month - 1];
	}

	public static void calendar(int day, int daysInMonth) {
		System.out.println("Calendar printed:\n");
		System.out.println("Su  Mo  Tu  We  Th  Fr  Sa");
		int array[] = new int[7];
		int j = 1;
		for (int i = day; j <= daysInMonth; i++) {
			if (i >= 7) {
				i = i % 7;
				if (i == 0) {
					for (int k = 0; k < array.length; k++) {
						if (array[k] != 0) {
							if (array[k] < 10) {
								System.out.print("  " + array[k] + "   ");
							} else if (array[k] >= 10) {
								System.out.print(" " + array[k] + " ");
							}
						} else {
							System.out.print("       ");
						}
					}
					System.out.print("\n");
					array = new int[7];
				}
			}
			array[i] = j;
			if (j == daysInMonth) {
				for (int k = 0; k < array.length && array[k] != 0; k++) {
					System.out.print(array[k] + " ");
				}
			}
			j++;
		}
	}

	public static void calendarLinkedList(int day, int daysInMonth) {
		System.out.println("\n\nCalendar printed with Linked List:\n");
		System.out.println("Su Mo Tu We Th Fr Sa");
		QueueLinkedList<Integer> queue = new QueueLinkedList<Integer>();
		int j = 1;
		for (int i = 0; i < day; i++) {
			queue.push(0);
		}
		for (int i = day; j <= daysInMonth; i++) {
			if (i >= 7) {
				i = i % 7;
				if (i == 0) {
					while (!queue.isEmpty()) {
						int data = queue.pop();
						if (data < 10 && data > 0) {
							System.out.print(" " + data + " ");
						} else if (data == 0) {
							System.out.print("   ");
						} else {
							System.out.print(data + " ");
						}
					}
					System.out.print("\n");
				}
			}
			if (j == daysInMonth) {
				queue.push(j);
				while (!queue.isEmpty()) {
					System.out.print(queue.pop() + " ");
				}
			}
			queue.push(j);
			j++;
		}
	}

	public static StackLinkedList<Integer> transfer(StackLinkedList<Integer> stack) {
		StackLinkedList<Integer> temp = new StackLinkedList<>();
		// Put content of stack in temp
		while (!stack.isEmpty()) {
			temp.push(stack.pop());
		}
		return temp;
	}

	public static void calendarStacks(int day, int daysInMonth) {
		System.out.println("\n\nCalendar printed stack:\n");
		System.out.println("Su Mo Tu We Th Fr Sa");
		StackLinkedList<Integer> stack = new StackLinkedList<>();
		int j = 1;
		for (int i = 0; i < day; i++) {
			stack.push(0);
		}
		for (int i = day; j <= daysInMonth; i++) {
			if (i >= 7) {
				i = i % 7;
				if (i == 0) {
					stack = transfer(stack);
					while (!stack.isEmpty()) {
						int data = stack.pop();
						if (data > 0 && data < 10) {
							System.out.print(" " + data + " ");
						} else if (data == 0) {
							System.out.print("   ");
						} else {
							System.out.print(data + " ");
						}
					}
					System.out.print("\n");
				}
			}
			if (j == daysInMonth) {
				stack.push(j);
				stack = transfer(stack);
				while (!stack.isEmpty()) {
					System.out.print(stack.pop() + " ");
				}
			}
			stack.push(j);
			j++;
		}
	}

	public static void main(String[] args) {
		int month = Integer.parseInt(args[0]);
		int year = Integer.parseInt(args[1]);
		int day = dayOfWeek(month, 1, year);
		int daysInMonth = daysInMonth(month);
		calendar(day, daysInMonth);
		calendarLinkedList(day, daysInMonth);
		calendarStacks(day, daysInMonth);
	}
}
