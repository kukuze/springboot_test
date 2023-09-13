package com.example.sprintboot_test.DesignPattern;

public class SingleCaseLazySafeEfficient {
    public static void main(String[] args) {
        Person person = Person.getPerson();
//        System.out.println();
//        System.out.println(Person.getPerson().hashCode());
//        System.out.println(Person.getPerson().hashCode());
//        try {
//            System.out.println(getPerson(Person.class).hashCode());
//        } catch (Exception e) {
//            System.out.println("hello");
//        }
        person.name="hello";
        person.friend=new Friend();
        person.friend.name="xiaohong";
        System.out.println(person.toString());
        Person clone = (Person)person.clone();
        clone.friend.name="xiaoming";
        clone.name="world";
        System.out.println(clone.toString());


    }

    public static Person getPerson(Class<Person> clazz) throws InstantiationException, IllegalAccessException {
        return clazz.newInstance();
    }
}
class Friend implements Cloneable{
    String name;
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Friend{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Person implements Cloneable {
    private Person() {
    }

    String name;
    private static volatile Person person;
    Friend friend;
    public static Person getPerson() {
        if (person == null) {
            synchronized (Person.class) {
                if (person == null)
                    person = new Person();
            }


        }
        return person;
    }

    @Override
    protected Object clone() {
        try {
            Person person=(Person) super.clone();
            person.friend=(Friend) friend.clone();
            return person;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", friend=" + friend +
                '}';
    }
}
