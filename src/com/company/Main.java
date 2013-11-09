package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, JSONException, Exception {
	// write your code here
        calcOperation(getData());
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

    public static void calcOperation(ArrayList<JSONObject> dataValues){
        for ( JSONObject dataValue : dataValues ) {
            System.out.println(dataValue.toString());
        }
    }

    public static ArrayList<JSONObject> getData() throws Exception {
        JSONObject bitStamp = readJsonFromUrl("https://www.bitstamp.net/api/ticker/");
        JSONObject mtGox = readJsonFromUrl("http://data.mtgox.com/api/2/BTCUSD/money/ticker_fast");
        ArrayList <JSONObject> dataValues = new ArrayList<JSONObject>();

        dataValues.add(bitStamp);
        dataValues.add(mtGox);
        return dataValues;

    }
}
