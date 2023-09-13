package com.example.sprintboot_test;

/**
 * @author CharmingZe
 * @version 1.0
 * @data 2023/2/15 15:12
 */
public class mbfl {
    public static void main(String[] args) {
        System.out.println(mid(3, 3, 5) + ":3");
        System.out.println(mid(1, 2, 3) + ":2");
        System.out.println(mid(3, 2, 1) + ":2");
        System.out.println(mid(5, 5, 5) + ":5");
        System.out.println(mid(5, 3, 4) + ":4");
        System.out.println(mid(2, 1, 4) + ":2");
    }

    public static int mid(int x, int y, int z) {
        int m;
        m = z;
        if (y <=z-1) {
            if (x < y)
                m = y;
            else if (x < z)
                m = x;
        } else {
            if (x > y)
                m = y;
            else if (x > z)
                m = x;
        }
        return m;
    }
}
