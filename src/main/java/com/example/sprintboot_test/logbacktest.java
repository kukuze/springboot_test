package com.example.sprintboot_test;

import com.example.sprintboot_test.mybatis.LambdaQueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class logbacktest {
    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>();
//        Collections.addAll(list,1,2,3,4,5,5,5,5,3,3,21);
//        boolean b = list.stream().distinct().noneMatch(x -> x == 100);
////        System.out.println(b);
//        User user=null;
//       // User user=new User("2","3");
//        //user=Optional.ofNullable(user).orElseGet(()->new User("1", "2"));
////        user = Optional.ofNullable(user).orElse(new User("1", "2"));
//        user=Optional.of(user).orElse(new User("1","2"));
//        System.out.println(user);

//        System.out.println(User.s);
//        System.out.println(User.s);
//        System.out.println(User.s);
//        User user = new User();
//        user.fanxing(new ArrayList<Integer>(){{
//            add(1);
//            add(2);
//            add(3);
//        }});
//        user.fanxing(new ArrayList<String>(){{
//            add("a");
//            add("b");
//            add("c");
//        }});
//        ArrayList list = new ArrayList<>();
//        list.add(1);
//
//        user.fanxing(list);
//        ArrayList<String>[]a=new ArrayList[5];
//        for (int i = 0; i < a.length; i++) {
//            a[i]=new ArrayList<>();
//        }
//        System.out.println(a[0].size());
//        test();
        Logger logger = LoggerFactory.getLogger("com");
        Logger logger1 = LoggerFactory.getLogger("com1");
        logger1.trace("heelo");
        logger1.debug("heelo");
        logger1.info("heelo");
        logger1.warn("heelo");
        logger1.error("heelo");

    }
    public static void test(){
        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(true,User::getName,"hello");
    }

}