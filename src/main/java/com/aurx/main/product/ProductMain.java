package com.aurx.main.product;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        String strJson = JsonUtils.getJsonFromUrl("https://dummyjson.com/products/");
        System.out.println("Getting All Content: " + strJson);
        populateProductData(strJson);
    }

    private static void populateProductData(String strJson) {
        if (strJson == null && strJson.isEmpty()) {
            System.out.println("No Data Recieved:");
            return;
        }
        Scanner scanner = new Scanner(System.in);
       JsonArray jsonArray=JsonUtils.parsingJson(strJson);
        System.out.println("How many products do you want: ");
        int data = scanner.nextInt();
        List<Product> products =JsonUtils.fetchingProduct(data,jsonArray);
        int productCount=0;
        for(Product product:products){
            System.out.println("Product: "+(++productCount));
            System.out.println(product+"\n");
        }
    }
}
