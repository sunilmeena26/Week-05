package com.day01.csvdatahandling;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//Create a class ReadLargeFile
class ReadLargeFile{
    //Create a static method to read Large File
    public static void readLargeFile(String filePath){
        //Create a variable to store the count of record
        int recordCount = 0;

        //use try block to handle the exception
        try{
            //Create an object of CSVReader class
            CSVReader reader = new CSVReader(new FileReader(filePath));

            //Create an array of string
            String[] data;

            //Create a list of to store the records
            List<String[]> records = new ArrayList<>();

            //Use while loop to read file
            while ((data = reader.readNext()) !=null){
                //Call the add method to add the data
                records.add(data);

                //check the condition
                if (records.size() == 100) {
                    //Call the method
                    processRecords(records);

                    //Count the records
                    recordCount += records.size();

                    //Call the method to clear the records
                    records.clear();

                    //Print the result
                    System.out.println("Processed records: " + recordCount);
                }
            }

            // check the condition for remaining records
            if (!records.isEmpty()) {
                //Call the method
                processRecords(records);
                recordCount += records.size();
                //Print the result
                System.out.println("Processed records: " + recordCount);
            }
        } catch (IOException e) {//Catch block to handle IOException
            //Print the statement
            System.out.println("Error"+e.getMessage());
        } catch (CsvValidationException e) {//Catch block to handle CsvValidationException
            //Print the statement
            System.out.println("Error:" + e.getMessage());
        }
    }

    //Create a method to process records in file
    private static void processRecords(List<String[]> chunk) {
        //Use for loop to print the data
        for (String[] record : chunk) {
            System.out.println(String.join(", ", record));
        }
    }
}
//Create a class ReadLargeCSVFileEfficiently
public class ReadLargeCSVFileEfficiently {
    public static void main(String[] args) {
        //Create a variable to store the file path
        String filePath = "C:\\Week-05\\Day-01-JavaCSVDataHandling\\src\\main\\java\\com\\day01\\csvdatahandling\\LaptopPrices.csv";

        //Call the method
        ReadLargeFile.readLargeFile(filePath);
    }

}
