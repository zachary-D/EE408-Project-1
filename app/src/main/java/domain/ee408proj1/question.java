package domain.ee408proj1;

public class question
{
	question()
	{
		answers = new String[4];
	}
	
	question(String _question, String[] _answers, int _correctAnswer)
	{
		answers = new String[4];
		//TODO: Add input validation for the array
		question = _question;
		for(int i = 0; i < 4; i++)
		{
			answers[i] = _answers[i];
		}
		correctAnswer = _correctAnswer;
	}
	
	private String question;
	private String[] answers;
	private int correctAnswer;
	
	String getQuestion()
	{
		return question;
	}
	
	String getAnswer(int index)
	{
		//TODO: Add input validation for 0<= index <= 3
		return answers[index]; 
	}
	
	void shuffle()
	{
		//TODO: Shuffle the answers around
	}
	
	boolean check(int index)
	{
		return correctAnswer == index;
	}	
}