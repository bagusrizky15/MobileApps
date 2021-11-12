package com.example.mobileapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;

public class QuizActivity extends AppCompatActivity {

    public static final String EXTRA_ANSWER = "extra_answer";
    public static final int RESULT_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        RadioGroup rgJawab = (RadioGroup) findViewById(R.id.rd_number);

        Button buttonJawab = (Button) findViewById(R.id.button_jawab);
        buttonJawab.setOnClickListener(v ->{
            int answer = 0;
            if(rgJawab.getCheckedRadioButtonId() != 0){
                int id = rgJawab.getCheckedRadioButtonId();
                if(id == R.id.rb_3)
                    answer = 1;
            }


            Intent hasilIntent = new Intent();
            hasilIntent.putExtra(EXTRA_ANSWER, answer);
            setResult(RESULT_CODE, hasilIntent);
            finish();

        });


    }
}