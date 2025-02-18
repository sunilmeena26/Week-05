package com.day01.csvdatahandling;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Create a class ValidateData to check the data is valid or not in csv file
class  ValidateData{

    //Create a method to check the data in the csv file is valid
    public static void checkValidateData(String filePath){
        //use try block to handle the exception
        try{
            //Create an object of CSVReader class
            CSVReader reader = new CSVReader(new FileReader(filePath));

            //Create an array of string
            String[] data=reader.readNext();

            //Print the statement
            System.out.printf("%-20s %-28s %-15s REASON\n",data[0],data[1],data[2]);

            //Create two string to store the regex
            String emailRegex = "[a-zA-Z0-9_.+-]+@[a-zA-z0-9-]+\\.[a-zA-z]{3,}";
            String phoneRegex = "\\d{10}";

            //Create object of Pattern class
            Pattern compileEmailRegex = Pattern.compile(emailRegex);
            Pattern compilePhoneRegex = Pattern.compile(phoneRegex);

            //Create reference variable of Matcher class
            Matcher matcherEmail;
            Matcher matcherPhone;

            //Use while loop to find the invalid record
            while ((data = reader.readNext()) !=null){

                //Call the matcher method
                matcherEmail = compileEmailRegex.matcher(data[1]);
                matcherPhone = compilePhoneRegex.matcher(data[2]);

                //Check the condition
                if(!matcherEmail.matches()){
                    //Print the data of invalid email
                    System.out.printf("%-20s %-28s %-15s\"Invalid Email!\"\n",data[0],data[1],data[2]);
                } else if(!matcherPhone.matches()){
                    //Print the data of invalid phone number
                    System.out.printf("%-20s %-28s %-15s\"Invalid Phone NUmber!\"\n",data[0],data[1],data[2]);
                }
            }
        } catch (IOException e) {//Catch block to handle IOException
            //Print the statement
            System.out.println("Error"+e.getMessage());
        } catch (CsvValidationException e) {//Catch block to handle CsvValidationException
            //Print the statement
            System.out.println("Error:" + e.getMessage());
        }
    }
}

//Create a class ValidateCSVDataBeforeProcessing
public class ValidateCSVDataBeforeProcessing {
    public static void main(String[] args) {

        //Create a variable to store the filePath
        String filePath = "C:\\Week-05\\Day-01-JavaCSVDataHandling\\src\\main\\java\\com\\day01\\csvdatahandling\\PersonDetails.csv";

        //Call the method and print the records
        System.out.println("Invalid Data is given below: \n");
        ValidateData.checkValidateData(filePath);
    }
}
