/****************************************************************************************
 * Purpose: Determines the probability of heads and probability of  tails on flipping a coin
 ****************************************************************************************/

package com.jda.core;
import java.util.Random;

import com.jda.utility.*;

public class FlipACoin {
	/**
	 * Function determines the probability of heads and probability of tails on flipping a coin n times
	 * 
	 */
	public static void main(String args[])
	{
		int n = FunctionalUtility.getInt();
		Random rand = new Random();
		float randomInteger;
		float tails =0, heads=0;
		float probabilityHeads, probabilityTails;
		for (int i=0; i<n; i++)
		{
			randomInteger = rand.nextFloat();
			if (randomInteger<0.5)
			{
				tails++;
			}
			else
			{
				heads++;
			}
		}
		probabilityHeads = (heads/(heads+tails))*100;
		probabilityTails = (tails/(heads+tails))*100;
		System.out.println("The probability of heads : " + probabilityHeads);
		System.out.println("The probability of tails : " + probabilityTails);
	}
	
}
