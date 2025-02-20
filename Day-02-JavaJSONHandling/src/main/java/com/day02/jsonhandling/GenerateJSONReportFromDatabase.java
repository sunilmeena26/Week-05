package com.day02.jsonhandling;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.*;

//Create a class GenerateJsonReport to generate report
class GenerateJsonReport{

    //Create a static method to generate Report
    public static void generateReport(String databaseFilePath,String jsonFilePath){
        //Use try block and create an object of BufferReader Class
        try (BufferedReader br = new BufferedReader(new FileReader(databaseFilePath))) {
            //Create an object of JsonArray class
            JsonArray employee = new JsonArray();

            //Create a variable to store data
            String data;

            //Use while loop
            while ((data = br.readLine()) != null) {
                //Create an array to store value
                String[] value = data.split(",");

                //Create an object of JsonObject class
                JsonObject employeeObject = new JsonObject();

                //Call the method to add property
                employeeObject.addProperty("id", Integer.parseInt(value[0]));
                employeeObject.addProperty("name", value[1]);
                employeeObject.addProperty("salary", Integer.parseInt(value[2]));
                employee.add(employeeObject);
            }

            //Create an object of JsonObject class
            JsonObject reportObject = new JsonObject();
            reportObject.add("employees", employee);

            //Create an object of GsonBuilder class
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            //USe try block and create an object of FileWriter
            try (FileWriter fileWriter = new FileWriter(jsonFilePath)) {
                gson.toJson(reportObject, fileWriter);
            }

            //Print the result
            System.out.println("JSON report has been generated Successfully.");
        } catch (IOException e) {//Catch block to handle exception

            //Print the result
            System.out.println("Error "+e.getMessage());
        }
    }
}

//Create a class GenerateJSONReportFromDatabase
public class GenerateJSONReportFromDatabase {
    public static void main(String[] args) {

        //Create a variable to store file path
        String databaseFilePath = "C:\\Week-05\\Day-02-JavaJSONHandling\\src\\main\\java\\com\\day02\\jsonhandling\\databse.txt";
        String generateReportPath = "C:\\Week-05\\Day-02-JavaJSONHandling\\src\\main\\java\\com\\day02\\jsonhandling\\generateReport.json";

        //Call the method
        GenerateJsonReport.generateReport(databaseFilePath,generateReportPath);
    }
}
