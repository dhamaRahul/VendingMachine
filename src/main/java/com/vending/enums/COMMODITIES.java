package com.vending.enums;

import com.vending.classes.ExtractEnumValues;

public enum COMMODITIES implements ExtractEnumValues {

    COKE("COKE",20),
    JUICE("JUICE",10),
    CHOCOLATE("CHOCOLATE",50),
    COOKIES("COOKIES",30),
    BAR("BAR",40);


    private Integer commodityPrice;

    private String value;

    private COMMODITIES(String value, Integer commodityPrice){
        this.value=value;
        this.commodityPrice=commodityPrice;
     }

    @Override
    public int getCode() {
        return commodityPrice;
    }

    @Override
    public String getValue() {
        return value;
    }
}
