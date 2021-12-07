package test;

public class IndividualScores implements Comparable{




    //private int ranking;
    private String name;
    private int highscore;


    public IndividualScores( String name , int highscore)
    {
      /*  ranking += 1;

        this.ranking= ranking;*/
        this.name = name;
        this.highscore = highscore;

    }

    public int getHighscore() {
        return highscore;
    }

    public int compareTo(Object b) {
        int comparescore = ((IndividualScores)b).getHighscore();
        //return this.highscore - comparescore;
        return -(this.highscore -comparescore) ;
    }


    public String getName() {
        return name;
    }

 /*   public int getRanking() {
        return ranking;
    }*/

}
