package domain.ee408proj1;

import java.util.ArrayList;

public class masterQuestionList
{
	static void loadQuestions(databaseManager srcDB)
	{
		db = srcDB;

		questions = db.getAllQuestions();
	}

	static private ArrayList<question> questions;
	static private databaseManager db;
	
	static questionList getQuestionSet(int numQuestions)
	{
		//TODO: In the future, add support to pick a random start point in the list of questions to start so we don't always use the exact same questions over and over
		
		//if(numQuestions > totalQuestions) throw Exception("Number of questions requested is greater than the total number available!");

        ArrayList<question> qList = new ArrayList<question>();

		for(int i = 0; i < numQuestions; i++)
		{
			qList.add(questions.get(i));
		}
		
		return new questionList(qList);
	}
};