package com.day02.jsonhandling;

import org.json.JSONObject;

//Create a class Students
class Students{

    //Create private variable to store value
    private String name;
    private int age;
    private String[] subjects;

    //Parameterized constructor to initialize variable
    public Students(String name, int age, String[] subjects) {
        this.name = name;
        this.age = age;
        this.subjects = subjects;
    }

    //Create a getter method
    public String getName() {
        return name;
    }

    //Create a getter method
    public int getAge() {
        return age;
    }

    //Create a getter method
    public String[] getSubjects() {
        return subjects;
    }
}
//Create a class CreateAJSONObject
public class CreateAJSONObject {
    public static void main(String[] args) {

        //Create an object of Students class
        Students Students1 = new Students("Alok",24,new String[]{"Java","OS","DBMS"});
        Students Students2 = new Students("Rishi",22,new String[]{"C","DBMS","Computer Network"});

        //Create an object of JSONObject class
        JSONObject StudentsObject  = new JSONObject();

        //Call the put method
        StudentsObject.put("Name",Students1.getName());
        StudentsObject.put("Age",Students1.getAge());
        StudentsObject.put("Subjects",Students1.getSubjects());

        //Create an object of JSONObject class
        JSONObject StudentsObject2  = new JSONObject();

        //Call the put method
        StudentsObject2.put("Name",Students2.getName());
        StudentsObject2.put("Age",Students2.getAge());
        StudentsObject2.put("Subjects",Students2.getSubjects());

        //Create an object of JSONObject class
        JSONObject Studentss = new JSONObject();

        //Call the put method
        Studentss.put("Students1 ",StudentsObject);
        Studentss.put("Students2 ",StudentsObject2);

        //Print the result
        System.out.println(Studentss.toString(4));

    }
}
