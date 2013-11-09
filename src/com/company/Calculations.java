package com.company;
import org.json.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: michaelsive
 * Date: 9/11/13
 * Time: 8:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Calculations {

    public static double[] extractFloats (int tradeExchange, ArrayList<JSONObject> json) throws JSONException {
        double[] price = new double[2];
        if ( tradeExchange == 0 ) {
            price[0] = Double.parseDouble(json.get(0).get("bid").toString());
            price[1] = Double.parseDouble(json.get(0).get("ask").toString());
        }
        else if ( tradeExchange == 1 ) {

            double askVal;
            double bidVal;

            JSONObject dataObjectBuy = json.get(1).getJSONObject("data").getJSONObject("buy");
            JSONObject dataObjectSell = json.get(1).getJSONObject("data").getJSONObject("sell");

            askVal = Double.parseDouble(dataObjectBuy.getString("value"));
            bidVal = Double.parseDouble(dataObjectSell.getString("value"));

            price[0] =  askVal;
            price[1] =  bidVal;
        }

        else {
            price[0] = 0;
            price[1] = 0;
        }

        return price;

    }

}
