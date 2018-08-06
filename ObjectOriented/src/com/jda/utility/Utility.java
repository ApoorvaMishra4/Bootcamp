package com.jda.utility;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utility {
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
	
	public static long getLong() {
            long n = input.nextLong();
            return n;
    }
	
	  public static List<String> allFilesInFolder(String path) {
	        File folder = new File(path);
	        File[] allFiles = folder.listFiles(new FilenameFilter() {
	            @Override
	            public boolean accept(File dir, String name) {
	                return name.toLowerCase().endsWith(".json");
	            }
	        });
	        List<String> Files = new ArrayList<>();
	        for (int i = 0; i < allFiles.length; i++) {
	            Files.add(allFiles[i].getName());
	        }
	        return Files;
	    }
}
