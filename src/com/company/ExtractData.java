package com.company;
import org.json.*;
import java.util.*;
import com.company.Exchange;

/**
 * Created with IntelliJ IDEA.
 * User: michaelsive
 * Date: 9/11/13
 * Time: 8:54 PM
 * Class used to parse exchange tickers and store bid and asks prices for each exchange
 */
public class ExtractData {

    //Get string representation of Exchange enums
    private static String bitStamp = Exchange.BITSTAMP.getValue();
    private static String mtGox = Exchange.MTGOX.getValue();
    private static String btcE = Exchange.BTCE.getValue();

    public static HashMap<String,double[]> extractFloats (HashMap<String, JSONObject> jsonMap) throws JSONException {
        HashMap<String, double[]> priceMap = new HashMap<String, double[]>();


        //Add bid and ask of bitStamp into priceMap
        double[] bitStampPrice = new double[2];
        JSONObject bitStampJson = jsonMap.get(bitStamp);
        bitStampPrice[0] = bitStampJson.getDouble("bid");
        bitStampPrice[1] = bitStampJson.getDouble("ask");

        priceMap.put(bitStamp, bitStampPrice);

        //Add bid and ask of mtGox into priceMap
        double[] mtGoxPrice = new double[2];
        JSONObject mtGoxJson = jsonMap.get(mtGox);
        mtGoxPrice[0] = mtGoxJson.getJSONObject("data").getJSONObject("buy").getDouble("value");
        mtGoxPrice[1] = mtGoxJson.getJSONObject("data").getJSONObject("sell").getDouble("value");

        priceMap.put(mtGox, mtGoxPrice);

        //Add bid and ask of btc-E into priceMap
        double[] btcEPrice = new double[2];
        JSONObject btcEJson = jsonMap.get(btcE);
        btcEPrice[0] = btcEJson.getJSONObject("ticker").getDouble("buy");
        btcEPrice[1] = btcEJson.getJSONObject("ticker").getDouble("sell");

        priceMap.put(btcE,btcEPrice);



        return priceMap;

    }

    public static double getAverageMarketPrice (HashMap<String, JSONObject> jsonMap) throws JSONException {

        JSONObject btcEJson = jsonMap.get(btcE);
        double btcELast = btcEJson.getJSONObject("ticker").getDouble("last");

        JSONObject bitStampJson = jsonMap.get(bitStamp);
        double bitStampLast = bitStampJson.getDouble("last");

        JSONObject mtGoxJson = jsonMap.get(mtGox);
        double mtGoxLast = mtGoxJson.getJSONObject("data").getJSONObject("last").getDouble("value");


        double averageMarketPrice = (mtGoxLast + bitStampLast + btcELast)/3;
        return averageMarketPrice;
    }

}
