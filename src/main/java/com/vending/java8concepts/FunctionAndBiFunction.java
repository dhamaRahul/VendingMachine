package com.vending.java8concepts;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionAndBiFunction {
    public static void main(String[] args) {
        Function<String,Integer> stringIntegerFunction=x->x.length();
        System.out.println(stringIntegerFunction.apply("Rahul"));

        Function<Integer,Integer> multiplyFunction=y->y*100;
        Integer finalValue=stringIntegerFunction.andThen(multiplyFunction).apply("Vardaan");
        System.out.println(finalValue);

        exampleBiFunction();
        GPS obj = exampleBiFunctionFactoryMethod("40.741895", "-73.989308", GPS::new);
        System.out.println(obj);
    }

   // The GPS::new calls the following constructor, which accepts two arguments and return an object (GPS)
   // , so it matches with the BiFunction signature.

    private static <R extends GPS> R exampleBiFunctionFactoryMethod(String latitude,String Longitude,
                                                       BiFunction<String,String,R> func) {
        return func.apply(latitude,Longitude);

    }

    private static void exampleBiFunction() {
        BiFunction<Integer,Integer,Integer> biFunction=(x,y)->(x+y);
        Integer integer=biFunction.apply(3,5);
        System.out.println(integer);

         BiFunction<Integer,Integer,Double> doubleBiFunction=(x,y)->Math.pow(x,y);
         Function<Double,String> doubleStringFunction=d->String.valueOf(d);
         System.out.println("Final Value-> "+doubleBiFunction.andThen(doubleStringFunction).apply(3,5));
         String value=powToString(3,5,(a,b)->Math.pow(a,b),x->String.valueOf(x));
         System.out.println("Combined Function : "+value);
    }
    public static <R> R powToString(Integer a1, Integer a2,
                                    BiFunction<Integer, Integer, Double> func,
                                    Function<Double, R> func2) {

        return func.andThen(func2).apply(a1, a2);

    }


}

class GPS {

    String Latitude;
    String Longitude;

    public GPS(String latitude, String longitude) {
        Latitude = latitude;
        Longitude = longitude;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    @Override
    public String toString() {
        return "GPS{" +
                "Latitude='" + Latitude + '\'' +
                ", Longitude='" + Longitude + '\'' +
                '}';
    }
}