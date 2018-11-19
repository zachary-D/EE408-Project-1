public static class masterQuestionList
{
	void loadQuestions()
	{
		//TODO: Make an actual db read/write code, for now hard-code it for testing
		totalQuestions = 5;
		questions = new question[totalQuestions];
		
		
		for(int i = 0; i < totalQuestions; i++)
		{
			String[] ans = new String[4];
			for(int j = 0; j < 4; j++)
			{
				ans[j] = String("Ans").concat(Integer.toString(j)).concat("for q").concat(Integer.toString(i));
			}
			
			questions[i] = question( String("question").concat(Integer.toString(i)), ans, i%4);
		}
	}
	
	
	private question[] questions;
	int totalQuestions;
	
	questionList getQuestionSet(int numQuestions)
	{
		//TODO: In the future, add support to pick a random start point in the list of questions to start so we don't always use the exact same questions over and over
		
		if(numQuestions > totalQuestions) throw Exception("Number of questions requested is greater than the total number available!");
		
		question[] newListEntries = new question[numQuestions];
		
		for(int i = 0; i < numQuestions; i++)
		{
			newListEntries[i] = questions[i];
		}
		
		return questionList(numQuestions, newListEntries);
	}
};