package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: elliotmckechie
 * Date: 10/11/13
 * Time: 2:09 PM
 * Enum class to store exchange values
 */
public enum Exchange {
    BITSTAMP("BitStamp"),
    MTGOX("MtGox"),
    BTCE("Btc-E");

    private final String value;

    private Exchange(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
