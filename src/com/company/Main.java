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

    private static int BTS = 0;
    private static int MTGOX = 1;

    public static void main(String[] args) throws IOException, JSONException, Exception {
	// write your code here
        System.out.println("BitStamp - bid:" + Calculations.extractFloats(BTS, GetData.getData())[0]);
        System.out.println("BitStamp - ask:" + Calculations.extractFloats(BTS, GetData.getData())[1]);
        //System.out.println("MtGox: " + Calculations.extractFloats(1, GetData.getData()));
        System.out.println("MtGox - bid:" + Calculations.extractFloats(MTGOX, GetData.getData())[0]);
        System.out.println("MtGox - ask:" + Calculations.extractFloats(MTGOX, GetData.getData())[1]);
    }
}
