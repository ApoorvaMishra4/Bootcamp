package com.jda.core;

import com.jda.utility.FunctionalUtility;

public class Quadratic {
	public static void main(String args[])
	{
		System.out.println("Enter the value of a:");
		int a = FunctionalUtility.getInt();
		System.out.println("Enter the value of b:");
		int b = FunctionalUtility.getInt();
		System.out.println("Enter the value of c:");
		int c = FunctionalUtility.getInt();
		double delta = Math.pow(b, 2) - 4*a*c;
		if (delta>=0)
		{
			double root1 = (-b + Math.sqrt(delta))/2*a;
			double root2 = (-b - Math.sqrt(delta))/2*a;
			System.out.println("The roots of the equation are :" + root1 + " and " + root2);
			return;
		}
		System.out.println("No roots of equations are present");
	}
}
