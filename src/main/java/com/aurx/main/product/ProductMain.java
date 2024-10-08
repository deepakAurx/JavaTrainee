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
            return;
        }
        Scanner scanner = new Scanner(System.in);
        JsonUtils.parsingJson(strJson);
        JsonObject jsonObject = JsonParser.parseString(strJson).getAsJsonObject();
        JsonArray jsonArray = jsonObject.get("products").getAsJsonArray();
        System.out.println("How many product you want: ");
        int data = scanner.nextInt();
        if (data < jsonArray.size()) {
            for (int i = 0; i < data; i++) {
                JsonObject jsonProduct = jsonArray.get(i).getAsJsonObject();
                System.out.println("Product " + (i + 1));

                int id = jsonProduct.get("id").getAsInt();
                System.out.println("id " + id);
                String title = jsonProduct.get("title").getAsString();
                System.out.println("title " + title);
                String description = jsonProduct.get("description").getAsString();
                System.out.println("description " + description);
                double price = jsonProduct.get("price").getAsDouble();
                System.out.println("price " + price);
                if(jsonProduct.get("brand").getAsJsonObject().keySet().contains("brand")) {
                    String brand = jsonProduct.get("brand").getAsString();
                    System.out.println("brand " + brand);
                }

                JsonArray images = jsonProduct.get("images").getAsJsonArray();
                System.out.println("images " + images.get(0));
            }
        } else {
            System.out.println(data + " is Insufficient");
        }
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
