package domain.ee408proj1;

public class questionList
{
	questionList()
	{
		numQuestions = 0;
	}
	
	questionList(int _numQuestions, question[] _questions)
	{
		numQuestions = _numQuestions;
		questions = new question[numQuestions];
		for(int i = 0; i < numQuestions; i++)
		{
			questions[i] = _questions[i];
		}
	}
	
	private question[] questions;
	private int numQuestions;
	
	question getQuestion(int index)
	{
		//TODO: Input validation for 0 <= index < numQuestions
		return questions[index];
	}
	
	void shuffle()
	{
		//TODO: Shuffle the order of the questions, and call shuffle() on each one of them.
		
	}
}
