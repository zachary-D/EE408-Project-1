package domain.ee408proj1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        masterQuestionList.loadQuestions();
        scoreboard.load();



    }

    public void change( View v ) {
        Intent myIntent = new Intent( this, QuestionActivity.class );
        this.startActivity( myIntent );
    }
}
