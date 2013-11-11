package com.company;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/**
* Created with IntelliJ IDEA.
* User: elliotmckechie
* Date: 11/11/13
* Time: 9:24 PM
* To change this template use File | Settings | File Templates.
*/
public class MarketMovement {

    static double[] marketPrices = new double[11];
    static boolean[] isIncresing = new boolean[10];

    public static boolean isRising(final HashMap<String, JSONObject> jsonMap) throws IOException, JSONException, InterruptedException{
        for (int i = 0; i < 10; i++){
            marketPrices[i] = ExtractData.getAverageMarketPrice(jsonMap);
            if (i > 0){
                isIncresing[i-1] = marketPrices[i] > marketPrices[i-1];
                if (isIncresing[i-1] == false){
                    return false;
                }
            System.out.println("That's " + ( i + 1) + ", almost...");
            Thread.sleep(5000);
            }
        }
        return true;
    }
}

//        int delay = 5000; // delay for 5 seconds
//        int period = 1000; // repeat every second
//        boolean[] isIncreasing;
//        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(new TimerTask() {
//            public void run() {
//                try {
//                    marketPrices[i] = ExtractData.getAverageMarketPrice(jsonMap);
//                } catch (JSONException e) {
//                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//                }
//                if (i > 0){
//                    isIncreasing[i-1] = (marketPrices[i] - marketPrices[i-1]);
//                }
//                i++;
//            }
//        } , delay, period);

