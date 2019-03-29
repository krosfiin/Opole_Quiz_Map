package com.example.opole_quiz_map;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        String name = getIntent().getStringExtra("Name");
        Toast.makeText(this, name , Toast.LENGTH_LONG).show();
    }
}
