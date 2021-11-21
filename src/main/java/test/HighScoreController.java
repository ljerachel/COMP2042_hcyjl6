package test;

import javax.swing.*;
import java.io.File;


/**
 * This class is the High Score Menu Controller which is used to control the Highscore menu
 */

public class HighScoreController{

    public static void inputdata()

    {

        String data[][] = {{"100", "Amit"},
                {"90", "Jai"},
                {"80", "Sachin"}};

        String column[] = {"Score", "Name"};
        /**
         * Highscore table
         */
        JTable HStable = new JTable(data, column);

        final String fileName = "src/main/resources/Misc/Highscore.csv";
        final File file = new File(fileName);
        exportToCSV ExportCSV = new exportToCSV();
        boolean exported = ExportCSV.export(HStable, "src/main/resources/Misc/Highscore.csv");
    }
        /**
         * Initializes the list
         */
        public void initList () {
            System.out.println("High Score is now loaded!");

        }


    }
