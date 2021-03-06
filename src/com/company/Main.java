package com.company;
import java.io.IOException;
import org.json.JSONException;
import java.util.*;

/**
 * Main class to print/display current bid and ask prices of all exchanges in Exchange enum class
 */

public class Main {

    public static void main(String[] args) throws JSONException, IOException, InterruptedException {
        HashMap<String,double[]> priceMap = ExtractData.extractFloats(GetData.getData());
//        for(Exchange exchange : Exchange.values()){
//            String exchangeString =  exchange.getValue();
//            double[] bidAsk = priceMap.get(exchangeString);
//            System.out.println(exchangeString + "-" + "bid: " + bidAsk[0]);
//            System.out.println(exchangeString + "-" + "ask: " + bidAsk[1]);
//        }
//        Comparison.makeComparison(priceMap);
        if (MarketMovement.isRising(GetData.getData())){
            System.out.println("Market is Rising, dive on in bro");
        }
        else {
            System.out.println("Don't even think about it, buddy");
        }
    }
}
