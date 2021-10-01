package com.bignerdranch.android.andersen_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText

const val EXTRA_MESSAGE: String = "com.example.android.twoactivities.extra.MESSAGE"

class TwoActivitiesAndIntents : AppCompatActivity() {

    private val logTag: String = TwoActivitiesAndIntents::class.java.name
    private lateinit var messageEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_activities_and_intents)
        messageEditText = findViewById(R.id.editText_main)
    }

    fun launchSecondActivity(view: View) {
        Log.d(logTag, "Button Clicked")
        val intent = Intent(this, SecondActivity::class.java)
        val message: String = messageEditText.text.toString()
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivity(intent)
    }
}