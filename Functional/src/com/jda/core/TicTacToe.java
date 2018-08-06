package com.jda.core;

import java.util.Random;
import com.jda.utility.FunctionalUtility;

public class TicTacToe {

    public static int[][] array = new int[3][3];

    public static boolean diagonal1Complete() {
        if (array[0][0] == 1 && array[1][1] == 1 && array[2][2] == 1) {
            return true;
        }
        if (array[0][0] == -1 && array[1][1] == -1 && array[2][2] == -1) {
            return true;
        }
        return false;
    }

    public static boolean diagonal2Complete() {
        if (array[0][2] == 1 && array[1][1] == 1 && array[2][0] == 1) {
            return true;
        }
        if (array[0][2] == -1 && array[1][1] == -1 && array[2][0] == -1) {
            return true;
        }
        return false;
    }

    public static boolean rowComplete() {
        for (int i = 0; i < 3; i++) {
            if (array[i][0] == 1 && array[i][1] == 1 && array[i][2] == 1) {
                return true;
            }
            if (array[i][0] == -1 && array[i][1] == -1 && array[i][2] == -1) {
                return true;
            }
        }
        return false;
    }

    public static boolean columnComplete() {
        for (int j = 0; j < 3; j++) {
            if (array[0][j] == 1 && array[1][j] == 1 && array[2][j] == 1) {
                return true;
            }
            if (array[0][j] == -1 && array[1][j] == -1 && array[2][j] == -1) {
                return true;
            }
        }
        return false;
    }

    public static boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (array[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void printMatrix() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(array[i][j]);
                System.out.print("  ");
            }
            System.out.println("\n");
        }
    }

    public static void main(String args[]) {
        int n, m;
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                array[i][j] = 0;
//            }
//        }
        printMatrix();
        boolean player = false;
        while (diagonal1Complete() == false && diagonal2Complete() == false
                && rowComplete() == false && columnComplete() == false
                && isFull() == false) {
            System.out.println("Enter the row:");
            n = FunctionalUtility.getInt();
            System.out.println("Enter the column:");
            m = FunctionalUtility.getInt();
            while (array[n][m] == -1 || array[n][m] == 1) {
                System.out.println("Enter again as the place is taken!");
                System.out.println("Enter the row:");
                n = FunctionalUtility.getInt();
                System.out.println("Enter the column:");
                m = FunctionalUtility.getInt();
            }
            array[n][m] = -1;
            player = true;
            printMatrix();
            if (diagonal1Complete() == true || diagonal2Complete() == true
                    || rowComplete() == true || columnComplete() == true
                    || isFull() == true) {
                break;
            }
            Random rand = new Random();
            int nRand = rand.nextInt(3);
            int mRand = rand.nextInt(3);
            while (array[nRand][mRand] == -1 || array[nRand][mRand] == 1) {
                rand = new Random();
                nRand = rand.nextInt(3);
                mRand = rand.nextInt(3);
            }
            array[nRand][mRand] = 1;
            System.out
                .println("The computer has made his move. The matrix now is:");
            player = false;
            printMatrix();
        }

        if (diagonal1Complete() == true || diagonal2Complete() == true
                || rowComplete() == true || columnComplete() == true) {
            if (player == true) {
                System.out.println("The player has won.");
            }
            else if (player == false) {
                System.out.println("The computer has won.");
            }
        }

        else if (isFull() == true) {
            System.out.println("The game is a draw.");
        }

    }

}
