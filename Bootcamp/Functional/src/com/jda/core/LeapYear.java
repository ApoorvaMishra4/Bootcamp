package com.jda.core;
import com.jda.utility.*;

public class LeapYear {
	public static void main(String args[])
	{
		int year = FunctionalUtility.getInt();
		while (year<1000 || year>9999)
		{
			System.out.println("Error! The integer is not a 4-digit number.");
			year = FunctionalUtility.getInt();
		}
		if ((year%4==0 && year%100!=0)||year%400==0)
		{
			System.out.println(year + " is a leap year");
		}
		else
		{
			System.out.println(year + " is not a leap year");
		}
	}
}
