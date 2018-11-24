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
    score lastScore;

    private databaseManager db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new databaseManager(this);


        masterQuestionList.loadQuestions(db);
        scoreboard.load(db);




        startQuiz = (Button) findViewById(R.id.startQuiz);

        View.OnClickListener sQListen = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                fn_startQuiz(v);
            }

        };

        startQuiz.setOnClickListener(sQListen);

        Description = (TextView) findViewById(R.id.Description);
        Score = (TextView) findViewById(R.id.Score);

        updateScoreBoard();






        }

    public void fn_startQuiz( View v ) {
        Intent myIntent = new Intent( this, QuestionActivity.class );
        this.startActivity( myIntent );
    }

    public void updateScoreBoard() {
        Score.setText("Score: " + scoreboard.getLastScore().correct + "/" + scoreboard.getLastScore().total);
    }
}

