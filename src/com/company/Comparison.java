package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: michaelsive
 * Date: 10/11/13
 * Time: 6:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class Comparison {
    public static void makeComparison(HashMap<String, double[]> prices) {

        for(Exchange exchange : Exchange.values()){
            String exchangeString =  exchange.getValue();
            double[] bidAsk = prices.get(exchangeString);

            for (Exchange exchangeInner : Exchange.values()) {
                String exchangeStringInner =  exchangeInner.getValue();
                double[] bidAskInner = prices.get(exchangeStringInner);
                if (exchangeString != exchangeStringInner) {
                    double difference = bidAsk[1] - bidAskInner[0];
                    if (difference > 0) {
                       System.out.println(exchangeStringInner + " to " + exchangeString + ": " + difference);
                    }
                    else {
                       System.out.println(exchangeStringInner + " to " + exchangeString + ": no trades");
                    }
                }
            }
        }
    }
}
