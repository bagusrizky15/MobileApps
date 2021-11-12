package com.example.mobileapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.widget.Button;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        TextView iniNama = (TextView) findViewById((R.id.iniNama));
        iniNama.setText(getIntent().getStringExtra(MainActivity.EXTRA_NAME));

        TextView iniHasil = (TextView) findViewById(R.id.iniHasil);

        Button buttonQuiz = (Button) findViewById(R.id.button_quiz);
        buttonQuiz.setOnClickListener(v ->{
            Intent gotoQuiz = new Intent(DashboardActivity.this, QuizActivity.class);
            startActivity(gotoQuiz);
        });

        Button buttonCall = (Button) findViewById(R.id.button_panggil);
        buttonCall.setOnClickListener(v ->{
            String number = "*123#";
            Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number));
            startActivity(callIntent);

        });

        Button buttonBack = (Button) findViewById(R.id.button_back);
        buttonBack.setOnClickListener(v ->{

            Intent backIntent = new Intent(DashboardActivity.this, MainActivity.class);
            startActivity(backIntent);

        });

    }
}