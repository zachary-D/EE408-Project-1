package domain.ee408proj1;

class scoreboard {
    static void load() {
        //TODO: implement lmao

        numScores = 0;
        if (numScores > 0) scores = new score[numScores];

        lastScore = new score("", 0, 0);
    }


    static private score[] scores;
    static private int numScores;
    static private score lastScore;

    static score getScore(int index) {
        //TODO: Make sure we can't access an index greater than the last score
        return scores[index];
    }

    static score getLastScore() {
        return lastScore;
    }

    static void addScore(score newScore) {
        score[] oldScores = new score[numScores];
        oldScores = scores;

        scores = new score[numScores + 1];

        for (int i = 0; i < numScores; i++) {
            scores[i] = oldScores[i];
        }
        scores[numScores] = newScore;
        lastScore = newScore;
        numScores++;
    }

    static void reset() {
        numScores = 0;
        scores = null;
    }

    static int getNumScores()
    {
        return numScores;
    }

    static double getScoreAverage()
    {
        double sum = 0;
        for(int i = 0; i < numScores; i++)
        {
            sum += (scores[i].correct / scores[i].total);
        }

        sum /= numScores;

        return sum;
    }
}