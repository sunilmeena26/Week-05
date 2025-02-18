package com.day01.csvdatahandling;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//Create a class Merge to merge the two csv file and write in new file
class Merge{
    //Create a static method mergeTwoFile to merge the two file
    public static void mergeTwoFile(String StudentDetails1,String StudentDetails2,String MergeStudentDetails){
        //Use try-catch block to handle the exception
        try {
            // Read first CSV file into a map
            Map<String, String[]> studentMap = new HashMap<>();
            //Create a object od CSVReader class to read first CSV file
            CSVReader reader1 = new CSVReader(new FileReader(StudentDetails1));
            String[] nextLine;
            while ((nextLine = reader1.readNext()) != null) {
                studentMap.put(nextLine[0], nextLine); // Use ID as the key
            }
            reader1.close();

            //Create an object of CSVReader class to read second CSV file and merge data
            CSVReader reader2 = new CSVReader(new FileReader(StudentDetails2));
            while ((nextLine = reader2.readNext()) != null) {
                if (studentMap.containsKey(nextLine[0])) {
                    String[] details1 = studentMap.get(nextLine[0]);
                    String[] mergedDetails = new String[details1.length + nextLine.length - 1];

                    System.arraycopy(details1, 0, mergedDetails, 0, details1.length);
                    System.arraycopy(nextLine, 1, mergedDetails, details1.length, nextLine.length - 1);

                    studentMap.put(nextLine[0], mergedDetails);
                }
            }
            reader2.close();

            // Write merged data to the output CSV file
            CSVWriter writer = new CSVWriter(new FileWriter(MergeStudentDetails));
            for (String[] details : studentMap.values()) {
                writer.writeNext(details);
            }
            writer.close();

            System.out.println("CSV files merged successfully!");

        }
        //Use catch block to handle the exception
        catch (IOException ex) {
            ex.printStackTrace();
        }catch (CsvValidationException ex) {
            ex.printStackTrace();
        }
    }
}

//Create a class MergeCSVFiles to merge the two csv file
class MergeTwoCSVFiles {

    public static void main(String[] args) {
        //Create a String variables to store the file path
        String StudentDetails1 = "C:\\Week-05\\Day-01-JavaCSVDataHandling\\src\\main\\java\\com\\day01\\csvdatahandling\\StudentDetails.csv";
        String StudentDetails2 = "C:\\Week-05\\Day-01-JavaCSVDataHandling\\src\\main\\java\\com\\day01\\csvdatahandling\\StudentDetails2.csv";
        String MergeStudentDetails = "C:\\Week-05\\Day-01-JavaCSVDataHandling\\src\\main\\java\\com\\day01\\csvdatahandling\\mergeStudentDetails.csv";

        //call the method
        Merge.mergeTwoFile(StudentDetails1,StudentDetails2,MergeStudentDetails);
    }
}
