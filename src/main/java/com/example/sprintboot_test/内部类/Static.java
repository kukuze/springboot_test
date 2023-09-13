package com.example.sprintboot_test.内部类;

public class Static {
    public static class Current{
        int x;
        int y;
        int step;
        @Override
        public String toString() {
            return "Current{" +
                    "x=" + x +
                    ", y=" + y +
                    ", step=" + step +
                    '}';
        }
    }
    public static void main(String[] args) {
        //静态内部类可以直接实例化 不需要依附于外部类
        Current cur = new Current();
        Current cur1 = new Current();
        cur.x=1;
        cur.y=0;
        cur.step=0;
        System.out.println(cur);
        System.out.println(cur1);
    }
}