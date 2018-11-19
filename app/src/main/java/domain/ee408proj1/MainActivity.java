package domain.ee408proj1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView Description;
    private TextView Score;
    private Button startQuiz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        masterQuestionList.loadQuestions();
        scoreboard.load();




        startQuiz = (Button) findViewById(R.id.startQuiz);

        Description = (TextView) findViewById(R.id.Description);
        Score = (TextView) findViewById(R.id.Score);


        Score.setText("Score: ");

        View.OnClickListener lDo = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent( this, QuestionActivity.class );
                this.startActivity( myIntent );
            }
        };

        startQuiz.setOnClickListener(lDo);

    }

    public void change( View v ) {
        Intent myIntent = new Intent( this, QuestionActivity.class );
        this.startActivity( myIntent );
    }
}

