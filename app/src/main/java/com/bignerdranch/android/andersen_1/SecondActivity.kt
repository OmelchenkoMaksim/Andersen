package com.bignerdranch.android.andersen_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

const val EXTRA_MESSAGE_SECOND_ACTIVITY: String =
    "com.big_nerd_ranch.android.andersen_1.second_activity.extra.MESSAGE"
const val EXTRA_REPLY: String =
    "com.big_nerd_ranch.android.andersen_1.twoactivities.extra.REPLY";
lateinit var replyToFirst: String

class SecondActivity : AppCompatActivity() {

    private val tagSecondActivity: String = SecondActivity::class.java.name
    private lateinit var messageSendReply: EditText
    private lateinit var buttonLaunchPreviousActivity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.d(tagSecondActivity, getString(R.string.funny_log_dad))
        val intent: Intent = intent
        val message = intent.getStringExtra(EXTRA_MESSAGE)
        val textView: TextView = findViewById(R.id.text_message)
        textView.text = message

        messageSendReply = findViewById(R.id.text_for_reply)

        buttonLaunchPreviousActivity = findViewById(R.id.button_to_first_activity)
        buttonLaunchPreviousActivity.setOnClickListener(::sendRequestedResult)
    }

    private fun sendRequestedResult(view: View) {
        val intent = Intent(applicationContext, TwoActivitiesAndIntents::class.java)
        intent.putExtra(EXTRA_MESSAGE_SECOND_ACTIVITY, messageSendReply.text.toString())
        setResult(RESULT_OK, intent)
        finish()
    }
}