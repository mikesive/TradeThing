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


    public static HashMap<String,double[]> extractFloats (HashMap<String, JSONObject> jsonMap) throws JSONException {
        HashMap<String, double[]> priceMap = new HashMap<String, double[]>();

        //Get string representation of Exchange enums
        String bitStamp = Exchange.BITSTAMP.getValue();
        String mtGox = Exchange.MTGOX.getValue();
        String btcE = Exchange.BTCE.getValue();

        //Add bid and ask of bitStamp into priceMap
        double[] bitStampPrice = new double[2];
        JSONObject bitStampJson = jsonMap.get(bitStamp);
        bitStampPrice[0] = Double.parseDouble(bitStampJson.get("bid").toString());
        bitStampPrice[1] = Double.parseDouble(bitStampJson.get("ask").toString());

        priceMap.put(bitStamp, bitStampPrice);

        //Add bid and ask of mtGox into priceMap
        double[] mtGoxPrice = new double[2];
        JSONObject mtGoxJson = jsonMap.get(mtGox);
        mtGoxPrice[0] = Double.parseDouble(mtGoxJson.getJSONObject("data").getJSONObject("buy").getString("value"));
        mtGoxPrice[1] = Double.parseDouble(mtGoxJson.getJSONObject("data").getJSONObject("sell").getString("value"));

        priceMap.put(mtGox, mtGoxPrice);

        //Add bid and ask of btc-E into priceMap
        double[] btcEPrice = new double[2];
        JSONObject btcEStampJson = jsonMap.get(btcE);
        btcEPrice[0] = Double.parseDouble(btcEStampJson.getJSONObject("ticker").get("buy").toString());
        btcEPrice[1] = Double.parseDouble(btcEStampJson.getJSONObject("ticker").get("sell").toString());

        priceMap.put(btcE,btcEPrice);

        return priceMap;

    }

}
