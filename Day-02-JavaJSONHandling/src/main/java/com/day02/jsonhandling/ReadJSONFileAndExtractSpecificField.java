package com.day02.jsonhandling;

import com.google.gson.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Create a ReadJSONFile to read a JSON file and extract only specific fields
class ReadJSONFile{
    //Create a static method ReadJSONFileAndExtractSpecificField to read a JSON file and extract only specific fields
    public static void ReadJSONFileAndExtractSpecificField(String jsonFilePath){
        try (FileReader reader = new FileReader(jsonFilePath)) {
            //Now, Parse the JSON file
            JsonElement jsonElement = JsonParser.parseReader(reader);
            JsonArray jsonArray = jsonElement.getAsJsonArray();

            List<JsonObject> extractedData = new ArrayList<>();

            //Using for-each loop to iterate through the JSON array and extract specific fields
            for (JsonElement element : jsonArray) {
                JsonObject obj = element.getAsJsonObject();
                String name = obj.get("name").getAsString();
                String email = obj.get("email").getAsString();

                JsonObject extractedObj = new JsonObject();
                extractedObj.addProperty("name", name);
                extractedObj.addProperty("email", email);

                extractedData.add(extractedObj);
            }

            // Print extracted data
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            extractedData.forEach(data -> System.out.println(gson.toJson(data)));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//Create a class ReadJSONFileAndExtractSpecificField to use ReadJSON class
public class ReadJSONFileAndExtractSpecificField {
        public static void main(String[] args) {
            //Create a String variable jsonFilePath to store file path
            String jsonFilePath = "C:\\Week-05\\Day-02-JavaJSONHandling\\src\\main\\java\\com\\day02\\jsonhandling\\persondetails.json";
            //call the method
            ReadJSONFile.ReadJSONFileAndExtractSpecificField(jsonFilePath);
        }
    }
