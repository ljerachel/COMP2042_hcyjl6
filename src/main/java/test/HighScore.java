package test;


public class HighScore {

    private int ScoreColumn;
    private String nameColumn;
    private int levelColumn;

    public HighScore(String nameColumn, int levelColumn, int ScoreColumn){
        this.ScoreColumn = ScoreColumn;
        this.nameColumn = nameColumn;
        this.levelColumn = levelColumn;
    }
    public int getScoreColumn() {
        return ScoreColumn;
    }

    public void setScoreColumn(int scoreColumn) {
        ScoreColumn = scoreColumn;
    }


    public String getNameColumn() {
        return nameColumn;
    }

    public void setNameColumn(String nameColumn) {
        this.nameColumn = nameColumn;
    }

    public int getLevelColumn() {
        return levelColumn;
    }

    public void setLevelColumn(int levelColumn) {
        this.levelColumn = levelColumn;
    }



}
