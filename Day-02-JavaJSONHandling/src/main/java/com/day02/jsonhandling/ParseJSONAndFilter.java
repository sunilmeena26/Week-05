package com.day02.jsonhandling;

import com.google.gson.*;
import java.util.ArrayList;
import java.util.List;

//Create a class Student to define student details and parse JSON and filter only those records where age > 25.
class Student{
    String name;
    String age;
    String rollNumber;

    //Create a constructor to initialize student details
    public Student(String name, String age, String rollNumber) {
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

//Create a class ParseJSONAndFilter to use Student class
public class ParseJSONAndFilter {
    public static void main(String[] args) {
        //Create an ArrayList object to store multiple student object
        List<Student> listOfStudent=new ArrayList<>();
        listOfStudent.add(new Student("Rohit","19","10925656"));
        listOfStudent.add(new Student("Sandeep","15","10925657"));
        listOfStudent.add(new Student("Rakesh","35","10925658"));

        //Create a Gson and JsonArray class object
        JsonArray jsonArray=new JsonArray();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //Use for loop to iterate list
        for(Student student:listOfStudent){
            JsonElement jsonElement=gson.toJsonTree(student);
            jsonArray.add(jsonElement);
        }

        //Using JsonParser to convert in JsonArray
        JsonArray inputArray = JsonParser.parseString(jsonArray.toString()).getAsJsonArray();
        //Create a JsonArray object to stored filtered student details those age is greater than 25
        JsonArray filteredArray = new JsonArray();

        //Use for -each loop to iterate inputArray
        for (JsonElement element : inputArray) {
            int age = element.getAsJsonObject().get("age").getAsInt();
            if (age > 25) {
                filteredArray.add(element);
            }
        }

        //print result in json format
        String filteredJson = gson.toJson(filteredArray);
        System.out.println(filteredJson);

    }
}
