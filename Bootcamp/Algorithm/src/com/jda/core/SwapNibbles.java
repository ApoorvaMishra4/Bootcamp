package com.jda.core;

import com.jda.utility.AlgorithmUtility;

public class SwapNibbles {
	static String binary = "";

	public static void toBinary(int n) {
		if (n == 0) {
			StringBuilder binaryReversed = new StringBuilder();
			binaryReversed.append(binary);
			binaryReversed.reverse();
			binary = binaryReversed.toString();
			System.out.println("The number in binary is " + binary);
			return;
		}
		int rem = n % 2;
		n = n / 2;
		binary += Integer.toString(rem);
		toBinary(n);
	}

	public static int swapNibbles(int n) {
		String converted = Integer.toBinaryString(n);
		String first = converted.substring(0, 3);
		String second = converted.substring(4, 7);
		converted = second + first;
		int decimal = Integer.parseInt(converted, 2);
		return decimal;
	}

	public static boolean isPowerOfTwo(int n) {
		while (n != 0) {
			if (n % 2 == 0) {
				n = n / 2;
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		binary = "";
		System.out.println("Enter the number:");
		int number = AlgorithmUtility.getInt();
		toBinary(number);
		System.out.println("Number after swapping nibbles :" + swapNibbles(number));
		System.out.println("Number is a power of 2 :" + isPowerOfTwo(number));
	}
}
