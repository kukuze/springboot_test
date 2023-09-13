package com.example.sprintboot_test.咸鱼该题;

import java.util.HashSet;
import java.util.Scanner;

public class AmazingSequence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int[] arr;
        boolean isAmazing = true;

        // Read input
        try {
            n = Integer.parseInt(sc.nextLine());
            if (n <= 0) {
                System.out.println("Error in input");
                return;
            }
            arr = new int[n];
            String[] inputArr = sc.nextLine().split(" ");
            if (inputArr.length != n) {
                System.out.println("lnvalid input");
                return;
            }
            if(arr[0]!=0) {
                isAmazing = false;
            }
            for (int i = 0; i < n; i++) {
                if(inputArr[i].contains(".")||inputArr[i].startsWith("-")) {
                    System.out.println("Invalid input");
                    return;
                }
                arr[i] = Integer.parseInt(inputArr[i]);
            }
        } catch (Exception e) {
            System.out.println("Error in input");
            return;
        }
        for (int i = 1; i < n; i++) {
            if (arr[i] <= arr[i - 1]) {
                isAmazing = false;
                break;
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                set.add(arr[j] - arr[i]);
            }
        }
        if (set.size() != (n * (n - 1) / 2))
            isAmazing = false;

        // Print result
        if (isAmazing) {
            System.out.println("It is an Amazing Sequence");
        } else {
            System.out.println("It is an ordinary sequence");
        }
    }
}