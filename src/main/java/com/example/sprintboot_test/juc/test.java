package com.example.sprintboot_test.juc;



import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author CharmingZe
 * @version 1.0
 * @data 2023/2/20 17:57
 */
public class test {
    public static void main(String[] args) {
        demo(()->new int[10],
                array->array.length);
    }
    public static <T>void demo(
            Supplier<T> arraySupplier,
            Function <T,Integer> a){
        System.out.println(a.apply(arraySupplier.get()));
    }
}
