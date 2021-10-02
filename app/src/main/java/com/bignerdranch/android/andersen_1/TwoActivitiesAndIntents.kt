package com.bignerdranch.android.andersen_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
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
        Log.d(tagTwoActivitiesAndIntents, getString(R.string.log_spacing))
        Log.d(tagTwoActivitiesAndIntents, getString(R.string.tag_on_create))

        textViewHeader = findViewById(R.id.text_header)

        val intent: Intent = intent
        val message = intent.getStringExtra(EXTRA_MESSAGE_SECOND_ACTIVITY)
        textViewRepliedMessage = findViewById(R.id.text_message_replied)
        textViewRepliedMessage.text = message

        if (savedInstanceState != null){
            if (savedInstanceState.getBoolean(getString(R.string.reply_visible))){
                textViewHeader.visibility = View.VISIBLE
                textViewRepliedMessage.text = savedInstanceState.getString(getString(R.string.reply_text))
                textViewRepliedMessage.visibility = View.VISIBLE
            }
        }
        messageEditText = findViewById(R.id.message_for_sent_to_second)

        buttonLaunchSecondActivity = findViewById(R.id.button_to_second_activity)
        buttonLaunchSecondActivity.setOnClickListener(::launchSecondActivity)
    }

    override fun onStart() {
        super.onStart()
        Log.d(tagTwoActivitiesAndIntents, getString(R.string.log_on_start))
    }

    override fun onPause() {
        super.onPause()
        Log.d(tagTwoActivitiesAndIntents, getString(R.string.log_on_pause))
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tagTwoActivitiesAndIntents, getString(R.string.log_on_restart))
    }

    override fun onResume() {
        super.onResume()
        Log.d(tagTwoActivitiesAndIntents, getString(R.string.log_on_resume))
    }

    override fun onStop() {
        super.onStop()
        Log.d(tagTwoActivitiesAndIntents, getString(R.string.log_on_stop))
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tagTwoActivitiesAndIntents, getString(R.string.log_on_destroy))
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (textViewHeader.visibility == View.VISIBLE) {
            outState.putBoolean(getString(R.string.reply_visible), true)
            outState.putString(getString(R.string.reply_text), textViewRepliedMessage.text.toString())
        }
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