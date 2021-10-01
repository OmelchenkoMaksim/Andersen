package com.bignerdranch.android.andersen_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class ScrollViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_view)
    }

    fun toMainActivity(view: View) {
        Toast.makeText(this, R.string.toast_message_change_activity, Toast.LENGTH_SHORT).show()
        val scrollIntent = Intent(applicationContext, MainActivity::class.java)
        startActivity(scrollIntent)
    }

    fun toTwoActivity(view: View) {
        Toast.makeText(this, R.string.toast_message_change_activity, Toast.LENGTH_SHORT).show()
        val scrollIntent = Intent(applicationContext, TwoActivitiesAndIntents::class.java)
        startActivity(scrollIntent)
    }
}