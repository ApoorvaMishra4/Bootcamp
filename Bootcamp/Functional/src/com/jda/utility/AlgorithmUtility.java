package com.jda.utility;

import java.util.Scanner;

public class AlgorithmUtility {
	static Scanner input = new Scanner(System.in);

	public static String getString() {
		String inputString = input.nextLine();
		return inputString;
	}

	public static int getInt() {
		return input.nextInt();
	}

	public static void dayOfWeek(int m, int d, int y) {
		int y1 = y - (14 - m) / 12;
		int x = y1 + y1 / 4 - y1 / 100 + y1 / 400;
		int m1 = m + 12 * ((14 - m) / 12) - 2;
		int d1 = (d + x + 31 * m1 / 12) % 7;
		String day = "";
		switch (d1) {
		case 0: {
			day = "Sunday";
		}
			break;
		case 1: {
			day = "Monday";
		}
			break;
		case 2: {
			day = "Tuesday";
		}
			break;
		case 3: {
			day = "Wednesday";
		}
			break;
		case 4: {
			day = "Thursday";
		}
			break;
		case 5: {
			day = "Friday";
		}
			break;
		case 6: {
			day = "Saturday";
		}
		}
		System.out.println("The day on this date was " + day);
	}

	public static int binarySearchInteger(int[] array, int key) {
		array = bubbleSortInteger(array);
		int l = 0;
		int r = array.length - 1;
		int m;
		while (l < r) {
			m = (l + r) / 2;
			if (array[m] == key) {
				return m;
			} else if (array[m] > key) {
				r = m;
			} else if (array[m] < key) {
				l = m;
			}
		}
		return -1;
	}

	public static int binarySearchString(String[] array, String key) {
		array = bubbleSortString(array);
		int l = 0;
		int r = array.length - 1;
		int m;
		while (l < r) {
			m = (l + r) / 2;
			if (array[m].compareTo(key) == 0) {
				return m;
			} else if (array[m].compareTo(key) > 0) {
				r = m;
			} else if (array[m].compareTo(key) < 0) {
				l = m;
			}
		}
		return -1;
	}

	public static double temperatureConversion(char unit, double temperature) {
		double converted = 0;
		if (unit == 'f') {
			converted = (temperature - 32) * 5 / 9;
		} else if (unit == 'c') {
			converted = (temperature * 9 / 5) + 32;
		}
		return converted;
	}

	public static int[] insertionSortInteger(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int j = i - 1;
			int key = array[i];
			while (j >= 0 && array[j] > key) {
				array[j + 1] = array[j];
				j = j - 1;
			}
			array[j + 1] = key;
		}
		return array;
	}

	public static String[] insertionSortString(String[] array) {
		for (int i = 1; i < array.length; i++) {
			int j = i - 1;
			String key = array[i];
			while (j >= 0 && array[j].compareTo(key) > 0) {
				array[j + 1] = array[j];
				j = j - 1;
			}
			array[j + 1] = key;
		}
		return array;
	}

	public static int[] bubbleSortInteger(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		return array;
	}

	public static String[] bubbleSortString(String[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j].compareTo(array[j + 1]) > 0) {
					String temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		return array;
	}

	public static double monthlyPayment(double principle, double rate, double year) {
		System.out.println(principle + " " + rate + " " + year);
		double r = rate / (12 * 100);
		double n = 12 * year;
		double payment = (principle * r) / (1 - Math.pow(1 + r, -n));
		return payment;
	}

	public static void printArrayString(String[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
	}

	public static void printArrayInt(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
	}

	public static void main(String args[]) {
		double principle = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		double year = Double.parseDouble(args[2]);
		// monthlyPayment(principle, rate, year);
		int s = 0;
		while (s != -1) {
			System.out.println("Enter 1 for string, 2 for integer, -1 to exit:");
			s = AlgorithmUtility.getInt();
			if (s == -1) {
				break;
			}
			System.out.println("Enter 1 for binary search, 2 for insertion sort, 3 for bubble sort:");
			int t = AlgorithmUtility.getInt();
			long start1, end1, diff1;
			long start2, end2, diff2;
			long start3, end3, diff3;
			if (s == 1) {
				System.out.println("Enter size of array:");
				int n = AlgorithmUtility.getInt();
				String[] array = new String[n];
				System.out.print("Enter array elements:");
				for (int i = 0; i < n; i++) {
					array[i] = AlgorithmUtility.getString();
				}
				switch (t) {
				case 1: {
					System.out.println("Enter String to be searched:");
					String key = AlgorithmUtility.getString();
					start1 = System.currentTimeMillis();
					System.out.println(binarySearchString(array, key));
					end1 = System.currentTimeMillis();
					diff1 = end1 - start1;
				}
					break;
				case 2: {
					start2 = System.currentTimeMillis();
					array = insertionSortString(array);
					end2 = System.currentTimeMillis();
					diff2 = end2 - start2;
					printArrayString(array);
				}
					break;
				case 3: {
					start3 = System.currentTimeMillis();
					array = bubbleSortString(array);
					end3 = System.currentTimeMillis();
					diff3 = end3 - start3;
					printArrayString(array);
				}
				}
			} else if (s == 2) {
				System.out.println("Enter size of array:");
				int n = AlgorithmUtility.getInt();
				System.out.println("Enter array elements:");
				int[] array = new int[n];
				for (int i = 0; i < n; i++) {
					array[i] = AlgorithmUtility.getInt();
				}
				switch (t) {
				case 1: {
					System.out.println("Enter Integer to be searched:");
					int key = AlgorithmUtility.getInt();
					System.out.println(binarySearchInteger(array, key));
				}
					break;
				case 2: {
					array = insertionSortInteger(array);
					printArrayInt(array);
				}
					break;
				case 3: {
					array = bubbleSortInteger(array);
					printArrayInt(array);
				}
				}
			}
		}
	}
}
