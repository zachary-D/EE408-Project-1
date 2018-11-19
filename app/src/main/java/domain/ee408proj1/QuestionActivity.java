package domain.ee408proj1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioButton;

public class QuestionActivity extends AppCompatActivity {

    private TextView question, showScore;
    private RadioGroup radioGroup;
    private RadioButton c1, c2, c3, c4;
    private Button quit, action;
    private int score;
    private int qNum;
    private int switchButton;

    quiz myQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        question = (TextView)findViewById(R.id.qBox);
        showScore = (TextView)findViewById(R.id.score);
        radioGroup = (RadioGroup)findViewById(R.id.group);
        c1 = (RadioButton)findViewById(R.id.choice1);
        c2 = (RadioButton)findViewById(R.id.choice2);
        c3 = (RadioButton)findViewById(R.id.choice3);
        c4 = (RadioButton)findViewById(R.id.choice4);
        quit = (Button)findViewById(R.id.quit);
        action = (Button)findViewById(R.id.action);
        score = 0;
        qNum = 1;
        switchButton = 0;

        action.setText("Submit");
        showScore.setText("Score: \n" +score + "/" + qNum);

        //addQuestion();
        normColor();
        myQuiz = new quiz (4);
    }

    public void actionButton( View v ) {
       if(radioGroup.getCheckedRadioButtonId()!= -1) { //checks to see if a radio button is checked
           if (switchButton == 0)  //SUBMIT button
           {
               int index;
               //Identify the index of the checked button
               for(index = 0; index < 4; index++) {
                   if(radioGroup.getCheckedRadioButtonId() == radioGroup.getChildAt(index).getId()) break;
               }


               //findViewById((radioGroup.getCheckedRadioButtonId())).

               //String radioText = ((RadioButton) findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();

               boolean isCorrect = myQuiz.getCurrent().check(index);

               //rgColor();
               showScore.setText("Score: \n" + score + "/" + qNum);
               switchButton = 1;
               action.setText("Next");
           }

           else if (switchButton == 1)  //NEXT button
           {
               if(qNum == 10)
                   leaveActivity();
               else {
                   normColor();
                   radioGroup.clearCheck();
                   addQuestion();
                   qNum++;
                   showScore.setText("Score: \n" + score + "/" + qNum);
                   switchButton = 0;
                   action.setText("Submit");
               }
           }
       }

    }

    public void addQuestion() {
        question.setText("Q" + qNum + ") " + myQuiz.getCurrent().getQuestion() );
        c1.setText(myQuiz.getCurrent().getAnswer(0));
        c2.setText(myQuiz.getCurrent().getAnswer(1));
        c3.setText(myQuiz.getCurrent().getAnswer(2));
        c4.setText(myQuiz.getCurrent().getAnswer(3));
    }

    public void normColor() { //turns choice background to normal color
       int norm = Color.parseColor("#99ccff");
       c1.setBackgroundColor(norm);
       c2.setBackgroundColor(norm);
       c3.setBackgroundColor(norm);
       c4.setBackgroundColor(norm);
    }

/*    public void rgColor() {  //highlights correct answer green, wrong red
        int green = Color.parseColor("#33ff33");
        int red = Color.parseColor("#ff6666");
        if(c1.getText().equals())
            c1.setBackgroundColor(green);
        else
            c1.setBackgroundColor(red);

        if(c2.getText().equals())
            c2.setBackgroundColor(green);
        else
            c2.setBackgroundColor(red);

        if(c3.getText().equals())
            c3.setBackgroundColor(green);
        else
            c3.setBackgroundColor(red);

        if(c4.getText().equals())
            c4.setBackgroundColor(green);
        else
            c4.setBackgroundColor(red);

    }*/


    public void quitButton( View v ) {
        AlertDialog alert = new AlertDialog.Builder( this ).create();
        alert.setTitle( "QUIT" );
        alert.setMessage( "Are you sure you want to quit the quiz?" );
        alert.setButton(DialogInterface.BUTTON_NEGATIVE,"No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        alert.setButton(DialogInterface.BUTTON_POSITIVE,"Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                leaveActivity();
                }
        });

        alert.show( );

    }

    public void leaveActivity()
    {
        Intent myIntent = new Intent( this, MainActivity.class );
        this.startActivity( myIntent );
    }

}
