package com.example.mobileapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    final public static String EXTRA_NAME = "extra_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inputName = (EditText) findViewById(R.id.id_input_name);
        EditText inputEmail = (EditText) findViewById(R.id.id_input_email);
        EditText inputPhone = (EditText) findViewById(R.id.id_input_phone);
        EditText inputPassword = (EditText) findViewById(R.id.id_input_pwd);

        Button buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(v ->{
            // kode untuk aksi dari klik button
            Intent loginIntent = new Intent(MainActivity.this, DashboardActivity.class);
            loginIntent.putExtra(EXTRA_NAME, inputName.getText().toString());
            startActivity(loginIntent);

            Log.d("--Nama--",inputName.getText().toString());
            Log.d("--Email--",inputEmail.getText().toString());
            Log.d("--Phone--",inputPhone.getText().toString());
            Log.d("--Password--",inputPassword.getText().toString());
        });
    }


    // Method untuk menampilkan log
    private void showLog(String text) {
        Log.d(getPackageName(), text);

    }

    @Override
    protected void onRestart() {
        super.onRestart(); //call to restart after onStop
        showLog("Activity restarted");
    }

    @Override
    protected void onStart() {
        super.onStart(); //soon be visible
        showLog("Activity started");
    }

    @Override
    protected void onResume() {
        super.onResume(); //visible
        showLog("Activity resumed");
    }

    @Override
    protected void onPause() {
        super.onPause(); //invisible
        showLog("Activity paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showLog("Activity stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showLog("Activity is being destroyed");
    }
}