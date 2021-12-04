package test;

import java.io.*;



public class WriteIntoFile {
    private int ranking = 1  ;  // rank according to high scores
    private String name ;
    private int highscore;



    public WriteIntoFile() throws IOException {

        highscore = Wall.getFinalhighscore();


        File a = new File("src/main/resources/Misc/Highscore.csv");


        FileWriter writer = new FileWriter(a, true);

        BufferedWriter bw = new BufferedWriter(writer);



        for (int i = 0; i < 10; i++) {

            if (a != null) {

                writer.append(GameBoard.getname());
                writer.append(',');
                writer.append(String.valueOf(highscore));
                writer.append(',');
                writer.append(String.valueOf(ranking));
                writer.append('\n');


                writer.close();


                System.out.println("success");
            }

            else {ranking = i ;}

        }

    }


}
