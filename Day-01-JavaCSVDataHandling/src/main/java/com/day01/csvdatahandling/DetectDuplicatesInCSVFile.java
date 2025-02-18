package com.day01.csvdatahandling;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Create a class DetectDuplicate to detect duplicates in a CSV File
class DetectDuplicate{
    //Create a method detectDuplicateInCSVFile to detect duplicates in a CSV File and print
    public static void detectDuplicateInCSVFile(String filePath){
        //Use try-catch block to handle the exception
        try {
            // Read CSV file Using CSVReader
            CSVReader reader = new CSVReader(new FileReader(filePath));
            String[] nextLine;

            // Use a map and Set interface
            Map<String, String[]> studentMap = new HashMap<>();
            Set<String> duplicateIds = new HashSet<>();

            //Use while loop the read file line-by-line
            while ((nextLine = reader.readNext()) != null) {
                String id = nextLine[0];
                if (studentMap.containsKey(id)) {
                    // If ID is already present, add to duplicates set
                    duplicateIds.add(id);
                } else {
                    // Otherwise, add to map
                    studentMap.put(id, nextLine);
                }
            }
            reader.close();

            // Print the duplicate records
            if (duplicateIds.isEmpty()) {
                System.out.println("No duplicates found.");
            } else {
                System.out.println("Duplicate records found:");
                for (String id : duplicateIds) {
                    String[] details = studentMap.get(id);
                    System.out.println(String.join(", ", details));
                }
            }

        }
        //Handle the exception
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }catch (CsvValidationException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

//Create a class DetectDuplicatesInCSVFile to use DetectDuplicate class
public class DetectDuplicatesInCSVFile {
    public static void main(String[] args) {
        //Create a String variable to store the file path
        String filePath = "C:\\Week-05\\Day-01-JavaCSVDataHandling\\src\\main\\java\\com\\day01\\csvdatahandling\\StudentDetails.csv";

        //call the method
        DetectDuplicate.detectDuplicateInCSVFile(filePath);

    }
}
