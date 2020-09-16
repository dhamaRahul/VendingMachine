package com.vending.classes;
import com.sun.tools.javac.util.Pair;
import java.util.*;

public class EnumGenericFunctions<T extends Enum<T>> {
    Map<T,Object> map=new HashMap<>();

    Class<T> enumType;

    public EnumGenericFunctions(Class<T> enumType){
        this.enumType = enumType;
    }

    //Fetches the Constructor Value of any Enum class provided in Pair Class
    public static <T extends ExtractEnumValues> Pair<String,Integer> fromCodeToEnum(String value, Class<T> clazz) {
        for(T t : clazz.getEnumConstants()) {
            if(t.getValue().equalsIgnoreCase(value)) {
                return new Pair(t.getValue(),t.getCode());
            }
        }
        return null;
    }


}
