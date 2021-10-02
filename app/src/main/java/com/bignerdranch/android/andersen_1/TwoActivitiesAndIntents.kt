package com.bignerdranch.android.andersen_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

const val EXTRA_MESSAGE: String =
    "com.big_nerd_ranch.android.andersen_1.two_activities.extra.MESSAGE"
const val TEXT_REQUEST = 1

class TwoActivitiesAndIntents : AppCompatActivity() {

    private val tagTwoActivitiesAndIntents: String = TwoActivitiesAndIntents::class.java.name
    private lateinit var messageEditText: EditText
    private lateinit var buttonLaunchSecondActivity: Button
    private lateinit var textViewRepliedMessage: TextView
    private lateinit var textViewHeader: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_activities_and_intents)
        Log.d(tagTwoActivitiesAndIntents, getString(R.string.funny_log_dad))

        val intent: Intent = intent
        val message = intent.getStringExtra(EXTRA_MESSAGE_SECOND_ACTIVITY)

        messageEditText = findViewById(R.id.message_for_sent_to_second)

        textViewRepliedMessage = findViewById(R.id.text_message_replied)
        textViewRepliedMessage.text = message

        textViewHeader = findViewById(R.id.text_header)

        buttonLaunchSecondActivity = findViewById(R.id.button_to_second_activity)
        buttonLaunchSecondActivity.setOnClickListener(::launchSecondActivity)
    }

    private fun launchSecondActivity(view: View) {
        Log.d(tagTwoActivitiesAndIntents, getString(R.string.log_what_happend_with_button))
        val intent = Intent(this, SecondActivity::class.java)
        val message: String = messageEditText.text.toString()
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivityForResult(intent, TEXT_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                val reply = data?.getStringExtra(EXTRA_MESSAGE_SECOND_ACTIVITY)
                textViewRepliedMessage.text = reply
                textViewHeader.visibility = View.VISIBLE
            }
        }
    }
}