package com.day01.csvdatahandling;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//Create a class EncryptAndDeCrypt
class EncryptAndDeCrypt{
    //Create a variable to store key
    private static final int  securityKey =3;

    //Create a method encryptAndDecryptData
    public static void encryptAndDecryptData(String filePath1,String filePath2){
        //Use try block
        try{

            //Create an object of CSVReader class
            CSVReader reader = new CSVReader(new FileReader(filePath1));

            //Create an object of CSVWrite class
            CSVWriter writeData = new CSVWriter(new FileWriter(filePath2));

            String[] data;
            //Use while loop to read file
            while ((data = reader.readNext()) !=null){
                writeData.writeNext(new String[]{data[0],data[1],data[2],encrypt(data[3]),encrypt(data[4])});
            }

            writeData.flush();
            //Create an object of CSVReader class
            CSVReader readerEncrypt = new CSVReader(new FileReader(filePath2));

            String[] line;

            //Use while loop to read file
            while ((line = readerEncrypt.readNext()) !=null){
                System.out.printf("%-5s %-5s  %-16s %-5s %s\n", data[0], data[1], data[2], decrypt(data[3]), decrypt(data[4]));
            }

        }catch (IOException e) {//Catch block to handle IOException
            //Print the statement
            System.out.println("Error"+e.getMessage());
        } catch (CsvValidationException e) {//Catch block to handle CsvValidationException
            //Print the statement
            System.out.println("Error:" + e.getMessage());
        }

    }

    //Create a method encrypt
    private static String encrypt(String data) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : data.toCharArray()) {
            encrypted.append((char) (c + securityKey));
        }
        return encrypted.toString();
    }

    //Create a method decrypt
    private static String decrypt(String encryptedData) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : encryptedData.toCharArray()) {
            decrypted.append((char) (c - securityKey));
        }
        return decrypted.toString();
    }

}

//Create a class EncryptAndDecryptCSVData
public class EncryptAndDecryptCSVData {

    public static void main(String[] args) throws IOException {

        //Create a variable to store valye
        String filePath1 = "C:\\Week-05\\Day-01-JavaCSVDataHandling\\src\\main\\java\\com\\day01\\csvdatahandling\\EmployeeRecord.csv";
        String filePath2 = "C:\\Week-05\\Day-01-JavaCSVDataHandling\\src\\main\\java\\com\\day01\\csvdatahandling\\EncryptData.csv";

        //CAll the method
        EncryptAndDeCrypt.encryptAndDecryptData(filePath1,filePath2);
    }
}
