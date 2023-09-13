package com.example.sprintboot_test.内部类;

public class Partial {
    String name = "外部类的类名";
    String type = "外部类的type属性";
    private int item = 1;
 
    public static void show() {
        System.out.println("掉用外部类中的show方法");
    }
    public void print() {
        System.out.println("调用外部类中的打印方法");
    }
 
    public void demo(){
        String name = "外部类方法deme()内部的方法名";
        String type = "外部类方法deme()内部的type属性";
        /*编写在方法的内部的类称之为局部内部类
        局部内部类不可使用权限修饰符 静态修饰符进行修饰 同局部变量相同
        局部内部类与局部变量使用范围一样 在此方法内部
        局部内部类可以直接访问方法中的属性 重名时使用参数传递完成访问*/
        class Inner{
            //局部内部类 可以访问方法外部类中属性和方法
            String name = "局部类的类名";
            public void showInner(String name){
//                show();
//                print();
//                System.out.println("我是："+ type);
//                System.out.println("我是："+ Partial.this.type);
//                System.out.println(item);
//                System.out.println("我是：" + this.name);
//                System.out.println("我是：" + name);
//                System.out.println("我是：" + Partial.this.name);
            }
        }
        //局部内部类 创建对象 要在方法内部 局部内部类的外部声明
        Inner inner = new Inner();
        inner.showInner(name);
    }
 
    public static void main(String[] args) {
        Partial partial = new Partial();
        partial.demo();
    }
}