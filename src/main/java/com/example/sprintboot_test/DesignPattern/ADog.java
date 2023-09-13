package com.example.sprintboot_test.DesignPattern;

public  class ADog implements Dog{
    String name;
    @Override
    public void say(){
        class Attach{
            public void say(){
                System.out.println("Attach");
            }
        }
        Attach attach = new Attach();
        attach.say();
    }
    public void this1(){
        System.out.println(this);
        System.out.println(this.name);
        this.hello();
    }
    @Override
    public void eat(){
        hello();
    }
    public static void hello(){
        System.out.println("hello");
    }
}

