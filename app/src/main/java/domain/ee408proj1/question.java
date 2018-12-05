package domain.ee408proj1;

import java.util.ArrayList;
import java.util.Random;

public class question
{
	question()
	{
		answers = new ArrayList<String>();
	}
	
	question(String question, ArrayList<String> answers, int correctAnswer)
	{
		this.question = question;
		this.answers = answers;
		this.correctAnswer = correctAnswer;
	}
	
	private String question;
	private ArrayList<String> answers;
	private int correctAnswer;
	
	String getQuestion()
	{
		return question;
	}
	
	String getAnswer(int index)
	{
		//TODO: Add input validation for 0<= index <= 3
		return answers.get(index);
	}

	String getCorrectAnswer()
	{
		return answers.get(correctAnswer);
	}
	
	void shuffle()
	{
		ArrayList<String> oldAns = answers;
		answers = new ArrayList<String>();
		Random rand = new Random();

		boolean correctAnsSet = false;

		while(oldAns.size() > 0)
		{
			int pos = rand.nextInt(oldAns.size());
			answers.add(oldAns.get(pos));
			oldAns.remove(pos);
			//This moves the correct answer back so we don't loose its place
			if(correctAnsSet == false) {
				if (correctAnswer > pos) correctAnswer--;
				else if (correctAnswer == pos) {
					correctAnswer = answers.size() - 1;
					correctAnsSet = true;
				}
			}
		}
	}

	boolean check(int index)
	{
		return correctAnswer == index;
	}	
}
