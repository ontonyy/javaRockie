package com.justony.currency.data;

import com.justony.currency.variables.Variables;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class DataInsert {

    public static int getConnection(String url) {
        try {
            URL openUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) openUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            return conn.getResponseCode();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void getData(String currency) {
        try {
            int connectionResponse = getConnection(String.format("https://exchange-rates.abstractapi.com/v1/live/?api_key=%s&base=%s", Variables.CURRENCY_API, currency));
            System.out.println(connectionResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getData("USD");
    }


}
