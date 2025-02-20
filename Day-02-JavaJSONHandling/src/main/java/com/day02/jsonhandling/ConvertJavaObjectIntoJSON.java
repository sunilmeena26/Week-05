package com.day02.jsonhandling;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//Create a class Car to define the car details
class Car{
    //Create a String variable model,year, and price to store car details
    String model;
    String year;
    String price;

    //Create a constructor to initialize car details
    public Car(String model, String year, String price) {
        this.model = model;
        this.year = year;
        this.price = price;
    }

    //Create a getter method to return car model
    public String getModel() {
        return model;
    }

    //Create a setter method to initialize car model
    public void setModel(String model) {
        this.model = model;
    }

    //Create a getter method to return car year
    public String getYear() {
        return year;
    }

    //Create a setter method to initialize car year
    public void setYear(String year) {
        this.year = year;
    }

    //Create a getter method to return car price
    public String getPrice() {
        return price;
    }

    //Create a setter method to initialize car price
    public void setPrice(String price) {
        this.price = price;
    }
}

//Create a class ConvertJavaObjectIntoJSON to use Car class
public class ConvertJavaObjectIntoJSON {
    public static void main(String[] args) {
        //Create an object of Car class pass argument as car details
        Car car1=new Car("Maruti Suzuki Wagon R","2024","30000000");
        Car car2=new Car("Fortuner","2022","3000000");
        Car car3=new Car("Scarpio N","2025","2500000");

        //Create on object of GsonBuilder
        Gson gson=new GsonBuilder().setPrettyPrinting().create();

        //Create a string variable to store object into JSON format
        String string1=gson.toJson(car1);
        String string2=gson.toJson(car2);
        String string3=gson.toJson(car3);

        //print the car details in json format
        System.out.println(string1);
        System.out.println(string2);
        System.out.println(string3);
    }
}
