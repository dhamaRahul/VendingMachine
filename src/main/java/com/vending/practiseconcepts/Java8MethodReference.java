package com.vending.practiseconcepts;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class Java8MethodReference {


    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B", "C");
        //Integer result=IntegerUtils::join(3,5);
        list.forEach(x->System.out.println(x));
        list.forEach(IntegerUtils::print);

        System.out.println(playTwoArgument(3,5,IntegerUtils::join));
    }

    private static <R> R playTwoArgument(int z,int b,BiFunction<Integer,Integer,R> rBiFunction){
        return rBiFunction.apply(z,b);
    }

}

class IntegerUtils{

    public static void print(String str){
        System.out.println(str);
    }
    public static String join(Integer a, Integer b) {
        return String.valueOf(a + b);
    }
}