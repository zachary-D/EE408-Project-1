class quiz
{
public:
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
	
private:
	questionList questions;
	int numCorrect;
	int totalQuestions;
	int currentQuestion;
	
	
	void getFromMaster(int numQuestions)
	{
		
	}
	
public:
	
	question getCurrent();
	boolean checkAnswer(int answer)
	{
		if(getCurrent().check(answer))
		{
			numCorrect++;
			return true;
		}
		else return false;		
	}
	
	void advanceQuestion();
	
	double getGrade();
	
	void closeQuiz()
	{

	}
}