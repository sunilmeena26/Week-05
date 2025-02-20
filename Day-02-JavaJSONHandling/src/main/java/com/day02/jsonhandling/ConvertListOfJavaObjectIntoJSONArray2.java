package com.day02.jsonhandling;


import com.google.gson.*;

import java.util.ArrayList;
import java.util.List;

//Create a class Student to define student details
class Student2{
    String name;
    String age;
    String rollNumber;

    //Create a constructor to initialize student details
    public Student2(String name, String age, String rollNumber) {
        this.name = name;
        this.age = age;
        this.rollNumber = rollNumber;
    }

    //Create a getter method to return name of the student
    public String getName() {
        return name;
    }

    //Create a getter method to return age of the student
    public String getAge() {
        return age;
    }

    //Create a getter method to return roll number of the student
    public String getRollNumber() {
        return rollNumber;
    }
}

//Create a class ConvertListOfJavaObjectIntoJSONArray2 to use Student class
public class ConvertListOfJavaObjectIntoJSONArray2 {
    public static void main(String[] args) {
        //Create an ArrayList object to store multiple student object
        List<Student2> listOfStudent=new ArrayList<>();
        listOfStudent.add(new Student2("Rohit","19","10925656"));
        listOfStudent.add(new Student2("Sandeep","18","10925657"));
        listOfStudent.add(new Student2("Rakesh","19","10925658"));

        //Create a Gson and JsonArray class object
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        JsonArray jsonArray=new JsonArray();

        //Use for loop to iterate list
        for(Student2 student:listOfStudent){
            JsonElement jsonElement=gson.toJsonTree(student);
            jsonArray.add(jsonElement);
        }

        //print array list in json format
        String jsonOutput=gson.toJson(jsonArray);
        System.out.println(jsonOutput);
    }
}

