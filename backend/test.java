

public class test
{
	public static void main()
	{
		//Prepare a 20-element quiz
		quiz myQuiz(20);
		
		//Loop for each question
		for(int i = 0; i < 20; i++)
		{
			System.out.println("Here is your question:");
			
			//get the prompt for the current question
			System.out.println(myQuiz.getCurrent().question);
			
			//Display the answers
			System.out.println("");
			System.out.println("Here are your options:");
			for(int i = 0; i < 4; i++)
			{
				System.out.print(Character.toDigit('a' + i));
				System.out.print(") ");
				System.out.println(myQuiz.getCurrent().getAnswer(i);
			}
			
			System.out.println("");
			System.out.println("What is your answer?");
			
			//Get input here
			int answer = 2;	//We'll assume the answer is 2.  Because I'm too lazy to get input.
			
			if(myQuiz.checkAnswer(2))
			{
				System.out.println("You chose correctly!");
			}
			else
			{
				System.out.println("WRONG");
			}
			
			//Move to the next question
			quiz.advanceQuestion();
		}
		
		//Push our results to the scoreboard, deallocate arrays, and general cleanup.
		quiz.closeQuiz();
	}	
}