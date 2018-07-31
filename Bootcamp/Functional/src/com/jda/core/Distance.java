/*************************************************************************************************
 * Purpose : Determines the distance between between a point (x,y) to origin
 **************************************************************************************************/
package com.jda.core;

public class Distance {
	/**
	 * Function to calculate and print the distance between a point and origin
	 * 
	 * @param args - x and y coordinates
	 */
	public static void main(String args[]) {
		double x= Double.parseDouble(args[0]);
		double y = Double.parseDouble(args[1]);
		double distance;
		x = Math.pow(x, 2);
		y = Math.pow(y, 2);
		distance = x + y;
		distance = Math.sqrt(distance);
		System.out.println("The distance is : " + distance);
	}
}
