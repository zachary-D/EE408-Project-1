class questionList
{
	questionList()
	{
		numQuestions = 0;
	}
	
	questionList(int _numQuestions, question[] _questions)
	{
		numQuestions = _numQuestions;
		questions = new questions[numQuestions];
		for(int i = 0; i < numQuestions; ++)
		{
			questions[i] = _questions[i];
		}
	}
	
private:
	question[] questions;
	int numQuestions;
	
public:
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