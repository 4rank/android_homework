package com.example.fedorinchik_practice

import android.app.ActivityOptions
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val buttonClick = AlphaAnimation(1f, 0.65f)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button1 = findViewById<Button>(R.id.button_act1_1)
        val button2 = findViewById<Button>(R.id.button_act1_2)
        val textView = findViewById<TextView>(R.id.text_send)
        textView.setTextColor(Color.parseColor("#1F65FA"))
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        textView.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_act1_1) {
            val intent = Intent(applicationContext, SecondActivity::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
        if (v.id == R.id.button_act1_2) {
            val intent = Intent(applicationContext, ThirdActivity::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
        if (v.id == R.id.text_send) {
            v.startAnimation(buttonClick)
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Делюсь приложением")
            sendIntent.type = "text/plain"
            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }
}