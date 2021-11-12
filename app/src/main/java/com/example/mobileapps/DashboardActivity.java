package com.example.mobileapps;

import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.widget.Button;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DashboardActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> resultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        TextView iniNama = (TextView) findViewById((R.id.iniNama));
        iniNama.setText(getIntent().getStringExtra(MainActivity.EXTRA_NAME));

        TextView iniHasil = (TextView) findViewById(R.id.iniHasil);
        resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
            if (result.getResultCode() == QuizActivity.RESULT_CODE && result.getData() != null){
                int answer = result.getData().getIntExtra(QuizActivity.EXTRA_ANSWER, 0);
                if(answer == 1)
                    iniHasil.setText("Jawaban Benar");

                else
                    iniHasil.setText("Jawaban Salah");

            }
                });

        Button buttonQuiz = (Button) findViewById(R.id.button_quiz);
        buttonQuiz.setOnClickListener(v ->{
            Intent gotoQuiz = new Intent(DashboardActivity.this, QuizActivity.class);
            resultLauncher.launch(gotoQuiz);
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