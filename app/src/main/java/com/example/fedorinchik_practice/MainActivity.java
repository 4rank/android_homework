package com.example.fedorinchik_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RadioGroup r_group;

    private final AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.65F);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button_act1_1);
        Button button2 = findViewById(R.id.button_act1_2);
        Button button_dn=findViewById(R.id.button_dn);
        r_group=findViewById(R.id.radioGroup);
        TextView textView=findViewById(R.id.text_send);
        textView.setTextColor(Color.parseColor("#1F65FA"));
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button_dn.setOnClickListener(this);
        r_group.setOnClickListener(this);
        textView.setOnClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.button_act1_1){
            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        }
        if (v.getId()==R.id.button_act1_2){
            Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        }
        if (v.getId()==R.id.radioGroup){
            switch (R.id.radioGroup){
                case (R.id.radio_day):
                    setTheme(AppCompatDelegate.MODE_NIGHT_NO);
                case (R.id.radio_night):
                    setTheme(AppCompatDelegate.MODE_NIGHT_YES);
            }
        }
        if (v.getId()==R.id.text_send){
            v.startAnimation(buttonClick);
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Поделиться");
            sendIntent.setType("text");
            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);
        }
        if (v.getId()==R.id.button_dn){
            int checked = r_group.getCheckedRadioButtonId();
            if (checked==R.id.radio_day){
                setTheme(R.style.Theme_MaterialComponents_Light);
            }
            if (checked==R.id.radio_night){
                setTheme(R.style.AppTheme_Dark);
            }
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
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
    public void onStop() {
        super.onStop();
        finish();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}