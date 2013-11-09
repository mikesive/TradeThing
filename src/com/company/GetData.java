package com.company;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: michaelsive
 * Date: 9/11/13
 * Time: 9:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class GetData {
    public static ArrayList<JSONObject> getData() throws Exception {
        JSONObject bitStamp = readJsonFromUrl("https://www.bitstamp.net/api/ticker/");
        JSONObject mtGox = readJsonFromUrl("http://data.mtgox.com/api/2/BTCUSD/money/ticker_fast");
        ArrayList <JSONObject> dataValues = new ArrayList<JSONObject>();

        dataValues.add(bitStamp);
        dataValues.add(mtGox);
        return dataValues;

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
