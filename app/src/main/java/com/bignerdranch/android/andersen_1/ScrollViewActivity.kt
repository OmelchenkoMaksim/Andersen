package com.bignerdranch.android.andersen_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

class ScrollViewActivity : AppCompatActivity() {

    private var tagScrollViewActivity: String = ScrollViewActivity::javaClass.name
    private lateinit var buttonToMainActivity: Button
    private lateinit var buttonToTwoActivity: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_view)
        Log.d(tagScrollViewActivity, getString(R.string.funny_log_mom))

        buttonToMainActivity = findViewById(R.id.button_to_main_activity)
        buttonToMainActivity.setOnClickListener(::toMainActivity)

        buttonToTwoActivity = findViewById(R.id.button_to_two_activity)
        buttonToTwoActivity.setOnClickListener(::toTwoActivity)

    }

    private fun toMainActivity(view: View) {
        Toast.makeText(this, R.string.toast_message_change_activity, Toast.LENGTH_SHORT).show()
        val scrollIntent = Intent(applicationContext, MainActivity::class.java)
        startActivity(scrollIntent)
    }

    private fun toTwoActivity(view: View) {
        Toast.makeText(this, R.string.toast_message_change_activity, Toast.LENGTH_SHORT).show()
        val scrollIntent = Intent(applicationContext, TwoActivitiesAndIntents::class.java)
        startActivity(scrollIntent)
    }
}