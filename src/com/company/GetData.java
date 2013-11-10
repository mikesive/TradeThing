package com.company;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import com.company.Exchange;

/**
 * Created with IntelliJ IDEA.
 * User: michaelsive
 * Date: 9/11/13
 * Time: 9:02 PM
 * Class used to access exchange ticker and store JSON "ticker" objects in exchangeMap
 */
public class GetData {

    public static HashMap<String, JSONObject>  getData() throws JSONException, IOException{
        HashMap<String, JSONObject> exchangeMap = new HashMap<String, JSONObject>();
        JSONObject bitStamp = readJsonFromUrl("https://www.bitstamp.net/api/ticker/");
        JSONObject mtGox = readJsonFromUrl("http://data.mtgox.com/api/2/BTCUSD/money/ticker_fast");
        JSONObject btcE = readJsonFromUrl("https://btc-e.com/api/2/btc_usd/ticker");
        exchangeMap.put(Exchange.BITSTAMP.getValue(), bitStamp);
        exchangeMap.put(Exchange.MTGOX.getValue(), mtGox);
        exchangeMap.put(Exchange.BTCE.getValue(), btcE);

        return exchangeMap;
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }
}
