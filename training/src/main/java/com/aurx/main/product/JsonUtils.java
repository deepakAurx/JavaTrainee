package com.aurx.main.product;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

public class JsonUtils {
    public static JsonArray parsingJson(String strJson){
        try {
            JsonObject jsonObject = JsonParser.parseString(strJson).getAsJsonObject();
            return jsonObject.getAsJsonArray("products");
        } catch (JsonParseException e) {
            System.out.println("Error parsing JSON: " + e.getMessage());
            return new JsonArray();
        }
    }

    public static void fetchingData(int data, JsonArray jsonArray) {
        if (data > jsonArray.size()) {
            System.out.println(data + " is insufficient; only " + jsonArray.size() + " products available.");
            return;
        }
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
                if (jsonProduct.has("brand") && !jsonProduct.get("brand").isJsonNull()) {
                    String brand = jsonProduct.get("brand").getAsString();
                    System.out.println("Brand: " + brand);
                }

                JsonArray images = jsonProduct.getAsJsonArray("images");
                if (images.size() > 0) {
                    System.out.println("First Image URL: " + images.get(0).getAsString());
                } else {
                    System.out.println("No images available.");
                }
                System.out.println();
            }
        }
    }

