package com.day01.csvdatahandling;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//Create a class Student to store the details of student
class Student {

    //Create private variable to store the details
    private int id;
    private String  name;
    private int age;
    private int marks;

    //Parameterized constructor to initialize variable
    public Student(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    //Create a method and override it
    public String toString() {
        return "Student{" +"id=" +id+", name='"+name +", age=" +age+",Marks="+marks+'}' ;
    }
}

//Create a class ConvertToObject to convert data to object
class ConvertToObject {

    //Create a static method to convert csv file data into java object
    public static void convertCSVDataToJavaObject(String filePath) {
        //Create a list to store the objects of Student class
        List<Student> students = new ArrayList<>();

        //use try block to handle the exception
        try {
            //Create an object of CSVReader class
            CSVReader reader = new CSVReader(new FileReader(filePath));

            //Create an array of string
            String[] data = reader.readNext();

            //Use while loop to read file and search the targeted record
            while ((data = reader.readNext()) != null) {

                //Create variable to store the converted value
                int id = Integer.parseInt(data[1]);
                int age = Integer.parseInt(data[3]);
                int marks = Integer.parseInt(data[4]);

                //Call the add method to add data into list
                students.add(new Student(id,data[2],age,marks));
            }
        } catch (IOException e) {//Catch block to handle IOException
            //Print the statement
            System.out.println("Error" + e.getMessage());
        } catch (CsvValidationException e) {//Catch block to handle CsvValidationException
            //Print the statement
            System.out.println("Error:" + e.getMessage());
        }

        //Print the result
        for(Student val : students){
            System.out.println(val);
        }
    }
}


//Create a class ConvertCSVDataIntoJavaObjects
public class ConvertCSVDataIntoJavaObjects {
    public static void main(String[] args) {
        //Create a variable to store the file path
        String filePath = "C:\\Week-05\\Day-01-JavaCSVDataHandling\\src\\main\\java\\com\\day01\\csvdatahandling\\StudentRecord.csv";

        //Call the method and print the result
        ConvertToObject.convertCSVDataToJavaObject(filePath);
    }
}
