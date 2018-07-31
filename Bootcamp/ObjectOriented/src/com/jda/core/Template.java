package com.jda.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jda.utility.Utility;

public class Template {

	private static String fullName;
	private static String phoneNumber;
	private static String data;
	private static Pattern p;
	private static Matcher m;

	private static String getTemplateData() throws IOException {
		return new String(Files.readAllBytes(Paths.get("C:\\Databases\\BootcampFiles\\template.txt")));
	}

	public static void getData() {
		System.out.println("Enter the full name:");
		fullName = Utility.getString();
		System.out.println("Enter your phone number:");
		phoneNumber = Utility.getString();
	}

	public static void replaceName() {
		p = Pattern.compile("<<\\w+>>");
		m = p.matcher(data);
		if (m.find()) {
			data = m.replaceAll(fullName.split(" ")[0]);
		}
	}

	public static void replaceFullName() {
		p = Pattern.compile("<<\\w+\\s\\w+>>");
		m = p.matcher(data);
		if (m.find()) {
			data = m.replaceAll(fullName);
		}
	}

	public static void replaceDate() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		p = Pattern.compile("[0-9]{2}/[0-9]{2}/[0-9]{4}");
		m = p.matcher(data);
		if (m.find()) {
			data = m.replaceAll(dtf.format(now));
		}
	}

	public static void replacePhoneNumber() {
		p = Pattern.compile("x{10}");
		m = p.matcher(data);
		if (m.find()) {
			data = m.replaceAll(phoneNumber);
		}
		System.out.println(data);
	}

	public static void main(String[] args) throws IOException {
		data = getTemplateData();
		getData();
		replaceName();
		replaceFullName();
		replaceDate();
		replacePhoneNumber();
	}
}
