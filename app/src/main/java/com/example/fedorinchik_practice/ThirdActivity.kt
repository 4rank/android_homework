package com.example.fedorinchik_practice

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate

class ThirdActivity : Activity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.getDefaultNightMode())
        val button1 = findViewById<Button>(R.id.button_act3_1)
        val button2 = findViewById<Button>(R.id.button_act3_2)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
    }

    public override fun onStart() {
        super.onStart()
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_act3_1) {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
        if (v.id == R.id.button_act3_2) {
            val intent = Intent(applicationContext, SecondActivity::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
    }
}