package com.bignerdranch.android.andersen_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

const val EXTRA_MESSAGE: String =
    "com.big_nerd_ranch.android.andersen_1.two_activities.extra.MESSAGE"

class TwoActivitiesAndIntents : AppCompatActivity() {

    private val tagTwoActivitiesAndIntents: String = TwoActivitiesAndIntents::class.java.name
    private lateinit var messageEditText: EditText
    private lateinit var buttonLaunchSecondActivity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_activities_and_intents)
        Log.d(tagTwoActivitiesAndIntents, getString(R.string.funny_log_dad))

        messageEditText = findViewById(R.id.editText_main)

        buttonLaunchSecondActivity = findViewById(R.id.button_to_second_activity)
        buttonLaunchSecondActivity.setOnClickListener(::launchSecondActivity)
    }

    private fun launchSecondActivity(view: View) {
        Log.d(tagTwoActivitiesAndIntents, "Button Clicked")
        val intent = Intent(this, SecondActivity::class.java)
        val message: String = messageEditText.text.toString()
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivity(intent)
    }
}