package test;

import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
//import java.io.File;

public class ModifyFile {
    private int ranking =1 ;
    private String name = "rachel";
    private int highscore = 5;



    public ModifyFile() throws IOException {

        highscore = Wall.getFinalhighscore();


        File a = new File("src/main/resources/Misc/Highscore.csv");

        FileWriter writer = new FileWriter(a);
        BufferedReader csvread = new BufferedReader(new FileReader(a)) ;

        String[] data = row.split(",");
        if (a != null)
        {

            String[] header = {"ranking", "name","High Score"};
            String[] data = {String.valueOf(ranking), name , String.valueOf(highscore)} ;
            writer.write(String.valueOf(header));
            writer.write(String.);
            writer.append((char) Wall.getFinalhighscore()) ;

            System.out.println();
            writer.close();
        }

        else {
            System.out.println("file already there");

        }

    }

}
