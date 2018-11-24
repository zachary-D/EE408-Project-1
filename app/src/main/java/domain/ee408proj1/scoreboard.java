package domain.ee408proj1;

import java.util.ArrayList;

class scoreboard {
    static void load(databaseManager srcDB) {
        db = srcDB;
        //TODO: implement lmao

        scores = db.getScoreboard();

        lastScore = new score("", 0, 0);
    }

    static private int maxScoresKept = 10;
    static private ArrayList<score> scores;
    static private score lastScore;
    static private databaseManager db;

    //TODO: Add a method to sort the board by highest score

    static score getScore(int index) {
        //TODO: Make sure we can't access an index greater than the last score
        return scores.get(index);
    }

    static score getLastScore() {
        return lastScore;
    }

    static void addScore(score newScore) {
        //If scores.size() >= maxScoresKept, drop the lowest score and add the new one.
        scores.add(newScore);
    }

    static void reset() {
        scores = new ArrayList<score>();
    }

    static int getNumScores()
    {
        return scores.size();
    }

    static double getScoreAverage()
    {
        double sum = 0;
        for(int i = 0; i < scores.size(); i++)
        {
            sum += (scores.get(i).correct / scores.get(i).total);
        }

        sum /= scores.size();

        return sum;
    }
}