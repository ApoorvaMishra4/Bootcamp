package com.jda.core;

import java.io.PrintWriter;

import com.jda.utility.FunctionalUtility;

public class TwoDArray {
	public static void main(String args[])
	{
		int m, n;
		System.out.println("Enter the number of rows:");
		m = FunctionalUtility.getInt();
		System.out.println("Enter the number of columns:");
		n = FunctionalUtility.getInt();
		String[][] array = FunctionalUtility.get2DStringArray(m, n);
		PrintWriter pw = new PrintWriter(System.out);
		for (int i=0; i<array.length; i++)
		{
			for (int j=0; j<array[i].length; j++)
			{
				pw.append(array[i][j]);
				pw.append("\n");
			}
		}
		pw.flush();
	}
}
