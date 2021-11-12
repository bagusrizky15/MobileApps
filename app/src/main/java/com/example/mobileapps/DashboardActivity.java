package com.example.mobileapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

        Button buttonBack = (Button) findViewById(R.id.button_back);
        buttonBack.setOnClickListener(v ->{

            Intent backIntent = new Intent(DashboardActivity.this, MainActivity.class);
            startActivity(backIntent);

        });

    }
}