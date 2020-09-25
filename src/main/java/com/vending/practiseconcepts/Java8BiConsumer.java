package com.vending.practiseconcepts;

import io.vavr.collection.List;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class Java8BiConsumer {
    public static void main(String[] args) {
        BiConsumer<String,String> biConsumer=Java8BiConsumer::concatAndPrint;
        biConsumer.accept("first","second");

        List<String> list= List.of("one","|","two");
        StringBuilder sb=visitList(list,StringBuilder::new,StringBuilder::append);
    }
    private static void concatAndPrint(String s1, String s2) {
        System.out.println(s1 + " | " + s2);
    }

    private static <T, U> U visitList(List<T> list, Supplier<U> userObjectSupplier,
                                      BiConsumer<U, T> biConsumer) {
        U u = userObjectSupplier.get();
        list.forEach(t -> biConsumer.accept(u, t));
        return u;
    }
}
