package com.day02.jsonhandling;

import java.io.FileReader;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Iterator;

//Create a class FilterData to filter JSON data: Print only users older than 25 years.
class FilterData {
    //Create a static method printUsersOlderThan to filter JSON data and print only users older than 25 years.
    public static void printUsersOlderThan(JSONArray usersArray, int ageLimit) {
        //use for loop to iterate JSONArray
        for (int i = 0; i < usersArray.length(); i++) {
            JSONObject user = usersArray.getJSONObject(i);
            int age = user.getInt("age");

            if (age > ageLimit) {
                System.out.println("Name: " + user.getString("name") + ", Age: " + age);
            }
        }
    }
}

//Create a class FilterJSONData to use FilterData class
public class FilterJSONData {
    public static void main(String[] args) {
        //handle the exception try-catch block
        try {
            //Create an object of FileReader class
            FileReader reader = new FileReader("C:\\Week-05\\Day-02-JavaJSONHandling\\src\\main\\java\\com\\day02\\jsonhandling\\jsonfileexample.json");
            StringBuilder sb = new StringBuilder();
            int i;
            while ((i = reader.read()) != -1) {
                sb.append((char) i);
            }
            reader.close();

            String jsonString = sb.toString();
            JSONObject jsonObject = new JSONObject(jsonString);

            JSONArray usersArray = jsonObject.getJSONArray("users");
            //call the method
            FilterData.printUsersOlderThan(usersArray, 25);

        }
        //handle the exception using check block
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
