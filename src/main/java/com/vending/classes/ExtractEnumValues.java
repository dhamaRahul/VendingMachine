package com.vending.classes;

public interface ExtractEnumValues<T extends Enum<T>> {
    public int getCode();
    public String getValue();
}
