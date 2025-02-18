package com.day01.csvdatahandling;


import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

//Create a class WriteCSVFile to write the csv file as employee details
class WriteCSVFile{
    //Create a static method writeDataToCsvFile to take argument as csv filePath and write the employee details in the file
    public static void writeDataToCsvFile(String filePath){
        //Use try-catch block to handle the exceptions
        try{
            //Create an Object of CSVWriter class
            CSVWriter csvWriter=new CSVWriter(new FileWriter(filePath));
            //Create a List to store employee details
            List<String[]> list=new ArrayList<>();

            //add employee details in list
            list.add(new String[]{"ID","NAME","Department","Salary"});
            list.add(new String[]{"101","Rohit Sharma","IT","50000"});
            list.add(new String[]{"102","Mohit Soni","Medical","90000"});
            list.add(new String[]{"103","Ravi Kishan","IT","12000"});
            list.add(new String[]{"104","Ramhet Verma","Sales","90000"});
            list.add(new String[]{"106","Ram Sharma","HR","45000"});
            list.add(new String[]{"107","Viraj Kushwaha","Computer Science","50000"});



            //write employee data in csv file use writeAll method
            csvWriter.writeAll(list);
            csvWriter.flush();

            //print massage after print massage in csv file
            System.out.println("Employee Record Successfully Added In File....");
        }
        //use catch block to handle the exception
        catch(Exception ex){
            ex.getMessage();
        }
    }
}

//Create a class WriteDataToCSVFile to use WriteCSVFile class
public class WriteDataToCSVFile {
    public static void main(String[] args) {
        //Create a string variable to store file path
        String filePath="C:\\Week-05\\Day-01-JavaCSVDataHandling\\src\\main\\java\\com\\day01\\csvdatahandling\\EmployeeDetails.csv";
        //call the method and pass argument as csv file path
        WriteCSVFile.writeDataToCsvFile(filePath);
    }
}
