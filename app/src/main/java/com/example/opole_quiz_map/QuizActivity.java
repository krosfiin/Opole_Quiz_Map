package com.example.opole_quiz_map;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.view.LayoutInflater;
import android.widget.Toast;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;
import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private LinearLayout mLinearLayout;
    private QuestionsLibrary mQuestionsLibrary = new QuestionsLibrary();
    private Context mContext;
    private TextView mScoreView;
    private TextView mCongratzView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonQuit;
    private DBUserAdapter dbUserAdapter;
    UserData userData = UserData.getInstance();
    private String mAnswer;
    private Integer mPointNumber;
    private Integer mScore = 0;
    private Integer oldScore;
    QuestionQuizHelper questionQuizHelper;
    QuestionQuiz currentQuestion;
    List<QuestionQuiz> list;
    private int mQuestionNumber = 0;
    private PopupWindow mPopupWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mContext = getApplicationContext();
        mLinearLayout = (LinearLayout) findViewById(R.id.activity_quiz);
        String name = getIntent().getStringExtra("Name");
        mScoreView = (TextView) findViewById(R.id.score);
        mQuestionView = (TextView) findViewById(R.id.question);
        mButtonChoice1 = (Button) findViewById(R.id.choice1);
        mButtonChoice2 = (Button) findViewById(R.id.choice2);
        mButtonChoice3 = (Button) findViewById(R.id.choice3);
        mButtonQuit = findViewById(R.id.quit_button);
        mPointNumber = mQuestionsLibrary.getPoint(name);
        updateScore(0);
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.custom_popup,null);

        mPopupWindow = new PopupWindow(
                customView,
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
        );
        // Get a reference for the custom view close button
        ImageButton mButtonClosePopUp = (ImageButton) customView.findViewById(R.id.ib_close);
        mCongratzView = customView.findViewById(R.id.tv);

        // Set a click listener for the popup window close button
        mButtonClosePopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Dismiss the popup window
                mPopupWindow.dismiss();
                finish();
            }
        });


        dbUserAdapter = new DBUserAdapter(this);
        questionQuizHelper = new QuestionQuizHelper(this);
        questionQuizHelper.getWritableDatabase();

        oldScore = userData.getScore(mPointNumber);
        if (questionQuizHelper.checkDBquestions() == 0) {
            //If not added then add the ques,options in table
            questionQuizHelper.allQuestion();
        }
        list = questionQuizHelper.getAllOfTheQuestions(name);
        updateQuestion();
        updateScore(oldScore);
        //Start of Button Listener for Button1
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //My logic for Button goes in here
                if (mQuestionNumber < 6) {
                    if (mButtonChoice1.getText().equals(mAnswer)) {
                        mScore = mScore + 1;
                        //This line of code is optional
                        mButtonChoice1.setBackgroundColor(Color.GREEN);
                        Snackbar.make(mButtonQuit, "Correct", 1).show();

                    } else {
                        mButtonChoice1.setBackgroundColor(Color.RED);
                        Snackbar.make(mButtonQuit, "Wrong", 1).show();

                    }
                    onPause();
                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    mButtonChoice1.setBackgroundColor(Color.parseColor("#0091EA"));
                                    if (mQuestionNumber < 5){
                                        updateQuestion();
                                    }else{
                                        mCongratzView.setText("Congratulation your score is " + mScore);
                                        mPopupWindow.showAtLocation(mLinearLayout, Gravity.CENTER,0,0);
                                        dbUserAdapter.updateScore(mPointNumber, userData.email, mScore);
                                        userData.setScore(mPointNumber, mScore);
                                        mQuestionNumber ++;
                                    }
                                    onResume();
                                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                                }
                            }, 1000);
                } else {
                    Toast.makeText(QuizActivity.this, "Your score : " + mScore, Toast.LENGTH_LONG).show();
                }

            }
        });

        //End of Button Listener for Button1

        //Start of Button Listener for Button2
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //My logic for Button goes in here
                if (mQuestionNumber < 6) {
                    if (mButtonChoice2.getText().equals(mAnswer)) {
                        mScore = mScore + 1;
                        //This line of code is optional
                        mButtonChoice2.setBackgroundColor(Color.GREEN);
                        Snackbar.make(mButtonQuit, "Correct", 1).show();

                    } else {
                        mButtonChoice2.setBackgroundColor(Color.RED);
                        Snackbar.make(mButtonQuit, "Wrong", 1).show();

                    }
                    onPause();
                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    mButtonChoice2.setBackgroundColor(Color.parseColor("#0091EA"));
                                    if (mQuestionNumber < 5){
                                        updateQuestion();
                                    }else{
                                        mCongratzView.setText("Congratulation your score is " + mScore);
                                        mPopupWindow.showAtLocation(mLinearLayout, Gravity.CENTER,0,0);
                                        dbUserAdapter.updateScore(mPointNumber, userData.email, mScore);
                                        userData.setScore(mPointNumber, mScore);
                                        mQuestionNumber ++;
                                    }
                                    onResume();
                                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                                }
                            }, 500);
                } else {
                    Toast.makeText(QuizActivity.this, "Your score : " + mScore, Toast.LENGTH_LONG).show();
                }
            }
        });

        //End of Button Listener for Button2


        //Start of Button Listener for Button3
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //My logic for Button goes in here
                if (mQuestionNumber < 6) {
                    if (mButtonChoice3.getText().equals(mAnswer)) {
                        mScore = mScore + 1;
                        //This line of code is optional
                        mButtonChoice3.setBackgroundColor(Color.GREEN);
                        Snackbar.make(mButtonQuit, "Correct", 1).show();
                    } else {
                        mButtonChoice3.setBackgroundColor(Color.RED);
                        Snackbar.make(mButtonQuit, "Wrong", 1).show();
                    }
                    onPause();
                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    mButtonChoice3.setBackgroundColor(Color.parseColor("#0091EA"));
                                    if (mQuestionNumber < 5){
                                        updateQuestion();
                                    }else{
                                        mCongratzView.setText("Congratulation your score is " + mScore);
                                        mPopupWindow.showAtLocation(mLinearLayout, Gravity.CENTER,0,0);
                                        dbUserAdapter.updateScore(mPointNumber, userData.email, mScore);
                                        userData.setScore(mPointNumber, mScore);
                                        mQuestionNumber ++;
                                    }
                                    onResume();
                                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                                }
                            }, 500);
                } else {
                    Toast.makeText(QuizActivity.this, "Your score : " + mScore, Toast.LENGTH_LONG).show();
                }

            }
        });

        mButtonQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userData.setScore(mPointNumber, mScore);
                dbUserAdapter.updateScore(mPointNumber, userData.email, mScore);
                finish();
            }
        });


    }

    private void updateQuestion() {
        currentQuestion = list.get(mQuestionNumber);
        mQuestionView.setText(currentQuestion.getQuestion());
        mButtonChoice1.setText(currentQuestion.getOptA());
        mButtonChoice2.setText(currentQuestion.getOptB());
        mButtonChoice3.setText(currentQuestion.getOptC());
        mAnswer = currentQuestion.getAnswer();
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
