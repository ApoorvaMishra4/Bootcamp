package com.jda.core.Algorithm;

import com.jda.utility.AlgorithmUtility;

public class FindYourNumber {
	
	public static void findNumber(int l, int r)
	{
		int m = (l+r)/2;
		System.out.println("Is your number "+m+"? (Y/N)");
		String ans;
		ans = AlgorithmUtility.getString();
		if (ans.equals("Y")|| ans.equals("y") || ans.equals("yes") || ans.equals("Yes"))
		{
			System.out.println("Your number is "+m);
		}
		else if (ans.equals("N")|| ans.equals("n") || ans.equals("no") || ans.equals("No"))
		{
			System.out.println("Is your number between "+l+" and "+m+"?");
			ans = AlgorithmUtility.getString();
			if (ans.equals("Y")|| ans.equals("y") || ans.equals("yes") || ans.equals("Yes"))
			{
				findNumber(l, m);
			}
			else if (ans.equals("N")|| ans.equals("n") || ans.equals("no") || ans.equals("No"))
			{
				findNumber(m, r);
			}
		}
	}
	
	public static void main(String args[])
	{
		findNumber(0, Integer.parseInt(args[0])-1);
	}
}
