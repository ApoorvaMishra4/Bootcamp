package com.jda.core;
import java.util.*;

import com.jda.utility.*;

public class PrimeFactors {
	public static Boolean isPrime(int n)
	{
		for (int i=2; i<n; i++)
		{
			if (n%i==0)
			{
				return false;
			}
		}
		return true;
	}
	public static void main (String args[])
	{
		int n = FunctionalUtility.getInt();
		ArrayList<Integer> primeFactors = new ArrayList<Integer>();
		for (int i=1;i*i<=n; i++)
		{
			if (n%i==0 && isPrime(i)==true)
			{
				primeFactors.add(i);
			}
		}
		for (int i=0; i<primeFactors.size();i++)
		{
			System.out.println(primeFactors.get(i));
		}
	}
}
