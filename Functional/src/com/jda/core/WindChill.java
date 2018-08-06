package com.jda.core;

public class WindChill {
	public static void main(String args[])
	{
		double temp = Double.parseDouble(args[0]);
		double speed = Double.parseDouble(args[1]);
		double w = 35.74 + 0.6215*temp + (0.4275*temp - 35.75)*Math.pow(speed, 0.16);
		System.out.println("The wind speed is : "+w);
	}
}
 