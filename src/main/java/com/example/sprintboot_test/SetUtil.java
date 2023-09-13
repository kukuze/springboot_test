package com.example.sprintboot_test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

public class SetUtil {
    public static void main(String[] args) {
//        HashMap<String, Object> hashMap = new HashMap<>() {{
//            put("name", "yjz");
//            put("age", 11);
//        }};
//        User user = new User();
//        set(hashMap,user);
//        System.out.println(user);
    }
    public static String upperCase(String str) {
        char[] ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }
        return new String(ch);
    }
    public static <T> T cast(Object o, Class<T> type) {
        if (type.isInstance(o)) return type.cast(o);
        throw new RuntimeException("can not cast " + o.getClass() + " to '" + type);
    }
    public static <T>void set(HashMap <String,Object>map, T bean){
        Class<?> clazz = bean.getClass();
        map.forEach((k,v)->{
            try {
                Field field = clazz.getDeclaredField(k);
                String methodName="set"+upperCase(k);
                Method method = clazz.getDeclaredMethod(methodName, field.getType());
                method.invoke(bean,cast(v,field.getType()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
