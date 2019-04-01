package com.example.opole_quiz_map;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    private QuestionsLibrary mQuestionsLibrary = new QuestionsLibrary();

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonQuit;
    private DBUserAdapter dbUserAdapter;
    UserData userData = UserData.getInstance();
    private String mAnswer;
    private int mScore = userData.getScore();
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        String name = getIntent().getStringExtra("Name");
        Toast.makeText(this, name, Toast.LENGTH_LONG).show();
        mScoreView = (TextView) findViewById(R.id.score);
        mQuestionView = (TextView) findViewById(R.id.question);
        mButtonChoice1 = (Button) findViewById(R.id.choice1);
        mButtonChoice2 = (Button) findViewById(R.id.choice2);
        mButtonChoice3 = (Button) findViewById(R.id.choice3);
        mButtonQuit = findViewById(R.id.quit_button);
        updateQuestion();
        dbUserAdapter = new DBUserAdapter(this);
        updateScore(mScore);
        //Start of Button Listener for Button1
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //My logic for Button goes in here
                if (mQuestionNumber < 5) {
                    if (mButtonChoice1.getText() == mAnswer) {
                        mScore = mScore + 1;
                        userData.setScore(mScore);
                        updateScore(mScore);
                        //This line of code is optional
                        mButtonChoice1.setBackgroundColor(Color.GREEN);
                        Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();

                    } else {
                        mButtonChoice1.setBackgroundColor(Color.RED);
                        Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();

                    }
                    onPause();
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    mButtonChoice1.setBackgroundColor(Color.parseColor("#0091EA"));
                                    if (mQuestionNumber < 4){
                                        updateQuestion();
                                    }else{
                                        dbUserAdapter.updateScore(userData.email, mScore);
                                        mQuestionNumber ++;
                                    }
                                    onResume();
                                }
                            }, 500);
                } else {
                    Toast.makeText(QuizActivity.this, "Twój wynik : " + mScore, Toast.LENGTH_LONG).show();
                }

            }
        });

        //End of Button Listener for Button1

        //Start of Button Listener for Button2
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //My logic for Button goes in here
                if (mQuestionNumber < 5) {
                    if (mButtonChoice2.getText() == mAnswer) {
                        mScore = mScore + 1;
                        userData.setScore(mScore);
                        updateScore(mScore);
                        //This line of code is optional
                        mButtonChoice2.setBackgroundColor(Color.GREEN);
                        Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();

                    } else {
                        mButtonChoice2.setBackgroundColor(Color.RED);
                        Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();

                    }
                    onPause();
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    mButtonChoice2.setBackgroundColor(Color.parseColor("#0091EA"));
                                    if (mQuestionNumber < 4){
                                        updateQuestion();
                                    }else{
                                        dbUserAdapter.updateScore(userData.email, mScore);
                                        mQuestionNumber ++;
                                    }
                                    onResume();
                                }
                            }, 500);
                } else {
                    //Toast.makeText(QuizActivity.this, "Twój wynik : " + userData.email + " " + mScore , Toast.LENGTH_LONG).show();
                    dbUserAdapter.updateScore(userData.email, mScore);
                    Toast.makeText(QuizActivity.this, "Twój wynik : " + mScore, Toast.LENGTH_LONG).show();
                }
            }
        });

        //End of Button Listener for Button2


        //Start of Button Listener for Button3
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //My logic for Button goes in here
                if (mQuestionNumber < 5) {
                    if (mButtonChoice3.getText() == mAnswer) {
                        mScore = mScore + 1;
                        updateScore(mScore);
                        userData.setScore(mScore);
                        //This line of code is optional
                        mButtonChoice3.setBackgroundColor(Color.GREEN);
                        Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();

                    } else {
                        mButtonChoice3.setBackgroundColor(Color.RED);
                        Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();

                    }
                    onPause();
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    mButtonChoice3.setBackgroundColor(Color.parseColor("#0091EA"));
                                    if (mQuestionNumber < 4){
                                        updateQuestion();
                                    }else{
                                        dbUserAdapter.updateScore(userData.email, mScore);
                                        mQuestionNumber ++;
                                    }
                                    onResume();
                                }
                            }, 500);
                } else {
                    dbUserAdapter.updateScore(userData.email, mScore);
                    Toast.makeText(QuizActivity.this, "Twój wynik : " + mScore, Toast.LENGTH_LONG).show();
                }

            }
        });

        mButtonQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbUserAdapter.updateScore(userData.email, mScore);
                finish();
            }
        });


    }

    private void updateQuestion() {
        mQuestionView.setText(mQuestionsLibrary.getQuestion(mQuestionNumber));
        mButtonChoice1.setText(mQuestionsLibrary.getChoice1(mQuestionNumber));
        mButtonChoice2.setText(mQuestionsLibrary.getChoice2(mQuestionNumber));
        mButtonChoice3.setText(mQuestionsLibrary.getChoice3(mQuestionNumber));

        mAnswer = mQuestionsLibrary.getCorrectAnswer(mQuestionNumber);
        mQuestionNumber++;


    }


    private void updateScore(int point) {
        mScoreView.setText("" + point);
    }

    @Override
    public void onPause() {
        super.onPause();  // Always call the superclass method first
    }
    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first
    }
}
