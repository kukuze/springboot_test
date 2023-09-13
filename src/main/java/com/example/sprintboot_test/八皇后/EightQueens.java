package com.example.sprintboot_test.八皇后;

public class EightQueens {
    public static int ans = 0;

    public static void main(String[] args) {
        long startTime = System.nanoTime();  // 记录开始时间

        int[] queens = new int[8];
        solveQueens(queens, 0);
        System.out.println(ans);

        long endTime = System.nanoTime();  // 记录结束时间

        long timeElapsed = endTime - startTime;  // 计算消耗时间

        System.out.println("程序执行消耗时间：" + timeElapsed + " 纳秒");


    }

    public static void solveQueens(int[] queens, int row) {
        if (row == queens.length) {
            // all queens are placed, print the result
//            printQueens(queens);
            ans++;
        } else {
            for (int i = 0; i < queens.length; i++) {
                queens[row] = i;
                if (isValid(queens, row)) {
                    solveQueens(queens, row + 1);
                }
            }
        }
    }

    public static boolean isValid(int[] queens, int row) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == queens[row] || Math.abs(queens[i] - queens[row]) == row - i) {
                return false;
            }
        }
        return true;
    }

    public static void printQueens(int[] queens) {
        for (int i = 0; i < queens.length; i++) {
            for (int j = 0; j < queens.length; j++) {
                if (queens[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
