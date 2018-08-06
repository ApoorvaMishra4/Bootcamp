package com.jda.core;
import java.util.Random;

import com.jda.utility.*;

public class Gambler {
	public static void main(String args[])
	{
		System.out.println("Enter the number of times he/she wants to play :");
		int n = FunctionalUtility.getInt();
		System.out.println("Enter the goal:");
		int goal = FunctionalUtility.getInt();
		Float randomInteger;
		System.out.println("Enter the base money:");
		int base = FunctionalUtility.getInt();
		int base2 = base;
		int fair;
		int win =0;
		int loss =0;
		for (int i=0; i<n; i++)
		{
			int tries=0;
			base2=base;
			while (base2>=0 && base2<goal)
			{
				tries++;
				Random r = new Random();
				randomInteger = r.nextFloat();
				if (randomInteger<0.5)
				{
					fair=-1;
				}
				else
				{
					fair=1;
				}
				base2 = base2+fair;
			}
			System.out.println("Tries:" + tries);
			if (base2>=goal)
			{
				win++;
			}
			else if (base2<=0)
			{
				loss++;
			}
		}
		System.out.println("Win : "+win);
		System.out.println("loss : " + loss);
	}
}
