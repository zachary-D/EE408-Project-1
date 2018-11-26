package domain.ee408proj1;

import java.util.ArrayList;

public class masterQuestionList
{
	static void loadQuestions(databaseManager srcDB)
	{
		db = srcDB;

		questions = new questionList(db.getAllQuestions());
		questions.shuffle();
	}

	static private questionList questions;
	static private databaseManager db;
	
	static questionList getQuestionSet(int numQuestions)
	{
	    questions.shuffle();

		//if(numQuestions > totalQuestions) throw Exception("Number of questions requested is greater than the total number available!");

        ArrayList<question> qList = new ArrayList<question>();

		for(int i = 0; i < numQuestions; i++)
		{
			qList.add(questions.getQuestion(i));
		}
		
		return new questionList(qList);
	}
};