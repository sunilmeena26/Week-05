package com.day02.jsonhandling;


import org.json.JSONObject;

//Create a class Person to store person details
class Person{
    //Create a String variable name,email,age, and city to store person details
    String name;
    String email;
    String age;
    String city;

    //Create a constructor to initialize person details
    public Person(String name, String email, String age, String city) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.city = city;
    }

    //Create a getter method to return name of the person
    public String getName() {
        return name;
    }

    //Create a getter method to return email of the person
    public String getEmail() {
        return email;
    }

    //Create a getter method to return age of the person
    public String getAge() {
        return age;
    }

    //Create a getter method to return city of the person
    public String getCity() {
        return city;
    }

    //Create a method toJson to store person details in json object
    public JSONObject toJson(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("Name",name);
        jsonObject.put("Email",email);
        jsonObject.put("Age",age);
        jsonObject.put("City",city);
        return  jsonObject;
    }

}

//Create a class MergeTwoJSONObjects to use Person class
public class MergeTwoJSONObjects {
    public static void main(String[] args) {
        //Create an object of person class
        Person person1=new Person("Ashish","ashish099@gamil.com","23","Pune");
        Person person2=new Person("Mohan","mohan099@gamil.com","53","Mumbai");

        //Create a object JSONObject class to store two json object details
        JSONObject mergeJson=new JSONObject();
        mergeJson.put("Person1",person1.toJson());
        mergeJson.put("Person2",person2.toJson());

        //Print the mergeJson
        System.out.println(mergeJson.toString(4));
    }
}
