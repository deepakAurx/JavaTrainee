package com.aurx.main.product;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JsonUtils {
    private static final String ID="id";
    private static final String TITLE="title";
    private static final String DESCRIPTION="description";
    private static final String PRICE="price";
    private static final String BRAND = "brand";
    private static final String IMAGES="images";
    public static JsonArray parsingJson(String strJson){
        if(strJson==null || strJson.isEmpty()){
            return new JsonArray() ;
        }
        try {
            JsonObject jsonObject = JsonParser.parseString(strJson).getAsJsonObject();
            return jsonObject.getAsJsonArray("products");
        } catch (JsonParseException e) {
            System.out.println("Error parsing JSON: " + e.getMessage());
            return new JsonArray();
        }
    }

    public static List<Product> fetchingProduct(int data, JsonArray jsonArray) {
        List<Product> products=new ArrayList<>();
        if(jsonArray.isJsonNull() || jsonArray.isEmpty()){
            return products;
        }
        if (data > jsonArray.size()) {
            System.out.println(data + " is insufficient; only " + jsonArray.size() + " products available.");
            return products;
        }
            for (int i = 0; i < data; i++) {
                JsonObject jsonProduct = jsonArray.get(i).getAsJsonObject();
                int id = jsonProduct.get(ID).getAsInt();
                String title = jsonProduct.get(TITLE).getAsString();
                String description = jsonProduct.get(DESCRIPTION).getAsString();
                double price = jsonProduct.get(PRICE).getAsDouble();
                String brand="";
                if (jsonProduct.has(BRAND) && !jsonProduct.get(BRAND).isJsonNull()) {
                     brand = jsonProduct.get(BRAND).getAsString();
                }
                JsonArray images = jsonProduct.getAsJsonArray(IMAGES);
                String image = "";
                if (images.size() > 0) {
                   image=images.get(0).getAsString();
                } else {
                    System.out.println("No images available.");
                }
                products.add(new Product(id,title,description,price,brand,image));
            }
            return products;
        }
    public static String getApiResponse(String apiUrl) {
        StringBuilder content = new StringBuilder();
        if (apiUrl == null || apiUrl.isEmpty()) {
            return content.toString();
        }
        try {
            URL url = new URL(apiUrl);
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                content.append(scanner.next()).append(" ");
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error fetching data from URL:" + e.getMessage());

        }

        return content.toString();
    }
    }

