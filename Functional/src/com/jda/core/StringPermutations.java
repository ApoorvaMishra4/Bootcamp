package com.jda.core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.jda.utility.FunctionalUtility;


public class StringPermutations 
{
	static Set<String> recursiveString = new HashSet<>();

	public static String swap(String str, int strtPos, int endPos) 
	{
		char[] ch = str.toCharArray();
		char tmp = ch[strtPos];
		ch[strtPos] = ch[endPos];
		ch[endPos] = tmp;
		return String.valueOf(ch);
	}

	public static void recursivePermutation(String tmpString, int strt, int len) {
		if (strt == len) {
			recursiveString.add(tmpString);
			return;
		}
		for (int i = strt; i < len; i++) {
			tmpString = swap(tmpString, i, strt);
			recursivePermutation(tmpString, strt + 1, len);
			tmpString = swap(tmpString, i, strt);
		}
	}

	public static Set<String> recursive(String tmpString, int strt, int len) {
		recursivePermutation(tmpString, strt, len);
		return recursiveString;
	}

	public static void main(String[] args) 
	{
		System.out.println("Enter the String ");
		String originalString = FunctionalUtility.getString();
	//	int len = originalString.length(), totPermutation = 1;
		int len = originalString.length();
		recursive(originalString, 0, len);
		/*for (int i = 2; i <= len; i++)
			totPermutation *= i;
		System.out.println("Permutation string of " + originalString + " is " + totPermutation);*/
			System.out.println(recursiveString);
			System.out.println("Permutation string of " + originalString + " is " + recursiveString.size());

	}
}