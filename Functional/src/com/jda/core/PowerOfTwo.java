package com.jda.core;
import com.jda.utility.*;

public class PowerOfTwo {
	public static void main(String args[])
	{
		int n = FunctionalUtility.getInt();
		int value = 1;
		for (int i=0; i<=n; i++)
		{
			System.out.println(value);
			value = value *2;
		}
	}
}
