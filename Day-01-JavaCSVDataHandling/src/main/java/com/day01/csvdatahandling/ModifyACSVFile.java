package com.day01.csvdatahandling;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Create a class Modify to read a CSV file and increase the salary of employees from the "IT" department by 10%
class Modify{
    //Create a static method modifyACSVFile to take argument as csv filePath and newFilePath to update salary of employee from the "IT" department by 10%
    public static void modifyACSVFile(String filePath,String newFilePath){
        //Use try-catch block to handle the exceptions
        try{
            //Create an Object of csvReader class
            CSVReader csvReader=new CSVReader(new FileReader(filePath));
            //Create an Object of CSVWriter class
            CSVWriter csvWriter=new CSVWriter(new FileWriter(newFilePath));
            //Create a List to store employee details
            List<String[]> employeeDetails=csvReader.readAll();
            List<String[]> updatedEmployeeDetails=new ArrayList<>();

            //use for loop to iterate employee list
           for(String[] record:employeeDetails){
               if(record[2].equals("IT")){
                   Double salary=Double.parseDouble(record[3]);
                   salary=salary*110/100;
                   record[3]=""+salary;
               }
               //add employee in new list
               updatedEmployeeDetails.add(record);
           }

            //write employee data in updated csv file using writeAll method
            csvWriter.writeAll(updatedEmployeeDetails);
            csvWriter.flush();

            //print massage after print massage in csv file
            System.out.println("IT Employee Salary Successfully Increased By 10%....");
        }

        //use catch block to handle the exception
        catch (CsvException ex){
            System.out.println(ex.getMessage());
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}

//Create a class ModifyACSVFile to use Modify class
public class ModifyACSVFile {
    public static void main(String[] args) {
        //Create a string variable to store new file path
        String filePath="C:\\Week-05\\Day-01-JavaCSVDataHandling\\src\\main\\java\\com\\day01\\csvdatahandling\\EmployeeDetails.csv";

        //Create a string variable to store file path
        String newFilePath="C:\\Week-05\\Day-01-JavaCSVDataHandling\\src\\main\\java\\com\\day01\\csvdatahandling\\Update_EmployeeDetails.csv";

        //call the method and pass argument as csv file path
        Modify.modifyACSVFile(filePath,newFilePath);
    }
}
