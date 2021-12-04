package test;



import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * read and arrange file in array list
 */
public class ReadFile {



    private int ranking = 1  ;
    private String name;
    private int highscore;

    public static ArrayList<IndividualScores> getaList() {
        return aList;
    }

    private static ArrayList<IndividualScores> aList = new ArrayList<IndividualScores>();
    //private static ArrayList<IndividualScores> aList = new ArrayList<IndividualScores>();
    String row  = "";

    public ReadFile() throws IOException {


        File a = new File("src/main/resources/Misc/Highscore.csv");

        BufferedReader csvread ;

            csvread = new BufferedReader(new FileReader(a));




            for(int i = 0; i < 9  ; i ++)  //
            {  // this loop is the problem

                    row = csvread.readLine();
                    System.out.println(row);

                    if(row!= null) {
                        String[] data = row.split(",");

                        //ranking = Integer.parseInt(data[2]) ;

                        name = data[0];

                        highscore = Integer.parseInt(data[1]);

                        aList.add(new IndividualScores(name, highscore));


                    }
                }
//            }

            Collections.sort(aList);  // sort file

        FileWriter writer = new FileWriter(a);



        for(IndividualScores score: aList ) {
            writer.write( score.getName() + ',' + score.getHighscore() +','+ ranking + '\n');
            ranking += 1;  // write again to the file
        }


        writer.close();


    }





    }



