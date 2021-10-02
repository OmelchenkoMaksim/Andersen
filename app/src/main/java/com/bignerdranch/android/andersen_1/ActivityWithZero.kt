package com.bignerdranch.android.andersen_1

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ActivityWithZero : AppCompatActivity() {

    private var count: Int = 0
    private var keyCount: String = "countState"
    private var tagZeroActivity: String = ActivityWithZero::javaClass.name
    private lateinit var showCount: TextView
    private lateinit var buttonZero: Button
    private lateinit var buttonToScrollViewActivity: Button
    private lateinit var buttonToMainActivity: Button
    private lateinit var buttonCountUp: Button
    private lateinit var buttonToast: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_zero)

        buttonToScrollViewActivity = findViewById(R.id.button_to_scrollview_activity)
        buttonToScrollViewActivity.setOnClickListener { toScrollViewActivity() }

        buttonToMainActivity = findViewById(R.id.button_to_main_activity)
        buttonToMainActivity.setOnClickListener { toMainActivity() }

        buttonZero = findViewById(R.id.button_zero)
        buttonZero.setOnClickListener(::countEqualsZero)

        buttonCountUp = findViewById(R.id.button_count)
        buttonCountUp.setOnClickListener { countUpZero() }

        buttonToast = findViewById(R.id.button_toast)
        buttonToast.setOnClickListener { showToastZero() }

        Log.d(tagZeroActivity, getString(R.string.funny_log_dad))
        val argument: Bundle? = intent.extras
        if (argument != null) count = intent.getIntExtra(EXTRA_MESSAGE_MAIN, 0)
        showCount = findViewById(R.id.show_count)
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(keyCount)
        }
        showCount.text = count.toString()

        if (count == 0) buttonZero.setBackgroundColor(Color.GRAY)
        if (count != 0) buttonZero.setBackgroundColor(Color.YELLOW)
    }

    private fun showToastZero() {
        val toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT)
        toast.show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(keyCount, count)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        count = savedInstanceState.getInt(keyCount)
        super.onRestoreInstanceState(savedInstanceState)
    }

    private fun countUpZero() {
        count++
        if (count != 0) buttonZero.setBackgroundColor(Color.YELLOW)
        Toast.makeText(this, R.string.toast_message_increase, Toast.LENGTH_SHORT).show()
        showCount.text = count.toString()
    }

    private fun countEqualsZero(view: View) {
        count = 0
        if (count == 0) view.setBackgroundColor(Color.GRAY)
        Toast.makeText(this, R.string.toast_message_to_zero, Toast.LENGTH_SHORT).show()
        showCount.text = count.toString()
    }

    private fun toMainActivity() {
        Toast.makeText(this, R.string.toast_message_change_activity, Toast.LENGTH_SHORT).show()
        val zeroActIntent = Intent(applicationContext, MainActivity::class.java)
        zeroActIntent.putExtra(EXTRA_MESSAGE_MAIN, count)
        startActivity(zeroActIntent)
    }

    private fun toScrollViewActivity() {
        Toast.makeText(this, R.string.toast_message_change_activity, Toast.LENGTH_SHORT).show()
        val scrollViewActivityIntent =
            Intent(applicationContext, ScrollViewActivity::class.java)
        scrollViewActivityIntent.putExtra(EXTRA_MESSAGE_MAIN, count)
        startActivity(scrollViewActivityIntent)
    }
}