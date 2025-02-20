package com.day02.jsonhandling;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

//Create a class IPLMatch
class IPLMatch {

    //Create private variables to store value
    private String team1;
    private String team2;
    private String playerOfTheMatch;

    //Create Getter method
    public String getTeam1() {
        return team1;
    }

    //Create Setter method
    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    //Create Getter method
    public String getTeam2() {
        return team2;
    }

    //Create Setter method
    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    //Create Getter method
    public String getPlayerOfTheMatch() {
        return playerOfTheMatch;
    }

    //Create Setter method
    public void setPlayerOfTheMatch(String playerOfTheMatch) {
        this.playerOfTheMatch = playerOfTheMatch;
    }
}

//Create a class CensorAnalyzer to analyze the ipl match data
class CensorAnalyzer {

    //Create a static method to read JsonFile
    public static List<IPLMatch> readJsonFileData(String filePath) {
        //USe try block and create object of FileReader Class
        try (FileReader reader = new FileReader(filePath)) {
            //Create an object of TypeToken class
            Type listType = new TypeToken<List<IPLMatch>>() {
            }.getType();
            return new Gson().fromJson(reader, listType);
        } catch (IOException e) {//Catch block to handle exception
            //Print the statement
            System.out.println("Error " + e.getMessage());
            return null;
        }
    }

    //Create a static method to read CSV file
    public static List<IPLMatch> readCsvData(String filePath) {
        //USe try block and create object of CSVReader Class
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            //Create a list to store value
            List<String[]> lines = reader.readAll();
            return lines.stream()
                    .skip(1) // Skip header row
                    .map(line -> {
                        IPLMatch match = new IPLMatch();
                        match.setTeam1(line[0]);
                        match.setTeam2(line[1]);
                        match.setPlayerOfTheMatch(line[2]);
                        return match;
                    })
                    .toList();
        } catch (IOException | CsvException e) {//Catch block to handle exception
            //Print the statement
            System.out.println("Error " + e.getMessage());
            return null;
        }
    }

    //Create a static method to censor data
    public static List<IPLMatch> censorData(List<IPLMatch> matches) {
        for (IPLMatch match : matches) {
            match.setTeam1(censorTeamName(match.getTeam1()));
            match.setTeam2(censorTeamName(match.getTeam2()));
            match.setPlayerOfTheMatch("REDACTED");
        }
        return matches;
    }

    //Create a static method to censor team name
    public static String censorTeamName(String teamName) {
        //Create a variable to store value
        int spaceIndex = teamName.lastIndexOf(' ');
        return spaceIndex == -1 ? teamName : teamName.substring(0, spaceIndex) + " ***";
    }

    //Create a static method to write Json file  data
    public static void writeJsonFileData(String filePath, List<IPLMatch> matches) {
        //USe try block and create object of FileWriter Class
        try (FileWriter writer = new FileWriter(filePath)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(matches, writer);
        } catch (IOException e) {//Catch block to handle exception
            //Print the statement
            System.out.println("Error " + e.getMessage());
        }
    }

    //Create a static method ot write CSV file
    public static void writeCsvFileData(String filePath, List<IPLMatch> matches) {
        //USe try block and create object of CSVWriter Class
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            //Create an array to store value
            String[] header = {"Team1", "Team2", "PlayerOfTheMatch"};
            writer.writeNext(header);

            //Use for each loop
            for (IPLMatch match : matches) {
                writer.writeNext(new String[]{
                        match.getTeam1(),
                        match.getTeam2(),
                        match.getPlayerOfTheMatch()
                });
            }
        } catch (IOException e) {//Catch block to handle exception
            //Print the statement
            System.out.println("Error " + e.getMessage());
        }
    }
}

//Create a class IPLAndCensorAnalyzer
public class IPLAndCensorAnalyzer {
    public static void main(String[] args) {

        //Create a variable to store file path
        String jsonInputPath = "C:\\Week-05\\Day-02-JavaJSONHandling\\src\\main\\java\\com\\day02\\jsonhandling\\IPL_Matches.json";
        String csvInputPath = "C:\\Week-05\\Day-02-JavaJSONHandling\\src\\main\\java\\com\\day02\\jsonhandling\\IPL_Match.csv";
        String jsonOutputPath = "C:\\Week-05\\Day-02-JavaJSONHandling\\src\\main\\java\\com\\day02\\jsonhandling\\IPL_Generated_Data.json";
        String csvOutputPath = "C:\\Week-05\\Day-02-JavaJSONHandling\\src\\main\\java\\com\\day02\\jsonhandling\\IPL_Generated_Data.csv";

        //Create a list and call the method
        List<IPLMatch> jsonMatches = CensorAnalyzer.readJsonFileData(jsonInputPath);

        //Create a list and call the method
        List<IPLMatch> censoredJsonMatches = CensorAnalyzer.censorData(jsonMatches);

        //Call the method
        CensorAnalyzer.writeJsonFileData(jsonOutputPath, censoredJsonMatches);

        //Create a list and call the method
        List<IPLMatch> csvMatches = CensorAnalyzer.readCsvData(csvInputPath);

        //Create a list and call the method
        List<IPLMatch> censoredCsvMatches = CensorAnalyzer.censorData(csvMatches);

        //Call the method
        CensorAnalyzer.writeCsvFileData(csvOutputPath, censoredCsvMatches);

        //Print the result
        System.out.println("Censored JSON and CSV file successfully");
    }
}
