/***********************************************************************************************************
 * 
 * Purpose : Determines the number of times random function is called to generate given number of distinct coupon numbers 
 * 
 * @author Apoorva Mishra
 *
 *************************************************************************************************************/

package com.jda.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.jda.utility.FunctionalUtility;

public class CouponNumbers 
{
	/**
	 * Function to print the number of times random function was called to get a given number of distinct coupon numbers
	 */
	public static void main(String args[]) 
	{
		System.out.println("Enter the number of coupons to be generated :");
		int n = FunctionalUtility.getInt();
		int couponGenerated;
		int count = 0;
		Random rand = FunctionalUtility.randomCreate();
		
		List<Integer> coupons = new ArrayList<>();
		while (coupons.size() < n) {
			Boolean match = false;
			couponGenerated = rand.nextInt(n);
			count++;
			for (int coupon : coupons) {
				if (couponGenerated == coupon) {
					match = true;
					break;
				}
			}
			if (match == false) {
				coupons.add(couponGenerated);
			}
		}
		System.out.println("The coupons are: \n  "+ coupons);
		System.out.println("The number of times tried :" + count);
	}
}
