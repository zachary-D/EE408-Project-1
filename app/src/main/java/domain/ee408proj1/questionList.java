package domain.ee408proj1;

import java.util.ArrayList;
import java.util.Random;

public class questionList
{
	questionList(){ questions = new ArrayList<question>(); }
	
	questionList(ArrayList<question> questions)
	{
		this.questions = questions;
	}

	private ArrayList<question> questions;
	
	question getQuestion(int index)
	{
		//TODO: Input validation for 0 <= index < numQuestions
		return questions.get(index);
	}
	
	void shuffle()
	{
        ArrayList<question> oldList = questions;

        questions = new ArrayList<question>();

        Random rand = new Random();

        //Shuffle the questions themselves
        while(oldList.size() > 0) {
            int pos = rand.nextInt(oldList.size());
            questions.add(oldList.get(pos));
            oldList.remove(pos);
        }

        //Shuffle the answers within the questions
        for(int i = 0; i < questions.size(); i++) {
            questions.get(i).shuffle();
        }

		//TODO: Shuffle the order of the questions, and call shuffle() on each one of them.

	}
}
