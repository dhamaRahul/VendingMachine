package com.vending.java8concepts;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class ConsumerInterface {
    public static void main(String[] args) {
       // simpleConsumerExample(6);
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // implementation of the Consumer's accept methods.
        Consumer<Integer> consumer = (Integer x) -> System.out.println(x);
        secondExample(list,consumer);

    }

    private static void secondExample(List<Integer> list, Consumer<Integer> consumer) {
        list.forEach(x->{
            consumer.accept(x*10);
        });
    }


    private static void simpleConsumerExample(Integer i) {
        Consumer<Integer> integerConsumer=x ->System.out.println(x+10);
        integerConsumer.accept(i);
    }

}
