package com.day02.jsonhandling;



import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;

//Create a class JsonToXml to convert json to xml
class JsonToXml{
    //Create a static method to write xml file
    public static void writeXmlFile(String jsonData, String xmlFile) {
        //use try block
        try {
            //Create an object of JSONArray class
            JSONArray jsonArray = new JSONArray(jsonData);

            //Create an object of JSONObject class
            JSONObject jsonObject = new JSONObject();

            //Call the method
            jsonObject.put("employees", jsonArray);

            //Create a variable to store the data
            String xmlData = XML.toString(jsonObject);

            //Use try block
            try (FileWriter writer = new FileWriter(xmlFile)) {//Create an object of FileWriter class
                writer.write(xmlData);
            }

            System.out.println("File Converted Successfully");
        } catch (Exception e) {//Catch block to handle exception
            //Print the statement
            System.out.println("Error "+e.getMessage());
        }
    }

    //Create a static method to read json file
    public static String readJsonFile(String jsonFile) {

        //Create an object of StringBuilder class
        StringBuilder jsonData = new StringBuilder();

        //Use try block
        try (BufferedReader br = new BufferedReader(new FileReader(jsonFile))) {

            //Create a variable to store value
            String line;

            //USe while loop
            while ((line = br.readLine()) != null) {
                jsonData.append(line);
            }
        } catch (IOException e) {//Catch block to handle exception
            //Print the statement
            System.out.println("Error "+e.getMessage());
        }
        return jsonData.toString();
    }
}

//Create a class ConvertJSONToXMLFormat
public class ConvertJSONToXMLFormat {
    public static void main(String[] args) {
        //Create a variable to store filePath
        String jsonFilePath = "C:\\Week-05\\Day-02-JavaJSONHandling\\src\\main\\java\\com\\day02\\jsonhandling\\EmployeeRecord.json";
        String xmlFilePath = "C:\\Week-05\\Day-02-JavaJSONHandling\\src\\main\\java\\com\\day02\\jsonhandling\\employee.xml";

        //Create a variable to store value and call the method
        String jsonData = JsonToXml.readJsonFile(jsonFilePath);

        //Call the method
        JsonToXml.writeXmlFile(jsonData,xmlFilePath);
    }
}

