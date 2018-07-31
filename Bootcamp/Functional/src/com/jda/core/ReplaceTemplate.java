package com.jda.core;

import com.jda.utility.FunctionalUtility;

public class ReplaceTemplate {
	public static void main(String args[]) {
		String inputString = FunctionalUtility.getString();
		String sentence = "Hello <<Username>>, How are you?";
		sentence = sentence.replaceFirst("\\<<(.*?)\\>>", inputString);
		System.out.println(sentence);
	}
}
