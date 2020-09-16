package com.vending.enums;

import com.vending.classes.ExtractEnumValues;

public enum PRICE implements ExtractEnumValues {
    FIVE("FIVE",5),
    TEN("TEN",10),
    TWENTY("TWENTY",20),
    FIFTY("FIFTY",50);


    private Integer cashPrice;
    private String value;

    private PRICE(String value,Integer cashPrice){
        this.value=value;
        this.cashPrice=cashPrice;
    }

    @Override
    public int getCode() {
        return cashPrice;
    }

    @Override
    public String getValue() {
        return value;
    }

}
