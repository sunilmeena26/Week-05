package com.day01.csvdatahandling;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Create an Employee class to store define employee details
class Employee {
    String id;
    String name;
    String department;
    int salary;

    //Create a constructor to initialize employee details
    Employee(String id, String name, String department, int salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}
//Create a class SortCsvRecords to read a CSV file and sort the records by Salary in descending order.
class SortCsvRecords{
    //Create a static method sortCSVRecordsByColumn to take argument as csv filePath to sort the records by Salary in descending order.
    public static void sortCSVRecordsByColumn(String filePath){
        //Create a List to store employee details
        List<Employee> employeeDetails=new ArrayList<>();
        //Use try-catch block to handle the exceptions
        try{
            //Create an Object of csvReader class
            CSVReader csvReader=new CSVReader(new FileReader(filePath));


            String line[];
            // Skip the header line
            csvReader.readNext();
            //Use while loop to read file line by line
            while ((line =csvReader.readNext()) != null) {
                String id = line[0];
                String name = line[1];
                String department = line[2];
                int salary = Integer.parseInt(line[3]);
                employeeDetails.add(new Employee(id, name, department, salary));
            }
        }
        //Handle the exception using catch block
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        catch(CsvValidationException ex){
            System.out.println(ex.getMessage());
        }

        //Using Bubble Sort to sort employees by salary in descending order
        for (int i = 0; i < employeeDetails.size() - 1; i++) {
            for (int j = 0; j < employeeDetails.size() - i - 1; j++) {
                if (employeeDetails.get(j).salary < employeeDetails.get(j + 1).salary) {
                    Employee temp = employeeDetails.get(j);
                    employeeDetails.set(j, employeeDetails.get(j + 1));
                    employeeDetails.set(j + 1, temp);
                }
            }
        }

        // Print the top 5 highest-paid employees
        System.out.println("Top 5 Highest Paid Employees:");
        for (int i = 0; i < Math.min(5, employeeDetails.size()); i++) {
            Employee employee = employeeDetails.get(i);
            System.out.println("ID: " + employee.id + ", Name: " + employee.name +
                    ", Department: " + employee.department +
                    ", Salary: " + employee.salary);
        }
    }

}

//Create a class SortCSVRecordsByColumn to use SortCsvRecords class
public class SortCSVRecordsByColumn {
    public static void main(String[] args) {
        //Create a string variable to store new file path
        String filePath="C:\\Week-05\\Day-01-JavaCSVDataHandling\\src\\main\\java\\com\\day01\\csvdatahandling\\EmployeeDetails.csv";

        //call the method and pass argument as csv file path
        SortCsvRecords.sortCSVRecordsByColumn(filePath);
    }
}

