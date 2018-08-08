package com.jda.core.Algorithm;

import java.util.ArrayList;
import java.util.List;

import com.jda.utility.AlgorithmUtility;

public class VendingMachine {
	public static void change(List<Integer> changeOrder, int count, int cashRequired) {
		if (cashRequired == 0) {
			System.out.println(changeOrder);
			System.out.println(count);
			return;
		}
		int[] cashUnits = { 1000, 500, 100, 50, 10, 5, 2, 1 };
		for (int i = 0; i < cashUnits.length; i++) {
			if (cashRequired >= cashUnits[i]) {
				cashRequired -= cashUnits[i];
				changeOrder.add(cashUnits[i]);
				count++;
				break;
			}
		}
		change(changeOrder, count, cashRequired);
	}

	public static void main(String[] args) {
		System.out.println("Enter the cash required:");
		int n = AlgorithmUtility.getInt();
		List<Integer> changeOrder = new ArrayList<>();
		change(changeOrder, 0, n);
	}
}
