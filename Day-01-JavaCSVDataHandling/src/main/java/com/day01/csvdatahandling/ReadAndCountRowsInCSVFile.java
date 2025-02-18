package com.day01.csvdatahandling;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

//Create a class ReadAndCountRows to read a CSV file and count the number of records (excluding the header row).
class ReadAndCountRows{
    //Create a static method readAndCountRowsInCSVFile to take argument as csv filePath and read a CSV file and count the number of rows
    public static int readAndCountRowsInCSVFile(String filePath){

        //Create a integer variable to store number of rows in the file
        int noOfRows=0;
        //Use try-catch block to handle the exceptions
        try{
            //Create an Object of CSVReader class
            CSVReader csvReader=new CSVReader(new FileReader(filePath));
            //Create a String array to store line by line data from csv file
            String line[];

            //Use while loop for iterating every line from csv file
            while((line=csvReader.readNext())!=null){
                //increment row number by one when row is present
                noOfRows++;
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
        //return number of rows in file
        return (noOfRows==0)?noOfRows:noOfRows-1;
    }
}

//Create a class ReadAndCountRowsInCSVFile to use ReadAndCountRows class
public class ReadAndCountRowsInCSVFile {
    public static void main(String[] args) {
        //Create a string variable to store file path
        String filePath="C:\\Week-05\\Day-01-JavaCSVDataHandling\\src\\main\\java\\com\\day01\\csvdatahandling\\StudentDetails.csv";
        //Create a variable noOfRows to store number rows in file and call the method and pass argument as csv file path
        int noOfRows=ReadAndCountRows.readAndCountRowsInCSVFile(filePath);

        //print the rows number
        System.out.println("Rows In CSV File: "+noOfRows);
    }
}
