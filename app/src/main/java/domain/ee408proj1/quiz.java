package domain.ee408proj1;

public class quiz
{
	quiz()
	{
		totalQuestions = 0;
	}

	quiz(int numQuestions)
	{
		//TODO: Add checking to make sure that 'numQuestions' isn't greater that the maximum number of questions in masterQuestionList.java
		totalQuestions = numQuestions;

		getFromMaster(totalQuestions);

		numCorrect = 0;
		currentQuestion = 0;
	}

	private questionList questions;
	private int numCorrect;
	private int totalQuestions;
	private int currentQuestion;


	private void getFromMaster(int numQuestions)
	{
		questions = masterQuestionList.getQuestionSet(numQuestions);
	}


	question getCurrent()
	{
		return questions.getQuestion(currentQuestion);
	}

	boolean checkAnswer(int answer)
	{
		if(getCurrent().check(answer))
		{
			numCorrect++;
			return true;
		}
		else return false;
	}

	void advanceQuestion()
	{
		currentQuestion++;
	}

	int getCurrentIndex() { return currentQuestion; }
	int getNumRight()
	{
		return numCorrect;
	}
	int getNumQuestions() { return totalQuestions; }


	
	void closeQuiz()
	{
		scoreboard.addScore(new score("tempname", numCorrect, totalQuestions));
	}
}