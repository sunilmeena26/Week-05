package com.day01.csvdatahandling;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//Create a class GenerateReports to generate report
class GenerateReports{

    //Create a static method generateReportsFromDataBase to generate report from database file
    public static void generateReportsFromDataBase(String dataBaseFile,String generatedFile){
        //use try block to handle the exception
        try{
            //Create an object of CSVReader class
            CSVReader reader = new CSVReader(new FileReader(dataBaseFile));

            //Create an object of CSVWrite class
            CSVWriter writeData = new CSVWriter(new FileWriter(generatedFile));

            writeData.writeNext(new String[]{"S.NO","Employee ID", "Name", "Department", "Salary"});

            //Create an array of string
            String[] data=reader.readNext();

            //Use while loop to read file
            while ((data = reader.readNext()) !=null){
                //Call the method to write data into file
                writeData.writeNext(data);
            }

            //Call the flush method
            writeData.flush();

            //Print the result
            System.out.println("Report Generated Successfully.");
        } catch (IOException e) {//Catch block to handle IOException
            //Print the statement
            System.out.println("Error"+e.getMessage());
        } catch (CsvValidationException e) {//Catch block to handle CsvValidationException
            //Print the statement
            System.out.println("Error:" + e.getMessage());
        }
    }
}
public class GenerateCSVReportFromDatabase {
    public static void main(String[] args) {
        //Create  a variable to store teh database file path
        String databaseFilePath = "C:\\Week-05\\Day-01-JavaCSVDataHandling\\src\\main\\java\\com\\day01\\csvdatahandling\\EmployeeRecord.csv";

        //Create  a variable to store teh generated file path
        String generatedFilePath = "C:\\Week-05\\Day-01-JavaCSVDataHandling\\src\\main\\java\\com\\day01\\csvdatahandling\\GenerateReportOfEmployee.csv";

        //Call the method to print the result
        GenerateReports.generateReportsFromDataBase(databaseFilePath,generatedFilePath);
    }
}
