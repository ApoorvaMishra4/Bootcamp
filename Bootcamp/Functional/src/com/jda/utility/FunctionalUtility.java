package com.jda.utility;

import java.util.Random;
import java.util.Scanner;

public class FunctionalUtility {
	static Scanner input = new Scanner(System.in);

	public static int getInt() {
		int n = input.nextInt();
		return n;
	}

	public static String getString() {
		String inputString = input.nextLine();
		return inputString;
	}

	public static float getFloat() {
		float n = input.nextFloat();
		return n;
	}

	public static double getDouble() {
		double n = input.nextDouble();
		return n;
	}

	public static int[][] get2DIntArray(int m, int n) {
		int[][] array = new int[m][n];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[j].length; j++) {
				array[i][j] = input.nextInt();
			}
		}
		return array;
	}

	public static double[][] get2DDoubleArray(int m, int n) {
		double[][] array = new double[m][n];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[j].length; j++) {
				array[i][j] = input.nextDouble();
			}
		}
		return array;
	}

	public static boolean[][] get2DBooleanArray(int m, int n) {
		boolean[][] array = new boolean[m][n];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[j].length; j++) {
				array[i][j] = input.nextBoolean();
			}
		}
		return array;
	}

	public static String[][] get2DStringArray(int m, int n) {
		String[][] array = new String[m][n];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = input.next();
			}
		}
		return array;
	}

	public static int[] get1DIntArray(int n) {
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = input.nextInt();
		}
		return array;
	}
	
	public static Random randomCreate ()
	{
		Random rand = new Random();
		return rand;
	}
}
