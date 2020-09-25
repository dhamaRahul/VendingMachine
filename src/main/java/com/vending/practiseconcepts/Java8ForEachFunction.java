package com.vending.practiseconcepts;


import com.sun.codemodel.internal.JForEach;
import io.vavr.collection.List;

import java.util.HashMap;
import java.util.Map;

public class Java8ForEachFunction {
    public static void main(String[] args) {
        List<Integer> integerList=List.of(10,20,30,40);
       // integerList.forEach((m)->add(m));
        forEachExample();
    }

    private static void forEachExample() {
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);
        //items.forEach((k,v)->System.out.println("Item is :"+k+" with count of "+v));

        items.forEach((k,v)->{
                if(v > 30) System.out.println("Hi "+k);
                }
                );
    }

    private static void add(Integer m) {
        System.out.println(m+110);
    }

}
