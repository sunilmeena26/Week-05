package com.day01.csvdatahandling;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//Create a class SearchRecord to search the record
class SearchRecord{

    //Create a static method to Search Record By Name
    public static boolean searchRecordByName(String filePath,String target){

        //use try block to handle the exception
        try{
            //Create an object of CSVReader class
            CSVReader reader = new CSVReader(new FileReader(filePath));

            //Create an array of string
            String[] data;

            //Use while loop to read file and search the targeted record
            while ((data = reader.readNext()) !=null){
                //Check the condition
                if(data[2].equalsIgnoreCase(target)){
                    //Print the data
                    System.out.println("Department : "+data[3]+"\nSalary : "+data[4]);
                    return true;
                }
            }
        } catch (IOException e) {//Catch block to handle IOException
            //Print the statement
            System.out.println("Error"+e.getMessage());
        } catch (CsvValidationException e) {//Catch block to handle CsvValidationException
            //Print the statement
            System.out.println("Error:" + e.getMessage());
        }

        return false;
    }
}

//Create a class SearchRecordInCSV
public class SearchRecordInCSV {
    public static void main(String[] args) {
        //Create a variable to store the file path
        String filePath = "C:\\Week-05\\Day-01-JavaCSVDataHandling\\src\\main\\java\\com\\day01\\csvdatahandling\\EmployeeRecord.csv";

        //Create an object of Scanner Class
        Scanner input = new Scanner(System.in);

        //Create a variable to store value and take user input
        System.out.print("Enter Full Name: ");
        String name = input.nextLine();

        //Call the method and print the result
        boolean result = SearchRecord.searchRecordByName(filePath,name);

        //Print the result if target not found
        if(!result){
            //Print the statement
            System.out.println("Not Found");
        }
    }
}

