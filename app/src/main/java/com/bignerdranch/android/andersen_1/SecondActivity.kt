package com.bignerdranch.android.andersen_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val intent: Intent = intent
        val message = intent.getStringExtra(EXTRA_MESSAGE)
        val textView: TextView = findViewById(R.id.text_message)
        textView.text = message
    }
}