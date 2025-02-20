package com.day02.jsonhandling;

import java.io.FileReader;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.everit.json.schema.ValidationException;

//Create a class ValidateEmail to check email is valid or not
class ValidateEmail{
    public static void ValidateEmailUsingJSONSchema(String emailSchemaFilePath,String emailDataFilePath) {
        //Use try-catch block to handle the exception
        try {
            //Create an object of FileReader class
            FileReader schemaReader = new FileReader(emailSchemaFilePath);
            JSONObject schemaObject = new JSONObject(new JSONTokener(schemaReader));
            Schema schema = SchemaLoader.load(schemaObject);

            //Create an object of FileReader class
            FileReader dataReader = new FileReader(emailDataFilePath);
            JSONObject jsonData = new JSONObject(new JSONTokener(dataReader));

            // Validate the JSON data against the schema and throws a ValidationException if the data is invalid
            schema.validate(jsonData);

            System.out.println("Email is valid!");

        }
        //handle the exception using catch block
        catch (ValidationException e) {
            System.out.println("Email is invalid: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//Create a class ValidateEmailUsingJSONSchema to use ValidateEmail class
public class ValidateEmailUsingJSONSchema {
    public static void main(String[] args) {
        //Create a c-String variable emailSchemaFilePath and emailDataFilePath
        String emailSchemaFilePath="C:\\Week-05\\Day-02-JavaJSONHandling\\src\\main\\java\\com\\day02\\jsonhandling\\email-schema.json";
        String emailDataFilePath="C:\\Week-05\\Day-02-JavaJSONHandling\\src\\main\\java\\com\\day02\\jsonhandling\\email-data.json";

        //call the method
        ValidateEmail.ValidateEmailUsingJSONSchema(emailSchemaFilePath,emailDataFilePath);
    }
}
