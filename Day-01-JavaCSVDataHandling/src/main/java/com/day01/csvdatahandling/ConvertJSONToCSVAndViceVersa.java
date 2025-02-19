package com.day01.csvdatahandling;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

//Create a class ConvertJSONToCSV to Convert JSON to CSV and Vice Versa
class ConvertJSONToCSV {

    //Create a static method jsonToCSV to convert JSON to CSV
    public static void jsonToCSV(String jsonFilePath, String csvFilePath) throws IOException {
        String jsonString = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
        JSONArray jsonArray = new JSONArray(jsonString);
        CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath));
        writer.writeNext(new String[]{"ID", "Name", "Age", "Marks", "Grade"});

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String[] csvData = {
                    jsonObject.getString("id"),
                    jsonObject.getString("name"),
                    jsonObject.getString("age"),
                    jsonObject.getString("marks"),
                    jsonObject.getString("grade")
            };
            writer.writeNext(csvData);
        }
        writer.close();
        System.out.println("JSON to CSV conversion completed successfully.");
    }

    //Create a static method csvToJSON to convert CSV to JSON
    public static void csvToJSON(String csvFilePath, String jsonFilePath) throws IOException, CsvValidationException {
        CSVReader reader = new CSVReader(new FileReader(csvFilePath));
        JSONArray jsonArray = new JSONArray();
        String[] nextLine;
        String[] headers = reader.readNext(); // Assuming first line is the header

        while ((nextLine = reader.readNext()) != null) {
            JSONObject jsonObject = new JSONObject();
            for (int i = 0; i < headers.length; i++) {
                jsonObject.put(headers[i], nextLine[i]);
            }
            jsonArray.put(jsonObject);
        }
        reader.close();
        Files.write(Paths.get(jsonFilePath), jsonArray.toString(4).getBytes());
        System.out.println("CSV to JSON conversion completed successfully.");
    }
}

//Create a class ConvertJSONToCSVAndViceVersa to use ConvertJSONToCSV class
public class ConvertJSONToCSVAndViceVersa {
    public static void main(String[] args) {
        //Create a string variable to store csv and json file path
        String jsonFilePath = "C:\\Week-05\\Day-01-JavaCSVDataHandling\\src\\main\\java\\com\\day01\\csvdatahandling\\students.json";
        String csvFilePath = "C:\\Week-05\\Day-01-JavaCSVDataHandling\\src\\main\\java\\com\\day01\\csvdatahandling\\StudentRecord.csv";
        String outputJsonFilePath = "C:\\Week-05\\Day-01-JavaCSVDataHandling\\src\\main\\java\\com\\day01\\csvdatahandling\\output_students.json";

        try {
            // Convert JSON to CSV
            ConvertJSONToCSV.jsonToCSV(jsonFilePath, csvFilePath);

            // Convert CSV to JSON
            ConvertJSONToCSV.csvToJSON(csvFilePath, outputJsonFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
