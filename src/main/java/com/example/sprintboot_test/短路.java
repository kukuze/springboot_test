package com.example.sprintboot_test;

/**
 * @author CharmingZe
 * @version 1.0
 * @data 2023/2/25 0:06
 */
public class 短路 {
    static int a=1;
    public static void main(String[] args) {
        boolean a=false,b=false,c = false,d=false,e=false;
        boolean b1 = a || b || c || d;
    }
    public static boolean doSomeThing(){
        System.out.println("短路运算");
        a=3;
        return true;
    }
}
