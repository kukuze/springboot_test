package com.example.sprintboot_test.内部类;

public class Outer {
    String name = "外部类的类名";
    static String type = "外部类的type属性";
    private int item = 1;
 
    public static void show() {
        System.out.println("掉用外部类中的show方法");
    }
    public void print() {
        System.out.println("调用外部类中的打印方法");
    }
 
    //成员内部类 可以使用权限修饰符进行修饰
    public class Inner{
        //static double weight = 1.8;  //成员内部类中不能使用static修饰变量和方法
        String name = "内部类的类名";
 
        public void innerShow(){
            //成员内部类可以直接访问外部类的属性和方法
            show();
            print();
            System.out.println(type);
            System.out.println(item);
            System.out.println("我是：" + name);
            //进行特指访问时 使用类名.this.变量名进行访问
            System.out.println("我是：" + Outer.this.name);
 
        }
    }
 
    public static void main(String[] args) {
        //成员内部类对象的创建步骤
        //1.第一步需要实例化外部类对象
        //2.第二步正常实例化内部类对象 但是new关键字要改成 外部类对象名.new
           /*Outer outer = new Outer();
            Inner inner = outer.new Inner();*/
        //或者这样创建
        Outer.Inner inner = new Outer().new Inner();
        inner.innerShow();
    }
}