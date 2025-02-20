package com.day02.jsonhandling;

import com.google.gson.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//Create a class MergeFiles to merge files
class MergeFiles{
    //Create a static method to merge two object
    public static JsonObject mergeTwoJsonObject(JsonObject jsonObject1, JsonObject jsonObject2) {

        //Create an object of mergedObject class
        JsonObject mergedObject = new JsonObject();

        //Use for each loop
        for (String key : jsonObject1.keySet()) {
            //call the put method
            mergedObject.add(key, jsonObject1.get(key));
        }

        //again use for each loop
        for (String key : jsonObject2.keySet()) {
            if (mergedObject.has(key)) {
                //create an object of JsonElement class
                JsonElement element1 = jsonObject1.get(key);
                JsonElement element2 = jsonObject2.get(key);

                if (element1.isJsonObject() && element2.isJsonObject()) {
                    //CAll the method
                    mergedObject.add(key, mergeTwoJsonObject(element1.getAsJsonObject(), element2.getAsJsonObject()));
                } else {
                    //Call the add method to add value
                    mergedObject.add(key, element2);
                }
            } else {
                mergedObject.add(key, jsonObject2.get(key));
            }
        }

        return mergedObject;
    }
}

//Create a class MergeTwoJSONFiles
public class MergeTwoJSONFiles {
    public static void main(String[] args) {

        //Create a variable to store file path
        String filePath1 = "C:\\Week-05\\Day-02-JavaJSONHandling\\src\\main\\java\\com\\day02\\jsonhandling\\EmployeeRecord.json";
        String filePath2 = "C:\\Week-05\\Day-02-JavaJSONHandling\\src\\main\\java\\com\\day02\\jsonhandling\\EmployeeRecord2.json";
        String mergedFilePath = "C:\\Week-05\\Day-02-JavaJSONHandling\\src\\main\\java\\com\\day02\\jsonhandling\\MergeEmployeeRecord.json";

        //Use try block
        try {
            //Create an  object of JsonElement class
            JsonElement jsonElement1 = JsonParser.parseReader(new FileReader(filePath1));

            //Create an  object of JsonObject class
            JsonObject jsonObject1 = jsonElement1.getAsJsonObject();

            //Create an  object of JsonElement class
            JsonElement jsonElement2 = JsonParser.parseReader(new FileReader(filePath2));

            //Create an  object of JsonObject class
            JsonObject jsonObject2 = jsonElement2.getAsJsonObject();

            //Create an  object of JsonObject class
            JsonObject mergedObject = MergeFiles.mergeTwoJsonObject(jsonObject1, jsonObject2);

            //Create an  object of Gson class
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            //Create a variable to store the value
            String mergedJsonString = gson.toJson(mergedObject);

            //Create an object of FileWriter class
            FileWriter fileWriter = new FileWriter(mergedFilePath);
            fileWriter.write(mergedJsonString);
            fileWriter.close();

            //Print the result
            System.out.println("File has been merged.");
        } catch (IOException e) {//catch block to handle exception
            System.out.println("Error: "+e.getMessage());
        }
    }
}
