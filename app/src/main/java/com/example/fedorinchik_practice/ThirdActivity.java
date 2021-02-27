package com.example.fedorinchik_practice;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatDelegate;

public class ThirdActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.getDefaultNightMode());

        Button button1 = findViewById(R.id.button_act3_1);
        Button button2 = findViewById(R.id.button_act3_2);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.button_act3_1){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        }
        if (v.getId()==R.id.button_act3_2){
            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        }
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onRestart() {
        super.onRestart();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
