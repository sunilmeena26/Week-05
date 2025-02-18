package com.day01.csvdatahandling;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

//Create a class ReadCSVFile to read the csv file and print student details
class ReadCSVFile{
    //Create a static method readCsvFilePrintData to take argument as csv filePath and read and print the student details form the file
    public static void readCsvFilePrintData(String filePath){
        //Use try-catch block to handle the exceptions
        try{
            //Create an Object of CSVReader class   s
            CSVReader csvReader=new CSVReader(new FileReader(filePath));
            //Create a String array to store line by line data from csv file
            String line[];

            //Use while loop for iterating every line from csv file
            while((line=csvReader.readNext())!=null){
                //Print csv file student data
                System.out.printf("%-5s %-5s %-16s %-5s %-5s",line[0],line[1],line[2],line[3],line[4]);
                System.out.println();
            }
        }
        //use catch block to handle the exception
        catch (IOException ex){
            ex.getMessage();
        }catch (CsvValidationException ex){
            ex.getMessage();
        }
    }
}

//Create a class ReadCSVFileAndPrintData to use ReadCSVFile class
public class ReadCSVFileAndPrintData {
    public static void main(String[] args) {
        //Create a string variable to store file path
        String filePath="C:\\Week-05\\Day-01-JavaCSVDataHandling\\src\\main\\java\\com\\day01\\csvdatahandling\\StudentDetails.csv";
        //call the method and pass argument as csv file path
        ReadCSVFile.readCsvFilePrintData(filePath);
    }
}
