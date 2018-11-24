package domain.ee408proj1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class databaseManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "appDB";
    private static final int DATABASE_VERSION = 2;

    //DB table headers for the 'questions' table
    private static final String TABLE_QU = "questions";
    private static final String QU_id = "id";
    private static final String QU_ques = "question";
    private static final String QU_ans = "answer";
    private static final String QU_incor1 = "incorA";
    private static final String QU_incor2 = "incorB";
    private static final String QU_incor3 = "incorC";

    //DB table headers for the scoreboard table
    private static final String TABLE_sboard = "scoreboard";
    private static final String sboard_id = "id";
    private static final String sboard_name = "name";
    private static final String sboard_corr = "numCorrect";
    private static final String sboard_total = "totalQuestions";


    public databaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {

        //Create the 'questions' table
        String create = "create table " + TABLE_QU + "(" + QU_id;
        create += " integer primary key autoincrement, " + QU_ques;
        create += " text, " + QU_ans + " text, " + QU_incor1 + " text, " + QU_incor2 + " text, ";
        create += QU_incor3 + " text)";

        db.execSQL(create);


        //Create the 'scoreboard' table
        create = "create table " + TABLE_sboard + "( " + sboard_id + " integer primary key autoincrement, ";
        create += sboard_name + " text, " + sboard_corr + " integer, " + sboard_total + " text)";

        db.execSQL(create);


        //Add the default questions
        db.execSQL("insert into " + TABLE_QU + " values(null, 'What is the 1st Planet from the Sun?', 'Mercury', 'Neptune', 'Earth', 'Jupiter')");
        db.execSQL("insert into " + TABLE_QU + " values(null, 'What is the 2nd Planet from the Sun', 'Venus', 'Mercury', 'Uranus', 'Neptune')");
        db.execSQL("insert into " + TABLE_QU + " values(null, 'What is the 3rd Planet from the Sun?', 'Earth', 'Saturn', 'Venus', 'Neptune')");
        db.execSQL("insert into " + TABLE_QU + " values(null, 'What is the 4th Planet from the Sun?', 'Mars', 'Venus', 'Uranus', 'Saturn')");
        db.execSQL("insert into " + TABLE_QU + " values(null, 'What is the 5th Planet from the Sun', 'Jupiter', 'Mars', 'Uranus', 'Saturn')");
        db.execSQL("insert into " + TABLE_QU + " values(null, 'What is the 6th Planet from the Sun', 'Saturn', 'Neptune', 'Earth', 'Jupiter')");
        db.execSQL("insert into " + TABLE_QU + " values(null, 'What is the 7th Planet from the Sun?', 'Uranus', 'Saturn', 'Venus', 'Mars')");
        db.execSQL("insert into " + TABLE_QU + " values(null, 'What is the 8th Planet from the Sun?', 'Neptune', 'Mercury', 'Jupiter', 'Earth')");
        db.execSQL("insert into " + TABLE_QU + " values(null, 'How many known planets are there in the Solar System?', '8', '5', '7', '11')");
        db.execSQL("insert into " + TABLE_QU + " values(null, 'What is the largest planet in the Solar System?', 'Jupiter', 'Earth', 'Saturn', 'Uranus')");
        db.execSQL("insert into " + TABLE_QU + " values(null, 'What is the Sun?', 'Star', 'Planet', 'Moon', 'Black hole')");
        db.execSQL("insert into " + TABLE_QU + " values(null, 'How long does it take the Earth to revolve around the sun?', '365 Days', '180 Days', '730 Days', '1 Day')");
        db.execSQL("insert into " + TABLE_QU + " values(null, 'All of the following are inner planets except?', 'Neptune', 'Earth', 'Mars', 'Venus')");
        db.execSQL("insert into " + TABLE_QU + " values(null, 'What sepeartes the inner and outer planets?', 'The Astroid Belt', 'Mars', 'Jupiter', 'Halley''s Commet')");
        db.execSQL("insert into " + TABLE_QU + " values(null, 'What is at the center of the Solar System?', 'The Sun', 'Earth', 'Jupiter', 'Pluto')");
        db.execSQL("insert into " + TABLE_QU + " values(null, 'Our solar system is located in which galaxy?', 'The Milky Way', 'Andromeda ', 'M32', 'Triangulum')");
        db.execSQL("insert into " + TABLE_QU + " values(null, 'What is the smallest planet in the Solar System?', 'Mercury', 'Earth', 'Mars', 'Neptune')");
        db.execSQL("insert into " + TABLE_QU + " values(null, 'What type of force is holding us to the Earth?', 'gravity', 'tension', 'friction', 'magnetic')");
        db.execSQL("insert into " + TABLE_QU + " values(null, 'What is the hottest planet in our solar system?', 'Venus', 'Mercury', 'Mars', 'Saturn')");
        db.execSQL("insert into " + TABLE_QU + " values(null, 'Which one of these used to be a planet?', 'Pluto', 'Ceres', 'Eris', 'Sedna')");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_QU);
        db.execSQL("drop table if exists " + TABLE_sboard);

        onCreate(db);
    }

    public void addQuestion(question newQuestion) {
        SQLiteDatabase db = this.getWritableDatabase();

        String insert = "insert into " + TABLE_QU;
        insert += " values( null, '" + newQuestion.getQuestion() + "', ";
        insert += "'" + newQuestion.getCorrectAnswer() + "', ";

        int ansAdded = 0;

        for (int i = 0; i < 4; i++) {
            if (newQuestion.check(i)) continue;
            insert += "'" + newQuestion.getAnswer(i);
            ansAdded++;
            if (ansAdded < 3) insert += "', ";
            else insert += "'";
        }

        insert += " )";

        db.execSQL(insert);
    }

    public ArrayList<question> getAllQuestions()
    {
        ArrayList questions = new ArrayList<question>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_QU, null);

        while(cursor.moveToNext())
        {
            String ans[] = new String[4];

            for(int i = 2; i < 6; i++)
            {
                ans[i-2] = cursor.getString(i);
            }

            questions.add( new question(cursor.getString(1), ans, 0));
        }

        return questions;
    }

    public ArrayList<score> getScoreboard()
    {
        ArrayList scoreboard = new ArrayList<score> ();

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from " + TABLE_sboard, null);

        while(cursor.moveToNext()) {
            scoreboard.add(
                    new score(
                            cursor.getString(0),
                            Integer.parseInt(cursor.getString(1)),
                            Integer.parseInt(cursor.getString(2))
                   ));
        }

        return scoreboard;
    }
}
