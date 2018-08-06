
/*********************************************************************************
 * Purpose : Finds prime numbers in the range 0-1000
 * @author Apoorva Mishra
 *********************************************************************************/

package com.jda.core;

import java.util.Arrays;

/**
 * PRIME_OR_NOT - boolean array which stores which numbers are prime
 * initialiseArray() markPrimes() printPrimes() main()
 */
public class PrimeNumbers {
    static boolean[] PRIME_OR_NOT = new boolean[1001];

    /**
     * Function to initialise boolean array PRIME_OR_NOT with value equal to
     * false
     */
    public static void initialiseArray() {
        for (int i = 1; i <= 1000; i++) {
            PRIME_OR_NOT[i] = false;
        }
    }

    /**
     * Function to mark the numbers which are prime with the value true
     */
    public static void markPrimes() {
        for (int i = 2; i <= 500; i++) {
            for (int j = 2; i * j <= 1000; j++) {
                PRIME_OR_NOT[i * j] = true;
            }
        }
    }

    /**
     * Function to print the prime numbers
     */
    public static void printPrimes() {
        for (int i = 1; i <= 1000; i++) {
            if (PRIME_OR_NOT[i] == false) {
                System.out.print(i + " ");
            }
        }
    }

    /**
     * Function to print the prime numbers which are anagrams of each other
     */
    public static void anagrams() {
        for (int i = 10; i <= 1000; i++) {
            if (PRIME_OR_NOT[i] == false) {
                int aLen = Integer.toString(i).length();
                char[] a = Integer.toString(i).toCharArray();
                for (int j = i + 1; j <= 1000; j++) {
                    if (PRIME_OR_NOT[j] == false
                            && Integer.toString(j).length() == aLen) {
                        StringBuilder temp = new StringBuilder();
                        temp.append(Integer.toString(j));
                        char[] b = temp.toString().toCharArray();
                        Arrays.sort(b);
                        if (Arrays.equals(a, b)) {
                            System.out.print(i + " and " + j + "\n");
                        }
                    }
                }
            }
        }
    }

    /**
     * Function to print the prime numbers which are palindromes
     */
    public static void palindrome() {
        for (int i = 100; i <= 1000; i++) {
            if (PRIME_OR_NOT[i] == false) {
                StringBuilder temp = new StringBuilder();
                temp.append(Integer.toString(i));
                String number = temp.toString();
                String reverse = temp.reverse().toString();
                if (reverse.equals(number)) {
                    System.out.println(i);
                }
            }
        }
    }

    public static void main(String args[]) {
        initialiseArray();
        markPrimes();
        printPrimes();
        System.out.println("\nAnagrams are:");
        anagrams();
        System.out.println("\nPalindromes are:");
        palindrome();
    }

}
