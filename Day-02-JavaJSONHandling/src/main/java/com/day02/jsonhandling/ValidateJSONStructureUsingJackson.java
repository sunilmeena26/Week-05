package com.day02.jsonhandling;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

// Create a Employee class to represent the JSON structure
class Employee2 {
    //Create a variable id,name,and salary to store employee details
    private int id;
    private String name;
    private double salary;

    //Create a Getter method for 'id'
    public int getId() {
        return id;
    }

    //Create a Setter method for 'id'
    public void setId(int id) {
        this.id = id;
    }

    //Create a Getter method for 'name'
    public String getName() {
        return name;
    }

    //Create a Setter method for 'name'
    public void setName(String name) {
        this.name = name;
    }

    //Create a Getter method for 'salary'
    public double getSalary() {
        return salary;
    }

    //Create a Setter method for 'salary'
    public void setSalary(double salary) {
        this.salary = salary;
    }
}

// Class to handle JSON structure validation
class JsonStructureValidation {
    //Create a static method to check if the JSON structure is valid
    public static void checkIsJsonStructureValid(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        //Use try-catch block to handle the exception
        try {
            // Read and validate the JSON structure
            Employee2 employee = mapper.readValue(new File(filePath), Employee2.class);
            System.out.println("JSON structure is valid.");
            System.out.println("Employee Details:");
            System.out.println("ID: " + employee.getId());
            System.out.println("Name: " + employee.getName());
            System.out.println("Salary: " + employee.getSalary());
        }
        // Handle exception if using catch block
        catch (IOException e) {
            System.out.println("Invalid JSON structure: " + e.getMessage());
        }
    }
}

// Create a class ValidateJSONStructureUsingJackson to use Employee2 class
public class ValidateJSONStructureUsingJackson {
    public static void main(String[] args) {
        // Specify the path to the JSON file
        String filePath = "C:\\Week-05\\Day-02-JavaJSONHandling\\src\\main\\java\\com\\day02\\jsonhandling\\employeesdata.json";

        // Call the method to check JSON structure validity
        JsonStructureValidation.checkIsJsonStructureValid(filePath);
    }
}