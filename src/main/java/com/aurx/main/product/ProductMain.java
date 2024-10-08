package com.aurx.main.product;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        String strJson = getJsonFromUrl("https://dummyjson.com/products/");
        System.out.println("Getting All Content: " + strJson);
        getData(strJson);
    }

    private static void getData(String strJson) {
        if (strJson == null && strJson.isEmpty()) {
            System.out.println("No Data Recieved:");
            return;
        }
        Scanner scanner = new Scanner(System.in);
       JsonArray jsonArray=JsonUtils.parsingJson(strJson);
        System.out.println("How many products do you want: ");
        int data = scanner.nextInt();
        JsonUtils.fetchingData(data,jsonArray);
    }


    private static String getJsonFromUrl(String theUrl) {
        if (theUrl == null && theUrl.isEmpty()) {
            return null;
        }
        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL(theUrl);
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                content.append(scanner.next() + " ");
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error fetching data from URL:" + e.getMessage());
            ;
        }

        return content.toString();
    }
}
